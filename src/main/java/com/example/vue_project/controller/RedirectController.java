package com.example.vue_project.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectController implements ErrorController {
    // 컴포넌트가 인덱스된 index.html로 들어가서 찾아서 화면을 보일 수 있게 함
    @GetMapping("/error")
    public String redirect() {
        return "index.html";
    }
}
