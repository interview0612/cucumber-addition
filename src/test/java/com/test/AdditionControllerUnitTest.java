package com.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(AdditionController.class)
public class AdditionControllerUnitTest {


    @Autowired
    private MockMvc mvc;

    private Integer value1 = 10;

    private Integer value2 = 20;

    @Test
    public void testAddition() throws Exception {

        this.mvc.perform(get("/sum")
                .param("value1", "10")
                .param("value2", "20")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(content().string("30"));
    }
}