package org.adrianwalker.clojure.netbeans.parser;

import java.util.Collection;
import java.util.Collections;
import org.netbeans.api.editor.mimelookup.MimeRegistration;
import org.netbeans.modules.parsing.api.Snapshot;
import org.netbeans.modules.parsing.spi.TaskFactory;

@MimeRegistration(mimeType = "text/x-clj", service = TaskFactory.class)
public final class CLJSyntaxErrorHighlightingTaskFactory extends TaskFactory {

  @Override
  public Collection create(final Snapshot snapshot) {
    return Collections.singleton(new CLJSyntaxErrorHighlightingTask());
  }
}
