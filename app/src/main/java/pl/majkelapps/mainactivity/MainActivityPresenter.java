package pl.majkelapps.mainactivity;

import javax.inject.Inject;

import pl.majkelapps.base.ui.BasePresenter;
import pl.majkelapps.dagger.component.InteractorComponent;
import pl.majkelapps.dagger.interactor.ApiInteractor;
import pl.majkelapps.dagger.interactor.DatabaseInteractor;

public class MainActivityPresenter extends BasePresenter<MainActivity> {
    @Inject
    ApiInteractor apiInteractor;

    @Inject
    DatabaseInteractor databaseInteractor;

    public MainActivityPresenter(InteractorComponent interactorComponent) {
        interactorComponent.inject(this);
    }


}
