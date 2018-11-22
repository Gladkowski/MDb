package dev.gladkowski.mdb.di.main.module;

import android.support.v7.app.AppCompatActivity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import dev.gladkowski.mdb.di.base.modules.BaseActivityModule;
import dev.gladkowski.mdb.di.base.modules.BaseFragmentModule;
import dev.gladkowski.mdb.di.base.scopes.ActivityScope;
import dev.gladkowski.mdb.di.movies.MoviesModule;
import dev.gladkowski.mdb.di.movies.MoviesScope;
import dev.gladkowski.mdb.presentation.main.MainActivity;
import dev.gladkowski.mdb.presentation.movies.MoviesFragment;


@Module(includes = {BaseActivityModule.class,
        MainPresenterModule.class,
        BaseFragmentModule.class,
        MoviesModule.class,
})
public interface MainModule {

    @Binds
    @ActivityScope
    AppCompatActivity bindAppCompatActivity(MainActivity mainActivity);

    @MoviesScope
    @ContributesAndroidInjector(modules = MoviesModule.class)
    MoviesFragment moviesFragmentInjector();
}
