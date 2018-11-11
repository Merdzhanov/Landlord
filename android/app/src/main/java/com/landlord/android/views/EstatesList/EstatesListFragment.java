package com.landlord.android.views.EstatesList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.landlord.android.R;
import com.landlord.android.models.Estate;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTextChanged;

public class EstatesListFragment
        extends Fragment
        implements EstatesListContracts.View, EstatesAdapter.OnEstateClickListener {
    private EstatesListContracts.Navigator mNavigator;

    @BindView(R.id.rv_estates)
    RecyclerView mEstatesView;

    @BindView(R.id.loading)
    ProgressBar mLoadingView;

    @BindView(R.id.et_filter)
    EditText mFilterEditText;

    @Inject
    EstatesAdapter mEstatesAdapter;

    private EstatesListContracts.Presenter mPresenter;
    private LinearLayoutManager mEstatesViewLayoutManager;

    @Inject
    public EstatesListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_estates_list, container, false);

        // ButterKnife is applied
        ButterKnife.bind(this, view);

        mEstatesAdapter.setOnEstateClickListener(this);

        mEstatesView.setAdapter(mEstatesAdapter);
        mEstatesViewLayoutManager = new LinearLayoutManager(getContext());
        mEstatesView.setLayoutManager(mEstatesViewLayoutManager);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
        mPresenter.loadEstates();
    }

    @Override
    public void setPresenter(EstatesListContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showEstates(List<Estate> Estates) {
        if(Estates.size()==1){
            onClick(Estates.get(0));
        }else {
            mEstatesAdapter.clear();
            mEstatesAdapter.addAll(Estates);
            mEstatesAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void showEmptyEstatesList() {
        Toast.makeText(getContext(),
                "No Estates",
                Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void showError(Throwable e) {
        Toast.makeText(getContext(), "Error: " + e.getMessage(), Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void showLoading() {
        mEstatesView.setVisibility(View.GONE);
        mLoadingView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mEstatesView.setVisibility(View.VISIBLE);
        mLoadingView.setVisibility(View.GONE);
    }

    @Override
    public void showEstateDetails(Estate Estate) {
        mNavigator.navigateWith(Estate);
    }

    void setNavigator(EstatesListContracts.Navigator navigator) {
        mNavigator = navigator;
    }

    @OnTextChanged(R.id.et_filter)
    public void onTextChanged() {
        String pattern = mFilterEditText.getText().toString();
        mPresenter.filterEstates(pattern);
    }

    @Override
    public void onClick(Estate Estate) {
        mPresenter.selectEstate(Estate);
    }
}
