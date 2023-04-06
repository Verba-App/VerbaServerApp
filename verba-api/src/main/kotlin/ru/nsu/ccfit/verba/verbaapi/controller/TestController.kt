package ru.nsu.ccfit.verba.verbaapi.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController {

    @GetMapping("/test")
    fun ff(): String {
        return "ddd"
    }
}