package io.zingoworks.springbootmybatis.api.response;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class ApiResult<T> {

    private boolean success;
    private ApiError error;
    private T response;

    public ApiResult(T response) {
        this.response = response;
        this.success = true; //enum으로 방어적코딩, success의 필요성(?), status code가 이미 있음
        //지금은 success, status code 둘다 고려해야함
    }

    public ApiResult(String message, HttpStatus status) {
        this.success = false;
        this.response = null;
        this.error = new ApiError(message, status);
    }

    public ApiResult(Throwable throwable, HttpStatus status) {
        this.success = false;
        this.response = null;
        this.error = new ApiError(throwable, status);
    }

}
