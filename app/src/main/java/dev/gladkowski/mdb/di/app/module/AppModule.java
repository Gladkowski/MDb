package dev.gladkowski.mdb.di.app.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.android.support.AndroidSupportInjectionModule;
import dev.gladkowski.mdb.App;

@Module(includes = AndroidSupportInjectionModule.class)
public interface AppModule {

    @Binds
    @Singleton
    Context bindContext(App app);
}
