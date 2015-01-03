package org.adrianwalker.clojure.netbeans.parser;

import org.netbeans.api.editor.mimelookup.MimeRegistration;
import org.netbeans.spi.editor.bracesmatching.BracesMatcher;
import org.netbeans.spi.editor.bracesmatching.BracesMatcherFactory;
import org.netbeans.spi.editor.bracesmatching.MatcherContext;
import org.netbeans.spi.editor.bracesmatching.support.BracesMatcherSupport;

@MimeRegistration(mimeType = "text/x-clj", service = BracesMatcherFactory.class)
public final class CLJBracesMatcherFactory implements BracesMatcherFactory {

  @Override
  public BracesMatcher createMatcher(MatcherContext context) {
    return BracesMatcherSupport.defaultMatcher(context, -1, -1);
  }
}
