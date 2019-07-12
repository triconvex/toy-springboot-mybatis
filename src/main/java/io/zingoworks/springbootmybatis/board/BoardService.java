package io.zingoworks.springbootmybatis.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    @Autowired
    private BoardMapper boardMapper;

    public Board findById(long id) {
        return boardMapper.findById(id);
    }

    public void createBoard(Board board) {
        boardMapper.createBoard(board);
    }

}
