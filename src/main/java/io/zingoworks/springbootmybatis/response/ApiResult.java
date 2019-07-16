package io.zingoworks.springbootmybatis.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApiResult<T> {

    private boolean success;

    private T response;

    public ApiResult(T response) {
        this.response = response;
        this.success = true;
    }

    public ApiResult(String message, HttpStatus status) {
        this.success = false;
        this.response = null;
    }

    public ApiResult(Throwable throwable, HttpStatus status) {
        this.success = false;
        this.response = null;
    }

}
