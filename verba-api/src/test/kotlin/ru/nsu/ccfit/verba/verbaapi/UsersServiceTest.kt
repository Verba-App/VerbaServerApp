package ru.nsu.ccfit.verba.verbaapi

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.test.context.ContextConfiguration
import ru.nsu.ccfit.verba.verbaapi.core.CoreConfig

@Import(CoreConfig::class)
@Configuration
@EntityScan("ru.nsu.ccfit.verba.verbaapi.domain")
class UsersTestConfig

@ContextConfiguration(
    classes = [UsersTestConfig::class],
    initializers = [TestContainerDbContextInitializer::class]
)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class UsersServiceTest {
//
//    @Autowired
//    lateinit var usersService: UserService

    @Test
    fun `Testcontainer is running`() {
        Assertions.assertTrue(pgContainer.isRunning)
    }
}