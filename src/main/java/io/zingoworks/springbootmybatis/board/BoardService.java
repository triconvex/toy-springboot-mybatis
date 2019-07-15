package io.zingoworks.springbootmybatis.board;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService implements BoardMapper {

    private static final Logger log = LoggerFactory.getLogger(BoardService.class);

    private final BoardMapper boardMapper;

    @Autowired
    public BoardService(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    @Override
    public void create(Board board) {
        boardMapper.create(board);
    }

    @Override
    public Board findById(long id) {
        return boardMapper.findById(id);
    }

    @Override
    public void update(Board board) {
        boardMapper.update(board);
    }

    @Override
    public void delete(long id) {
        boardMapper.delete(id);
    }

}
