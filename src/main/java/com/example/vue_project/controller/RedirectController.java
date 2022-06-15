package com.example.vue_project.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectController implements ErrorController {
    // url 맵핑이 안된 주소로 접속하면 404 error일 경우에 메인 페이지가 보여지도록 하기 위함
    @GetMapping("/error")
    public String redirect() {
        return "forward:/";
    }
}
