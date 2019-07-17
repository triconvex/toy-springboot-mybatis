package io.zingoworks.springbootmybatis.board;

import io.zingoworks.springbootmybatis.exception.BoardNotFoundException;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BoardControllerTestMock {

    @Autowired
    private BoardController boardController;

    private MockMvc mockMvc;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(boardController).build();
    }

    @Test
    public void 게시물_조회() throws Exception {
        mockMvc.perform(get("/board/1"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void 게시물_조회_실패() {
        Assertions.assertThatThrownBy(() -> mockMvc.perform(get("/board/0")))
        .hasCause(new BoardNotFoundException("해당 게시물이 존재하지 않습니다."));
    }

    @Test
    public void 게시물_삭제() throws Exception {
        mockMvc.perform(delete("/board/1"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void 게시물_삭제_실패() {
        Assertions.assertThatThrownBy(() -> mockMvc.perform(delete("/board/0")))
                .hasCause(new BoardNotFoundException("해당 게시물이 존재하지 않습니다."));
    }

}