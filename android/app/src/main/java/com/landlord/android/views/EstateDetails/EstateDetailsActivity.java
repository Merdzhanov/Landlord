package com.landlord.android.views.EstateDetails;

import android.content.Intent;
import android.os.Bundle;

import com.landlord.android.Constants;
import com.landlord.android.R;
import com.landlord.android.models.Estate;
import com.landlord.android.views.BaseDrawerActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class EstateDetailsActivity extends BaseDrawerActivity {

    @Inject
    EstateDetailsFragment mEstateDetailsFragment;

    @Inject
    EstateDetailsContracts.Presenter mEstateDetailsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estate_details);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        Estate Estate = (Estate) intent.getSerializableExtra(Constants.EXTRA_KEY);

        mEstateDetailsPresenter.setEstateId(Estate.getId());
        mEstateDetailsFragment.setPresenter(mEstateDetailsPresenter);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mEstateDetailsFragment)
                .commit();
    }

    @Override
    protected long getIdentifier() {
        return 0;
    }
}
