package ru.nsu.ccfit.verba.verbaapi.core.users

import org.springframework.data.jpa.repository.JpaRepository
import ru.nsu.ccfit.verba.verbaapi.domain.User

interface UserRepository : JpaRepository<User, Long>