package io.zingoworks.springbootmybatis.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @PostMapping
    public void create(@RequestBody BoardRequest boardRequest) {
        boardService.create(boardRequest.toBoard());
    }

    @GetMapping("/{id}")
    public Board read(@PathVariable long id) {
        return boardService.findById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable long id, @RequestBody BoardRequest boardRequest) {
        boardService.update(id, boardRequest.toBoard());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        boardService.delete(id);
    }

}
