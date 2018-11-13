package com.landlord.android.views;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.widget.Toolbar;

import com.landlord.android.Constants;
import com.landlord.android.R;
import com.landlord.android.views.EstateCreate.EstateCreateActivity;
import com.landlord.android.views.EstatesList.EstatesListActivity;
import com.landlord.android.views.Login.LoginActivity;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;


import butterknife.BindView;
import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseDrawerActivity extends DaggerAppCompatActivity {

    @BindView(R.id.drawer_toolbar)
    Toolbar mToolbar;

    public BaseDrawerActivity() {

    }

    public void setupDrawer() {
        PrimaryDrawerItem listEstatesItem = new PrimaryDrawerItem()
                .withIdentifier(Constants.LIST_IDENTIFIER)
                .withIcon(android.R.drawable.ic_input_get)
                .withName("Home");

//        PrimaryDrawerItem createEstateItem = new PrimaryDrawerItem()
//                .withIdentifier(Constants.CREATE_IDENTIFIER)
//                .withIcon(android.R.drawable.btn_plus)
//                .withName("Create Estate");

        PrimaryDrawerItem logoutItem = new PrimaryDrawerItem()
                .withIdentifier(Constants.LOGOUT_IDENTIFIER)
                .withIcon(android.R.drawable.button_onoff_indicator_off)
                .withName("Logout");

        Drawer drawer = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(mToolbar)
                .addDrawerItems(
                        listEstatesItem,
//                        new DividerDrawerItem(),
//                        createEstateItem ,
                        new DividerDrawerItem(),
                        logoutItem
                )
                .withOnDrawerItemClickListener((view, position, drawerItem) ->
                {
                    long identifier = drawerItem.getIdentifier();

                    if (getIdentifier() == identifier) {
                        return false;
                    }

                    Intent intent = getNextIntent(identifier);
                    if (intent == null) {
                        return false;
                    }

                    startActivity(intent);
                    return true;
                })
                .build();
    }

    private Intent getNextIntent(long identifier) {
        if (identifier == Constants.CREATE_IDENTIFIER) {
            return new Intent(this, EstateCreateActivity.class);
        }
        else if (identifier == Constants.LIST_IDENTIFIER)
        {
            return new Intent(this, EstatesListActivity.class);
        }
        else if (identifier == Constants.LOGOUT_IDENTIFIER)
        {
            SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = sp.edit();
            editor.clear();
            editor.putString("username", "");
            editor.commit();
            //return new Intent(this, EstatesListActivity.class);
            return new Intent(this, LoginActivity.class);
        }

        return null;
    }

    public Toolbar getToolbar() {
        return mToolbar;
    }

    protected abstract long getIdentifier();

    @Override
    protected void onStart() {
        super.onStart();
        setupDrawer();
    }
}
