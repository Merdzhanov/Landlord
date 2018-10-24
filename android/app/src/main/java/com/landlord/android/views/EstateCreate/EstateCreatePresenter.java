package com.landlord.android.views.EstateCreate;

import com.landlord.android.async.base.SchedulerProvider;
import com.landlord.android.models.Estate;
import com.landlord.android.services.base.EstatesService;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class EstateCreatePresenter implements EstateCreateContracts.Presenter {

    private final EstatesService mEstatesService;
    private final SchedulerProvider mSchedulerProvider;
    private EstateCreateContracts.View mView;

    @Inject
    public EstateCreatePresenter(
            EstatesService EstatesService,
            SchedulerProvider schedulerProvider) {
        mEstatesService = EstatesService;
        mSchedulerProvider = schedulerProvider;
    }

    @Override
    public void subscribe(EstateCreateContracts.View view) {
        mView = view;
    }

    @Override
    public void unsubscribe() {
        mView = null;
    }

    @Override
    public void save(Estate Estate) {
        mView.showLoading();
        Disposable disposable = Observable
                .create((ObservableOnSubscribe<Estate>) emitter -> {
                    Estate createdEstate = mEstatesService.createEstate(Estate);
                    emitter.onNext(createdEstate);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doOnEach(x -> mView.hideLoading())
                .doOnError(mView::showError)
                .subscribe(s -> mView.navigateToHome());
    }
}
