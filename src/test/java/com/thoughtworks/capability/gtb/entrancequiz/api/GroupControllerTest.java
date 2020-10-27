package com.thoughtworks.capability.gtb.entrancequiz.api;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class GroupControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @Order(1)
    public void should_get_group_list() throws Exception {

        mockMvc.perform(get("/students/list"))
                .andExpect(jsonPath("$", hasSize(15)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[3].name", is("钟无艳")))
                .andExpect(jsonPath("$[6].id", is(7)))
                .andExpect(jsonPath("$[9].name", is("庄周")))
                .andExpect(jsonPath("$[12].id", is(13)))
                .andExpect(jsonPath("$[14].name", is("蔡文姬")))
                .andExpect(status().isOk());

    }

    @Test
    @Order(2)
    public void should_add_one_student() throws Exception {

        mockMvc.perform(post("/students").content("齐宣王").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        mockMvc.perform(get("/students/list"))
                .andExpect(jsonPath("$", hasSize(16)))
                .andExpect(jsonPath("$[15].id", is(16)))
                .andExpect(jsonPath("$[15].name", is("齐宣王")))
                .andExpect(status().isOk());

    }
}