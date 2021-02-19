package com.valfed.memorybox.controllers;

import com.valfed.memorybox.dao.WordDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("word")
public class WordController {

  private final WordDao wordDao;

  @Autowired
  public WordController(WordDao wordDao) {
    this.wordDao = wordDao;
  }

  @GetMapping
  public String getAll(Model model) {
    model.addAttribute("words", wordDao.getAll());
    return "word/words";
  }
}
