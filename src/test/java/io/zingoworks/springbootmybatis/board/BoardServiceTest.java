package io.zingoworks.springbootmybatis.board;

import org.junit.Test;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BoardServiceTest {

    private static final Logger log = LoggerFactory.getLogger(BoardServiceTest.class);

    @Autowired
    private BoardService boardService;

    @Order(1)
    @Test
    public void 게시물_작성() {
        Board board = new Board("test title", "test content");
        boardService.create(board);
    }

    @Order(2)
    @Test
    public void 게시물_조회() {
        boardService.findById(1L);
    }

    @Order(3)
    @Test
    public void 게시물_수정() {
        Board board = new Board(1L, "update board", "updated content");
        boardService.update(board);
        log.debug("update board : {}", boardService.findById(1L));
    }

    @Order(4)
    @Test
    public void 게시물_삭제() {
        boardService.delete(1L);
    }

}