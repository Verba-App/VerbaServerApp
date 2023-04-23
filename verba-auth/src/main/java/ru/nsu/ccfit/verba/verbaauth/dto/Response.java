package ru.nsu.ccfit.verba.verbaauth.dto;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;
import ru.nsu.ccfit.verba.verbaauth.enumeration.Code;

@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Response<T> {

    Code code;

    String message;

    T data;

    public static <T> Response<T> withData(T data) {
        return new Response<>(Code.OK, null, data);
    }

    public static <T> Response<T> withError(Code code, String errorMessage) {
        return new Response<>(code, errorMessage, null);
    }

    public static Response<Void> withoutErrors() {
        return new Response<>(Code.OK, null, null);
    }
}
