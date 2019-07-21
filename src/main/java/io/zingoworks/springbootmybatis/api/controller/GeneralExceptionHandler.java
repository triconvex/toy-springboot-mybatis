package io.zingoworks.springbootmybatis.api.controller;

import io.zingoworks.springbootmybatis.exception.BoardNotFoundException;
import io.zingoworks.springbootmybatis.api.response.ApiResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;

@ControllerAdvice
public class GeneralExceptionHandler {

    private Logger log = LoggerFactory.getLogger(getClass());

    private ResponseEntity<ApiResult> createResponse(Throwable throwable, HttpStatus status) {
        if(log.isErrorEnabled()) {
            throwable.printStackTrace();
//            log.error("error occured : {}", throwable.); //에러 스택트레이스 찍기
        }
        HttpHeaders headers = new HttpHeaders();
//        headers.save("Content-Type", "application/json"); 지정하는 이유?
        return new ResponseEntity<>(new ApiResult(throwable, status), headers, status);
    }

    @ExceptionHandler(BoardNotFoundException.class) //에러 발생 시 로그
    public ResponseEntity<?> handleBoardNotFoundException(Exception e) {
        return createResponse(e, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({
            IllegalStateException.class, IllegalArgumentException.class,
            TypeMismatchException.class, HttpMessageNotReadableException.class,
            MissingServletRequestParameterException.class, MultipartException.class
    })
    public ResponseEntity<?> handleBadRequestException(Exception e) {
        return createResponse(e, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMediaTypeException.class)
    public ResponseEntity<?> handleHttpMediaTypeException(Exception e) {
        return createResponse(e, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<?> handleMethodNotAllowedException(Exception e) {
        return createResponse(e, HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler({Exception.class, RuntimeException.class})
    public ResponseEntity<?> handleException(Exception e) {
        log.error(e.getMessage(), e);
        return createResponse(e, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
