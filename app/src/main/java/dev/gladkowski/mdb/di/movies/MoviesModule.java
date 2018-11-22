package dev.gladkowski.mdb.di.movies;

import android.support.v4.app.Fragment;

import dagger.Binds;
import dagger.Module;
import dev.gladkowski.mdb.di.base.modules.BaseFragmentModule;
import dev.gladkowski.mdb.presentation.movies.MoviesFragment;

@Module(includes = {BaseFragmentModule.class,
        MoviesPresenterModule.class,
        MoviesInteractorModule.class,
        MoviesRepositoryModule.class,
        MoviesUtilsModule.class})
public interface MoviesModule {

    @Binds
    Fragment bindFragment(MoviesFragment moviesFragment);
}
