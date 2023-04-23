package ru.nsu.ccfit.verba.verbaapi.core.catalogs

import org.hibernate.cfg.beanvalidation.IntegrationException
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.stereotype.Service
import ru.nsu.ccfit.verba.verbaapi.core.groups.GroupDto
import ru.nsu.ccfit.verba.verbaapi.platform.exception.NotFoundException


@Service
class CatalogService(
    private val catalogRepository: CatalogRepository,
    private val catalogMapper: CatalogMapper
) {
    fun getById(id: Long): CatalogDto {
        val foundCatalog = catalogRepository.findById(id)
        return foundCatalog.map(catalogMapper::toDto).orElseThrow {
            NotFoundException("Группа с id: $id не найден!")
        }
    }

    fun add(catalogDto: CatalogDto, userId: Long, groupId: Long) {
        try {
            catalogRepository.createCatalog(catalogDto.name, catalogDto.createDate, userId, groupId)
        } catch (e: DataIntegrityViolationException) {
            throw IntegrationException("Попытка добавления клиента приводит к нарушению целостности данных")
        }
    }

    fun getAllCatalogByGroup(groupId: Long): List<CatalogDto> {
        return catalogRepository.getAllCatalogByGroupId(groupId).map(catalogMapper::toDto)
    }
}