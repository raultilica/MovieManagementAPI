package com.tirit.moviemanagementapi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
public class MovieServiceTest {

    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private MovieService movieService;

    private Movie movie;

    @BeforeEach
    void setUp() {
        movie = new Movie(1, "Morometii", "V. Rebengiuc", 1987, 9.1);
    }

    @Test
    void testFindAll_shouldReturnMovieList() {
        given(movieRepository.findAll()).willReturn(List.of(movie));

        List<Movie> movieList = movieService.findAll();

        assertThat(movieList).isNotNull();
        assertThat(movieList.size()).isEqualTo(1);
        assertThat(movieList.get(0).getTitle()).isEqualTo("Morometii");
    }

    @Test
    void testFindById_shouldReturnMovie() {
        given(movieRepository.findById(1L)).willReturn(Optional.of(movie));

        Movie found = movieService.findById(1L);

        assertThat(found).isNotNull();
        assertThat(found.getDirector()).isEqualTo("V. Rebengiuc");
    }
}
