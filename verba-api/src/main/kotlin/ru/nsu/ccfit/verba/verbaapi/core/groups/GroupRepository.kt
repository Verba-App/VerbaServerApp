package ru.nsu.ccfit.verba.verbaapi.core.groups


import jakarta.transaction.Transactional
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import ru.nsu.ccfit.verba.verbaapi.domain.GroupCatalog

interface GroupRepository : CrudRepository<GroupCatalog, Long> {

    @Modifying
    @Transactional
    @Query("INSERT INTO group_catalog (name, author_id) VALUES (:name, :authorId)", nativeQuery = true)
    fun createGroupCatalog(@Param("name") name: String, @Param("authorId") authorId: Long):Int

    @Query("SELECT gc FROM GroupCatalog gc WHERE gc.author.id = :userId")
    fun getAllGroupByUserId(@Param("userId") userId: Long): List<GroupCatalog>

    @Query("SELECT gc FROM GroupCatalog gc INNER JOIN AllowUserGroup aug ON gc.id = aug.group.id WHERE aug.user.id = :userId ")
    fun getAllAvailableGroupByUserId(@Param("userId") userId: Long):List<GroupCatalog>
}