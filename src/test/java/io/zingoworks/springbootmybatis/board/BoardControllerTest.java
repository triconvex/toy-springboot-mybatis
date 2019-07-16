package io.zingoworks.springbootmybatis.board;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BoardControllerTest {

    private MockMvc mockMvc;

    @Before
    public void setup(){
        this.mockMvc = MockMvcBuilders.standaloneSetup(new BoardController()).build();
    }

    @Test
    public void A_게시물_작성() throws Exception {
    }

    @Test
    public void B_게시물_조회() {
    }

    @Test
    public void C_게시물_수정() {
    }

    @Test
    public void D_게시물_삭제() {
    }

}