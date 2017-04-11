package com.learnshare.loginapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class MainActivity extends AppCompatActivity {

    private LoginButton mLoginButton ;

    private CallbackManager mCallbackManager ;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mLoginButton = (LoginButton) findViewById(R.id.login_button);

        mLoginButton.setReadPermissions("email");

        mCallbackManager = CallbackManager.Factory.create();

        mLoginButton.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                Toast.makeText(MainActivity.this,"Login Success",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCancel() {

                Toast.makeText(MainActivity.this,"Cancelled",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onError(FacebookException error) {

                Toast.makeText(MainActivity.this,"Error !!",Toast.LENGTH_SHORT).show();

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mCallbackManager.onActivityResult(requestCode,resultCode,data);
    }
}
