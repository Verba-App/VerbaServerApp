package ru.nsu.ccfit.verba.verbaapi.app

import io.swagger.v3.oas.annotations.Operation

import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import ru.nsu.ccfit.verba.verbaapi.core.groups.GroupDto
import ru.nsu.ccfit.verba.verbaapi.core.groups.GroupService
import ru.nsu.ccfit.verba.verbaapi.platform.Response

@RestController
@RequestMapping("api/group")
@Tag(name = "Группы", description = "Запросы для взаимодействия с экземплярами групп")
class GroupController(
    @Autowired
    val groupService: GroupService
) {

    @GetMapping("/{id}")
    @Operation(summary = "Возвращает группу по заданному id")
    @ApiResponse(responseCode = "200")
    fun getById(@PathVariable id: Long): Response<GroupDto> {
        return Response.withData(groupService.getById(id))
    }


    @PostMapping("/create")
    @Operation(summary = "Добавление группы")
    @ApiResponse(responseCode = "200")
    fun add(@RequestHeader("user-id") userId: Long, @RequestParam("name") nameGroup: String): Response<Void> {
        groupService.add(userId,nameGroup)
        return Response.withoutErrors()
    }

    @PostMapping("/{id}/delete")
    @Operation(summary = "Удаление группы")
    @ApiResponse(responseCode = "200")
    fun delete(@RequestHeader("user-id") userId: Long, @PathVariable("id") groupId: Long): Response<Void> {
        groupService.delete(userId,groupId)
        return Response.withoutErrors()
    }


    @GetMapping("/all/user")
    @Operation(summary = "Получение списка групп пользователся")
    @ApiResponse(responseCode = "200")
    fun getAllByUser(@RequestHeader("user-id") userId: Long): Response<List<GroupDto>> {
        return Response.withData(groupService.getAllGroupByUser(userId))
    }

    @GetMapping("/all/available")
    @Operation(summary = "Получение списка всех доступных для пользователя групп")
    @ApiResponse(responseCode = "200")
    fun getAllAvailable(@RequestHeader("user-id") userId: Long): Response<List<GroupDto>> {
        return Response.withData(groupService.getAllAvailableGroup(userId))
    }



}