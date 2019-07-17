package io.zingoworks.springbootmybatis.board.model;

import lombok.*;

import static com.google.common.base.Preconditions.checkArgument;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Board {

    private Long id;
    private String title;
    private String content;

    public Board(String title, String content) {
        this(null, title, content);
    }

    public Board(Long id, String title, String content) {
        checkArgument(2 <= title.length() && title.length() <= 20,
                "Board title length must be between 2 ~ 20");
        checkArgument(2 <= content.length() && content.length() <= 75,
                "Board title length must be between 2 ~ 75");

        this.id = id;
        this.title = title;
        this.content = content;
    }

    public void update(Board target) {
        this.title = target.title;
        this.content = target.content;
    }

}
