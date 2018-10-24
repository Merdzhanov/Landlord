package com.landlord.android.views.EstateCreate;

import android.content.Intent;
import android.os.Bundle;

import com.landlord.android.Constants;
import com.landlord.android.R;
import com.landlord.android.views.BaseDrawerActivity;
import com.landlord.android.views.EstatesList.EstatesListActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class EstateCreateActivity extends BaseDrawerActivity implements EstateCreateContracts.Navigator {

    @Inject
    EstateCreateFragment mView;

    @Inject
    EstateCreateContracts.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estate_create);
        ButterKnife.bind(this);

        mView.setPresenter(mPresenter);
        mView.setNavigator(this);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mView)
                .commit();
    }

    @Override
    protected long getIdentifier() {
        return Constants.CREATE_IDENTIFIER;
    }

    @Override
    public void navigateToHome() {
        Intent intent = new Intent(this, EstatesListActivity.class);
        startActivity(intent);
        finish();
    }
}
