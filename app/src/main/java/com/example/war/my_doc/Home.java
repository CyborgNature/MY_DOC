package com.example.war.my_doc;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Locale;

public class Home extends AppCompatActivity {

    Button btn;
    TextToSpeech textToSpeech;
    int result;
    String text;
    static int counter=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        textToSpeech=new TextToSpeech(Home.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {

                if(i==TextToSpeech.SUCCESS){

                    result=textToSpeech.setLanguage(Locale.UK);

                }else
                    Toast.makeText(Home.this, "Your device is not supported for this", Toast.LENGTH_SHORT).show();

            }
        });


        btn=(Button)findViewById(R.id.btnsigin);
       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {



               if(counter==0) {
                   switch (view.getId()) {

                       case R.id.btnsigin:
                           if (result == textToSpeech.LANG_MISSING_DATA || result == textToSpeech.LANG_NOT_SUPPORTED) {

                               Toast.makeText(Home.this, "feautre not supported in your device", Toast.LENGTH_SHORT).show();


                           } else {
                               text = "so my friend , here are few steps for you in order to get registered yourself, in my hot list. ";
                               textToSpeech.speak(text, textToSpeech.QUEUE_FLUSH, null);

                               counter++;

                           }
                           break;


                   }

               }


               startActivity(new Intent(Home.this,Profile.class));
           }
       });


    }


}