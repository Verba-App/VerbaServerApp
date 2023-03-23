package ru.nsu.ccfit.verba.proxy

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.zuul.EnableZuulProxy

@EnableZuulProxy
@SpringBootApplication
open class ProxyVerbaApplication

fun main(args: Array<String>) {
    runApplication<ProxyVerbaApplication>(*args)
}