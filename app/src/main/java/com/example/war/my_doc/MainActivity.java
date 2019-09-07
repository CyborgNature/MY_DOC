package com.example.war.my_doc;

import android.content.Intent;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.ErrorCodes;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {



    private final int REQUEST_LOGIN=1000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);




        FirebaseAuth auth = FirebaseAuth.getInstance();
        // if already signed
        if (auth.getCurrentUser() != null) {

            if (!FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber().isEmpty()) {


                startActivity(new Intent(MainActivity.this, SecondActivity.class)
                        .putExtra("phone", FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber().isEmpty())

                );

                finish();
            }
        }
        else {
                startActivityForResult(AuthUI.getInstance()
                        .createSignInIntentBuilder().setAvailableProviders(
                                Arrays.asList(
                                        new AuthUI.IdpConfig.Builder(AuthUI.PHONE_VERIFICATION_PROVIDER).build()
                                )).build(), REQUEST_LOGIN);
            }
        }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==REQUEST_LOGIN){


            IdpResponse response=IdpResponse.fromResultIntent(data);
            //Sucessfully signed in
            if(resultCode==RESULT_OK) {

                if (!FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber().isEmpty()) {

                    startActivity(new Intent(this, SecondActivity.class).putExtra("phone", FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber()));

                    finish();
                    return;

                } else { // sign in failed

                    if (response == null) {
                        Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (response.getErrorCode() == ErrorCodes.NO_NETWORK) {
                        Toast.makeText(this, "No Network", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (response.getErrorCode() == ErrorCodes.UNKNOWN_ERROR) {
                        Toast.makeText(this, "Unknown Error", Toast.LENGTH_SHORT).show();
                        return;

                    }

                }
                Toast.makeText(this, "Unknown sign in !!!!!!", Toast.LENGTH_SHORT).show();

            }
        }

     }
   }


