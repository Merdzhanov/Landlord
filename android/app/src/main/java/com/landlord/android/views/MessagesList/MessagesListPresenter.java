package com.landlord.android.views.MessagesList;

import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.Log;

import com.landlord.android.async.base.SchedulerProvider;
import com.landlord.android.models.ChatMessage;
import com.landlord.android.models.ChatMessageDTO;
import com.landlord.android.models.Estate;
import com.landlord.android.models.User;
import com.landlord.android.repositories.HttpRepository;
import com.landlord.android.services.HttpEstatesService;
import com.landlord.android.services.base.EstatesService;
import com.landlord.android.services.base.MessagesDTOService;
import com.landlord.android.services.base.MessagesService;
import com.landlord.android.services.base.UsersService;
import com.landlord.android.sharedpreferences.base.SharedPreferencesRepository;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class MessagesListPresenter implements MessagesListContracts.Presenter

{

    private final MessagesService mMessagesService;
    private final MessagesDTOService mMessagesDTOService;
    private final EstatesService mEstatesService;
    private final UsersService mUsersService;
    //private final SharedPreferencesRepository mSharedPreferencesRepository;
    private final SchedulerProvider mSchedulerProvider;
    private MessagesListContracts.View mView;
    private Integer mMessageId;
    public Integer mEstateId;
    public String mUsername;
    private MessagesListContracts.Navigator mNavigator;

//    Handler handler = new Handler();
//    Runnable timedTask = () -> {
//        loadMessages();
//        handler.postDelayed(timedTask, 1000);
//    };



    @Inject
    public MessagesListPresenter(
            MessagesService MessagesService,
            MessagesDTOService MessagesDTOService,
            EstatesService EstatesService,
            UsersService UsersService,
            // SharedPreferencesRepository SharedPreferencesRepository,
            SchedulerProvider schedulerProvider) {
        mMessagesService = MessagesService;
        mMessagesDTOService=MessagesDTOService;
        mEstatesService=EstatesService;
        mUsersService=UsersService;
        //mSharedPreferencesRepository = SharedPreferencesRepository;
        mSchedulerProvider = schedulerProvider;
    }


    @Override
    public void subscribe(MessagesListContracts.View view) {
        mView = view;
    }

    @Override
    public void loadMessages() {
        Disposable observable = Observable
                .create((ObservableOnSubscribe<List<ChatMessage>>) emitter -> {
                    List<ChatMessage> Messages = mMessagesService.getMessagesByEstateID(mEstateId);
                    emitter.onNext(Messages);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(
                        this::presentMessagesToView,
                        error -> mView.showError(error)
                );
    }

    private void presentMessagesToView(List<ChatMessage> Messages) {
        if (Messages.isEmpty()) {
            mView.showEmptyMessagesList();
        } else {
            mView.showMessages(Messages);
        }
    }

    @Override
    public void setMessageId(Integer id) {

    }

    public void setEstateId(Integer estateId) {
        mEstateId = estateId;
    }

    @Override
    public void save(String chatMessage) {
        //mView.showLoading();

//        String sender=mUsername;
//        String estateID=mEstateId
        Disposable disposable = Observable
                .create((ObservableOnSubscribe<ChatMessageDTO>) emitter -> {
                    //ChatMessage createdChatMessage = mMessagesService.createMessage(chatMessage);
                    //ChatMessageDTO createdChatMessage =
                            mMessagesDTOService.createMessage(new ChatMessageDTO(chatMessage, mUsername, mEstateId.toString()));
                    //emitter.onNext(createdChatMessage);
                   // emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doOnEach(x -> mView.hideLoading())
                .doOnError(mView::showError)
                .subscribe(
                        present-> loadMessages(),
                        s -> mView.navigateToHome()
                );
        //loadMessages();
    }
    @Override
    public void setUsername(String username){
        mUsername=username;
    }

    @Override
    public void loadUser() {
//        Disposable observable = Observable
//                .create((ObservableOnSubscribe<User>) emitter -> {
//                    User user= mUsersService.getUserByUsername(mUsername);
//                    emitter.onNext(user);
//                    emitter.onComplete();
//                })
//                .subscribeOn(mSchedulerProvider.background())
//                .observeOn(mSchedulerProvider.ui())
//                .doOnError(mView::showError)
//                .subscribe(mView::setUser);
    }

    @Override
    public void loadEstate() {
//        Disposable observable = Observable
//                .create((ObservableOnSubscribe<Estate>) emitter -> {
//                    Estate estate = mEstatesService.getDetailsById(mEstateId);
//                    emitter.onNext(estate);
//                    emitter.onComplete();
//                })
//                .subscribeOn(mSchedulerProvider.background())
//                .observeOn(mSchedulerProvider.ui())
//                .doOnError(mView::showError)
//                .subscribe(mView::setEstate);
    }
}

