package ru.nsu.ccfit.verba.verbaauth.controller;

import org.hibernate.cfg.beanvalidation.IntegrationException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.nsu.ccfit.verba.verbaauth.dto.Response;
import ru.nsu.ccfit.verba.verbaauth.enumeration.Code;
import ru.nsu.ccfit.verba.verbaauth.exception.BasicLicenceException;

import java.util.List;

@ResponseBody
@ControllerAdvice
public class ExceptionHandlingController {

    @ExceptionHandler(BasicLicenceException.class)
    public ResponseEntity<Response<Void>> handleLicenceException(BasicLicenceException exception) {
        return getResponseWithError(exception.getCode(), exception);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Response<Void>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<String> messageException =  exception.getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .toList();

        return getResponseWithError(Code.BAD_REQUEST, new Exception(messageException.toString()));
    }

    @ExceptionHandler(IntegrationException.class)
    public ResponseEntity<Response<Void>> handleMethodArgumentNonUniqueException(IntegrationException exception) {
        return getResponseWithError(Code.BAD_REQUEST, exception);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response<Void>> handleError(Exception exception) {
        return getResponseWithError(Code.INTERNAL_SERVER_ERROR, exception);
    }

    private ResponseEntity<Response<Void>> getResponseWithError(Code code, Exception exception) {

        return ResponseEntity.status(code.getHttpStatus())
                .body(Response.withError(code, exception.getMessage()));
    }
}
