package pl.majkelapps.base.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {
    private static final String TAG = "majkel";
    private Unbinder unbinder;
    public Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(getContentVIew());
        unbinder =  ButterKnife.bind(this);
        activity = this;
    }

    protected abstract int getContentVIew();


    @Override
    protected void onDestroy() {
        unbinder.unbind();
        super.onDestroy();
    }

    public Context getContext() {
        return this;
    }

    protected View getRootView() {
        return findViewById(android.R.id.content);
    }

    public void showSnackBar(String message, int duration) {
        Snackbar.make(getRootView(), message, duration).show();
    }




}
