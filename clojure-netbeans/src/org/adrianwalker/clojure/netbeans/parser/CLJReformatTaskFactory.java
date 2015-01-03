package org.adrianwalker.clojure.netbeans.parser;

import org.netbeans.api.editor.mimelookup.MimeRegistration;
import org.netbeans.modules.editor.indent.spi.Context;
import org.netbeans.modules.editor.indent.spi.ReformatTask;

@MimeRegistration(mimeType = "text/x-clj", service = ReformatTask.Factory.class)
public final class CLJReformatTaskFactory implements ReformatTask.Factory {

  @Override
  public ReformatTask createTask(Context context) {
    return new CLJReformatTask(context);
  }
}
