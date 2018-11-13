package com.landlord.android.views.EstatesList;

import android.app.Activity;
import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.landlord.android.LandlordApplication;
import com.landlord.android.async.base.SchedulerProvider;
import com.landlord.android.models.Estate;
import com.landlord.android.services.base.EstatesService;
import com.landlord.android.services.base.UsersService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class EstatesListPresenter
        implements EstatesListContracts.Presenter {

    private final EstatesService mEstatesService;
    private final UsersService mUsersService;
    private final SchedulerProvider mSchedulerProvider;
    private EstatesListContracts.View mView;

    @Inject
    public EstatesListPresenter(
            EstatesService EstatesService,
            UsersService usersService,
            SchedulerProvider schedulerProvider) {
        mEstatesService = EstatesService;
        mSchedulerProvider = schedulerProvider;
        mUsersService = usersService;
    }

    @Override
    public void subscribe(EstatesListContracts.View view) {
        mView = view;
    }

    @Override
    public void loadEstates() {
        mView.showLoading();
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(EstatesListActivity.getAppContext());
        String username = sharedPrefs.getString("username", "");
        Disposable observable = Observable
                .create((ObservableOnSubscribe<List<Estate>>) emitter -> {
                    List<Estate> Estates = mEstatesService.getEstatesByUser(username);
                    emitter.onNext(Estates);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doFinally(mView::hideLoading)
                .subscribe(
                        this::presentEstatesToView,
                        error -> mView.showError(error)
                );
    }

    @Override
    public void filterEstates(String pattern) {
        mView.showLoading();
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(EstatesListActivity.getAppContext());
        String username = sharedPrefs.getString("username", "");
        Disposable observable = Observable
                .create((ObservableOnSubscribe<List<Estate>>) emitter -> {
                    List<Estate> Estates = mEstatesService.getFilteredEstates(pattern, username);
                    emitter.onNext(Estates);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doOnError(error -> mView.showError(error))
                .doFinally(mView::hideLoading)
                .subscribe(this::presentEstatesToView);
    }

    @Override
    public void selectEstate(Estate Estate) {
        mView.showEstateDetails(Estate);
    }

    private void presentEstatesToView(List<Estate> Estates) {
        if (Estates.isEmpty()) {
            mView.showEmptyEstatesList();
        } else {
            mView.showEstates(Estates);
        }
    }

    @Override
    public UsersService getUsersService() {
        return mUsersService;
    }
}
