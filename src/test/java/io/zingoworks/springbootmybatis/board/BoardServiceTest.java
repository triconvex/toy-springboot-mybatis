package io.zingoworks.springbootmybatis.board;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BoardServiceTest {

    private static final Logger log = LoggerFactory.getLogger(BoardServiceTest.class);

    @Autowired
    private BoardService boardService;

    @Test
    public void A_게시물_작성() {
        Board board = new Board("test title", "test content");
        boardService.create(board);
    }

    @Test
    public void B_게시물_조회() {
        boardService.findById(1L);
    }

    @Test
    public void C_게시물_수정() {
        Board board = new Board( "update board", "updated content");
        boardService.update(1L, board);
        log.debug("update board : {}", boardService.findById(1L));
    }

    @Test
    public void D_게시물_삭제() {
        boardService.delete(1L);
    }

}