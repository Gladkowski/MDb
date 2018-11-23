package dev.gladkowski.mdb.rxutils.movies.repository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import dev.gladkowski.mdb.data.network.MoviesApi;
import dev.gladkowski.mdb.data.repository.movies.MoviesRepository;
import dev.gladkowski.mdb.data.repository.movies.MoviesRepositoryImpl;
import dev.gladkowski.mdb.data.repository.movies.converter.MovieListResponseConverter;
import dev.gladkowski.mdb.entity.movies.data.MovieResponseByPage;
import dev.gladkowski.mdb.entity.movies.domain.Movie;
import io.reactivex.Single;
import io.reactivex.observers.TestObserver;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MoviesRepositoryTest {
    private MoviesRepository moviesRepository;

    @Mock
    private MoviesApi moviesApi;
    @Mock
    private MovieListResponseConverter converter;
    @Mock
    private MovieResponseByPage movieResponseByPage;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        moviesRepository = new MoviesRepositoryImpl(moviesApi, converter);
    }

    @Test
    public void getPopularMoviesByPageShouldSuccess() {

        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(0, "title", "path"));

        when(moviesApi.getPopularMoviesByPage(anyInt())).thenReturn(Single.just(movieResponseByPage));
        try {
            when(converter.apply(any(MovieResponseByPage.class))).thenReturn(movies);
        } catch (Exception e) {
            e.printStackTrace();
        }

        TestObserver testObserver = moviesRepository.getPopularMoviesByPage(anyInt()).test();
        testObserver.assertNoErrors();
        testObserver.awaitTerminalEvent();

        verify(moviesApi, times(1)).getPopularMoviesByPage(anyInt());
    }
}
