package io.zingoworks.springbootmybatis.board.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@EqualsAndHashCode
@ToString
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    @Builder
    public Board(Long id, String title, String content) {
        //TODO parameter validation(?)
        this.id = id;
        this.title = title;
        this.content = content;
    }

}
