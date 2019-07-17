package io.zingoworks.springbootmybatis.board.model;

import lombok.*;

import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class BoardRequest {

    @Size(min = 2, max = 20)
    private String title;
    @Size(min = 2, max = 75)
    private String content;

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
