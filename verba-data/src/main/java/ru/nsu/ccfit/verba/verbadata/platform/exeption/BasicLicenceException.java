package ru.nsu.ccfit.verba.verbadata.platform.exeption;

import lombok.Getter;
import ru.nsu.ccfit.verba.verbadata.platform.enumeration.Code;



@Getter
public abstract class BasicLicenceException extends RuntimeException {
    private final Code code;

    protected BasicLicenceException(Code code) {
        this(code, code.getErrorMessage());
    }

    protected BasicLicenceException(Code code, String message) {
        super(message);
        this.code = code;
    }
}
