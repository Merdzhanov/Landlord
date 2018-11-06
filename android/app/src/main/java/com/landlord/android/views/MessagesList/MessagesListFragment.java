package com.landlord.android.views.MessagesList;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.landlord.android.R;
import com.landlord.android.models.ChatMessage;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

public class MessagesListFragment
        extends Fragment
        implements MessagesListContracts.View, MessagesAdapter.OnMessageClickListener {

    private MessagesListContracts.Presenter mPresenter;
    private LinearLayoutManager mMessagesViewLayout;
    private OnChatClickListener mOnClickListener;

    @BindView(R.id.rv_list_of_message)
    RecyclerView mMessagesView;

    @BindView(R.id.fab)
    FloatingActionButton fab;

    @BindView(R.id.input)
    EditText input;

    @Inject
    MessagesAdapter mMessagesAdapter;

    @Inject
    public MessagesListFragment() {
        // Required empty public constructor
    }



//    !!!! Start
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_estate_chat, container, false);

        // ButterKnife is applied
        ButterKnife.bind(this, view);

        mMessagesAdapter.setOnMessageClickListener(this);

        mMessagesView.setAdapter(mMessagesAdapter);
        mMessagesViewLayout = new LinearLayoutManager(getContext());
        mMessagesView.setLayoutManager(mMessagesViewLayout);

//
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

        displayChatMessage();

        return view;
    }


    private void displayChatMessage() {
        //   ??????

    }


//    !!!! End

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe((MessagesListContracts.View) this);
        mPresenter.loadMessages();
    }

    @Override
    public void setPresenter(MessagesListContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onClick(ChatMessage Message) {
        mOnClickListener.onClick(mMessagesView);
    }

    interface OnChatClickListener {
        void onClick(RecyclerView ChatMessage);
    }

    @Override
    public void showMessages(List<ChatMessage> Message) {

    }

    @Override
    public void showEmptyMessagesList() {

    }

    @Override
    public void showError(Throwable e) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
