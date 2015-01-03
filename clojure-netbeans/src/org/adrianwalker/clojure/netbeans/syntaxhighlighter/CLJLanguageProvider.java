package org.adrianwalker.clojure.netbeans.syntaxhighlighter;

import org.netbeans.api.lexer.InputAttributes;
import org.netbeans.api.lexer.Language;
import org.netbeans.api.lexer.LanguagePath;
import org.netbeans.api.lexer.Token;
import org.netbeans.spi.lexer.LanguageEmbedding;
import org.netbeans.spi.lexer.LanguageProvider;
import org.openide.util.lookup.ServiceProvider;

@ServiceProvider(service = LanguageProvider.class)
public final class CLJLanguageProvider extends LanguageProvider {

  @Override
  public Language<?> findLanguage(final String mimeType) {

    if ("text/x-clj".equals(mimeType)) {
      return CLJTokenId.getLanguage();
    }

    return null;
  }

  @Override
  public LanguageEmbedding<?> findLanguageEmbedding(final Token<?> token, final LanguagePath lp, final InputAttributes ia) {

    return null;
  }
}
