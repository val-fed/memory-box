package com.valfed.memorybox.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Word {
  private int id;

  @NotEmpty(message = "Origin text can not be empty")
  @Size(min = 2, max = 300, message = "Origin text should be between 2 and 300 chars")
  private String origin;

  @NotEmpty(message = "Translation text can not be empty")
  @Size(min = 2, max = 300, message = "Translation text should be between 2 and 300 chars")
  private String translation;

  public Word() {
  }

  public Word(int id, String origin, String translation) {
    this.id = id;
    this.origin = origin;
    this.translation = translation;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getOrigin() {
    return origin;
  }

  public void setOrigin(String origin) {
    this.origin = origin;
  }

  public String getTranslation() {
    return translation;
  }

  public void setTranslation(String translation) {
    this.translation = translation;
  }
}
