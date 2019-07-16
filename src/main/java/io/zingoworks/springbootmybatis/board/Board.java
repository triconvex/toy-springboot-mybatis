package io.zingoworks.springbootmybatis.board;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Board {

    private long id;
    private String title;
    private String content;

    //TODO
    // default 생성자 필요한 경우와 이유

    public Board(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Board(long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public void update(Board board) {
        this.title = board.title;
        this.content = board.content;
    }

}
