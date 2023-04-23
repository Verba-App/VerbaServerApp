package ru.nsu.ccfit.verba.verbaauth.exception.impl;


import ru.nsu.ccfit.verba.verbaauth.enumeration.Code;
import ru.nsu.ccfit.verba.verbaauth.exception.BasicLicenceException;

public class BadRequestException extends BasicLicenceException {
    public BadRequestException() {
        super(Code.BAD_REQUEST);
    }

    public BadRequestException(String message) {
        super(Code.BAD_REQUEST, message);
    }
}
