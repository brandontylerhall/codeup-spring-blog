package com.codeup.codeupspringblog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MathController {
    @GetMapping("/add/{num1}/and/{num2}")
    @ResponseBody
    public String add(@PathVariable int num1, @PathVariable int num2) {
        int sum = num1 + num2;
        return String.format("%d plus %d equals %d", num1, num2, sum);
    }
    @GetMapping("/subtract/{num1}/from/{num2}")
    @ResponseBody
    public String subtract(@PathVariable int num1, @PathVariable int num2) {
        int difference = num1 - num2;
        return String.format("%d plus %d equals %d", num1, num2, difference);
    }
    @GetMapping("/multiply/{num1}/and/{num2}")
    @ResponseBody
    public String multiply(@PathVariable int num1, @PathVariable int num2) {
        int product = num1 * num2;
        return String.format("%d plus %d equals %d", num1, num2, product);
    }
    @GetMapping("/divide/{num1}/by/{num2}")
    @ResponseBody
    public String divide(@PathVariable int num1, @PathVariable int num2) {
        int quotient = num1 / num2;
        return String.format("%d plus %d equals %d", num1, num2, quotient);
    }
}
