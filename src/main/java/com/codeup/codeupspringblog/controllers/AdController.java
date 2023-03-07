package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Ad;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.AdRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.codeup.codeupspringblog.services.EmailService;


@Controller
public class AdController {
    private final AdRepository adDao;
    private final UserRepository userDao;
    private final EmailService emailService;

    public AdController(AdRepository adDao, UserRepository userDao, EmailService emailService) {
        this.adDao = adDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }


    @GetMapping("/ads")
    public String showAllAds(Model model) {
        model.addAttribute("ads", adDao.findAll());
        return "ads/index";
    }

    @GetMapping("/ads/{id}")
    public String getOneAd(@PathVariable long id, Model model) {
        model.addAttribute("ad", adDao.findAdById(id));
        model.addAttribute("userIsCreator", true);
        return "ads/show";
    }

    @PostMapping("/ads/save")
    public String saveAd(@ModelAttribute Ad ad) {
        User user = userDao.findUserById(1);
        ad.setUser(user);
        adDao.save(ad);
        emailService.prepareAndSendAd(ad);
        return "redirect:/ads";
    }

    @PostMapping("/ads/create")
    public String saveNewAd(@RequestParam String title, @RequestParam String description) {
        User user = userDao.findUserById(1);
        Ad ad = new Ad(title, description, user);
        adDao.save(ad);
        return "redirect:/ads/index";
    }
}
