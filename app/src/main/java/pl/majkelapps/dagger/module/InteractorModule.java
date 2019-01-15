package pl.majkelapps.dagger.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pl.majkelapps.dagger.ApplicationApp;
import pl.majkelapps.dagger.interactor.ApiInteractor;
import pl.majkelapps.dagger.interactor.DatabaseInteractor;
@Module
public class InteractorModule {

    private ApplicationApp application;

    public InteractorModule(ApplicationApp application){
        this.application = application;
    }

    @Provides
    @Singleton
    ApiInteractor apiInteractor(){
        return new ApiInteractor(application.getApplicationComponent());
    }

    @Provides
    @Singleton
    DatabaseInteractor databaseInteractor(){
        return new DatabaseInteractor(application.getApplicationComponent());
    }

}
