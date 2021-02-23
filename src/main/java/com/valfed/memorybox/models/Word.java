package com.valfed.memorybox.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Word {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String origin;
  private String translation;

  public Word() {
  }

  public Word(long id, String origin, String translation) {
    this.id = id;
    this.origin = origin;
    this.translation = translation;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
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
