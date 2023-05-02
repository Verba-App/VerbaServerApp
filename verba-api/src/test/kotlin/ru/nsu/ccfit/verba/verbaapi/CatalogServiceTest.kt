package ru.nsu.ccfit.verba.verbaapi

import jakarta.transaction.Transactional
import org.hibernate.cfg.beanvalidation.IntegrationException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.jdbc.Sql
import ru.nsu.ccfit.verba.verbaapi.core.ConfigApp
import ru.nsu.ccfit.verba.verbaapi.core.catalogs.CatalogService

@Import(ConfigApp::class)
@Configuration
@EntityScan("ru.nsu.ccfit.verba.verbaapi.domain")
class CatalogTestConfig

@ContextConfiguration(
    classes = [UsersTestConfig::class],
    initializers = [TestContainerDbContextInitializer::class]
)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Sql(statements = ["TRUNCATE TABLE catalog CASCADE;"])
@Transactional(rollbackOn = [Exception::class])
class CatalogServiceTest {
    @Autowired
    lateinit var catalogService: CatalogService

    @Test
    @Sql(
        value = [
            "/db/insert-group.sql",
            "/db/insert-catalog.sql"
        ],
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD
    )
    fun `when adding multiple directories to the same group with the same name, an error occurs`() {
        val name = "MyCatalog"
        assertThrows<IntegrationException> {
            catalogService.add(name,1L,1L)
        }
    }


}