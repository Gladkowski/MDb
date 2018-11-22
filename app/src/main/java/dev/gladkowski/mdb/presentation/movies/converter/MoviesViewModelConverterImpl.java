package dev.gladkowski.mdb.presentation.movies.converter;

import java.util.ArrayList;
import java.util.List;

import dev.gladkowski.mdb.entity.movies.domain.Movie;
import dev.gladkowski.mdb.entity.movies.presentation.BaseMovieItem;
import dev.gladkowski.mdb.entity.movies.presentation.MovieViewModel;
import dev.gladkowski.mdb.presentation.movies.provider.MoviesResourceProvider;


/**
 * Implementation of MoviesViewModelConverter
 */
public class MoviesViewModelConverterImpl implements MoviesViewModelConverter {

    private MoviesResourceProvider resourceProvider;

    public MoviesViewModelConverterImpl(MoviesResourceProvider resourceProvider) {
        this.resourceProvider = resourceProvider;
    }

    @Override
    public List<BaseMovieItem> apply(List<Movie> movies) throws Exception {
        List<BaseMovieItem> viewModelList = new ArrayList<>();

        for (Movie movie : movies) {
            viewModelList.add(new MovieViewModel(movie.getId(),
                    movie.getTitle(),
                    convertPosterUrl(movie.getPosterPath())));
        }
        return viewModelList;
    }

    private String convertPosterUrl(String path) {
        return resourceProvider.getPosterW500Url() + (path);
    }
}
