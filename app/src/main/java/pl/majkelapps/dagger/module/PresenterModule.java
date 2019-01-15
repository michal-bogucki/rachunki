package pl.majkelapps.dagger.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pl.majkelapps.dagger.ApplicationApp;
import pl.majkelapps.mainactivity.MainActivityPresenter;

@Module
public class PresenterModule {
    private ApplicationApp application;

    public PresenterModule(ApplicationApp application) {
        this.application = application;
    }

    @Provides
    @Singleton
    MainActivityPresenter presenterMain() {
        return new MainActivityPresenter(application.getInteractorComponent());
    }


}
