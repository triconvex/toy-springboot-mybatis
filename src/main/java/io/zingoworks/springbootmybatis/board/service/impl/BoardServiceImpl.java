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
        return getExistBoard(id);
    }

    @Transactional //트랜잭션의 경계, 글로벌 트랜잭션 정책
    @Override
    public void update(Board board) {
        getExistBoard(board.getId());
        boardMapper.update(board);
    }

    @Transactional
    @Override
    public void delete(long id) {
        getExistBoard(id);
        boardMapper.delete(id);
    }

    private Board getExistBoard(long id) { //메소드명, 반환타입
        Board board = boardMapper.findById(id);
        if(board == null) {
            throw new BoardNotFoundException("해당 게시물이 존재하지 않습니다.");
        }

        return board;
    }

}
