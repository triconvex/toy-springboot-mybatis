package io.zingoworks.springbootmybatis.board;

import io.zingoworks.springbootmybatis.exception.BoardNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    @Autowired
    private BoardMapper boardMapper;

    public void create(Board board) {
        boardMapper.create(board);
    }

    public Board findById(Long id) {
        return checkNotNull(id);
    }

    public Board update(long id, Board target) {
        Board original = findById(id);
        original.update(target);

        boardMapper.update(original);

        return original;
    }

    public void delete(long id) {
        checkNotNull(id);
        boardMapper.delete(id);
    }

    private Board checkNotNull(long id) {
        Board board = boardMapper.findById(id);

        if (board == null) {
            throw new BoardNotFoundException("해당 게시물이 존재하지 않습니다.");
        }

        return board;
    }

}
