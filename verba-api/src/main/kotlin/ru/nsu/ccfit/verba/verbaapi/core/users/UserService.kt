package ru.nsu.ccfit.verba.verbaapi.core.users

import org.hibernate.cfg.beanvalidation.IntegrationException
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.stereotype.Service

@Service
class UserService(
    val userRepository: UserRepository,
    val userMapper: UserMapper
) {
    fun getById(id: Long): UserDto {
        TODO("Not yet implemented")
    }

    fun add(userDto: UserDto) {
        try {
            userRepository.save(userMapper.toEntity(userDto))
        } catch (e: DataIntegrityViolationException) {
            throw IntegrationException("Попытка добавления клиента приводит к нарушению целостности данных")
        }
    }
}