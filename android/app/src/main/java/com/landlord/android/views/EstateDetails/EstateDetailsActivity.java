package com.landlord.android.views.EstateDetails;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import com.landlord.android.Constants;
import com.landlord.android.R;
import com.landlord.android.models.Estate;
import com.landlord.android.views.BaseDrawerActivity;
import com.landlord.android.views.EstatesList.EstatesListFragment;
import com.landlord.android.views.EstatesList.EstatesListPresenter;
import com.landlord.android.views.MessagesList.MessagesListFragment;
import com.landlord.android.views.MessagesList.MessagesListPresenter;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class EstateDetailsActivity extends BaseDrawerActivity {

    @Inject
    EstateDetailsFragment mEstateDetailsFragment;

    @Inject
    MessagesListFragment mMessagesListFragment;

    @Inject
    MessagesListPresenter mMessagesListPresenter;

    @Inject
    EstateDetailsContracts.Presenter mEstateDetailsPresenter;


    EstateDetailsFragmentPagerAdapter mEstateDetailsFragmentPagerAdapter;
    ViewPager mViewPager;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estate_details);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        Estate Estate = (Estate) intent.getSerializableExtra(Constants.EXTRA_KEY);

        // ViewPager and its adapters use support library
        // fragments, so use getSupportFragmentManager.
        Integer estateId=Estate.getId();
        String estateName=Estate.getName();
        mEstateDetailsPresenter.setEstateId(estateId);
        mEstateDetailsFragment.setPresenter(mEstateDetailsPresenter);
        //mEstatesListFragment.setNavigator(this);
        mMessagesListPresenter.setEstateId(estateId);
        mMessagesListFragment.setPresenter(mMessagesListPresenter);


        mEstateDetailsFragmentPagerAdapter =
                new EstateDetailsFragmentPagerAdapter(
                        getSupportFragmentManager());
        mEstateDetailsFragmentPagerAdapter.mEstateDetailsFragment=mEstateDetailsFragment;
        mEstateDetailsFragmentPagerAdapter.mMessagesListFragment=mMessagesListFragment;

        mViewPager = findViewById(R.id.pager);
        mViewPager.setAdapter(mEstateDetailsFragmentPagerAdapter);
    }

    @Override
    protected long getIdentifier() {
        return Constants.CREATE_IDENTIFIER;
    }
}
