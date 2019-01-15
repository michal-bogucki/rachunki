package pl.majkelapps.dagger;

import pl.majkelapps.dagger.component.ApplicationComponent;
import pl.majkelapps.dagger.component.DaggerApplicationComponent;
import pl.majkelapps.dagger.component.DaggerInteractorComponent;
import pl.majkelapps.dagger.component.DaggerPresenterComponent;
import pl.majkelapps.dagger.component.InteractorComponent;
import pl.majkelapps.dagger.component.PresenterComponent;
import pl.majkelapps.dagger.module.ApplicationModule;
import pl.majkelapps.dagger.module.InteractorModule;
import pl.majkelapps.dagger.module.NetModule;
import pl.majkelapps.dagger.module.PresenterModule;
import pl.majkelapps.dagger.module.RealmModule;

public class ApplicationApp extends android.app.Application {

    private PresenterComponent presenterComponent;
    private ApplicationComponent applicationComponent;
    private InteractorComponent interactorComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        presenterComponent = DaggerPresenterComponent.builder()
                .presenterModule(new PresenterModule(this))
                .build();
        interactorComponent = DaggerInteractorComponent.builder()
                .interactorModule(new InteractorModule(this))
                .build();
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .realmModule(new RealmModule(getApplicationContext()))
                .netModule(new NetModule("https://www.onet.pl"))
                .build();
    }


    public PresenterComponent getPresenterComponent() {
        return presenterComponent;
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }


    public InteractorComponent getInteractorComponent() {
        return interactorComponent;
    }
}
