package com.landlord.android.views.EstatesList;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

import com.landlord.android.Constants;
import com.landlord.android.R;
import com.landlord.android.models.Estate;
import com.landlord.android.views.BaseDrawerActivity;
import com.landlord.android.views.EstateDetails.EstateDetailsActivity;
import com.landlord.android.views.EstateDetails.EstateDetailsFragment;
import com.landlord.android.views.EstateDetails.EstateDetailsPresenter;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class EstatesListActivity
        extends BaseDrawerActivity
        implements EstatesListContracts.Navigator {

    @Inject
    EstatesListFragment mEstatesListFragment;

    @Inject
    EstatesListContracts.Presenter mEstatesListPresenter;

    @Inject
    EstateDetailsFragment mEstateDetailsFragment;

    @Inject
    EstateDetailsPresenter mEstateDetailsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estates_list);

        ButterKnife.bind(this);

        //setSupportActionBar(getToolbar());

        mEstatesListFragment.setNavigator(this);
        mEstatesListFragment.setPresenter(mEstatesListPresenter);

        //FragmentTransaction transaction =
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mEstatesListFragment)
                .commit();

//        if (!isPhone()) {
//            mEstateDetailsFragment.setPresenter(mEstateDetailsPresenter);
//            transaction.replace(R.id.content_details, mEstateDetailsFragment);
//        }

        //transaction.commit();
    }

    private boolean isPhone() {
        return findViewById(R.id.content_details) == null;
    }

    @Override
    protected long getIdentifier() {
        return Constants.LIST_IDENTIFIER;
    }

    @Override
    public void navigateWith(Estate Estate) {
        if (isPhone()) {
            Intent intent = new Intent(
                    this,
                    EstateDetailsActivity.class
            );

            intent.putExtra(Constants.EXTRA_KEY, Estate);

            startActivity(intent);
        } else {
            mEstateDetailsPresenter.setEstateId(Estate.getId());
            mEstateDetailsPresenter.loadEstate();
        }
    }
}