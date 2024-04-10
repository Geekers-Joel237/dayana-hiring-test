package com.example.dayanahiringtest.identity.person.all;

import com.example.dayanahiringtest.PostgreSqlTestConfiguration;
import com.example.dayanahiringtest.identity.person.application.ports.PersonRepository;
import com.example.dayanahiringtest.identity.person.domain.model.Person;
import com.example.dayanahiringtest.identity.person.domain.viewmodel.GetAllPersonsViewModel;
import com.example.dayanahiringtest.identity.person.domain.vo.NameVo;
import com.example.dayanahiringtest.identity.person.domain.vo.NiuVo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Import(PostgreSqlTestConfiguration.class)
public class GetAllPersonsE2ETests {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private PersonRepository repository;

    @Test
    @DirtiesContext
    public void shouldGetAllPersons() throws Exception {
        var existingPerson1 = Person.create(
                new NiuVo("P059116609705Y"),
                new NameVo("John"),
                new NameVo("Doe"),
                LocalDate.parse(LocalDate.now().toString())
        );
        repository.save(existingPerson1);

        var existingPerson2 = Person.create(
                new NiuVo("P059116609706Y"),
                new NameVo("Jane"),
                new NameVo("Smith"),
                LocalDate.parse(LocalDate.now().toString())
        );
        repository.save(existingPerson2);


        var result = mockMvc
                .perform(MockMvcRequestBuilders.get("/persons"))
                .andExpect(status().isOk())
                .andReturn();

        var response = objectMapper.readValue(
                result.getResponse().getContentAsString(),
               GetAllPersonsViewModel.class
        );


        Assertions.assertEquals(2, response.persons.size());
        Assertions.assertEquals(2, response.total);
    }

    @Test
    @DirtiesContext
    public void shouldGetAllPersonsWithPagination() throws Exception {
        var existingPerson1 = Person.create(
                new NiuVo("P059116609705Y"),
                new NameVo("John"),
                new NameVo("Doe"),
                LocalDate.parse(LocalDate.now().toString())
        );
        repository.save(existingPerson1);

        var existingPerson2 = Person.create(
                new NiuVo("P059116609706Y"),
                new NameVo("Jane"),
                new NameVo("Smith"),
                LocalDate.parse(LocalDate.now().toString())
        );
        repository.save(existingPerson2);


        var result = mockMvc
                .perform(MockMvcRequestBuilders.get("/persons")
                        .param("limit", String.valueOf(1))
                        .param("offset", String.valueOf(0)))
                .andExpect(status().isOk())
                .andReturn();

        var response = objectMapper.readValue(
                result.getResponse().getContentAsString(),
                GetAllPersonsViewModel.class
        );


        Assertions.assertNotNull(response);
        Assertions.assertEquals(1, response.persons.size());
        Assertions.assertEquals(2, response.total);
    }
}
