package fr.dta.ovg;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;

@Transactional
public class NotificationControllerTest extends UnitTestBase {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getOneNotificationByIdTest() throws Exception {
        this.mvc.perform(get("/api/v1/notification/1"))
            .andExpect(status().isOk());
    }

    @Rollback
    @Test
    public void testDelete() throws Exception {
        this.mvc.perform(delete("/api/v1/notification/1"))
            .andExpect(status().isNoContent());
    }
}
