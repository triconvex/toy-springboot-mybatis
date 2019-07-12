package io.zingoworks.springbootmybatis.board;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest()
@RunWith(SpringRunner.class)
public class BoardServiceTest {

    private static final Logger log = LoggerFactory.getLogger(BoardServiceTest.class);

    @Autowired
    private BoardService boardService;

    @Test
    public void test() {
        Board board = new Board(1L, "title", "content");
        boardService.createBoard(board);
        board = new Board(2L, "new title", "new content");
        boardService.createBoard(board);
        System.out.println(boardService.findById(1L));
        System.out.println(boardService.findById(2L));

    }

}