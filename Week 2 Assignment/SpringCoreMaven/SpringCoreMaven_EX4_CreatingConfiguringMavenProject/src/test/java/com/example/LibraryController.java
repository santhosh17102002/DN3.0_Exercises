package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LibraryController {

    @RequestMapping("/welcome")
    @ResponseBody
    public String welcome() {
        return "Welcome to the Library Management System!";
    }
}
