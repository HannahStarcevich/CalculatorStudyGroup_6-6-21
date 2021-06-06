package com.company.calculatorStudyGroup.controller;

import com.company.calculatorStudyGroup.models.Numbers;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(CalculatorStudyGroupController.class)
public class CalculatorStudyGroupControllerTest {

    // wiring in mockMVC object
    @Autowired
    private MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    String inputJson;
    Numbers numbers;

    @Before
    public void setUp() throws Exception {
        numbers = new Numbers();
        numbers.setNum1(2.5);
        numbers.setNum2(3.6);

        inputJson = objectMapper.writeValueAsString(numbers);
    }

    @Test
    public void shouldReturnTheSumOfTwoDoubles() throws Exception{
        // Arrange - what i expect
        String result = objectMapper.writeValueAsString(6.1);

        //Act - what i got
        mockMvc.perform(
                post("/add")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print())
                .andExpect(status().isCreated()).andExpect(content().json(result));

        //Assert - compare what i expect to what i got
    }
}