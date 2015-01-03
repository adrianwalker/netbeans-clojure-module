package org.adrianwalker.clojure.netbeans.parser;

import org.antlr.v4.runtime.RecognitionException;

public class SyntaxError {

  private RecognitionException exception;
  private String message;
  private int line;
  private int charPositionInLine;

  public SyntaxError() {
  }

  public SyntaxError(RecognitionException exception, String message, int line, int charPositionInLine) {
    this.exception = exception;
    this.message = message;
    this.line = line;
    this.charPositionInLine = charPositionInLine;
  }

  public RecognitionException getException() {
    return exception;
  }

  public void setException(RecognitionException exception) {
    this.exception = exception;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public int getLine() {
    return line;
  }

  public void setLine(int line) {
    this.line = line;
  }

  public int getCharPositionInLine() {
    return charPositionInLine;
  }

  public void setCharPositionInLine(int charPositionInLine) {
    this.charPositionInLine = charPositionInLine;
  }

}
