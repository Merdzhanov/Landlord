package com.landlord.android.views.EstateDetails;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.landlord.android.Constants;
import com.landlord.android.R;
import com.landlord.android.models.Estate;
import com.landlord.android.views.BaseDrawerActivity;
import com.landlord.android.views.EstatesList.EstatesListFragment;
import com.landlord.android.views.EstatesList.EstatesListPresenter;
import com.landlord.android.views.MessagesList.MessagesListContracts;
import com.landlord.android.views.MessagesList.MessagesListFragment;
import com.landlord.android.views.MessagesList.MessagesListPresenter;
import com.landlord.android.views.camera.CameraMainFragment;
import com.landlord.android.views.camera.CameraUtils;

import javax.inject.Inject;

import butterknife.ButterKnife;

import static java.security.AccessController.getContext;

public class EstateDetailsActivity extends BaseDrawerActivity implements MessagesListContracts.Navigator {

    @Inject
    EstateDetailsFragment mEstateDetailsFragment;

    @Inject
    MessagesListFragment mMessagesListFragment;

    @Inject
    MessagesListPresenter mMessagesListPresenter;

    @Inject
    CameraMainFragment mCameraMainFragment;

    @Inject
    EstateDetailsContracts.Presenter mEstateDetailsPresenter;


    EstateDetailsFragmentPagerAdapter mEstateDetailsFragmentPagerAdapter;
    ViewPager mViewPager;
Activity mActivity;
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

        mCameraMainFragment.setEstateId(estateId);





        mEstateDetailsFragmentPagerAdapter =
                new EstateDetailsFragmentPagerAdapter(
                        getSupportFragmentManager());
        mEstateDetailsFragmentPagerAdapter.mEstateDetailsFragment=mEstateDetailsFragment;
        mEstateDetailsFragmentPagerAdapter.mMessagesListFragment=mMessagesListFragment;
        if (!CameraUtils.isDeviceSupportCamera(getApplicationContext())) {
            mEstateDetailsFragmentPagerAdapter.mCameraMainFragment=null;
        }else {
            mEstateDetailsFragmentPagerAdapter.mCameraMainFragment = mCameraMainFragment;
        }

        mViewPager = findViewById(R.id.pager);
        mViewPager.setAdapter(mEstateDetailsFragmentPagerAdapter);

        mViewPager.setCurrentItem(1);
        mActivity=this;
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int state) {}
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

            public void onPageSelected(int position) {
                if(position!=0){
                    hideKeyboard(mActivity);
                }

            }
        });
        //mMessagesListPresenter.handler
    }
    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
    @Override
    protected long getIdentifier() {
        return Constants.CREATE_IDENTIFIER;
    }

    @Override
    public void navigateToHome() {
        Intent intent = new Intent(this, EstateDetailsActivity.class);
        startActivity(intent);
        finish();
    }
}
