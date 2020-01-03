package fr.dta.ovg;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.hasSize;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@Transactional
public class EventControllerTest extends UnitTestBase {

    private static final String CREATE_BODY =  "{\"label\": \"test create event\", "
            + "\"creator\": \"Lister Kerd\","
            + "\"description\": \"fzedeafrzaxxzafeaa\","
            + "\"startedat\": \"2020-01-03T09:52:37.601Z\","
            + "\"nbPlaceMax\": \"10\","
            + "\"address\": \"13 rue des elysées\","
            + "\"postcode\": \"75000\","
            + "\"city\": \"Paris\"}";
    @Autowired
    private MockMvc mvc;

    @Test
    public void getAllEventTest() throws Exception {
        this.mvc.perform(get("/api/v1/event?page=0&quantity=5"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.content").exists())
            .andExpect(jsonPath("$.content", hasSize(5)));
    }

    @Test
    public void testGetOneEvent() throws Exception {
        this.mvc.perform(get("/api/v1/event?page=0&quantity=5"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.content[2].label").value("GameBox"));
    }

//    @Test
//    public void testGetOneEventSearch() throws Exception {
//        this.mvc.perform(get("/api/v1/event?page=0&quantity=5search=upra"))
//            .andExpect(status().isOk())
//            .andExpect(jsonPath("$.content", hasSize(1)))
//            .andExpect(jsonPath("$.content[1].label").value("Supra Party One"));
//    }

    @Test
    public void testCreateEvent() throws Exception {
        this.mvc.perform(post("/api/v1/event")
                .content(CREATE_BODY)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isUnauthorized());
//        .andExpect(jsonPath("$.label").value("test create event"));
    }
}
