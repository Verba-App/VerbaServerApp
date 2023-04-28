package ru.nsu.ccfit.verba.verbaapi.core.category

import org.springframework.data.jpa.repository.JpaRepository
import ru.nsu.ccfit.verba.verbaapi.domain.Category

interface CategoryWordRepository : JpaRepository<Category, Long>