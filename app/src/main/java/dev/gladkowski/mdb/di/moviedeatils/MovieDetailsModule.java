package dev.gladkowski.mdb.di.moviedeatils;

import android.support.v4.app.Fragment;

import dagger.Binds;
import dagger.Module;
import dev.gladkowski.mdb.di.base.modules.BaseFragmentModule;
import dev.gladkowski.mdb.presentation.moviedetails.MovieDetailsFragment;


@Module(includes = {BaseFragmentModule.class, MovieDetailsRepositoryModule.class,
        MovieDetailsUtilsModule.class, MovieDetailsInteractorModule.class,
        MovieDetailsPresenterModule.class})
public interface MovieDetailsModule {

    @Binds
    Fragment bindFragment(MovieDetailsFragment movieDetailsFragment);
}
