/*
 * Copyright (c) 2014 Davide Cirillo
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 *     Come on, don't tell me you read that.
 */

package com.linkindia.multiselectrecyclerview.sampleToolbar;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.linkindia.multiselectlibrary.MultiChoiceAdapter;
import com.linkindia.multiselectrecyclerview.R;

import java.util.ArrayList;

/**
 * Created by Shera on 13/03/16.
 */
class MySampleToolbarAdapter extends MultiChoiceAdapter<MySampleToolbarViewHolder> {

    private final ArrayList<String> mList;
    private final Context mContext;

    MySampleToolbarAdapter(ArrayList<String> stringList, Context context) {
        this.mList = stringList;
        this.mContext = context;
    }

    @Override
    public MySampleToolbarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MySampleToolbarViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sample_toolbar, parent, false));
    }


    @Override
    public void onBindViewHolder(MySampleToolbarViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        holder.mTextView.setText(mList.get(position));
    }


    /**
     * Override this method to implement a custom active/deactive state
     */
    @Override
    public void setActive(@NonNull View view, boolean state) {

        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.get_started_relative_layout);

        if(relativeLayout != null){
            if(state){
                relativeLayout.setBackgroundColor(ContextCompat.getColor(mContext, R.color.colorPrimaryDark));
            }else{
                relativeLayout.setBackgroundColor(Color.WHITE);
            }
        }
    }

    @Override
    protected View.OnClickListener defaultItemViewClickListener(MySampleToolbarViewHolder holder, final int position) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Click on item "+position, Toast.LENGTH_SHORT).show();
            }
        };
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
