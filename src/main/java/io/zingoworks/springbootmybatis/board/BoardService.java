package io.zingoworks.springbootmybatis.board;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    private static final Logger log = LoggerFactory.getLogger(BoardService.class);

    @Autowired
    private BoardMapper boardMapper;

    public void createBoard(Board board) {
        log.debug("board created!");
        boardMapper.createBoard(board);
    }

    public Board findById(long id) {
        return boardMapper.findById(id);
    }

}
