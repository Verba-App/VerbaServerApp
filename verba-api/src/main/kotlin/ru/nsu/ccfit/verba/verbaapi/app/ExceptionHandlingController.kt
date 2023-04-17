package ru.nsu.ccfit.verba.verbaapi.app

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import ru.nsu.ccfit.verba.verbaapi.platform.Code
import ru.nsu.ccfit.verba.verbaapi.platform.Response
import ru.nsu.ccfit.verba.verbaapi.platform.exception.BasicVerbaException

@ResponseBody
@ControllerAdvice
class ExceptionHandlingController {

    @ExceptionHandler(BasicVerbaException::class)
    fun handleVerbaException(exception: BasicVerbaException): ResponseEntity<Response<Void>> {
        return getResponseWithError(exception.errorCode, exception)
    }

    @ExceptionHandler(Exception::class)
    fun handleError(exception: Exception): ResponseEntity<Response<Void>> {
        return getResponseWithError(Code.INTERNAL_SERVER_ERROR, exception)
    }

    private fun getResponseWithError(errorCode: Code, exception: Exception): ResponseEntity<Response<Void>> {
        return ResponseEntity.status(errorCode.httpStatus)
            .body(Response.withError(errorCode, exception.message))
    }
}