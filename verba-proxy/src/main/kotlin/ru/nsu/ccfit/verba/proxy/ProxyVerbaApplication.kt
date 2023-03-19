package ru.nsu.ccfit.verba.proxy

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ProxyVerbaApplication

fun main(args: Array<String>) {
    runApplication<ProxyVerbaApplication>(*args)
}
