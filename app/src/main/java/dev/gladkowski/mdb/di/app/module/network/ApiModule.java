package dev.gladkowski.mdb.di.app.module.network;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dev.gladkowski.mdb.data.network.MoviesApi;
import retrofit2.Retrofit;

@Module(includes = {RetrofitModule.class, CommonNetworkModule.class})
public interface ApiModule {

    @Singleton
    @Provides
    static MoviesApi provideMoviesApi(Retrofit retrofit) {
        return retrofit.create(MoviesApi.class);
    }
}
