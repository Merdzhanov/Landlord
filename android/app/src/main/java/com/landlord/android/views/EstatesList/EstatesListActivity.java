package com.landlord.android.views.EstatesList;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.preference.PreferenceManager;
import android.support.v4.app.DialogFragment;
import android.support.v7.preference.PreferenceFragmentCompat;

import com.landlord.android.Constants;
import com.landlord.android.R;
import com.landlord.android.models.Estate;
import com.landlord.android.views.BaseDrawerActivity;
import com.landlord.android.views.EstateDetails.EstateDetailsActivity;
import com.landlord.android.views.EstateDetails.EstateDetailsFragment;
import com.landlord.android.views.EstateDetails.EstateDetailsPresenter;
import com.landlord.android.views.Login.LoginActivity;

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


    private static Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = getApplicationContext();

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

    public static Context getAppContext() {
        return mContext;
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

    @Override
    public void onStart() {
        super.onStart();
        if (shouldStartSignIn()) {
            startSignIn();
        }
    }

    private boolean shouldStartSignIn() {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        return sharedPrefs.getString("username", "").isEmpty();
    }

    private void startSignIn() {
        Intent intent =new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
