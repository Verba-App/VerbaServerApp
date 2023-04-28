package ru.nsu.ccfit.verba.verbaapi.app

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.nsu.ccfit.verba.verbaapi.core.cards.CardDto
import ru.nsu.ccfit.verba.verbaapi.core.cards.CardService
import ru.nsu.ccfit.verba.verbaapi.platform.Response

@RestController
@RequestMapping("api/card")
@Tag(name = "Карточки", description = "Запросы для взаимодействия с экземплярами карт")
class CardController(
    val cardService: CardService
) {

    @GetMapping("/all/catalog/{id}")
    @Operation(summary = "Получение списка каталогов группы")
    @ApiResponse(responseCode = "200")
    fun getAll(@PathVariable("id") catalogId: Long): Response<List<CardDto>> {
        return Response.withData(cardService.getAllCardByCatalog(catalogId))
    }






}