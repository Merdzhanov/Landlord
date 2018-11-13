package com.landlord.android.views.EstatesList;


import com.landlord.android.models.Estate;
import com.landlord.android.services.base.UsersService;

import java.util.List;

public interface EstatesListContracts {
    interface View {
        void setPresenter(Presenter presenter);

        void showEstates(List<Estate> Estates);

        void showEmptyEstatesList();

        void showError(Throwable e);

        void showLoading();

        void hideLoading();

        void showEstateDetails(Estate Estate);
    }

    interface Presenter {
        void subscribe(View view);

        void loadEstates();

        void filterEstates(String pattern);

        void selectEstate(Estate Estate);

        UsersService getUsersService();
    }

    interface Navigator {
        void navigateWith(Estate Estate);
    }
}
