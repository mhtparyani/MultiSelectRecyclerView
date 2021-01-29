package com.linkindia.multiselectrecyclerview;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;

import com.linkindia.multiselectlibrary.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Shera on 24/06/2016.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    protected Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setActivityIdentifier());

        ButterKnife.bind(this);

        //setToolbar();
    }

    private void setToolbar() {
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null && showBackHomeAsUpIndicator()) {
            getSupportActionBar().setDisplayShowTitleEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setShowHideAnimationEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp);
            if (toolbarTitle() != Constants.INVALID_RES) {
                getSupportActionBar().setTitle(toolbarTitle());
            }

            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        }
    }

    //Toolbar related methods
    protected boolean showBackHomeAsUpIndicator() {
        return false;
    }

    @StringRes
    protected int toolbarTitle() {
        return Constants.INVALID_RES;
    }

    protected abstract int setActivityIdentifier();
}
