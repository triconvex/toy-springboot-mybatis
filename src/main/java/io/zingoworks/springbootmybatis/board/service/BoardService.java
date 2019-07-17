package io.zingoworks.springbootmybatis.board.service;

import io.zingoworks.springbootmybatis.board.model.Board;

public interface BoardService {

    void create(Board board);

    Board findById(long id);

    void update(Board board);

    void delete(long id);

}
