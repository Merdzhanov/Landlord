package com.landlord.android.views.Login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.landlord.android.R;
import com.landlord.android.views.EstatesList.EstatesListActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.username)
    EditText mUsername;

    @BindView(R.id.bt_login)
    Button mButtonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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
}
