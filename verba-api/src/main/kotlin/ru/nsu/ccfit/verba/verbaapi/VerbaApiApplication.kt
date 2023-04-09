package ru.nsu.ccfit.verba.verbaapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
class VerbaApiApplication

fun main(args: Array<String>) {
    runApplication<VerbaApiApplication>(*args)
}
