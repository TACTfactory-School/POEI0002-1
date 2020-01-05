package fr.dta.ovg;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;

@Transactional
public class HobbyControllerTest extends UnitTestBase {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getAllHobbyTest() throws Exception {
        this.mvc.perform(get("/api/v1/hobby"))
            .andExpect(status().isOk());
    }

    @Test
    public void getOneHobbyTest() throws Exception {
        this.mvc.perform(get("/api/v1/hobby/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.label").value("Bénévolat"));
    }

    @Rollback
    @Test
    public void testDelete() throws Exception {
        this.mvc.perform(delete("/api/v1/hobby/1"))
            .andExpect(status().isNoContent());
    }
}
