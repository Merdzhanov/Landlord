package com.landlord.android.views.EstateDetails;

import com.landlord.android.async.base.SchedulerProvider;
import com.landlord.android.models.Estate;
import com.landlord.android.services.base.EstatesService;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class EstateDetailsPresenter
        implements EstateDetailsContracts.Presenter {
    private final EstatesService mEstatesService;
    private final SchedulerProvider mSchedulerProvider;

    private EstateDetailsContracts.View mView;
    private int mEstateId;

    @Inject
    public EstateDetailsPresenter(
            EstatesService EstatesService,
            SchedulerProvider schedulerProvider
    ) {
        mEstatesService = EstatesService;
        mSchedulerProvider = schedulerProvider;
    }

    @Override
    public void subscribe(EstateDetailsContracts.View view) {
        mView = view;
    }

    @Override
    public void loadEstate() {
        mView.showLoading();
        Disposable observable = Observable
                .create((ObservableOnSubscribe<Estate>) emitter -> {
                    Estate Estate = mEstatesService.getDetailsById(mEstateId);
                    emitter.onNext(Estate);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doOnError(mView::showError)
                .subscribe(mView::showEstate);
    }

    @Override
    public void setEstateId(int EstateId) {
        mEstateId = EstateId;
    }
}
