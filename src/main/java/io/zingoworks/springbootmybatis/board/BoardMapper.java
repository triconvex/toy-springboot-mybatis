package io.zingoworks.springbootmybatis.board;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {

    void createBoard(Board board);

    Board findById(long id);

}
