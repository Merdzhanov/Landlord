package com.landlord.android.views.EstateDetails;


import android.support.v4.app.Fragment ;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.landlord.android.views.EstatesList.EstatesListFragment;
import com.landlord.android.views.MessagesList.MessagesListFragment;

import javax.inject.Inject;

public class EstateDetailsFragmentPagerAdapter extends FragmentStatePagerAdapter {
    @Inject
    EstateDetailsFragment mEstateDetailsFragment;

    @Inject
    MessagesListFragment mMessagesListFragment;

    @Inject
    EstatesListFragment mEstatesListFragment;


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
//            case 2:
//                return mEstatesListFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position==1){
            return "Estate Details";
        }
        if (position==2){
            return "Chat";
        }
//        if (position==3){
//            return "Photo";
//        }
        return ""+ position;
    }
}

