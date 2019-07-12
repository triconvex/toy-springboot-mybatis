package io.zingoworks.springbootmybatis;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.containsString;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMybatisApplicationTests {

	@ClassRule
	public static OutputCapture out = new OutputCapture();

	@Test
	public void contextLoads() {
		out.expect(containsString("1,San Francisco,CA,US"));
	}

}
