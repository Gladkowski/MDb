package dev.gladkowski.mdb.movies.converter;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import dev.gladkowski.mdb.data.repository.movies.converter.MovieListResponseConverter;
import dev.gladkowski.mdb.data.repository.movies.converter.MovieListResponseConverterImpl;
import dev.gladkowski.mdb.entity.movies.data.MovieResponse;
import dev.gladkowski.mdb.entity.movies.data.MovieResponseByPage;
import dev.gladkowski.mdb.entity.movies.domain.Movie;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MovieListResponseConverterTest {

    @Test
    public void applyShouldSuccess() {

        List<MovieResponse> responseList = new ArrayList<>();
        MovieResponse movieResponse = mock(MovieResponse.class);
        when(movieResponse.getId()).thenReturn(10);
        when(movieResponse.getPosterPath()).thenReturn("path");
        when(movieResponse.getTitle()).thenReturn("title");
        responseList.add(movieResponse);

        MovieResponseByPage responseByPage = mock(MovieResponseByPage.class);
        when(responseByPage.getPage()).thenReturn(1);
        when(responseByPage.getResults()).thenReturn(responseList);


        List<Movie> movies = null;
        MovieListResponseConverter converter = new MovieListResponseConverterImpl();
        try {
            movies = converter.apply(responseByPage);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (movies != null) {
            assertEquals(10, movies.get(0).getId());
            assertEquals("path", movies.get(0).getPosterPath());
            assertEquals("title", movies.get(0).getTitle());
        } else {
            assertEquals(0, 1); //test fails
        }
    }
}
