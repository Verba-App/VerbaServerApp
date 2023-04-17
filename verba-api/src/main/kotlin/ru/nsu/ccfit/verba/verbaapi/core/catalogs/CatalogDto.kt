package ru.nsu.ccfit.verba.verbaapi.core.catalogs

import java.io.Serializable
import java.sql.Date


data class CatalogDto(val id: Long, val name: String, val createDate: Date) : Serializable