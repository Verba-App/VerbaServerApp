package ru.nsu.ccfit.verba.verbaapi.core.catalogs

import jakarta.transaction.Transactional
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import ru.nsu.ccfit.verba.verbaapi.domain.Catalog
import java.sql.Date
import java.time.LocalDate

interface CatalogRepository : JpaRepository<Catalog, Long> {


    @Modifying
    @Transactional
    @Query("INSERT INTO catalog (name, create_date, author_id, group_id) VALUES (:name, :createDate, :authorId, :groupId)", nativeQuery = true)
    fun createCatalog(@Param("name") name: String, @Param("createDate") createDate: Date, @Param("authorId") authorId: Long, @Param("groupId") groupId: Long)

    @Query("SELECT c FROM Catalog c WHERE c.group = :groupId")
    fun getAllCatalogByGroupId(@Param("groupId") groupId: Long): List<Catalog>
}