package io.zingoworks.springbootmybatis.board.dao;

import io.zingoworks.springbootmybatis.board.model.Board;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {

    void create(Board board);

    Board findById(long id);

    void update(Board target);

    void delete(long id);

}
