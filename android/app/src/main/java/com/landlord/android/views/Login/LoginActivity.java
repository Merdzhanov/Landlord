package com.landlord.android.views.Login;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.landlord.android.R;
import com.landlord.android.async.base.SchedulerProvider;
import com.landlord.android.models.Estate;
import com.landlord.android.models.User;
import com.landlord.android.services.HttpUsersService;
import com.landlord.android.services.base.UsersService;
import com.landlord.android.views.EstateDetails.EstateDetailsPresenter;
import com.landlord.android.views.EstatesList.EstatesListActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class LoginActivity extends AppCompatActivity implements LoginContracts.Navigator{
    @BindView(R.id.username)
    EditText mUsername;

    @BindView(R.id.bt_login)
    Button mButtonLogin;

//    @Inject
//    LoginPresenter mLoginPresenter;
    Activity mActivity;
    User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mActivity=this;
        ButterKnife.bind(this);

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);

        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    SharedPreferences.Editor editor = sp.edit();
                    editor.clear();
                        editor.putString("username", String.valueOf(mUsername.getText()));
                    editor.commit();
                    startActivity(new Intent(getApplicationContext(), EstatesListActivity.class));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
