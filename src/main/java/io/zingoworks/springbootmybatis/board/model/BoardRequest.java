package io.zingoworks.springbootmybatis.board.model;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class BoardRequest {

    private String title;
    private String content;

    public BoardRequest(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Board toBoard() {
        return new Board(title, content);
    }

}
