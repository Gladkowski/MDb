package dev.gladkowski.mdb.moviedetails.repository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import dev.gladkowski.mdb.data.network.MovieDetailsApi;
import dev.gladkowski.mdb.data.repository.moviedetails.MovieDetailsRepository;
import dev.gladkowski.mdb.data.repository.moviedetails.MovieDetailsRepositoryImpl;
import dev.gladkowski.mdb.data.repository.moviedetails.converter.MovieDetailsResponseConverter;
import dev.gladkowski.mdb.entity.moviedetails.data.MovieDetailsResponse;
import dev.gladkowski.mdb.entity.moviedetails.domain.MovieDetails;
import io.reactivex.Single;
import io.reactivex.observers.TestObserver;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MovieDetailsRepositoryTest {
    private MovieDetailsRepository repository;

    @Mock
    private MovieDetailsApi api;
    @Mock
    private MovieDetailsResponseConverter converter;
    @Mock
    private MovieDetailsResponse response;
    @Mock
    private MovieDetails movieDetails;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        repository = new MovieDetailsRepositoryImpl(api, converter);
    }

    @Test
    public void getMovieDetailsShouldSuccess() {


        when(api.getMovieDetails(anyInt())).thenReturn(Single.just(response));
        try {
            when(converter.apply(any(MovieDetailsResponse.class))).thenReturn(movieDetails);
        } catch (Exception e) {
            e.printStackTrace();
        }

        TestObserver testObserver = repository.getMovieDetails(anyInt()).test();
        testObserver.assertNoErrors();
        testObserver.awaitTerminalEvent();

        verify(api, times(1)).getMovieDetails(anyInt());
    }
}
