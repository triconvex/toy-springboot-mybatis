package io.zingoworks.springbootmybatis.board;

import io.zingoworks.springbootmybatis.exception.BoardNotFoundException;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BoardServiceTest {

    private static final Board DEFAULT_BOARD = new Board(1L, "test title", "test content");

    @Autowired
    private BoardService boardService;

    @Test
    public void A_게시물_작성() {
        Board board = new Board("test title", "test content");
        boardService.create(board);

        assertThat(boardService.findById(1L)).isEqualTo(DEFAULT_BOARD);
    }

    @Test
    public void B_게시물_조회() {
        assertThat(boardService.findById(1L)).isEqualTo(DEFAULT_BOARD);
    }

    @Test(expected = BoardNotFoundException.class)
    public void B_존재하지않는_게시물_조회() {
        boardService.findById(5L);
    }

    @Test
    public void C_게시물_수정() {
        Board target = new Board( 1L, "update board", "updated content");
        boardService.update(1L, target);

        assertThat(boardService.findById(1L)).isEqualTo(target);
    }

    @Test(expected = BoardNotFoundException.class)
    public void C_존재하지않는_게시물_수정() {
        Board target = new Board( 1L, "update board", "updated content");
        boardService.update(5L, target);
    }

    @Test
    public void D_게시물_삭제() {
        boardService.delete(1L);
    }

    @Test(expected = BoardNotFoundException.class)
    public void D_존재하지않는_게시물_삭제() {
        boardService.delete(5L);
    }

}