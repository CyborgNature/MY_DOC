package com.example.war.my_doc;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.war.my_doc.Common.Common;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Locale;

public class SecondActivity extends AppCompatActivity {



    TextToSpeech textToSpeech;
    int result;
    String text;
    TextView textView;
    int counter=0;

/*    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

//        if(item.getItemId()==R.id.sign_out)
  //          signOut();
        return true;
    }

    private void signOut() {
        AuthUI.getInstance().signOut(SecondActivity.this)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        startActivity(new Intent(SecondActivity.this,MainActivity.class));

                        finish();
                    }
                });
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

     //   Toolbar toolbar=(Toolbar)findViewById(R.id.toolBar);
     //   toolbar.setTitle("Firebase auth");
     //   setActionBar(toolbar);

        textToSpeech=new TextToSpeech(SecondActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {

                if(i==TextToSpeech.SUCCESS){

                    result=textToSpeech.setLanguage(Locale.CANADA);

                }else
                    Toast.makeText(SecondActivity.this, "Your device is not supported for this", Toast.LENGTH_SHORT).show();

            }
        });

        textView=(TextView)findViewById(R.id.text1);
        if(getIntent()!=null)
             textView.setText(getIntent().getStringExtra("phone"));
             textView.setText(" ");
    }


   public void speak(View view){

        if(counter==0) {
            switch (view.getId()) {

                case R.id.btnsignup:
                    if (result == textToSpeech.LANG_MISSING_DATA || result == textToSpeech.LANG_NOT_SUPPORTED) {

                        Toast.makeText(this, "feautre not supported in your device", Toast.LENGTH_SHORT).show();


                    } else {
                        text = "Hello Dear I am your new Doctor , so let's get started,," +
                                "     Now with simple step's let's make your own profile for your better diagonisis                             ";
                        textToSpeech.speak(text, textToSpeech.QUEUE_FLUSH, null);
                        counter++;

                    }
                    break;


            }

        }
        if(SignIn.c==0)
        startActivity(new Intent(SecondActivity.this,Home.class));
        else
            startActivity(new Intent(SecondActivity.this,HOMEE.class));



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
