package pl.majkelapps.mainactivity;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

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

    @Override
    protected void openCropper() {
        CropImage.activity()
                .setGuidelines(CropImageView.Guidelines.ON)
                .start(this);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                Uri resultUri = result.getUri();
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }
    }


    @OnClick({R.id.menu, R.id.sort, R.id.search, R.id.fab})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.menu:
                break;
            case R.id.sort:
                break;
            case R.id.search:
                showHideSearchEditText();
                break;
            case R.id.fab:
                addNew(Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE);
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
