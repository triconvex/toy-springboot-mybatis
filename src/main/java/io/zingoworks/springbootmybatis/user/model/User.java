package io.zingoworks.springbootmybatis.user.model;

import lombok.*;

import javax.persistence.Entity;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
@Builder
@Entity
public class User {

    private long id;
    private String name;
    private String password;

}
