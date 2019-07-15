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
//        boardService.update();
    }

    @Order(4)
    @Test
    public void 게시물_삭제() {
        boardService.delete(1L);
    }

    @Test
    public void test() {
        log.debug("test");

        Board board = new Board(1L, "title", "content");

        BoardRequest newBoard = new BoardRequest("title", "content");
        boardService.create(board);
        board = new Board(2L, "new title", "new content");
        boardService.create(board);
        System.out.println(boardService.findById(1L));
        System.out.println(boardService.findById(2L));

        Board updatedBoard = new Board(1L, "updated", "updated");
        boardService.update(updatedBoard);
        System.out.println(boardService.findById(1L));

        boardService.delete(1L);
        System.out.println(boardService.findById(1L));
        log.debug("{}", boardService.findById(2L));
    }

}