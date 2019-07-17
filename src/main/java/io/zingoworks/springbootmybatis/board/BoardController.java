package io.zingoworks.springbootmybatis.board;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.zingoworks.springbootmybatis.board.model.Board;
import io.zingoworks.springbootmybatis.board.model.BoardRequest;
import io.zingoworks.springbootmybatis.board.service.BoardService;
import io.zingoworks.springbootmybatis.api.response.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @ApiOperation(value = "게시물 작성")
    @PostMapping
    public ApiResult<String> create(
            @ApiParam(value = "작성 게시물 제목과 내용")
            @RequestBody BoardRequest boardRequest) {
        boardService.create(boardRequest.toBoard());
        return new ApiResult<>("게시물 작성 성공");
    }

    @ApiOperation(value = "게시물 조회")
    @GetMapping("/{id}")
    public ApiResult<Board> read(
            @ApiParam(value = "조회하는 게시물의 id")
            @PathVariable long id) {
        return new ApiResult<>(boardService.findById(id));
    }


    @ApiOperation(value = "게시물 수정")
    @PutMapping("/{id}")
    public ApiResult<Board> update(
            @ApiParam(value = "수정하려는 게시물의 id")
            @PathVariable long id,
            @ApiParam(value = "수정 된 제목과 내용")
            @RequestBody BoardRequest boardRequest) {
        return new ApiResult<>(boardService.update(id, boardRequest.toBoard()));
    }

    @ApiOperation(value = "게시물 삭제")
    @DeleteMapping("/{id}")
    public ApiResult<String> delete(
            @ApiParam(value = "삭제하려는 게시물의 id")
            @PathVariable long id) {
        boardService.delete(id);
        return new ApiResult<>("게시물 삭제 성공");
    }

}
