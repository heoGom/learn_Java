import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import kr.co.greenart.config.RootConfig;
import kr.co.greenart.config.WebConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class, WebConfig.class})
@WebAppConfiguration
public class TestCalController {
	@Autowired
	private WebApplicationContext webContext;
	
	private MockMvc mock;
	
	@Before
	public void setUpMock() {
		mock = MockMvcBuilders.webAppContextSetup(webContext).build();
	}
	
	@Test
	public void test() throws Exception {
		mock.perform(get("/cal"))
			.andExpect(view().name("calculatorForm"))
			.andExpect(status().is2xxSuccessful());
	}

	@Test
	public void testPlus() throws Exception {
		mock.perform(post("/cal")
				.param("num1", "10").param("num2", "20").param("operator", "plus"))
			.andExpect(model().attribute("result", 30))
			.andExpect(view().name("calculatorResult"))
			.andExpect(status().is2xxSuccessful());
	}
}







