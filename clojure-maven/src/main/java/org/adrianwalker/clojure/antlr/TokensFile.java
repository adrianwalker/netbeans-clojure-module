package org.adrianwalker.clojure.antlr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public final class TokensFile {

  private static final String SPLIT_REGEX = "=";
  private static final String RESERVED = "T__";

  private final String filename;

  public TokensFile(final String filename) {
    this.filename = filename;
  }

  public Map<String, Integer> readEntries() throws IOException {

    InputStream is = getClass().getResourceAsStream(filename);
    BufferedReader reader = new BufferedReader(new InputStreamReader(is));

    Map<String, Integer> entries = new HashMap<>();

    String line;
    while ((line = reader.readLine()) != null) {

      String[] split = line.split(SPLIT_REGEX);
      String name = split[0].trim();

      // skip reserved tokens
      if (name.startsWith(RESERVED)) {
        continue;
      }

      Integer id = Integer.valueOf(split[1].trim());
      if (!entries.containsValue(id)) {
        entries.put(name, id);
      }
    }

    return entries;
  }
}
