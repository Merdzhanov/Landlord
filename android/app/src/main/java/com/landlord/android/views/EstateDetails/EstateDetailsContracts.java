package com.landlord.android.views.EstateDetails;


import com.landlord.android.models.Estate;

public interface EstateDetailsContracts {
    interface View {
        void showEstate(Estate Estate);

        void setPresenter(Presenter presenter);

        void showError(Throwable e);

        void showLoading();

        void hideLoading();
    }

    interface Presenter {
        void subscribe(View view);

        void loadEstate();

        void setEstateId(Integer id);
    }
}
