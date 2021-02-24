package com.valfed.memorybox.controllers;

import com.valfed.memorybox.models.User;
import com.valfed.memorybox.models.Word;
import com.valfed.memorybox.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class WordController {

  private final WordService service;

  @Autowired
  public WordController(WordService service) {
    this.service = service;
  }

  @RequestMapping("/")
  public String viewHomePage() {
    return "index";
  }

  @RequestMapping("/words")
  public String viewWordsPage(@AuthenticationPrincipal User user,
                              Model model) {
    List<Word> words = service.listAll(user);
    model.addAttribute("words", words);

    return "word_list";
  }

  @RequestMapping("/new")
  public String showNewWordPage(Model model) {
    Word word = new Word();
    model.addAttribute("word", word);

    return "new_word";
  }

  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public String saveWord(@AuthenticationPrincipal User user,
                         @ModelAttribute("word") Word word) {
    word.setAuthor(user);
    service.save(word);

    return "redirect:/words";
  }

  @RequestMapping("/edit/{id}")
  public ModelAndView showEditWordPage(@PathVariable(name = "id") int id) {
    ModelAndView mav = new ModelAndView("edit_word");
    Word word = service.get(id);
    mav.addObject("word", word);

    return mav;
  }

  @RequestMapping("/delete/{id}")
  public String deleteWord(@PathVariable(name = "id") int id) {
    service.delete(id);
    return "redirect:/words";
  }
}
