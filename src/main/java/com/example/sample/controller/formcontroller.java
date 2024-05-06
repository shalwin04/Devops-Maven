package com.example.sample.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.sample.domain.form;
import com.example.sample.service.formservice;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class formcontroller {

    @Autowired
    private formservice service;

    @GetMapping("/")
    public String home() {
        return "fillform";
    }

    // @GetMapping("/getin")
    // public String disp() {
    // return "submitted";
    // }

    @PostMapping("/getin")
    public String savehere(@ModelAttribute("leo") form leo) {

        form oauthUser = service.saveform(leo.getItemname(), leo.getQuantity());

        System.out.print(oauthUser);
        if (Objects.nonNull(oauthUser)) {
            return "submitted";
        } else {
            return "redirect:/";
        }
    }
}
