package io.zingoworks.springbootmybatis.board.dao;

import io.zingoworks.springbootmybatis.board.model.Board;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<Board, Long> {



}
