package ru.nsu.ccfit.verba.verbaproxy

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
class VerbaProxyApplication

fun main(args: Array<String>) {
    runApplication<VerbaProxyApplication>(*args)
}
