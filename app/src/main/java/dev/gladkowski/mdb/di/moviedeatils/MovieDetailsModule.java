package dev.gladkowski.mdb.di.moviedeatils;

import dagger.Module;
import dev.gladkowski.mdb.di.base.modules.BaseFragmentModule;


@Module(includes = {BaseFragmentModule.class, MovieDetailsRepositoryModule.class,
        MovieDetailsUtilsModule.class, MovieDetailsInteractorModule.class})
public interface MovieDetailsModule {


}
