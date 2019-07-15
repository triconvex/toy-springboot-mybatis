package io.zingoworks.springbootmybatis.board;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest()
@RunWith(SpringRunner.class)
public class BoardServiceTest {

    private static final Logger log = LoggerFactory.getLogger(BoardServiceTest.class);

    @Autowired
    private BoardService boardService;

    @Order(1)
    @Test
    public void 게시물_작성() {

    }

    @Order(2)
    @Test
    public void 게시물_조회() {

    }

    @Order(3)
    @Test
    public void 게시물_수정() {

    }

    @Order(4)
    @Test
    public void 게시물_삭제() {

    }

    @Test
    public void test() {
        log.debug("test");

        Board board = new Board(1L, "title", "content");
        boardService.createBoard(board);
        board = new Board(2L, "new title", "new content");
        boardService.createBoard(board);
        System.out.println(boardService.findById(1L));
        System.out.println(boardService.findById(2L));

    }

}