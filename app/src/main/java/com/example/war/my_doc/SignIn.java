package com.example.war.my_doc;

import android.app.ProgressDialog;
import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.war.my_doc.Common.Common;
import com.example.war.my_doc.model.Users;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.Locale;

public class SignIn extends AppCompatActivity {

    private Firebase mRef;
    Button btnsignin;
    EditText editTextphone,editTextpassword;


    TextToSpeech textToSpeech;
    int result;
    String text;
    TextView textView;
    public static int c;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        Firebase.setAndroidContext(this);
        mRef=new Firebase("https://mydoc-4cc21.firebaseio.com/Users");

        editTextphone = (MaterialEditText) findViewById(R.id.editPhone);
        editTextpassword = (MaterialEditText) findViewById(R.id.editpassword);
        btnsignin = (Button) findViewById(R.id.btnsigin);



        textToSpeech=new TextToSpeech(SignIn.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {

                if(i==TextToSpeech.SUCCESS){

                    result=textToSpeech.setLanguage(Locale.CANADA);

                }else
                    Toast.makeText(SignIn.this, "Your device is not supported for this", Toast.LENGTH_SHORT).show();

            }
        });

       btnsignin.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               final ProgressDialog mDialog=new ProgressDialog(SignIn.this);
               mDialog.setMessage("Please Wait ...");
               mDialog.show();


               mRef.addValueEventListener(new com.firebase.client.ValueEventListener() {
               @Override
               public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {

                   if(editTextphone.getText().toString().equals(""))
                   {

                       Toast.makeText(SignIn.this, "Missing data", Toast.LENGTH_SHORT).show();
                       mDialog.dismiss();
                   }
                   else{
                   if(dataSnapshot.child(editTextphone.getText().toString()).exists()){
                       mDialog.dismiss();
                       //get user information
                       Users user=dataSnapshot.child(editTextphone.getText().toString()).getValue(Users.class);
                       if(user.getPassword().equals(editTextpassword.getText().toString())){

                           Toast.makeText(SignIn.this, "Sign in", Toast.LENGTH_SHORT).show();

                           Common.currentuser=user;
                           if (result == textToSpeech.LANG_MISSING_DATA || result == textToSpeech.LANG_NOT_SUPPORTED) {

                               Toast.makeText(SignIn.this, "Feature not Supported in your device", Toast.LENGTH_SHORT).show();

                           } else {
                               text ="Nice to see you Dear "+user.getName()+" well guess what i like your name "+
                                       user.getName()+" its very Good";
                               textToSpeech.speak(text, textToSpeech.QUEUE_FLUSH, null);


                           }

                           Intent homeintent = new Intent(SignIn.this,HOMEE.class);
                           startActivity(homeintent);
                           finish();
                             c=1;

                       }else
                       {
                           Toast.makeText(SignIn.this, "Wrong Password", Toast.LENGTH_SHORT).show();

                       }
                   }else {
                       mDialog.dismiss();
                       Toast.makeText(SignIn.this, "User does not exist", Toast.LENGTH_SHORT).show();


                   }

                   }
               }

               @Override
               public void onCancelled(FirebaseError firebaseError) {

               }
           });



           }
       });





    }

    @Override
    protected void onDestroy() {

        super.onDestroy();

        if(textToSpeech!=null)
        {

            textToSpeech.stop();
            textToSpeech.shutdown();

        }


    }

}







