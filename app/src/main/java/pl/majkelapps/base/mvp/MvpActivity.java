package pl.majkelapps.base.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;

import pl.majkelapps.base.ui.BaseActivity;
import pl.majkelapps.base.ui.BasePresenter;

public abstract class MvpActivity<P extends BasePresenter> extends BaseActivity {
    protected abstract P getPresenter();

    protected abstract void inject();

    P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject();
        presenter = getPresenter();
        presenter.attachView(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.dettachView();
    }


}
