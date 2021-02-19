package com.valfed.memorybox.dao;

import com.valfed.memorybox.models.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WordDao {

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public WordDao(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public List<Word> getAll() {
    return jdbcTemplate.query("SELECT * FROM word", new BeanPropertyRowMapper<>(Word.class));
  }
}
