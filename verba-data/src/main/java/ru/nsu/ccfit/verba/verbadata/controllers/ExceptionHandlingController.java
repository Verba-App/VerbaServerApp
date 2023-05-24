package ru.nsu.ccfit.verba.verbadata.controllers;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.nsu.ccfit.verba.verbadata.platform.ResponseDto;

import ru.nsu.ccfit.verba.verbadata.platform.enumeration.Code;
import ru.nsu.ccfit.verba.verbadata.platform.exeption.BasicVerbaException;

import java.util.List;

@ResponseBody
@ControllerAdvice
public class ExceptionHandlingController {

    @ExceptionHandler(BasicVerbaException.class)
    public ResponseEntity<ResponseDto<Void>> handleLicenceException(BasicVerbaException exception) {
        return getResponseWithError(exception.getCode(), exception);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDto<Void>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<String> messageException =  exception.getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .toList();
        return getResponseWithError(Code.BAD_REQUEST, new Exception(messageException.toString()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDto<Void>> handleError(Exception exception) {
        return getResponseWithError(Code.INTERNAL_SERVER_ERROR, exception);
    }

    private ResponseEntity<ResponseDto<Void>> getResponseWithError(Code code, Exception exception) {

        return ResponseEntity.status(code.getHttpStatus())
                .body(ResponseDto.withError(code, exception.getMessage()));
    }
}
