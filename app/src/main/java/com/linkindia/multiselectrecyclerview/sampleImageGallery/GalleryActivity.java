package com.linkindia.multiselectrecyclerview.sampleImageGallery;

import android.os.Bundle;
import android.view.View;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.linkindia.multiselectlibrary.MultiChoiceAdapter;
import com.linkindia.multiselectlibrary.MultiChoiceToolbar;
import com.linkindia.multiselectrecyclerview.BaseActivity;
import com.linkindia.multiselectrecyclerview.R;

import butterknife.BindView;

public class GalleryActivity extends BaseActivity {
    @BindView(R.id.multiChoiceRecyclerView)
    public RecyclerView mMultiChoiceRecyclerView;

    @Override
    protected int setActivityIdentifier() {
        return R.layout.activity_sample_custom_view;
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setUpMultiChoiceRecyclerView();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        ((MultiChoiceAdapter) mMultiChoiceRecyclerView.getAdapter()).onSaveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        ((MultiChoiceAdapter) mMultiChoiceRecyclerView.getAdapter()).onRestoreInstanceState(savedInstanceState);
        super.onRestoreInstanceState(savedInstanceState);
    }

    private void setUpMultiChoiceRecyclerView() {

        mMultiChoiceRecyclerView.setLayoutManager(new GridLayoutManager(this, 4, LinearLayoutManager.VERTICAL, false));

        MultiChoiceToolbar multiChoiceToolbar =
                new MultiChoiceToolbar.Builder(GalleryActivity.this, toolbar)
                        .setTitles(getString(toolbarTitle()), "")
                        .setMultiChoiceColours(R.color.colorPrimaryMulti, R.color.colorPrimaryDarkMulti)
                        .setDefaultIcon(R.drawable.ic_arrow_back_white_24dp, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                onBackPressed();
                            }
                        })
                        .build();

        SampleGalleryAdapter adapter = new SampleGalleryAdapter(GalleryActivity.this);
        adapter.setMultiChoiceToolbar(multiChoiceToolbar);

        mMultiChoiceRecyclerView.setAdapter(adapter);
    }

    @Override
    protected int toolbarTitle() {
        return R.string.image_gallery;
    }

    @Override
    protected boolean showBackHomeAsUpIndicator() {
        return true;
    }
}
