package ru.nsu.ccfit.verba.verbaapi.core.users


data class UserDto(
    val id: Long,
    val name: String,
    val email: String,
    val region: String,
    val password: String
)