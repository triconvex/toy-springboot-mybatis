package io.zingoworks.springbootmybatis.board.service.impl;

import io.zingoworks.springbootmybatis.board.model.Board;
import io.zingoworks.springbootmybatis.board.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

    @Override
    public Board create(Board board) {
        return null;
    }

    @Override
    public Board findById(long id) {
        return null;
    }

    @Override
    public Board update(Board board) {
        return null;
    }

    @Override
    public long delete(long id) {
        return 0;
    }

}
