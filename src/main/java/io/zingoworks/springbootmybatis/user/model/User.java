package io.zingoworks.springbootmybatis.user.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@ToString
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //TODO 전략 학습
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Builder
    public User(long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    //TODO noargs쓰면 클래스단위 빌더 못쓰나?
}
