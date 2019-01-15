package pl.majkelapps.mainactivity;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import pl.majkelapps.R;
import pl.majkelapps.base.mvp.MvpActivity;
import pl.majkelapps.dagger.ApplicationApp;

public class MainActivity extends MvpActivity<MainActivityPresenter> {
    private static final String profile = "profile";
    @Inject
    MainActivityPresenter presenter;
    FragmentManager fragmentManager;
    @BindView(R.id.layout)
    ConstraintLayout layout;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.searchEditText)
    TextInputLayout searchEditText;


    @Override
    protected MainActivityPresenter getPresenter() {
        return presenter;
    }

    @Override
    protected void inject() {
        ((ApplicationApp) getApplication()).getPresenterComponent().inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentManager = getSupportFragmentManager();
        initAdapter();
    }

    private void initAdapter() {
        Adapter adapter = new Adapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected int getContentVIew() {
        return R.layout.activity_main;
    }


    @OnClick({R.id.menu, R.id.sort, R.id.search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.menu:
                break;
            case R.id.sort:
                break;
            case R.id.search:
                showHideSearchEditText();
                break;
        }
    }

    private void showHideSearchEditText() {
        int visible = searchEditText.getVisibility();
        if (visible == View.VISIBLE) {
            searchEditText.setVisibility(View.GONE);
        } else {
            searchEditText.setVisibility(View.VISIBLE);
        }
    }
}
