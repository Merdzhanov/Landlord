package com.landlord.android.views.EstateDetails;


import android.support.v4.app.Fragment ;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.widget.Toast;

import com.landlord.android.views.EstatesList.EstatesListFragment;
import com.landlord.android.views.MessagesList.MessagesListFragment;
import com.landlord.android.views.camera.CameraMainFragment;
import com.landlord.android.views.camera.CameraUtils;

import javax.inject.Inject;

public class EstateDetailsFragmentPagerAdapter extends FragmentStatePagerAdapter {
    //@Inject
    EstateDetailsFragment mEstateDetailsFragment;

    //@Inject
    MessagesListFragment mMessagesListFragment;

    //@Inject
    CameraMainFragment mCameraMainFragment;


    public EstateDetailsFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return mMessagesListFragment;
            case 1:
                return mEstateDetailsFragment;
            case 2:
                return mCameraMainFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        if(mCameraMainFragment!=null){
           return 3;
        }
        return 2;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        if (position==1){
            return "Chat";
        }
        if (position==2){
            return "Estate Details";
        }
        if (position==3){
            return "Camera";
        }
        return ""+ position;
    }

    @Override
    public int getItemPosition(Object object) {
        // POSITION_NONE makes it possible to reload the PagerAdapter
        return POSITION_NONE;
        //return 1;
    }
}

