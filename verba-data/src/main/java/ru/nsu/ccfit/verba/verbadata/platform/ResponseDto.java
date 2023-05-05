package ru.nsu.ccfit.verba.verbadata.platform;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;
import ru.nsu.ccfit.verba.verbadata.platform.enumeration.Code;


@Value
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class ResponseDto<T> {

    Code code;

    String message;

    T data;

    public static <T> ResponseDto<T> withData(T data) {
        return new ResponseDto<>(Code.OK, null, data);
    }

    public static <T> ResponseDto<T> withError(Code code, String errorMessage) {
        return new ResponseDto<>(code, errorMessage, null);
    }

    public static ResponseDto<Void> withoutErrors() {
        return new ResponseDto<>(Code.OK, null, null);
    }
}
