package com.landlord.android.views.Login;

import com.landlord.android.models.User;
import com.landlord.android.services.base.UsersService;
import javax.inject.Inject;
import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;


public class LoginPresenter implements LoginContracts.Presenter{

    UsersService mUserService;
    User mUser;

    @Inject
    public LoginPresenter(
            UsersService usersService
    ){
            mUserService=usersService;
    }

    @Override
    public User getUserByName(String s) {
        Disposable observable = Observable
                .create((ObservableOnSubscribe<User>) emitter -> {
                    User user = mUserService.getUserByUsername(s);
                    emitter.onNext(user);
                    emitter.onComplete();
                })
                .subscribe(user -> mUser=user);
      return mUser;
    }
}
