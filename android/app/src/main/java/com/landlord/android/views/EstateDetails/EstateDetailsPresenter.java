package com.landlord.android.views.EstateDetails;

import com.landlord.android.async.base.SchedulerProvider;
import com.landlord.android.models.Estate;
import com.landlord.android.models.RatingVoteDTO;
import com.landlord.android.models.User;
import com.landlord.android.services.base.EstatesService;
import com.landlord.android.services.base.RatingVoteDTOService;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class EstateDetailsPresenter
        implements EstateDetailsContracts.Presenter {
    private final EstatesService mEstatesService;
    private final RatingVoteDTOService mRatingVoteDTOService;
    private final SchedulerProvider mSchedulerProvider;

    private EstateDetailsContracts.View mView;
    private Integer mEstateId;

    @Inject
    public EstateDetailsPresenter(
            EstatesService EstatesService,
            RatingVoteDTOService ratingVoteDTOService,
            SchedulerProvider schedulerProvider
    ) {
        mEstatesService = EstatesService;
        mSchedulerProvider = schedulerProvider;
        mRatingVoteDTOService = ratingVoteDTOService;
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
    public void setEstateId(Integer EstateId) {
        mEstateId = EstateId;
    }

    @Override
    public void setRating(User whoRates, User rated, int stars) {
        RatingVoteDTO ratingVoteDTO = new RatingVoteDTO(stars, whoRates.getUserName(), rated.getUserName());
        Disposable disposable = (Disposable) Observable
                .create((ObservableOnSubscribe<RatingVoteDTO>) emitter -> {
                    mRatingVoteDTOService.createRatingVote(ratingVoteDTO);
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doOnEach(x -> mView.hideLoading())
                .doOnError(mView::showError)
                .subscribe(s->loadEstate());

    }

}
