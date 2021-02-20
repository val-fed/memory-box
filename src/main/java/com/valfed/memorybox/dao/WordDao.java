package com.valfed.memorybox.dao;

import com.valfed.memorybox.models.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

import java.sql.Types;
import java.util.List;

@Component
public class WordDao {

  private final JdbcTemplate jdbcTemplate;
  private final SimpleJdbcInsert simpleJdbcInsert;

  @Autowired
  public WordDao(JdbcTemplate jdbcTemplate, SimpleJdbcInsert simpleJdbcInsert) {
    this.jdbcTemplate = jdbcTemplate;
    this.simpleJdbcInsert = simpleJdbcInsert;
  }

  public List<Word> getAll() {
    return jdbcTemplate.query("SELECT * FROM word", new BeanPropertyRowMapper<>(Word.class));
  }

  public void save(Word word) {
    MapSqlParameterSource parameterSource = new MapSqlParameterSource();
    parameterSource.addValue("origin", word.getOrigin(), Types.VARCHAR);
    parameterSource.addValue("translation", word.getTranslation(), Types.VARCHAR);
    simpleJdbcInsert.withTableName("word").usingGeneratedKeyColumns("id").execute(parameterSource);
  }

  public void update(int id, Word updatedWord) {
    jdbcTemplate.update("UPDATE word SET origin=?, translation=? WHERE id=?",
            updatedWord.getOrigin(),
            updatedWord.getTranslation(),
            id);
  }

  public Word show(int id) {
    return jdbcTemplate.query(
            "SELECT * FROM word WHERE id=?",
            new Object[]{id},
            new int[]{Types.INTEGER},
            new BeanPropertyRowMapper<>(Word.class))
            .stream().findAny().orElse(null);
  }

  public void delete(int id) {
    jdbcTemplate.update("DELETE FROM word WHERE id=?", id);
  }
}
