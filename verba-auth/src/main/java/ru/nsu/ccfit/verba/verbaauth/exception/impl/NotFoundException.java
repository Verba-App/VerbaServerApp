package ru.nsu.ccfit.verba.verbaauth.exception.impl;


import ru.nsu.ccfit.verba.verbaauth.enumeration.Code;
import ru.nsu.ccfit.verba.verbaauth.exception.BasicLicenceException;

public class NotFoundException extends BasicLicenceException {
    public NotFoundException() {
        super(Code.NOT_FOUND);
    }

    public NotFoundException(String message) {
        super(Code.NOT_FOUND, message);
    }
}
