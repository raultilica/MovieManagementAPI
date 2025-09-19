package com.tirit.moviemanagementapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = MovieController.class)
public class MovieControllerTest {

    @MockBean
    private MovieService movieService;

    @Autowired
    private ObjectMapper objectMapper;

    private Movie movie;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        movie = new Movie(1L, "Scarface", "Brian De Palma", 1983, 8.8);
    }

    @Test
    void testGetMovie_whenMovieExists() throws Exception {
        given(movieService.findById(1L)).willReturn(movie);

        ResultActions response = mockMvc.perform(get("/api/movies/{id}", 1L));

        response.andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Scarface"))
                .andExpect(jsonPath("$.director").value("Brian De Palma"));

    }

}
