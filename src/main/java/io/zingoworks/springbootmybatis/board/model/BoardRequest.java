package io.zingoworks.springbootmybatis.board.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class BoardRequest {

    private String title;
    private String content;

    @Builder
    public BoardRequest(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Board toEntity() {
        return Board.builder()
                .title(title)
                .content(content)
                .build();
    }

}
