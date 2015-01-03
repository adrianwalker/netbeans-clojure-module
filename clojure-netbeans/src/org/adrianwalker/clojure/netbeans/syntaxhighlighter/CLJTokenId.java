package org.adrianwalker.clojure.netbeans.syntaxhighlighter;

import org.netbeans.api.lexer.Language;
import org.netbeans.api.lexer.TokenId;

public final class CLJTokenId implements TokenId {

  private static final Language<CLJTokenId> LANGUAGE = new CLJLanguageHierarchy().language();
  private final String name;
  private final String primaryCategory;
  private final int id;

  public CLJTokenId(final String name, final String primaryCategory, final int id) {

    this.name = name;
    this.primaryCategory = primaryCategory;
    this.id = id;
  }

  public static Language<CLJTokenId> getLanguage() {
    return LANGUAGE;
  }

  @Override
  public String name() {
    return this.name;
  }

  @Override
  public int ordinal() {
    return this.id;
  }

  @Override
  public String primaryCategory() {
    return this.primaryCategory;
  }

  @Override
  public String toString() {
    return "CLJTokenId{" + "name=" + name + ", primaryCategory=" + primaryCategory + ", id=" + id + '}';
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 29 * hash + this.id;
    return hash;
  }

  @Override
  public boolean equals(final Object obj) {

    if (obj == null) {
      return false;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    CLJTokenId other = (CLJTokenId) obj;
    if (this.id != other.id) {
      return false;
    }
    return true;
  }
}
