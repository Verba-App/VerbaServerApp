package ru.nsu.ccfit.verba.verbaproxy

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class VerbaProxyApplication

fun main(args: Array<String>) {
    runApplication<VerbaProxyApplication>(*args)
}
