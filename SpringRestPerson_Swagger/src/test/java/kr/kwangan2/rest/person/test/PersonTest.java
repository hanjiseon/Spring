package kr.kwangan2.rest.person.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;

import kr.kwangan2.rest.person.domain.Person;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
@Log4j
public class PersonTest {

	@Setter(onMethod_ = @Autowired)
	private WebApplicationContext ctx;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}

	@Test
	public void testSelectPerson() throws Exception {
		mockMvc.perform(get("/person/4")).andExpect(status().is(200));
	}

	@Test
	public void testListPerson() throws Exception {
		mockMvc.perform(get("/person/")).andExpect(status().is(200));
	}

	@Test
	public void testInsertPerson() throws Exception {
		mockMvc.perform(post("/person/insert").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.content(new Gson().toJson(new Person("최영", Long.valueOf(55L))))).andExpect(status().is(200));
	}

	@Test
	public void testUpdatePerson() throws Exception {
		mockMvc.perform(put("/person/5").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.content(new Gson().toJson(new Person("최영update", Long.valueOf(55L))))).andExpect(status().is(200));
	}

	@Test
	public void testDeletePerson() throws Exception {
		mockMvc.perform(delete("/person/5")).andExpect(status().is(200));
	}


} // class
