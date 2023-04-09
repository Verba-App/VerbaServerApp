package ru.nsu.ccfit.verba.verbaapi.core.groups

import org.springframework.data.jpa.repository.JpaRepository
import ru.nsu.ccfit.verba.verbaapi.domain.AllowUserGroup

interface AllowGroupRepository : JpaRepository<AllowUserGroup, Long>