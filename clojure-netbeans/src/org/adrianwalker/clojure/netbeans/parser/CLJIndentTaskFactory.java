package org.adrianwalker.clojure.netbeans.parser;

import org.netbeans.api.editor.mimelookup.MimeRegistration;
import org.netbeans.modules.editor.indent.spi.Context;
import org.netbeans.modules.editor.indent.spi.IndentTask;

@MimeRegistration(mimeType = "text/x-clj", service = IndentTask.Factory.class)
public final class CLJIndentTaskFactory implements IndentTask.Factory {

  @Override
  public IndentTask createTask(final Context context) {
    return new CLJIndentTask(context);
  }
}
