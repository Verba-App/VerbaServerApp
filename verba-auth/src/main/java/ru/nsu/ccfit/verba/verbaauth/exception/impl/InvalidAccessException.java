package ru.nsu.ccfit.verba.verbaauth.exception.impl;

import ru.nsu.ccfit.verba.verbaauth.enumeration.Code;
import ru.nsu.ccfit.verba.verbaauth.exception.BasicLicenceException;

public class InvalidAccessException extends BasicLicenceException {
    public InvalidAccessException() {
        super(Code.UNAUTHORIZED);
    }

    public InvalidAccessException(String message) {
        super(Code.UNAUTHORIZED, message);
    }
}
