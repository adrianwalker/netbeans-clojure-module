package org.adrianwalker.clojure.netbeans.syntaxhighlighter;

import org.adrianwalker.clojure.antlr.ClojureLexer;
import org.netbeans.api.lexer.Token;
import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerRestartInfo;

public final class CLJEditorLexer implements Lexer<CLJTokenId> {

  private final LexerRestartInfo<CLJTokenId> info;
  private final ClojureLexer lexer;

  public CLJEditorLexer(final LexerRestartInfo<CLJTokenId> info) {

    this.info = info;

    ANTLRCharStream charStream = new ANTLRCharStream(info.input(), "CLJEditor");
    lexer = new ClojureLexer(charStream);
  }

  @Override
  public org.netbeans.api.lexer.Token<CLJTokenId> nextToken() {

    org.antlr.v4.runtime.Token token = lexer.nextToken();

    Token<CLJTokenId> createdToken = null;

    if (token.getType() != -1) {

      CLJTokenId tokenId = CLJLanguageHierarchy.getToken(token.getType());
      createdToken = info.tokenFactory().createToken(tokenId);

    } else if (info.input().readLength() > 0) {

      CLJTokenId tokenId = CLJLanguageHierarchy.getToken(ClojureLexer.WS);
      createdToken = info.tokenFactory().createToken(tokenId);
    }

    return createdToken;
  }

  @Override
  public Object state() {
    return null;
  }

  @Override
  public void release() {
  }
}
