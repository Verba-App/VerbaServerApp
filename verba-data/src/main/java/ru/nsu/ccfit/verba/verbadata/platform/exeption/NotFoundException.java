package ru.nsu.ccfit.verba.verbadata.platform.exeption;


import ru.nsu.ccfit.verba.verbadata.platform.enumeration.Code;
import ru.nsu.ccfit.verba.verbadata.platform.exeption.BasicVerbaException;

public class NotFoundException extends BasicVerbaException {
    public NotFoundException() {
        super(Code.NOT_FOUND);
    }

    public NotFoundException(String message) {
        super(Code.NOT_FOUND, message);
    }
}
