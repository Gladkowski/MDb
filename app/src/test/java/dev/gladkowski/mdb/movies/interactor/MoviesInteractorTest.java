package dev.gladkowski.mdb.movies.interactor;

import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import dev.gladkowski.mdb.data.repository.movies.MoviesRepository;
import dev.gladkowski.mdb.domain.movies.MoviesInteractor;
import dev.gladkowski.mdb.domain.movies.MoviesInteractorImpl;
import dev.gladkowski.mdb.entity.movies.domain.Movie;
import dev.gladkowski.mdb.rxutils.RxImmediateSchedulerRule;
import dev.gladkowski.mdb.utils.rx.ErrorProcessing;
import dev.gladkowski.mdb.utils.rx.ErrorResourceProvider;
import dev.gladkowski.mdb.utils.rx.RxUtils;
import dev.gladkowski.mdb.utils.rx.SingleErrorHandler;
import io.reactivex.Single;
import io.reactivex.observers.TestObserver;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MoviesInteractorTest {
    private MoviesInteractor interactor;

    @ClassRule
    public static final RxImmediateSchedulerRule schedulers = new RxImmediateSchedulerRule();

    @Mock
    private MoviesRepository repository;
    @Mock
    private SingleErrorHandler singleErrorHandler;
    @Mock
    private List<Movie> mockArrayList;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        RxUtils rxUtils = new RxUtils();
        ErrorResourceProvider mockErrorRes = mock(ErrorResourceProvider.class);
        ErrorProcessing errorProcessing = new ErrorProcessing(mockErrorRes);
        singleErrorHandler = new SingleErrorHandler(errorProcessing);
        interactor = new MoviesInteractorImpl(repository, singleErrorHandler, rxUtils);
    }

    @Test
    public void getMoviesByPageShouldSuccess() {

        when(repository.getPopularMoviesByPage(anyInt())).thenReturn(Single.just(mockArrayList));

        TestObserver testObserver = interactor.getMoviesByPage(anyInt()).test();
        testObserver.awaitTerminalEvent();
        testObserver.assertNoErrors();

        verify(repository, times(1)).getPopularMoviesByPage(anyInt());
    }
}
