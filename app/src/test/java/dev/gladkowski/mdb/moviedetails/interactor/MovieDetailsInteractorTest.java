package dev.gladkowski.mdb.moviedetails.interactor;

import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import dev.gladkowski.mdb.data.repository.moviedetails.MovieDetailsRepository;
import dev.gladkowski.mdb.domain.moviedetails.MovieDetailsInteractor;
import dev.gladkowski.mdb.domain.moviedetails.MovieDetailsInteractorImpl;
import dev.gladkowski.mdb.entity.moviedetails.domain.MovieDetails;
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

public class MovieDetailsInteractorTest {
    private MovieDetailsInteractor interactor;

    @ClassRule
    public static final RxImmediateSchedulerRule schedulers = new RxImmediateSchedulerRule();

    @Mock
    private MovieDetailsRepository repository;
    @Mock
    private SingleErrorHandler singleErrorHandler;
    @Mock
    private MovieDetails movieDetails;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        RxUtils rxUtils = new RxUtils();
        ErrorResourceProvider mockErrorRes = mock(ErrorResourceProvider.class);
        ErrorProcessing errorProcessing = new ErrorProcessing(mockErrorRes);
        singleErrorHandler = new SingleErrorHandler(errorProcessing);
        interactor = new MovieDetailsInteractorImpl(repository, singleErrorHandler, rxUtils);
    }

    @Test
    public void getMovieDetailsShouldSuccess() {

        when(repository.getMovieDetails(anyInt())).thenReturn(Single.just(movieDetails));

        TestObserver testObserver = interactor.getMovieDetails(anyInt()).test();
        testObserver.awaitTerminalEvent();
        testObserver.assertNoErrors();

        verify(repository, times(1)).getMovieDetails(anyInt());

    }
}
