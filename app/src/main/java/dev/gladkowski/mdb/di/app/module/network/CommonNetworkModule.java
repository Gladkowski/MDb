package dev.gladkowski.mdb.di.app.module.network;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dev.gladkowski.mdb.BuildConfig;
import dev.gladkowski.mdb.entity.app.data.AppConfig;
import dev.gladkowski.mdb.utils.network.ApiKeyInterceptor;
import dev.gladkowski.mdb.utils.network.LanguageInterceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

@Module
public interface CommonNetworkModule {

    @Provides
    @Singleton
    static OkHttpClient provideOkHttpClient(HttpLoggingInterceptor loggingInterceptor,
                                            ApiKeyInterceptor apiKeyInterceptor,
                                            LanguageInterceptor languageInterceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(apiKeyInterceptor)
                .addInterceptor(languageInterceptor)
                .addInterceptor(loggingInterceptor)
                .connectTimeout(AppConfig.DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(AppConfig.DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .build();
    }

    @Provides
    @Singleton
    static Retrofit.Builder provideRetrofitBuilder(Converter.Factory converterFactory, OkHttpClient client) {
        return new Retrofit.Builder()
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(converterFactory);
    }

    @Provides
    static Retrofit provideRetrofit(Retrofit.Builder builder) {
        return builder.baseUrl(BuildConfig.TmdbBaseUrl).build();
    }

    @Provides
    @Singleton
    static ApiKeyInterceptor provideApiKeyInterceptor() {
        return new ApiKeyInterceptor();
    }

    @Provides
    @Singleton
    static LanguageInterceptor provideLanguageInterceptor(Context context) {
        return new LanguageInterceptor(context);
    }
}
