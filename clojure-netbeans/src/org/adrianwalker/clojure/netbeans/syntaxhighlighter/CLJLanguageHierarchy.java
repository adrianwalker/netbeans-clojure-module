package org.adrianwalker.clojure.netbeans.syntaxhighlighter;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.netbeans.spi.lexer.LanguageHierarchy;
import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerRestartInfo;

public final class CLJLanguageHierarchy extends LanguageHierarchy<CLJTokenId> {

  private static List<CLJTokenId> tokens;
  private static Map<Integer, CLJTokenId> idToToken;

  private static void init() {

    ANTLRTokenReader reader = new ANTLRTokenReader();
    tokens = reader.readTokens();
    idToToken = new HashMap<Integer, CLJTokenId>();

    for (CLJTokenId token : tokens) {
      idToToken.put(token.ordinal(), token);
    }
  }

  public static synchronized CLJTokenId getToken(final int id) {

    if (idToToken == null) {
      init();
    }

    return idToToken.get(id);
  }

  @Override
  public synchronized Collection<CLJTokenId> createTokenIds() {

    if (tokens == null) {
      init();
    }

    return tokens;
  }

  @Override
  protected synchronized Lexer<CLJTokenId> createLexer(final LexerRestartInfo<CLJTokenId> info) {
    return new CLJEditorLexer(info);
  }

  @Override
  protected String mimeType() {
    return "text/x-clj";
  }
}
