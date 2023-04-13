package ru.nsu.ccfit.verba.verbaapi.core.users

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.nsu.ccfit.verba.verbaapi.domain.User

@Service
class UserService(
    @Autowired
    val userRepository: UserRepository
) {

    fun saveUser(user: User) {
        userRepository.save(user)
    }

    fun findUserById(id:Long):User {
        return userRepository.findById(id).orElseThrow()
    }

}