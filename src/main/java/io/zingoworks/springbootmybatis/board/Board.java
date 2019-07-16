package io.zingoworks.springbootmybatis.board;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Board {

    private Long id;
    private String title;
    private String content;

    public Board(String title, String content) {
        this(null, title, content);
    }

    public Board(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public void update(Board target) {
        this.title = target.title;
        this.content = target.content;
    }

}
