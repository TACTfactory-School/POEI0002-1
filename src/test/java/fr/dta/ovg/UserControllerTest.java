package fr.dta.ovg;

//import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;

import fr.dta.ovg.controllers.UserController;

@Transactional
public class UserControllerTest extends UnitTestBase {

    @Autowired
    private MockMvc mvc;

//    @Autowired
//    private UserRepository repository;

    private static final String CREATE_BODY = "{\"username\": \"fzedeafrzaxxzafea\", \"birthdate\": \"1989-10-10\","
            + " \"email\": \"fzedeafrzaxxzafeaa3@gmail.com\", \"password\": \"test\"}";

    @Test
    public void testGetAll() throws Exception {
        this.mvc.perform(get("/api/v1/user?page=0&quantity=5"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.content").exists())
            .andExpect(jsonPath("$.content", hasSize(5)));
    }

    @Test
    public void testGetAllWithoutPassword() throws Exception {
        this.mvc.perform(get("/api/v1/user?page=0&quantity=5"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.content[0].password").doesNotExist());
    }

    /** Tests default filter of {@link UserController#getAll}.. */
    @Test
    public void testGetAllDefaultFilter() throws Exception {
        this.mvc.perform(get("/api/v1/user?page=0&quantity=5"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.content[0].username").value("Pamwamba"));
    }

    /** Tests search parameter of {@link UserController#getAll get all} action. */
    @Test
    public void testGetAllSearch() throws Exception {
        this.mvc.perform(get("/api/v1/user?page=0&quantity=5&search=amwam"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.content", hasSize(1)))
            .andExpect(jsonPath("$.content[0].username").value("Pamwamba"));
    }

    /**
     * @throws Exception
     */
    @Rollback
    @Test
    public void testCreate() throws Exception {
        this.mvc
            .perform(post("/api/v1/user")
                    .content(CREATE_BODY)
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.username").value("fzedeafrzaxxzafea"))
            .andExpect(jsonPath("$.password").doesNotExist());
    }

//    @Rollback
//    @Test
//    public void testDelete() throws Exception {
//        this.mvc.perform(delete("/api/v1/user/id"))
//            .andExpect(status().isNotFound())
//            .andExpect(jsonPath("$.id").value(1));
//
//    }

    // TODO: NE devrait PAS etre la !
//    @Test
//    public void foundByUsername() throws Exception {
//        final Optional<User> found = this.repository.findByUsername("Pamwamba");
//
//        assertTrue(found.isPresent());
//        assertEquals("Pamwamba", found.get().getUsername());
//    }

}
