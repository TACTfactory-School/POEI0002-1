package fr.dta.ovg;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.hasSize;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

@Transactional
public class EventControllerTest extends UnitTestBase {

    @Autowired
    private MockMvc mvc;

    @Test
    public void GetAllEventTest() throws Exception {
        this.mvc.perform(get("/api/v1/event?page=0&quantity=5"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.content").exists())
            .andExpect(jsonPath("$.content", hasSize(5)));
    }

    @Test
    public void TestGetOneEvent() throws Exception {
        this.mvc.perform(get("/api/v1/event?page=0&quantity=5"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.content[2].label").value("GameBox"));
    }

}
