package pl.majkelapps.dagger.interactor;

import javax.inject.Inject;

import pl.majkelapps.dagger.component.ApplicationComponent;
import retrofit2.Retrofit;

public class ApiInteractor {

    @Inject
    Retrofit retrofit;


    public ApiInteractor(ApplicationComponent applicationComponent) {
        applicationComponent.inject(this);
    }
}
