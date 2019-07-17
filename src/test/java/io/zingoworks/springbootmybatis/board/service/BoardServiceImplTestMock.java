//package io.zingoworks.springbootmybatis.board.service;
//
//import io.zingoworks.springbootmybatis.board.dao.BoardMapper;
//import io.zingoworks.springbootmybatis.board.model.Board;
//import io.zingoworks.springbootmybatis.board.service.impl.BoardServiceImpl;
//import io.zingoworks.springbootmybatis.exception.BoardNotFoundException;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.assertj.core.api.Java6Assertions.assertThat;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//@RunWith(MockitoJUnitRunner.class)
//public class BoardServiceImplTestMock {
//
//    @Mock
//    private BoardMapper boardMapper;
//
//    @InjectMocks
//    private BoardServiceImpl boardServiceImpl;
//
//    private Board original;
//    private Board target;
//
//    @Before
//    public void setUp() throws Exception {
//        original = new Board(1L, "Test", "Test");
//        target = new Board(1L, "Updated", "Updated");
//    }
//
//    @Test
//    public void 게시물_조회() {
//        when(boardMapper.findById(1L)).thenReturn(original);
//
//        Board board = boardServiceImpl.findById(1L);
//        assertThat(board).isEqualTo(original);
//    }
//
//    @Test
//    public void 게시물_수정() {
//        when(boardMapper.findById(1L)).thenReturn(original);
//        System.out.println(boardServiceImpl.update(1L, target));
//    }
//
//    @Test
//    public void 게시물_삭제() {
//        when(boardMapper.findById(1L)).thenReturn(original);
//        boardServiceImpl.delete(1L);
//    }
//
//    @Test(expected = BoardNotFoundException.class)
//    public void 게시물_삭제_실패() {
//        when(boardMapper.findById(1L)).thenReturn(null);
//        boardServiceImpl.delete(1L);
//    }
//
//}