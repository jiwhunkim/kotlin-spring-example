package com.store.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HelloController {
    @GetMapping("/")
    fun index(): String {
        return "index"
    }
}
