package com.valfed.memorybox.repo;

import com.valfed.memorybox.models.Word;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordRepo extends JpaRepository<Word, Long> {
}
