package com.example.war.my_doc;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by war on 1/30/2018.
 */

public class MY_DOC extends Application {

    @Override
    public void onCreate() {
        super.onCreate();


        Firebase.setAndroidContext(this);
    }
}
