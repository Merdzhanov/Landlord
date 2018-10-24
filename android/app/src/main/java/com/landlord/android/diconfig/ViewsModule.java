package com.landlord.android.diconfig;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.landlord.android.views.EstatesList.EstatesAdapter;

import dagger.Module;
import dagger.Provides;

@Module
public class ViewsModule {
    @Provides
    public RecyclerView.Adapter<EstatesAdapter.EstateViewHolder> EstateArrayAdapter(Context context) {
        return new EstatesAdapter();
    }
}
