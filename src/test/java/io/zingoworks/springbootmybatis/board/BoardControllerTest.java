package io.zingoworks.springbootmybatis.board;

import io.zingoworks.springbootmybatis.response.ApiResult;
import io.zingoworks.support.AcceptanceTest;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

import static org.assertj.core.api.Java6Assertions.assertThat;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BoardControllerTest extends AcceptanceTest {

    private static final Logger log = LoggerFactory.getLogger(BoardControllerTest.class);

    @Test
    public void A_게시물_작성() {
        ResponseEntity<ApiResult> responseEntity = template
                .postForEntity("/board", new BoardRequest("test", "test"), ApiResult.class);

        assertThat(responseEntity.getBody().getResponse()).isEqualTo("게시물 작성 성공했습니다");
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
        template.delete("/board/1");

        ResponseEntity<ApiResult> responseEntity = template
                .getForEntity("/board/1", ApiResult.class);

        log.debug("Selected Board : {}", responseEntity.getBody().getResponse());
    }

}