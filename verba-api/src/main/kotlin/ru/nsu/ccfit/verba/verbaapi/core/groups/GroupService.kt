package ru.nsu.ccfit.verba.verbaapi.core.groups

import org.hibernate.cfg.beanvalidation.IntegrationException
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.stereotype.Service
import ru.nsu.ccfit.verba.verbaapi.platform.exception.NotFoundException

@Service
class GroupService(
    private val groupCatalogMapper: GroupCatalogMapper,
    private val groupRepository: GroupRepository,
    private val allowGroupRepository: AllowGroupRepository
) {

    fun getById(id: Long): GroupDto {
        val foundClient = groupRepository.findById(id)
        return foundClient.map(groupCatalogMapper::toDto).orElseThrow {
            NotFoundException("Группа с id: $id не найден!")
        }

    }

    fun add(idUser: Long, nameGroup: String) {
        try {
            groupRepository.createGroupCatalog(nameGroup, idUser)
        } catch (e: DataIntegrityViolationException) {
            throw IntegrationException("Попытка добавления клиента приводит к нарушению целостности данных")
        }
    }

    fun delete(idUser:Long,idGroup: Long) {
        allowGroupRepository.removeUserFromGroup(idUser,idGroup)
    }

    fun getAllGroupByUser(userId: Long): List<GroupDto> {
        return groupRepository.getAllGroupByUserId(userId).map(groupCatalogMapper::toDto)
    }

    fun getAllAvailableGroup(userId: Long): List<GroupDto> {
        return groupRepository.getAllAvailableGroupByUserId(userId).map(groupCatalogMapper::toDto)
    }

}