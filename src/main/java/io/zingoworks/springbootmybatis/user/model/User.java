package io.zingoworks.springbootmybatis.user.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
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

    public User update(User target) {
        if(!this.password.equals(target.password)) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        this.name = target.name;
        return this;
    }

}
