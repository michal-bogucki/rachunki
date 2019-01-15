package pl.majkelapps.base.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import pl.majkelapps.base.ui.BaseFragment;
import pl.majkelapps.base.ui.BasePresenter;

public abstract class MvpFragment<P extends BasePresenter> extends BaseFragment {
    protected P presenter;

    protected abstract P createPresenter();
    protected abstract void inject();

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        inject();
        presenter = createPresenter();
        presenter.attachView(this);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.dettachView();
        }
    }
}
