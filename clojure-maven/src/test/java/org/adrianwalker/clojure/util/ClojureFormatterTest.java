package org.adrianwalker.clojure.util;

import org.junit.Test;
import org.adrianwalker.clojure.util.ClojureFormatter;
import org.junit.Assert;

public class ClojureFormatterTest {

  public ClojureFormatterTest() {
  }

  @Test
  public void prettyPrint() {
    String code
            = "(defn cl-format \n"
            + "\"An implementation of a Common Lisp compatible format function\"\n"
            + "[stream format-in & args] (let [compiled-format (if (string? format-in) \n"
            + "(compile-format format-in) format-in) navigator (init-navigator args)] \n"
            + "(execute-format stream compiled-format navigator)))";

    String prettyCode = ClojureFormatter.prettyPrint(code);

    System.out.println("*\n" + prettyCode + "\n*");

    Assert.assertEquals("(defn cl-format\n"
            + "   \"An implementation of a Common Lisp compatible format function\"\n"
            + "   [stream format-in & args]\n"
            + "   (let [compiled-format (if (string? format-in)\n"
            + "                           (compile-format format-in)\n"
            + "                           format-in)\n"
            + "         navigator (init-navigator args)]\n"
            + "     (execute-format stream compiled-format navigator)))", prettyCode);
  }
}
