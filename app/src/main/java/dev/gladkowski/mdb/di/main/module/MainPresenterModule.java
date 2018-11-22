package dev.gladkowski.mdb.di.main.module;

import dagger.Module;
import dagger.Provides;
import dev.gladkowski.mdb.di.base.scopes.ActivityScope;
import dev.gladkowski.mdb.presentation.main.MainPresenter;
import ru.terrakok.cicerone.Router;

@Module
public interface MainPresenterModule {

    @Provides
    @ActivityScope
    static MainPresenter provideMainPresenter(Router router) {
        return new MainPresenter(router);
    }
}
