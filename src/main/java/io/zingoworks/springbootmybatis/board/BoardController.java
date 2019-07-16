package io.zingoworks.springbootmybatis.board;

import io.swagger.annotations.ApiOperation;
import io.zingoworks.springbootmybatis.response.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @ApiOperation(value = "게시물 작성")
    @PostMapping
    public ApiResult<String> create(@RequestBody BoardRequest boardRequest) {
        boardService.create(boardRequest.toBoard());
        return new ApiResult<>("게시물 작성 성공");
    }

    @ApiOperation(value = "게시물 조회")
    @GetMapping("/{id}")
    public ApiResult<Board> read(@PathVariable long id) {
        return new ApiResult<>(boardService.findById(id));
    }


    @ApiOperation(value = "게시물 수정")
    @PutMapping("/{id}")
    public ApiResult<Board> update(@PathVariable long id, @RequestBody BoardRequest boardRequest) {
        return new ApiResult<>(boardService.update(id, boardRequest.toBoard()));
    }

    @ApiOperation(value = "게시물 삭제")
    @DeleteMapping("/{id}")
    public ApiResult<String> delete(@PathVariable long id) {
        boardService.delete(id);
        return new ApiResult<>("게시물 삭제 성공");
    }

}
