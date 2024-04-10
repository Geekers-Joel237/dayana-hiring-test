package com.example.dayanahiringtest.identity.person;

import com.example.dayanahiringtest.PostgreSqlTestConfiguration;
import com.example.dayanahiringtest.identity.person.application.ports.PersonRepository;
import com.example.dayanahiringtest.identity.person.domain.viewmodel.IdResponse;
import com.example.dayanahiringtest.identity.person.infrastructure.spring.CreatePersonDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@Import(PostgreSqlTestConfiguration.class)
public class CreatePersonE2ETests {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private PersonRepository personRepository;

    @Test
    public void shouldCreatePerson() throws Exception {
        var dto = new CreatePersonDto(
                "P059116609705Y",
                "John",
                "Doe",
                "1998-05-05"
        );

        var result = mockMvc
                .perform(MockMvcRequestBuilders.post("/persons")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andReturn();

        var idResponse = objectMapper.readValue(
                result.getResponse().getContentAsString(),
                IdResponse.class
        );
        var person = personRepository.findById(idResponse.getId()).get();

        Assertions.assertNotNull(person);
        Assertions.assertEquals(dto.getName(), person.getName().value());
        Assertions.assertEquals(dto.getNiu(), person.getNiu().value());
        Assertions.assertEquals(dto.getSurname(), person.getSurname().value());
        Assertions.assertEquals(dto.getBirthDate(), person.getBirthDate().toString());

    }
}
