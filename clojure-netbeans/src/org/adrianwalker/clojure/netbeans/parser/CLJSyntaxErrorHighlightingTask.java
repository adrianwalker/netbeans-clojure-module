package org.adrianwalker.clojure.netbeans.parser;

import java.util.ArrayList;
import java.util.List;
import javax.swing.text.Document;
import org.netbeans.modules.parsing.spi.Parser.Result;
import org.netbeans.modules.parsing.spi.ParserResultTask;
import org.netbeans.modules.parsing.spi.Scheduler;
import org.netbeans.modules.parsing.spi.SchedulerEvent;
import org.netbeans.spi.editor.hints.ErrorDescription;
import org.netbeans.spi.editor.hints.ErrorDescriptionFactory;
import org.netbeans.spi.editor.hints.HintsController;
import org.netbeans.spi.editor.hints.Severity;

public class CLJSyntaxErrorHighlightingTask extends ParserResultTask {

  public CLJSyntaxErrorHighlightingTask() {
  }

  @Override
  public void run(final Result result, final SchedulerEvent event) {

    CLJEditorParserResult cljResult = (CLJEditorParserResult) result;
    List<SyntaxError> syntaxErrors = cljResult.getSyntaxErrors();
    Document document = result.getSnapshot().getSource().getDocument(false);
    List<ErrorDescription> errors = new ArrayList<ErrorDescription>();

    for (SyntaxError syntaxError : syntaxErrors) {
      String message = syntaxError.getMessage();

      int line = syntaxError.getLine();
      if (line <= 0) {
        continue;
      }

      ErrorDescription errorDescription = ErrorDescriptionFactory.createErrorDescription(
              Severity.ERROR,
              message,
              document,
              line);

      errors.add(errorDescription);
    }

    HintsController.setErrors(document, "clj", errors);
  }

  @Override
  public int getPriority() {
    return 100;
  }

  @Override
  public Class<? extends Scheduler> getSchedulerClass() {
    return Scheduler.EDITOR_SENSITIVE_TASK_SCHEDULER;
  }

  @Override
  public void cancel() {
  }
}
