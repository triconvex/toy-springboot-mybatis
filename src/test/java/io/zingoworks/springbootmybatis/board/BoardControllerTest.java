package io.zingoworks.springbootmybatis.board;

import io.zingoworks.springbootmybatis.board.model.BoardRequest;
import io.zingoworks.springbootmybatis.api.response.ApiResult;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BoardControllerTest {

    private static final Logger log = LoggerFactory.getLogger(BoardControllerTest.class);

    @Autowired
    private TestRestTemplate template;

    @Test
    public void A_게시물_작성() {
        ResponseEntity<ApiResult> responseEntity = template
                .postForEntity("/board", new BoardRequest("test", "test"), ApiResult.class);

        assertThat(responseEntity.getBody().getResponse()).isEqualTo("게시물 작성 성공");
    }

    @Test
    public void B_게시물_조회() throws IOException {
        ResponseEntity<ApiResult> responseEntity = template
                .getForEntity("/board/1", ApiResult.class);

        log.debug("Selected Board : {}", responseEntity.getBody().getResponse());
    }

    @Test
    public void B_존재하지않는_게시물_조회() {
        ResponseEntity<ApiResult> responseEntity = template
                .getForEntity("/board/5", ApiResult.class);

        assertThat(responseEntity.getBody().getError().getStatus()).isEqualTo(404);
    }

    @Test
    public void C_게시물_수정() {
        BoardRequest target = new BoardRequest("updated", "updated");
        template.put("/board/1", target);

        ResponseEntity<ApiResult> responseEntity = template
                .getForEntity("/board/1", ApiResult.class);

        log.debug("Selected Board : {}", responseEntity.getBody().getResponse());
    }

    @Test
    public void D_게시물_삭제() {
        ResponseEntity<ApiResult> responseEntity = template
                .exchange("/board/1", HttpMethod.DELETE, HttpEntity.EMPTY, ApiResult.class);

        assertThat(responseEntity.getBody().getResponse()).isEqualTo("게시물 삭제 성공");
    }

}