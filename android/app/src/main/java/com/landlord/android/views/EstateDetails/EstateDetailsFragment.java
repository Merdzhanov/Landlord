package com.landlord.android.views.EstateDetails;


import android.app.Fragment;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.landlord.android.R;
import com.landlord.android.models.Estate;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EstateDetailsFragment
        extends Fragment
        implements EstateDetailsContracts.View {

    private EstateDetailsContracts.Presenter mPresenter;

    @BindView(R.id.iv_estate_details)
    ImageView mImageView;

    @BindView(R.id.tv_name)
    TextView mNameTextView;

    @BindView(R.id.tv_description)
    TextView mDescriptionTextView;

    @Inject
    public EstateDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_estate_details, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
        mPresenter.loadEstate();
    }

    @Override
    public void showEstate(Estate Estate) {
        mNameTextView.setText(Estate.getName());
        mDescriptionTextView.setText(Estate.getDescription());
        mDescriptionTextView.setMovementMethod(new ScrollingMovementMethod());
        Picasso.get().load(Estate.getImageUrl()).into(mImageView);
    }

    @Override
    public void setPresenter(EstateDetailsContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showError(Throwable e) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
