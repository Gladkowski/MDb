package dev.gladkowski.mdb.moviedetails.converter;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Test;

import dev.gladkowski.mdb.data.repository.moviedetails.converter.MovieDetailsResponseConverter;
import dev.gladkowski.mdb.data.repository.moviedetails.converter.MovieDetailsResponseConverterImpl;
import dev.gladkowski.mdb.entity.moviedetails.data.MovieDetailsResponse;
import dev.gladkowski.mdb.entity.moviedetails.domain.MovieDetails;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MovieDetailsResponseConverterTest {

    @Test
    public void applyShouldSuccess() {
        DateTimeZone.setDefault(DateTimeZone.UTC);

        DateTime date = new DateTime();

        MovieDetailsResponse response = mock(MovieDetailsResponse.class);
        when(response.getId()).thenReturn(1);
        when(response.getRuntime()).thenReturn(100);
        when(response.getReleaseDate()).thenReturn(date);
        when(response.getVoteAverage()).thenReturn(2.2d);
        when(response.getTitle()).thenReturn("title");
        when(response.getPosterPath()).thenReturn("poster");
        when(response.getBackdropPath()).thenReturn("backdrop");
        when(response.getOverview()).thenReturn("overview");


        MovieDetails movieDetails = null;
        MovieDetailsResponseConverter converter = new MovieDetailsResponseConverterImpl();
        try {
            movieDetails = converter.apply(response);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (movieDetails != null) {
            assertEquals(1, (int) movieDetails.getId());
            if (movieDetails.getRuntime() != null) {
                assertEquals(100, (int) movieDetails.getRuntime());
            }
            assertEquals(movieDetails.getReleaseDate(), date);
            assertEquals(2.2d, movieDetails.getVoteAverage(), 0.0);
            assertEquals("title", movieDetails.getTitle());
            assertEquals("poster", movieDetails.getPosterPath());
            assertEquals("backdrop", movieDetails.getBackdropPath());
            assertEquals("overview", movieDetails.getOverview());
        } else {
            assertEquals(0, 1); //test fails
        }
    }
}
