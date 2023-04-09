package ru.nsu.ccfit.verba.verbaapi.core.catalogs

import org.springframework.data.jpa.repository.JpaRepository
import ru.nsu.ccfit.verba.verbaapi.domain.Catalog

interface CatalogRepository : JpaRepository<Catalog, Long>