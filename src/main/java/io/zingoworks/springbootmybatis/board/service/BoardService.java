package io.zingoworks.springbootmybatis.board.service;

import io.zingoworks.springbootmybatis.board.model.Board;

public interface BoardService {

    Board create(Board board);

    Board findById(long id);

    Board update(Board board);

    long delete(long id);

}
