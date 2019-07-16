package io.zingoworks.springbootmybatis.board;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class BoardTest {

    @Test
    public void 게시물_업데이트() {
        Board original = new Board("original title", "original content");
        Board target = new Board("updated title", "updated content");

        original.update(target);
        assertThat(original).isEqualTo(target);
    }

}