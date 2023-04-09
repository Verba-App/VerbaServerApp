package ru.nsu.ccfit.verba.verbaapi.core.tactics

import org.springframework.data.jpa.repository.JpaRepository
import ru.nsu.ccfit.verba.verbaapi.domain.Tactics

interface TacticRepository : JpaRepository<Tactics, Long>