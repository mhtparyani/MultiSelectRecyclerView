package com.linkindia.multiselectrecyclerview.sampleImageGallery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.linkindia.multiselectlibrary.MultiChoiceAdapter;
import com.linkindia.multiselectrecyclerview.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Shera on 27/06/2016.
 */

class SampleGalleryAdapter extends MultiChoiceAdapter<SampleGalleryAdapter.SampleGalleryViewHolder> {
    private final Context mContext;
    private ArrayList<Integer> imageList;

    private Integer[] images = new Integer[]{
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5
    };
    private ScaleAnimation mSelectScaleAnimation;
    private ScaleAnimation mDeselectScaleAnimation;

    SampleGalleryAdapter(Context mContext) {
        this.mContext = mContext;

        setUpImageList();
    }

    private void setUpImageList() {
        imageList = new ArrayList<>();
        Random r = new Random();

        for (int i = 0; i < getItemCount(); i++) {
            imageList.add(images[r.nextInt(5)]);
        }
    }

    @Override
    public int getItemCount() {
        return 50;
    }

    @Override
    public SampleGalleryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SampleGalleryViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sample_gallery, parent, false));
    }

    @Override
    public void onBindViewHolder(SampleGalleryViewHolder holder, final int position) {
        super.onBindViewHolder(holder, position);

        Picasso picasso = Picasso.get();

        picasso
                .load(imageList.get(position))
                .error(R.drawable.placeholder)
                .resize(200, 200)
                .centerCrop()
                .into(holder.mImageView);
    }

    @Override
    public void setActive(@NonNull View view, boolean state) {

        ImageView imageView = (ImageView) view.findViewById(R.id.image_view);
        final ImageView tickImage = (ImageView) view.findViewById(R.id.tick_image);

        if (state) {
            imageView.setScaleX(0.7f);
            imageView.setScaleY(0.7f);
            tickImage.setVisibility(View.VISIBLE);
        } else {
            imageView.setScaleX(1f);
            imageView.setScaleY(1f);
            tickImage.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    protected View.OnClickListener defaultItemViewClickListener(SampleGalleryViewHolder holder, final int position) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Click on item " + position, Toast.LENGTH_SHORT).show();
            }
        };
    }
    class SampleGalleryViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image_view)
        ImageView mImageView;

        SampleGalleryViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
