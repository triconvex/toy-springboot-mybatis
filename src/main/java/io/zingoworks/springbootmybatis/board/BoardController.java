package io.zingoworks.springbootmybatis.board;

import io.zingoworks.springbootmybatis.board.model.Board;
import io.zingoworks.springbootmybatis.board.model.BoardRequest;
import io.zingoworks.springbootmybatis.board.service.impl.BoardServiceImpl;
import io.zingoworks.springbootmybatis.api.response.ApiResult;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/board") //boards 복수. 레스트풀
@AllArgsConstructor
@Slf4j //로거팩토리 마다 사이드이펙트
//@Log4j
public class BoardController {
    
//    private static final Logger log = LoggerFactory.getLogger(BoardController.class); //롬복 어노테이션

    private BoardServiceImpl boardServiceImpl;

    @PostMapping
    public ApiResult<String> create(
            @RequestBody @Valid BoardRequest boardRequest)
    {
        log.debug("create board");

        Board board = boardRequest.toEntity();
        boardServiceImpl.create(board);
        return new ApiResult<>("게시물 작성 성공");
    }

    @GetMapping("/{id}")
    public ApiResult<Board> read(
            @PathVariable long id)
    {
        if(log.isDebugEnabled()) { //log isDebugEnabled, 로거 구현체가 여러개일 때, 스프링의 로그정책
            log.debug("read board({})", id);
        }
        return new ApiResult<>(boardServiceImpl.findById(id));
    }

    @PutMapping("/{id}")
    public ApiResult<String> update(
            @PathVariable long id,
            @RequestBody @Valid BoardRequest boardRequest)
    {
        log.debug("modify board"); //마찬가지 로그

        //부수효과
        //board request to entity 인자
        Board target = Board.builder()
                .id(id)
                .title(boardRequest.getTitle())
                .content(boardRequest.getContent())
                .build();

        boardServiceImpl.update(target);
        return new ApiResult<>("게시물 수정 성공");
    }

    @DeleteMapping("/{id}")
    public ApiResult<String> delete(
            @PathVariable long id)
    {
        log.debug("delete board");

        boardServiceImpl.delete(id);
        return new ApiResult<>("게시물 삭제 성공");
    }

}
