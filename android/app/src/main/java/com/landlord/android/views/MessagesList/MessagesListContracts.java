package com.landlord.android.views.MessagesList;


import com.landlord.android.models.ChatMessage;

import java.util.List;

public interface MessagesListContracts {
    interface View {

        void setPresenter(Presenter presenter);

        void showMessages(List<ChatMessage> Message);

        void showEmptyMessagesList();

        void showError(Throwable e);

        void showLoading();

        void hideLoading();
    }

    interface Presenter {
        void subscribe(View view);

        void loadMessages();

        void setMessageId(int id);

    }

    interface Navigator {
        void navigateWith(ChatMessage Message);
    }
}

