package com.landlord.android.views.MessagesList;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.landlord.android.Constants;
import com.landlord.android.R;
import com.landlord.android.models.ChatMessage;
import com.landlord.android.views.BaseDrawerActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;


public class MessagesListActivity
        extends BaseDrawerActivity{

    @Inject
    MessagesListFragment mMessagesListFragment;

    @Inject
    MessagesListContracts.Presenter mMessagesListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estate_chat);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        ChatMessage ChatMessage = (ChatMessage) intent.getSerializableExtra(Constants.EXTRA_KEY);

        mMessagesListPresenter.setMessageId(ChatMessage.getId());
        mMessagesListFragment.setPresenter(mMessagesListPresenter);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mMessagesListFragment)
                .commit();
        mMessagesListPresenter.loadMessages();
    }

//    mEstateDetailsPresenter.setEstateId(Estate.getId());
//    mEstateDetailsPresenter.loadEstate();

    @Override
    protected long getIdentifier() {
        return 0;
    }

}
