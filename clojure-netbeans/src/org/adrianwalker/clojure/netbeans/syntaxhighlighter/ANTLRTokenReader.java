package org.adrianwalker.clojure.netbeans.syntaxhighlighter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.adrianwalker.clojure.antlr.TokensFile;
import org.openide.util.Exceptions;

public final class ANTLRTokenReader {

  private static final String TOKENS_FILENAME = "/Clojure.tokens";

  public List<CLJTokenId> readTokens() {

    List<CLJTokenId> tokens = new ArrayList<CLJTokenId>();

    TokensFile tokensFile = new TokensFile(TOKENS_FILENAME);

    Map<String, Integer> entries;
    try {
      entries = tokensFile.readEntries();
    } catch (IOException ex) {
      Exceptions.printStackTrace(ex);
      return tokens;
    }

    for (Map.Entry<String, Integer> entry : entries.entrySet()) {

      String name = entry.getKey();
      Integer id = entry.getValue();
      String tokenCategory = name.toLowerCase();

      CLJTokenId cljid = new CLJTokenId(name, tokenCategory, id);

      if (!tokens.contains(cljid)) {
        tokens.add(cljid);
      }
    }

    return tokens;
  }
}
