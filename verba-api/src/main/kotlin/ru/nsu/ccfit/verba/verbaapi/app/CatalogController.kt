package ru.nsu.ccfit.verba.verbaapi.app

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import ru.nsu.ccfit.verba.verbaapi.core.catalogs.CatalogDto
import ru.nsu.ccfit.verba.verbaapi.core.catalogs.CatalogService
import ru.nsu.ccfit.verba.verbaapi.core.groups.GroupDto
import ru.nsu.ccfit.verba.verbaapi.platform.Response

@RestController
@RequestMapping("/catalog")
@Tag(name = "Каталоги", description = "Запросы для взаимодействия с экземплярами каталогов")
class CatalogController(
    val catalogService: CatalogService
) {


    @PostMapping("/{id}")
    @Operation(summary = "Возвращает пользователя по заданному id")
    @ApiResponse(responseCode = "200")
    fun getById(@Parameter(description = "Идентификатор каталога") @PathVariable id: Long): Response<CatalogDto> {
        return Response.withData(catalogService.getById(id))
    }


    @PostMapping("/create")
    @Operation(summary = "Добавление каталога")
    @ApiResponse(responseCode = "200")
    fun add(
        @RequestHeader("user-id") userId: Long,
        @RequestParam("group-id") groupId: Long,
        @RequestBody catalogDto: CatalogDto
    ): Response<Void> {
        catalogService.add(catalogDto, userId, groupId)
        return Response.withoutErrors()
    }

    @GetMapping("/all/group/{id}")
    @Operation(summary = "Получение списка каталогов группы")
    @ApiResponse(responseCode = "200")
    fun getAll(@PathVariable("id") groupId: Long): Response<List<CatalogDto>> {
        return Response.withData(catalogService.getAllCatalogByGroup(groupId))
    }


}