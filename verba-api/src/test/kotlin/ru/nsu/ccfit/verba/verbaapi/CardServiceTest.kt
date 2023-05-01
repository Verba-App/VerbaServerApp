package ru.nsu.ccfit.verba.verbaapi

import jakarta.transaction.Transactional
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.jdbc.Sql
import ru.nsu.ccfit.verba.verbaapi.core.ConfigApp
import ru.nsu.ccfit.verba.verbaapi.core.cards.CardRepository
import ru.nsu.ccfit.verba.verbaapi.core.groups.AllowGroupRepository


@Import(ConfigApp::class)
@Configuration
@EntityScan("ru.nsu.ccfit.verba.verbaapi.domain")
class CardTestConfig

@ContextConfiguration(
    classes = [UsersTestConfig::class],
    initializers = [TestContainerDbContextInitializer::class]
)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Sql(statements = ["TRUNCATE TABLE card CASCADE;"])
@Transactional(rollbackOn = [Exception::class])
class CardServiceTest {

    @Autowired
    lateinit var cardRepository: CardRepository
    @Autowired
    lateinit var allowGroupRepository: AllowGroupRepository


    @Test
    @Sql(
        value = [
            "/db/insert-group.sql",
            "/db/insert-catalog.sql"
        ],
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD
    )
    fun `select card`() {
        cardRepository.findAllByCatalogId(1)
    }

    @Test
    @Sql(
        value = [
            "/db/insert-group.sql",
            "/db/insert-catalog.sql",
            "/db/insert-photo-card.sql"
        ],
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD
    )
    fun `hash map`() {
        val response  = allowGroupRepository.findAll()

    }


}