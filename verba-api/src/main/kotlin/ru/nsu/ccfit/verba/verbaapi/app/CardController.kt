package ru.nsu.ccfit.verba.verbaapi.app

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*
import ru.nsu.ccfit.verba.verbaapi.core.cards.CardDto
import ru.nsu.ccfit.verba.verbaapi.core.cards.CardService
import ru.nsu.ccfit.verba.verbaapi.core.cards.StatusCardDto
import ru.nsu.ccfit.verba.verbaapi.core.cards.types.photo.PhotoCardDto
import ru.nsu.ccfit.verba.verbaapi.core.users.UserDto
import ru.nsu.ccfit.verba.verbaapi.platform.Response

@RestController
@RequestMapping("api/card")
@Tag(name = "Карточки", description = "Запросы для взаимодействия с экземплярами карт")
class CardController(
    val cardService: CardService
) {

        @GetMapping("/all/catalog/{id}")
    @Operation(summary = "Получение списка карточек каталога")
    @ApiResponse(responseCode = "200")
    fun getAllCard(@PathVariable("id") catalogId: Long): Response<List<CardDto>> {
        return Response.withData(cardService.getAllCardByCatalog(catalogId))
    }

    @PostMapping("/{id}")
    @Operation(summary = "Возвращает экземпляр карты по заданному id")
    @ApiResponse(responseCode = "200")
    fun getCardById(@Parameter(description = "Идентификатор карты") @PathVariable id: Long): Response<CardDto> {
        return Response.withData(cardService.getCardById(id))
    }

    @PostMapping("/renewal/{id}")
    @Operation(summary = "Оставляет этап изучения каточки неизменненным")
    @ApiResponse(responseCode = "200")
    fun renewalCardById(
        @RequestHeader("user-id") userId: Long,
        @Parameter(description = "Идентификатор карты") @PathVariable("id") cardId: Long
    ): Response<Void> {
        cardService.renewalCardByUserId(userId, cardId)
        return Response.withoutErrors()
    }


    @GetMapping("/status/{id}")
    @Operation(summary = "Получение статуса карточка")
    @ApiResponse(responseCode = "200")
    fun getStatusCard(
        @RequestHeader("user-id") userId: Long,
        @PathVariable("id") cardId: Long
    ): Response<StatusCardDto> {
        return Response.withData(cardService.getStatusCardById(userId,cardId))
    }


    @PostMapping("/studied/{id}")
    @Operation(summary = "Переводит каточку на следующий этап изучения")
    @ApiResponse(responseCode = "200")
    fun studiedCardById(
        @RequestHeader("user-id") userId: Long,
        @Parameter(description = "Идентификатор карты") @PathVariable("id") cardId: Long
    ): Response<Void> {
        cardService.studiedCardByUserId(userId, cardId)
        return Response.withoutErrors()
    }

    @PostMapping("/photo/{id}")
    @Operation(summary = "Возвращает экземпляр фото-карты по заданному id")
    @ApiResponse(responseCode = "200")
    fun getPhotoCardById(@Parameter(description = "Идентификатор карты") @PathVariable id: Long): Response<PhotoCardDto> {
        return Response.withData(cardService.getPhotoCardById(id))
    }


    @PostMapping("/create/photo")
    @Operation(summary = "Возвращает экземпляр фото-карты по заданному id")
    @ApiResponse(responseCode = "200")
    fun createPhotoCard(@RequestBody photoCardDto: PhotoCardDto): Response<Void> {
        cardService.createPhotoCard(photoCardDto)
        return Response.withoutErrors()
    }
}