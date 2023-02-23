package com.codeup.codeupspringblog.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RollDiceController {
    @GetMapping("/roll-dice")
    public String rollDice() {
        return "roll-dice/index";
    }

    @GetMapping("/roll-dice/{guess}")
    public String rollDice(@PathVariable int guess, Model model) {
        int roll = (int) (Math.random() * 6) + 1;
        String message = (guess == roll) ? "You guessed correctly!" : "Sorry, you are the worst.";
        model.addAttribute("guess", guess);
        model.addAttribute("roll", roll);
        model.addAttribute("message", message);
        return "roll-dice/show";
    }
}
