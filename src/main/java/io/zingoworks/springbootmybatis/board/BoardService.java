package io.zingoworks.springbootmybatis.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    @Autowired
    private BoardMapper boardMapper;

    public void create(Board board) {
        boardMapper.create(board);
    }

    public Board findById(long id) {
        Board board = boardMapper.findById(id);

        //TODO null 처리 개선필요
        if(board == null) {
            throw new IllegalArgumentException("해당 게시물이 존재하지 않습니다.");
        }

        return board;
    }

    public void update(long id, Board target) {
        Board original = findById(id);
        original.update(target);

        boardMapper.update(original);
    }

    public void delete(long id) {
        boardMapper.delete(id);
    }

}
