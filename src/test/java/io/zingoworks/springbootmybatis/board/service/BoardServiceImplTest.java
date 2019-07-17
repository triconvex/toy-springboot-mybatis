package io.zingoworks.springbootmybatis.board.service;

import io.zingoworks.springbootmybatis.board.model.Board;
import io.zingoworks.springbootmybatis.board.service.impl.BoardServiceImpl;
import io.zingoworks.springbootmybatis.exception.BoardNotFoundException;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Java6Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BoardServiceImplTest {

    private static final Board DEFAULT_BOARD = new Board(1L, "test title", "test content");

    @Autowired
    private BoardServiceImpl boardServiceImpl;

    @Test
    public void A_게시물_작성() {
        Board board = new Board("test title", "test content");
        boardServiceImpl.create(board);

        assertThat(boardServiceImpl.findById(1L)).isEqualTo(DEFAULT_BOARD);
    }

    @Test
    public void B_게시물_조회() {
        assertThat(boardServiceImpl.findById(1L)).isEqualTo(DEFAULT_BOARD);
    }

    @Test(expected = BoardNotFoundException.class)
    public void B_존재하지않는_게시물_조회() {
        boardServiceImpl.findById(5L);
    }

    @Test
    @Transactional
    public void C_게시물_수정() {
        Board target = new Board(1L, "update board", "updated content");
        boardServiceImpl.update(target);

        assertThat(boardServiceImpl.findById(1L)).isEqualTo(target);
    }

    @Test(expected = BoardNotFoundException.class)
    public void C_존재하지않는_게시물_수정() {
        Board target = new Board(5L, "update board", "updated content");
        boardServiceImpl.update(target);
    }

    @Test
    @Transactional
    public void D_게시물_삭제() {
        boardServiceImpl.delete(1L);
    }

    @Test(expected = BoardNotFoundException.class)
    public void D_존재하지않는_게시물_삭제() {
        boardServiceImpl.delete(5L);
    }

}