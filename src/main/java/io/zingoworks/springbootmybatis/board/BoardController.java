package io.zingoworks.springbootmybatis.board;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.zingoworks.springbootmybatis.board.model.Board;
import io.zingoworks.springbootmybatis.board.model.BoardRequest;
import io.zingoworks.springbootmybatis.board.service.impl.BoardServiceImpl;
import io.zingoworks.springbootmybatis.api.response.ApiResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/board")
@AllArgsConstructor
public class BoardController {

    private BoardServiceImpl boardServiceImpl;

    @ApiOperation(value = "게시물 작성")
    @PostMapping
    public ApiResult<String> create(
            @ApiParam(value = "작성 게시물 제목과 내용")
            @RequestBody BoardRequest boardRequest)
    {
        Board board = boardRequest.toEntity();
        boardServiceImpl.create(board);
        return new ApiResult<>("게시물 작성 성공");
    }

    @ApiOperation(value = "게시물 조회")
    @GetMapping("/{id}")
    public ApiResult<Board> read(
            @ApiParam(value = "조회하는 게시물의 id")
            @PathVariable long id)
    {
        return new ApiResult<>(boardServiceImpl.findById(id));
    }


    @ApiOperation(value = "게시물 수정")
    @PutMapping("/{id}")
    public ApiResult<String> update(
            @ApiParam(value = "수정하려는 게시물의 id")
            @PathVariable long id,
            @ApiParam(value = "수정 된 제목과 내용")
            @RequestBody BoardRequest boardRequest)
    {
        Board target = Board.builder()
                .id(id)
                .title(boardRequest.getTitle())
                .content(boardRequest.getContent())
                .build();

        boardServiceImpl.update(target);
        return new ApiResult<>("게시물 수정 성공");
    }

    @ApiOperation(value = "게시물 삭제")
    @DeleteMapping("/{id}")
    public ApiResult<String> delete(
            @ApiParam(value = "삭제하려는 게시물의 id")
            @PathVariable long id)
    {
        boardServiceImpl.delete(id);
        return new ApiResult<>("게시물 삭제 성공");
    }

}
