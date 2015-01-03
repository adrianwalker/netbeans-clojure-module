package org.adrianwalker.clojure.netbeans.parser;

import javax.swing.text.BadLocationException;
import org.netbeans.modules.editor.indent.spi.Context;
import org.netbeans.modules.editor.indent.spi.ExtraLock;
import org.netbeans.modules.editor.indent.spi.IndentTask;

public final class CLJIndentTask implements IndentTask {

  private Context context;

  public CLJIndentTask(final Context context) {
    this.context = context;
  }

  @Override
  public void reindent() throws BadLocationException {
    //TODO
  }

  @Override
  public ExtraLock indentLock() {
    return null;
  }
}
