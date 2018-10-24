package com.landlord.android.views.EstatesList;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.landlord.android.R;
import com.landlord.android.models.Estate;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EstatesAdapter extends RecyclerView.Adapter<EstatesAdapter.EstateViewHolder> {
    private List<Estate> mEstates;
    private OnEstateClickListener mOnEstateClickListener;

    @Inject
    public EstatesAdapter() {
        mEstates = new ArrayList<>();
    }

    @NonNull
    @Override
    public EstateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.estate_item, parent, false);
        return new EstateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EstateViewHolder holder, int position) {
        holder.setOnClickListener(mOnEstateClickListener);
        holder.bind(mEstates.get(position));
    }

    @Override
    public int getItemCount() {
        return mEstates.size();
    }

    public Estate getItem(int position) {
        return mEstates.get(position);
    }

    public void clear() {
        mEstates.clear();
    }

    public void addAll(List<Estate> Estates) {
        mEstates.addAll(Estates);
    }

    public void setOnEstateClickListener(OnEstateClickListener onEstateClickListener) {
        this.mOnEstateClickListener = onEstateClickListener;
    }

    public static class EstateViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_name_estate)
        TextView mNameTextView;

        @BindView(R.id.iv_estate)
        ImageView mEstateImageView;

        private OnEstateClickListener mOnClickListener;
        private Estate mEstate;

        EstateViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        void bind(Estate Estate) {
            mNameTextView.setText(Estate.getName());
            Picasso.get()
                    .load(Estate.getImageUrl())
                    .into(mEstateImageView);
            mEstate = Estate;
        }

        @OnClick
        public void onClick() {
            mOnClickListener.onClick(mEstate);
        }

        public void setOnClickListener(OnEstateClickListener onClickListener) {
            mOnClickListener = onClickListener;
        }
    }

    interface OnEstateClickListener {
        void onClick(Estate Estate);
    }
}