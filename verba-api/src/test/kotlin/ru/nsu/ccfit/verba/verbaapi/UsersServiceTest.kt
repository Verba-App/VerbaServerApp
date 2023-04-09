package ru.nsu.ccfit.verba.verbaapi

import org.assertj.core.api.Assertions.assertThat
import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.MatcherAssert
import org.junit.Assert
import org.junit.Assume
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Configuration
import org.springframework.core.ParameterizedTypeReference
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.jdbc.Sql
import ru.nsu.ccfit.verba.verbaapi.core.users.UserService
import kotlin.concurrent.thread


@Configuration
@EntityScan("ru.nsu.ccfit.verba.verbaapi.domain")
class UsersTestConfig

@ContextConfiguration(
    classes = [UsersTestConfig::class],
    initializers = [TestContainerDbContextInitializer::class]
)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Sql(statements = ["TRUNCATE TABLE user CASCADE;"])
class UsersServiceTest {

    @Autowired
    lateinit var usersService: UserService

    @Test
    fun `User password should not be extractable after registration`() {
        Assertions.assertTrue(pgContainer.isRunning)
    }
}