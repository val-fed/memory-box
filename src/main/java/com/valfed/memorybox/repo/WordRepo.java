package com.valfed.memorybox.repo;

import com.valfed.memorybox.models.User;
import com.valfed.memorybox.models.Word;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WordRepo extends JpaRepository<Word, Long> {
  List<Word> findByAuthor(User user);
}
