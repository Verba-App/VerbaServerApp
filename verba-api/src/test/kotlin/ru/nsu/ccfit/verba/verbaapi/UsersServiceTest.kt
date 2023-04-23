package ru.nsu.ccfit.verba.verbaapi

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.jdbc.Sql
import ru.nsu.ccfit.verba.verbaapi.core.ConfigApp
import ru.nsu.ccfit.verba.verbaapi.core.users.UserService

@Import(ConfigApp::class)
@Configuration
@EntityScan("ru.nsu.ccfit.verba.verbaapi.domain")
class UsersTestConfig

@ContextConfiguration(
    classes = [UsersTestConfig::class],
    initializers = [TestContainerDbContextInitializer::class]
)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Sql(statements = ["TRUNCATE TABLE verba_user CASCADE;"])
class UsersServiceTest {

    @Autowired
    lateinit var usersService: UserService

    @Test
    fun `TestContainer is running`() {
        Assertions.assertTrue(pgContainer.isRunning)
    }
}