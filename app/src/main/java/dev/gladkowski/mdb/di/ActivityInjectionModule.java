package dev.gladkowski.mdb.di;


import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import dev.gladkowski.mdb.di.base.scopes.ActivityScope;
import dev.gladkowski.mdb.di.main.module.MainModule;
import dev.gladkowski.mdb.presentation.main.MainActivity;


@Module
public interface ActivityInjectionModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = {MainModule.class})
    MainActivity mainActivityInjector();

}
