package com.landlord.android.views.MessagesList;


import com.landlord.android.models.ChatMessage;
import com.landlord.android.models.Estate;
import com.landlord.android.models.User;

import java.util.List;

public interface MessagesListContracts {
    interface View {

        void setPresenter(Presenter presenter);

        void showMessages(List<ChatMessage> Message);

        void showEmptyMessagesList();

        void showError(Throwable e);

        void hideLoading();

        void navigateToHome();

        void setUser(User user);

        void setEstate(Estate estate);
    }

    interface Presenter {
        void subscribe(View view);

        void loadMessages();

        void setMessageId(Integer id);

        void save(String chatMessage);

        void setUsername(String username);

        void loadUser();

        void loadEstate();
    }

    public interface Navigator {

        void navigateToHome();
    }
}

