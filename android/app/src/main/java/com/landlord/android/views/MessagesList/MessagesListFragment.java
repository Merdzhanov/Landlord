package com.landlord.android.views.MessagesList;

import android.bluetooth.BluetoothManager;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.landlord.android.R;
import com.landlord.android.async.AsyncSchedulerProvider;
import com.landlord.android.async.base.SchedulerProvider;
import com.landlord.android.models.ChatMessage;
import com.landlord.android.models.ChatMessageDTO;
import com.landlord.android.models.Estate;
import com.landlord.android.models.User;
import com.landlord.android.services.base.UsersService;


import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class MessagesListFragment
        extends Fragment
        implements MessagesListContracts.View, Runnable{
    @Inject
    UsersService mUserService;

    @Inject
    SchedulerProvider mSchedulerProvider;

//    @Inject
//    MessagesListContracts.Navigator mNavigator;

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
    public User mUser;
    public Estate mEstate;
    // Create the Handler object (on the main thread by default)
    Handler handler = new Handler();
    // Define the code block to be executed
    private Runnable runnableCode = new Runnable() {
        @Override
        public void run() {
            // Do something here on the main thread
            Log.d("Handlers", "Called on main thread");
            refresh();
            // Repeat this the same runnable code block again another 2 seconds
            handler.postDelayed(runnableCode, 2000);
        }
        private void refresh() {
            mPresenter.loadMessages();
        }
    };

//    @Inject
//    public ViewPager mViewPager;

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
        //mMessagesView.scrollToPosition(mMessagesAdapter.getItemCount()-1);
        mMessagesView.scrollTo(0,mMessagesView.getBottom());




//        // !!! Start
//
//
//        //mMessagesAdapter.setOnClickListener(this);
//
//
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                int i=5;
//
//                input.setText("");
//            }
//        });
        // Start the initial runnable task by posting through the handler
        return view;
    }

//    !!!! End

    @Override
    public void onStart() {
        super.onStart();
        handler.post(runnableCode);
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        String username= sharedPrefs.getString("username", "");
        mPresenter.setUsername(username);
        //mMessagesView.scrollTo(0,mMessagesAdapter.getItemCount());
        mMessagesView.scrollTo(0,mMessagesView.getBottom());
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
        mPresenter.loadMessages();
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        String username= sharedPrefs.getString("username", "");
        mPresenter.setUsername(username);
        //mMessagesView.scrollToPosition(mMessagesAdapter.getItemCount());
        //mMessagesView.scrollTo(0,mMessagesAdapter.getItemCount());
        mMessagesView.scrollTo(0,mMessagesView.getBottom());
       // mPresenter.loadUser();
       // mPresenter.loadEstate();
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
//        Toast.makeText(getContext(),
//                "No Messages",
//                Toast.LENGTH_LONG)
//                .show();
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

    @OnClick(R.id.fab)
    public void onMessageSendClicked() {
        mPresenter.save(input.getText().toString());
        input.setText("");
        mPresenter.loadMessages();
        //String message = input.getText().toString();
        ////SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        //String username= sharedPrefs.getString("username", "");
//
//        Disposable observable = Observable
//                .create((ObservableOnSubscribe<User>) emitter -> {
//                    User user = mUserService.getUserByUsername(username);
//                    emitter.onNext(user);
//                    emitter.onComplete();
//                })
//                .subscribeOn(mSchedulerProvider.background())
//                .observeOn(mSchedulerProvider.ui())
//                .doOnError(this::showError)
//                .subscribe(this::setUser);
//                //.subscribe();
//        mPresenter.loadUser();
//        User sender = mUser;
//        Estate estate = mEstate;
        //Date date =  Calendar.getInstance().getTime().;
        //String message;
        //String messageSenderUsername;
        //String estateId;

        //ChatMessageDTO chatMessageDTO = new ChatMessageDTO(message, username, estateId);
        //ChatMessageDTO chatMessageDTO = new ChatMessageDTO(message, sender, estate);
        //mPresenter.save(chatMessageDTO);
//        mPresenter.save(input.getText().toString());
    }
    @Override
    public void setUser(User user) {
        this.mUser=user;
    }
    @Override
    public void setEstate(Estate estate) {
        this.mEstate=estate;
    }

    @Override
    public void navigateToHome() {
        //mNavigator.navigateToHome();
        //showMessages(messages);
//          ViewPager mViewPager;
//        mViewPager.getAdapter().notifyDataSetChanged();
        mMessagesAdapter.notifyDataSetChanged();
    }

    @Override
    public void run() {

    }
//    public void update(UpdateData xyzData) {
//        this.updateData = xyzData;
//        notifyDataSetChanged();
//    }
//    @Override
//    public int getItemPosition(Object object) {
//        if (object instanceof UpdateableFragment) {
//            ((UpdateableFragment) object).update(updateData);
//        }
//        //don't return POSITION_NONE, avoid fragment recreation.
//        return super.getItemPosition(object);
//    }
}
