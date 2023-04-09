package ru.nsu.ccfit.verba.verbaapi.core.words

import org.springframework.data.jpa.repository.JpaRepository
import ru.nsu.ccfit.verba.verbaapi.domain.Word

interface WordRepository : JpaRepository<Word, Long>