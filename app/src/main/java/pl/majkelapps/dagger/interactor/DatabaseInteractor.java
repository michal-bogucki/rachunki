package pl.majkelapps.dagger.interactor;

import javax.inject.Inject;

import io.realm.Realm;
import pl.majkelapps.dagger.component.ApplicationComponent;

public class DatabaseInteractor {

    @Inject
    Realm realm;

    public DatabaseInteractor(ApplicationComponent applicationComponent) {
        applicationComponent.inject(this);
    }


}
