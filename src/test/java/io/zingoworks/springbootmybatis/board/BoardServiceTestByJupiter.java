package io.zingoworks.springbootmybatis.board;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BoardServiceTestByJupiter {

    private static final Logger log = LoggerFactory.getLogger(BoardServiceTestByJupiter.class);

    @Autowired
    private BoardService boardService;

    @Order(1)
    @Test
    public void A_게시물_작성() {
        Board board = new Board("test title", "test content");
        boardService.create(board);
    }

    @Order(2)
    @Test
    public void B_게시물_조회() {
        boardService.findById(1L);
    }

    @Order(3)
    @Test
    public void C_게시물_수정() {
        Board board = new Board( "update board", "updated content");
        boardService.update(1L, board);

        log.debug("update board : {}", boardService.findById(1L));
    }

    @Order(4)
    @Test
    public void D_게시물_삭제() {
        boardService.delete(1L);
    }

}