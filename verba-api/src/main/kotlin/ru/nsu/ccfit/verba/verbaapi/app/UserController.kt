package ru.nsu.ccfit.verba.verbaapi.app

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import ru.nsu.ccfit.verba.verbaapi.core.users.UserDto
import ru.nsu.ccfit.verba.verbaapi.core.users.UserService
import ru.nsu.ccfit.verba.verbaapi.platform.Response

@RestController
@RequestMapping("/user")
@Tag(name = "Пользователи", description = "Запросы для взаимодействия с экземплярами пользователей")
class UserController(
    @Autowired
    val userService: UserService
) {

    @PostMapping("/{id}")
    @Operation(summary = "Возвращает пользователя по заданному id")
    @ApiResponse(responseCode = "200")
    fun getById(@Parameter(description = "Идентификатор пользователя") @PathVariable id: Long): Response<UserDto> {
        return Response.withData(userService.getById(id))
    }

    @PostMapping("/create")
    @Operation(summary = "Добавление пользователя")
    @ApiResponse(responseCode = "200")
    fun add(@RequestBody userDto: UserDto): Response<Void> {
        userService.add(userDto)
        return Response.withoutErrors()
    }

}