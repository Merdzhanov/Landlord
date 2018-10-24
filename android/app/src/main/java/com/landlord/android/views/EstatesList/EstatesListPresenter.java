package com.landlord.android.views.EstatesList;

import com.landlord.android.async.base.SchedulerProvider;
import com.landlord.android.models.Estate;
import com.landlord.android.services.base.EstatesService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class EstatesListPresenter
        implements EstatesListContracts.Presenter {

    private final EstatesService mEstatesService;
    private final SchedulerProvider mSchedulerProvider;
    private EstatesListContracts.View mView;

    @Inject
    public EstatesListPresenter(
            EstatesService EstatesService,
            SchedulerProvider schedulerProvider) {
        mEstatesService = EstatesService;
        mSchedulerProvider = schedulerProvider;
    }

    @Override
    public void subscribe(EstatesListContracts.View view) {
        mView = view;
    }

    @Override
    public void loadEstates() {
        mView.showLoading();
        Disposable observable = Observable
                .create((ObservableOnSubscribe<List<Estate>>) emitter -> {
                   // List<Estate> Estates = mEstatesService.getAllEstates();
                    List<Estate> Estates = mEstatesService.getEstatesByUser("rumi");
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
        Disposable observable = Observable
                .create((ObservableOnSubscribe<List<Estate>>) emitter -> {
                    List<Estate> Estates = mEstatesService.getFilteredEstates(pattern);
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
}
