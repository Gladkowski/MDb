package dev.gladkowski.mdb.presentation.moviedetails.converter;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import dev.gladkowski.mdb.entity.moviedetails.domain.MovieDetails;
import dev.gladkowski.mdb.entity.moviedetails.presentation.MovieDetailsViewModel;
import dev.gladkowski.mdb.presentation.moviedetails.provider.MovieDetailsResourceProvider;


/**
 * Implementation of MovieDetailsViewModelConverter
 */
public class MovieDetailsViewModelConverterImpl implements MovieDetailsViewModelConverter {

    private MovieDetailsResourceProvider resourceProvider;

    public MovieDetailsViewModelConverterImpl(MovieDetailsResourceProvider resourceProvider) {
        this.resourceProvider = resourceProvider;
    }

    @Override
    public MovieDetailsViewModel apply(MovieDetails movie) throws Exception {
        return new MovieDetailsViewModel(movie.getId(),
                movie.getTitle(),
                convertOverview(movie.getOverview()),
                convertPosterUrl(movie.getPosterPath()),
                convertBackdropUrl(movie.getBackdropPath()),
                convertReleaseDate(movie.getReleaseDate()),
                convertVoteAverage(movie.getVoteAverage()),
                convertRuntime(movie.getRuntime()));
    }

    private String convertPosterUrl(String path) {
        return resourceProvider.getPosterW500Url() + (path);
    }

    private String convertBackdropUrl(String path) {
        return resourceProvider.getBackdropW1280Url() + (path);
    }

    private String convertOverview(String overview) {
        if (overview == null) {
            return resourceProvider.getNoAvailableOverview();
        } else return overview;
    }

    private String convertReleaseDate(DateTime releaseDate) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
        return formatter.print(releaseDate);
    }

    private String convertVoteAverage(double voteAverage) {
        return String.valueOf(voteAverage)
                .concat(resourceProvider.getSingleSpace())
                .concat(resourceProvider.getOutOfTen());
    }

    private String convertRuntime(Integer runtime) {
        if (runtime == null) {
            return resourceProvider.getRuntimeUnknown();
        } else return String.valueOf(runtime)
                .concat(resourceProvider.getSingleSpace())
                .concat(resourceProvider.getMin());
    }
}
