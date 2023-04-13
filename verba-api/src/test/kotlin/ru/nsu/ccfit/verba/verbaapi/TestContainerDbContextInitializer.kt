package ru.nsu.ccfit.verba.verbaapi

import org.springframework.boot.test.util.TestPropertyValues
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import org.testcontainers.containers.PostgreSQLContainer


val pgContainer: PostgreSQLContainer<*> by lazy {
    PostgreSQLContainer("postgres:15")
        .withExposedPorts(5432)
        .withUsername("test-verba-postgres")
        .withPassword("postgres")
        .withDatabaseName("postgres")
        .withTmpFs(mapOf("/var" to "rw"))
        .withEnv("PGDATA", "/var/lib/postgresql/data-no-mounted")
        .withCommand("-c max_connections=400")
        .withReuse(true)
        .withDatabaseName("hello")
        //.withInitScript("db/verba-db-init.sql")
        .apply {
            start()
        }
}

class TestContainerDbContextInitializer : ApplicationContextInitializer<ConfigurableApplicationContext> {

    override fun initialize(applicationContext: ConfigurableApplicationContext) {
        applicationContext.overrideProperties(
            "spring.datasource.url" to pgContainer.jdbcUrl,
            "spring.datasource.username" to "postgres",
            "spring.datasource.password" to "postgres"
        )
    }
}

fun ConfigurableApplicationContext.overrideProperties(vararg properties: Pair<String, String>) {
    TestPropertyValues
        .of(properties.toMap())
        .applyTo(this)
}

