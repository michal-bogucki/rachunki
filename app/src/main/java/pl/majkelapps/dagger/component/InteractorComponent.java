package pl.majkelapps.dagger.component;

import javax.inject.Singleton;

import dagger.Component;
import pl.majkelapps.dagger.module.InteractorModule;
import pl.majkelapps.mainactivity.MainActivityPresenter;

@Singleton
@Component(modules = {InteractorModule.class})
public interface InteractorComponent {

    void inject(MainActivityPresenter presenter);




}
