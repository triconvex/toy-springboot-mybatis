package io.zingoworks.springbootmybatis.study;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such board")
public class BoardNotFoundException extends RuntimeException {

    public BoardNotFoundException(long boardId) {
        super(String.format("boardId(%s) not found", boardId));
    }
    
}
