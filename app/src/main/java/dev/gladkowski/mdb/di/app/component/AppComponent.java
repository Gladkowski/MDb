package dev.gladkowski.mdb.di.app.component;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dev.gladkowski.mdb.App;
import dev.gladkowski.mdb.di.ActivityInjectionModule;
import dev.gladkowski.mdb.di.app.module.AppModule;
import dev.gladkowski.mdb.di.app.module.NavigationModule;
import dev.gladkowski.mdb.di.app.module.UtilModule;


@Singleton
@Component(modules = {AppModule.class, ActivityInjectionModule.class, NavigationModule.class,
        UtilModule.class})
public interface AppComponent extends AndroidInjector<App> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<App> {
    }
}
