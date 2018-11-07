package com.landlord.android.views.MessagesList;

import com.landlord.android.async.base.SchedulerProvider;
import com.landlord.android.models.ChatMessage;
import com.landlord.android.models.Estate;
import com.landlord.android.services.base.MessagesService;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class MessagesListPresenter implements MessagesListContracts.Presenter

{

    private final MessagesService mMessagesService;
    private final SchedulerProvider mSchedulerProvider;
    private MessagesListContracts.View mView;
    private Integer mMessageId;
    private Integer mEstateId;

    @Inject
    public MessagesListPresenter(
            MessagesService MessagesService,
            SchedulerProvider schedulerProvider) {
        mMessagesService = MessagesService;
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
//                    List<ChatMessage> Messages = mMessagesService.getMessagesByEstate("dvustaen");
                    List<ChatMessage> Messages = mMessagesService.getMessagesByEstateID(mEstateId);
                    emitter.onNext(Messages);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                //.doFinally(mView::hideLoading)
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
}

