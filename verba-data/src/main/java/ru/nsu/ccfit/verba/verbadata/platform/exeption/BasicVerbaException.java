package ru.nsu.ccfit.verba.verbadata.platform.exeption;

import lombok.Getter;
import ru.nsu.ccfit.verba.verbadata.platform.enumeration.Code;



@Getter
public abstract class BasicVerbaException extends RuntimeException {
    private final Code code;

    protected BasicVerbaException(Code code) {
        this(code, code.getErrorMessage());
    }

    protected BasicVerbaException(Code code, String message) {
        super(message);
        this.code = code;
    }
}
