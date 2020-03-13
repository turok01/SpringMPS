package com.Igor.SpringMPS.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/edit")
public class EditController {
    @GetMapping("/current")
    public String editForm(Model model){
        model.addAttribute();
    }
}
