package com.landlord.android.views.MessagesList;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.landlord.android.R;
import com.landlord.android.models.ChatMessage;
import com.landlord.android.models.Estate;
import com.landlord.android.models.User;
import com.landlord.android.models.base.UserType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;


public class MessagesListFragment
        extends Fragment
        implements MessagesListContracts.View {

    @BindView(R.id.rv_list_of_message)
    RecyclerView mMessagesView;

    @BindView(R.id.fab)
    FloatingActionButton fab;

    @BindView(R.id.input)
    EditText input;

    @Inject
    MessagesAdapter mMessagesAdapter;

    private MessagesListContracts.Presenter mPresenter;
    private  LinearLayoutManager mLayoutManager;

    @Inject
    public MessagesListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_estate_chat, container, false);

        // ButterKnife is applied
        ButterKnife.bind(this, view);


        mMessagesView.setAdapter(mMessagesAdapter);
        mLayoutManager = new LinearLayoutManager(getContext());
        mMessagesView.setLayoutManager(mLayoutManager);

        // !!! Start


        //mMessagesAdapter.setOnClickListener(this);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int i=5;
        
                input.setText("");
            }
        });

        return view;
    }

//    !!!! End

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
        mPresenter.loadMessages();
    }

    @Override
    public void setPresenter(MessagesListContracts.Presenter presenter) {
        mPresenter = presenter;
    }


    @Override
    public void showMessages(List<ChatMessage> Message) {
        mMessagesAdapter.clear();
        mMessagesAdapter.addAll(Message);
        mMessagesAdapter.notifyDataSetChanged();
    }


    @Override
    public void showEmptyMessagesList() {
        Toast.makeText(getContext(),
                "No Messages",
                Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void showError(Throwable e) {
        Toast.makeText(getContext(), "Error: " + e.getMessage(), Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void hideLoading() {
        mMessagesView.setVisibility(View.VISIBLE);
        mMessagesView.setVisibility(View.GONE);
    }

}
