package com.landlord.android.views.EstateCreate;


import com.landlord.android.models.Estate;

public interface EstateCreateContracts {
    interface View {

        void setPresenter(Presenter presenter);

        void navigateToHome();

        void showError(Throwable throwable);

        void hideLoading();

        void showLoading();
    }

    interface Presenter {

        void subscribe(View view);

        void unsubscribe();

        void save(Estate Estate);
    }

    public interface Navigator {

        void navigateToHome();
    }
}
