package ru.egorkuban.springmvcapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {
        if (name != null && surname != null) {
            model.addAttribute("message", "Hello " + name + " " + surname);
        } else {
            name = "Annonimus";
            surname = " ";
            model.addAttribute("message", "Hello " + name + surname);
        }

        return "first/hello";
    }

    @GetMapping("/bye")
    public String goodByePage() {
        return "first/bye";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "a", required = false) Integer a,
                             @RequestParam(value = "b", required = false) Integer b,
                             @RequestParam(value = "action", required = false) String action,
                             Model model) {
        double result;

        if ("multiplication".equals(action)) {
            result = a * b;
            model.addAttribute("message", "result = " + result);
        } else if ("addition".equals(action)) {
            result = a + b;
            model.addAttribute("message", "result = " + result);
        } else if ("subtraction".equals(action)) {
            result = a - b;
            model.addAttribute("message", "result = " + result);
        } else if ("division".equals(action)) {
            result = a / (double) b;
            model.addAttribute("message", "result = " + result);
        } else {
            model.addAttribute("message", "You entered an invalid parameter");
        }
        return "first/calculator";
    }
}
