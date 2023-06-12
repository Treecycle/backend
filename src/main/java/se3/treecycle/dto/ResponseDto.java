package se3.treecycle.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ResponseDto<T> {
    private final String status;
    private final Integer code;
    private final String message;
    private final T data;

    public static ResponseDto success(String message) {
        return new ResponseDto("success", 200, message, null);
    }

    public static <T> ResponseDto success(String message, T data) {
        return new ResponseDto("success", 200, message, data);
    }

    public static ResponseDto fail(int code, String message) {
        return new ResponseDto("fail", code, message, null);
    }
}
