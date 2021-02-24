package com.valfed.memorybox.controllers;

import com.valfed.memorybox.models.User;
import com.valfed.memorybox.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

  private final UserRepo userRepo;

  @Autowired
  public RegistrationController(UserRepo userRepo) {
    this.userRepo = userRepo;
  }

  @GetMapping("/registration")
  public String registration() {
    return "registration";
  }

  @PostMapping("/registration")
  public String addUser(User user, Model model) {
    User userFromDb = userRepo.findByUsername(user.getUsername());
    if(userFromDb != null) {
      model.addAttribute("message", "User exists!");
      return "registration";
    }
    user.setActive(true);
    userRepo.save(user);
    return "redirect:/login";
  }
}
