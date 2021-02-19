package com.valfed.memorybox.models;

public class Word {
  private int id;
  private String origin;
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
