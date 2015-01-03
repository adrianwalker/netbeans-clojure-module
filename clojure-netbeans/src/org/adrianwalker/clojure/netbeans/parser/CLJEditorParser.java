package org.adrianwalker.clojure.netbeans.parser;

import java.util.ArrayList;
import java.util.List;
import javax.swing.event.ChangeListener;
import org.adrianwalker.clojure.antlr.ClojureLexer;
import org.adrianwalker.clojure.antlr.ClojureParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.netbeans.modules.parsing.api.Snapshot;
import org.netbeans.modules.parsing.api.Task;
import org.netbeans.modules.parsing.spi.ParseException;
import org.netbeans.modules.parsing.spi.Parser;
import org.netbeans.modules.parsing.spi.SourceModificationEvent;
import org.openide.util.Exceptions;

public final class CLJEditorParser extends Parser {

  private Snapshot snapshot;
  private ClojureParser clojureParser;
  private List<SyntaxError> syntaxErrors;

  @Override
  public void parse(final Snapshot snapshot, final Task task, final SourceModificationEvent sme) throws ParseException {

    this.snapshot = snapshot;
    this.syntaxErrors = new ArrayList<SyntaxError>();

    CharStream input = new ANTLRInputStream(snapshot.getText().toString());
    Lexer lexer = new ClojureLexer(input);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    clojureParser = new ClojureParser(tokens);
    clojureParser.addErrorListener(new BaseErrorListener() {

      @Override
      public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        syntaxErrors.add(new SyntaxError(e, msg, line, charPositionInLine));
      }
    });

    try {
      clojureParser.file();
    } catch (Exception ex) {
      Exceptions.printStackTrace(ex);
    }
  }

  @Override
  public Result getResult(final Task task) throws ParseException {
    return new CLJEditorParserResult(snapshot, this);
  }

  @Override
  public void addChangeListener(final ChangeListener cl) {
  }

  @Override
  public void removeChangeListener(final ChangeListener cl) {
  }

  public List<SyntaxError> getSyntaxErrors() {
    return syntaxErrors;
  }
}
