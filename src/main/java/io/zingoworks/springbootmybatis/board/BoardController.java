package io.zingoworks.springbootmybatis.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping
    public void createBoard(Board board) {
        boardService.createBoard(board);
    }

    @GetMapping("/{id}")
    public Board getBoard(@PathVariable long id) {
        return boardService.findById(id);
    }

}
