package pl.majkelapps.dagger.component;

import javax.inject.Singleton;

import dagger.Component;
import pl.majkelapps.dagger.interactor.ApiInteractor;
import pl.majkelapps.dagger.interactor.DatabaseInteractor;
import pl.majkelapps.dagger.module.ApplicationModule;
import pl.majkelapps.dagger.module.NetModule;
import pl.majkelapps.dagger.module.RealmModule;

@Singleton
@Component(modules = {ApplicationModule.class, RealmModule.class, NetModule.class})
public interface ApplicationComponent {

    void inject(ApiInteractor interactor);

    void inject(DatabaseInteractor interactor);
}
