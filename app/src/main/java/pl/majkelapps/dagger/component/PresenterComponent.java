package pl.majkelapps.dagger.component;

import javax.inject.Singleton;

import dagger.Component;
import pl.majkelapps.dagger.module.PresenterModule;
import pl.majkelapps.mainactivity.MainActivity;

@Singleton
@Component(modules = {PresenterModule.class})
public interface PresenterComponent {

    void inject(MainActivity mainActivity);

}
