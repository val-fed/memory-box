package com.valfed.memorybox.controllers;

import com.valfed.memorybox.dao.WordDao;
import com.valfed.memorybox.models.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("words")
public class WordController {

  private final WordDao wordDao;

  @Autowired
  public WordController(WordDao wordDao) {
    this.wordDao = wordDao;
  }

  @GetMapping
  public String getAll(Model model) {
    model.addAttribute("words", wordDao.getAll());
    return "words/index";
  }

  @GetMapping("/{id}")
  public String show(@PathVariable("id") int id, Model model) {
    model.addAttribute("word", wordDao.show(id));
    return "words/show";
  }

  @GetMapping("/new")
  public String newPerson(@ModelAttribute("word") Word word) {
    return "words/new";
  }

  @PostMapping()
  public String create(@ModelAttribute("word") @Valid Word word, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return "words/new";
    }
    wordDao.save(word);
    return "redirect:/words";
  }

  @GetMapping("/{id}/edit")
  public String edit(Model model, @PathVariable("id") int id) {
    model.addAttribute("word", wordDao.show(id));
    return "words/edit";
  }

  @PatchMapping("/{id}")
  public String update(@ModelAttribute("word") @Valid Word word,
                       BindingResult bindingResult,
                       @PathVariable("id") int id) {
    if (bindingResult.hasErrors()) {
      return "words/edit";
    }
    wordDao.update(id, word);
    return "redirect:/words";
  }

  @DeleteMapping("/{id}")
  public String delete(@PathVariable("id") int id) {
    wordDao.delete(id);
    return "redirect:/words";
  }
}
