package org.adrianwalker.clojure.netbeans.parser;

import org.adrianwalker.clojure.netbeans.syntaxhighlighter.CLJTokenId;
import org.netbeans.api.lexer.Language;
import org.netbeans.modules.csl.spi.DefaultLanguageConfig;
import org.netbeans.modules.csl.spi.LanguageRegistration;
import org.netbeans.modules.parsing.spi.Parser;

@LanguageRegistration(mimeType = "text/x-clj")
public final class CLJLanguage extends DefaultLanguageConfig {

  @Override
  public Language getLexerLanguage() {
    return CLJTokenId.getLanguage();
  }

  @Override
  public String getDisplayName() {
    return "CLJ";
  }

  @Override
  public Parser getParser() {
    return new CLJEditorParser();
  }
}
