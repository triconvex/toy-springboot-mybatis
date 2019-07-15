package io.zingoworks.springbootmybatis.board;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/board")
public class BoardController {

    private static final Logger log = LoggerFactory.getLogger(BoardController.class);

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping
    public void create(@RequestBody BoardRequest boardRequest) {
        log.debug("Board create : {}", boardRequest);
        boardService.create(boardRequest.toBoard());
    }

    @GetMapping("/{id}")
    public Board read(@PathVariable long id) {
        log.debug("Read board({})", id);
        return boardService.findById(id);
    }

    @PutMapping
    public void update(Board board) {
        boardService.update(board);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        boardService.delete(id);
    }

}
