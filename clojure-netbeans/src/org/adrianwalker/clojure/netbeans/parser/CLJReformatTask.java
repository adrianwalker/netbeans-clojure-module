package org.adrianwalker.clojure.netbeans.parser;

import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import org.adrianwalker.clojure.util.ClojureFormatter;
import org.netbeans.modules.editor.indent.spi.Context;
import org.netbeans.modules.editor.indent.spi.ExtraLock;
import org.netbeans.modules.editor.indent.spi.ReformatTask;

public final class CLJReformatTask implements ReformatTask {

  private Context context;

  public CLJReformatTask(final Context context) {
    this.context = context;
  }

  @Override
  public void reformat() throws BadLocationException {
    final Document document = context.document();
    String code = document.getText(0, document.getLength());
    String prettyCode = ClojureFormatter.prettyPrint(code);
    document.remove(0, document.getLength());
    document.insertString(0, prettyCode, null);
  }

  @Override
  public ExtraLock reformatLock() {
    return null;
  }
}
