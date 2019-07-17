package io.zingoworks.springbootmybatis.board.service.impl;

import io.zingoworks.springbootmybatis.board.dao.BoardMapper;
import io.zingoworks.springbootmybatis.board.model.Board;
import io.zingoworks.springbootmybatis.board.service.BoardService;
import io.zingoworks.springbootmybatis.exception.BoardNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

    private BoardMapper boardMapper;

    @Transactional
    @Override
    public void create(Board board) {
        boardMapper.create(board);
    }

    @Override
    public Board findById(long id) {
        checkNull(id);

        Board board = boardMapper.findById(id);
        return board;
    }

    @Transactional
    @Override
    public void update(Board board) {
        checkNull(board.getId());
        boardMapper.update(board);
    }

    @Transactional
    @Override
    public void delete(long id) {
        checkNull(id);
        boardMapper.delete(id);
    }

    private void checkNull(long id) {
        Board board = boardMapper.findById(id);
        if(board == null) {
            throw new BoardNotFoundException("해당 게시물이 존재하지 않습니다.");
        }
    }

}
