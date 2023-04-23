package ru.nsu.ccfit.verba.verbaapi.core.groups

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.jpa.repository.query.Procedure
import org.springframework.data.repository.query.Param
import org.springframework.transaction.annotation.Transactional
import ru.nsu.ccfit.verba.verbaapi.domain.AllowUserGroup


interface AllowGroupRepository : JpaRepository<AllowUserGroup, Long>{

    @Transactional
    @Modifying
    @Query(value = "CALL remove_user_from_group(:userId, :groupId)", nativeQuery = true)
    fun removeUserFromGroup(@Param("userId") userId: Long, @Param("groupId") groupId: Long): Int
}