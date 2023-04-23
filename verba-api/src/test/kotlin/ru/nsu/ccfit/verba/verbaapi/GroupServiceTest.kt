package ru.nsu.ccfit.verba.verbaapi

import jakarta.transaction.Transactional
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.hibernate.cfg.beanvalidation.IntegrationException
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.jdbc.Sql
import ru.nsu.ccfit.verba.verbaapi.core.ConfigApp
import ru.nsu.ccfit.verba.verbaapi.core.groups.GroupService
import ru.nsu.ccfit.verba.verbaapi.core.users.UserService
import ru.nsu.ccfit.verba.verbaapi.platform.exception.NotFoundException

@Import(ConfigApp::class)
@Configuration
@EntityScan("ru.nsu.ccfit.verba.verbaapi.domain")
class GroupTestConfig

@ContextConfiguration(
    classes = [UsersTestConfig::class],
    initializers = [TestContainerDbContextInitializer::class]
)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Sql(statements = ["TRUNCATE TABLE verba_user CASCADE;", "TRUNCATE TABLE group_catalog CASCADE;", "TRUNCATE TABLE allow_user_group CASCADE;"])
@Transactional(rollbackOn = [Exception::class])
class GroupServiceTest {
    @Autowired
    lateinit var groupService: GroupService


    @Test
    @Sql("/db/insert-group.sql")
    fun `add group with existing name should throw exception`() {
        val name = "My Group"
        val idUser = 1L

        assertThrows<IntegrationException> {
            groupService.add(idUser, name)
        }
    }

    @Test
    @Sql("/db/insert-group.sql")
    fun `when creating a group, the user has access to the group`() {
        val list = groupService.getAllAvailableGroup(1L)
        Assertions.assertTrue(list.any { it.id == 1L })
    }

    @Test
    @Sql(
        value = [
            "/db/insert-group.sql",
            "/db/insert-allow-group.sql"
        ],
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD
    )
    fun `delete a group that does not belong to a user, the directory will not be deleted`() {
        groupService.delete(2L, 1L)

        assertDoesNotThrow { groupService.getById(1L) }
    }

    @Test
    @Sql(
        value = [
            "/db/insert-group.sql",
            "/db/insert-allow-group.sql"
        ],
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD
    )
    fun `when deleting a group owned by a user, the directory is deleted`() {
        groupService.delete(1L, 1L)

        assertThrows<NotFoundException> { groupService.getById(1L) }
    }

    @Test
    @Sql(
        value = [
            "/db/insert-group.sql",
            "/db/insert-allow-group.sql"
        ],
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD
    )
    fun `when deleting a group belonging to a user, access to the directory is removed from everyone`() {
        groupService.delete(1L, 1L)

        val list = groupService.getAllAvailableGroup(2L)

        Assertions.assertFalse(list.any { it.id == 1L })
    }

}