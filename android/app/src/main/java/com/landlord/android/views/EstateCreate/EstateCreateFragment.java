package com.landlord.android.views.EstateCreate;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.landlord.android.R;
import com.landlord.android.models.Estate;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EstateCreateFragment extends Fragment implements EstateCreateContracts.View {
    private EstateCreateContracts.Presenter mPresenter;

    @BindView(R.id.et_name)
    EditText mNameEditText;

    @BindView(R.id.et_description)
    EditText mDescription;

    @BindView(R.id.et_imageUrl)
    EditText mImageUrl;
    private EstateCreateContracts.Navigator mNavigator;


    @Inject
    public EstateCreateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_estate_create, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.unsubscribe();
    }

    @OnClick(R.id.btn_save)
    public void onEstatesaveClicked() {
        String name = mNameEditText.getText().toString();
        String description = mDescription.getText().toString();
        String imageUrl = mImageUrl.getText().toString();
        Estate Estate = new Estate(name, description, imageUrl);
        mPresenter.save(Estate);
    }

    @Override
    public void setPresenter(EstateCreateContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void navigateToHome() {
        mNavigator.navigateToHome();
    }

    @Override
    public void showError(Throwable throwable) {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showLoading() {

    }

    public void setNavigator(EstateCreateContracts.Navigator navigator) {
        mNavigator = navigator;
    }
}
