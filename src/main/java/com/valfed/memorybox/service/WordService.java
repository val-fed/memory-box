package com.valfed.memorybox.service;

import com.valfed.memorybox.models.User;
import com.valfed.memorybox.models.Word;
import com.valfed.memorybox.repo.WordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordService {
  private WordRepo repo;

  @Autowired
  public WordService(WordRepo wordRepo) {
    this.repo = wordRepo;
  }

  public List<Word> listAll(User user) {
    return repo.findByAuthor(user);
  }

  public void save(Word word) {
    repo.save(word);
  }

  public Word get(long id) {
    return repo.findById(id).get();
  }

  public void delete(long id) {
    repo.deleteById(id);
  }
}
