package org.adrianwalker.clojure.netbeans.parser;

import java.util.Collections;
import java.util.List;
import org.netbeans.modules.csl.spi.ParserResult;
import org.netbeans.modules.parsing.api.Snapshot;

public final class CLJEditorParserResult extends ParserResult {

  private final CLJEditorParser cljEditorParser;
  private boolean valid = true;

  public CLJEditorParserResult(final Snapshot snapshot, final CLJEditorParser cljEditorParser) {

    super(snapshot);

    this.cljEditorParser = cljEditorParser;
  }

  @Override
  protected void invalidate() {
    valid = false;
  }

  @Override
  public List<? extends org.netbeans.modules.csl.api.Error> getDiagnostics() {

    return Collections.EMPTY_LIST;
  }

  public List<SyntaxError> getSyntaxErrors() {

    return cljEditorParser.getSyntaxErrors();
  }

}
