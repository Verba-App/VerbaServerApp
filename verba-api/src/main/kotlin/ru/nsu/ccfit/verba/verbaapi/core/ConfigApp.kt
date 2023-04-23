package ru.nsu.ccfit.verba.verbaapi.core

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories


@EnableAutoConfiguration
@EnableJpaRepositories
@ComponentScan
@Configuration
class ConfigApp