package com.example.war.my_doc;

import android.content.Intent;
import android.graphics.Typeface;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class Profile extends AppCompatActivity {

    TextToSpeech textToSpeech;
    static int counter=0;
    int result;
    String text;
    Button btnsignu,btnsignin;
    TextView textSlogan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        textToSpeech=new TextToSpeech(Profile.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {

                if(i==TextToSpeech.SUCCESS){

                    result=textToSpeech.setLanguage(Locale.ENGLISH);

                }else
                    Toast.makeText(Profile.this, "Your device is not supported for this", Toast.LENGTH_SHORT).show();

            }
        });



    btnsignu=(Button)findViewById(R.id.btnsignup);
    btnsignin=(Button)findViewById(R.id.btnsigin);

    textSlogan=(TextView)findViewById(R.id.textSlogan);

        Typeface typeface= Typeface.createFromAsset(getAssets(),"fonts/Nabila.ttf");
        textSlogan.setTypeface(typeface);


        btnsignu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


              if(counter==0) {
                  switch (view.getId()) {

                      case R.id.btnsignup:
                          if (result == textToSpeech.LANG_MISSING_DATA || result == textToSpeech.LANG_NOT_SUPPORTED) {

                              Toast.makeText(Profile.this, "feautre not supported in your device", Toast.LENGTH_SHORT).show();


                          } else {
                              text = "Simple is better , so just enter your phone number and a name for my database . ";
                              textToSpeech.speak(text, textToSpeech.QUEUE_FLUSH, null);


                              counter++;

                          }
                          break;


                  }

              }


                Intent intent=new Intent(Profile.this,SignUpp.class);
                startActivity(intent);
            }
        });

        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                switch (view.getId()){

                    case R.id.btnsigin:
                        if(result==textToSpeech.LANG_MISSING_DATA || result==textToSpeech.LANG_NOT_SUPPORTED){

                            Toast.makeText(Profile.this, "feautre not supported in your device", Toast.LENGTH_SHORT).show();


                        }else{
                            text="Simple is better , so just enter your phone number and a password for my database . ";
                            textToSpeech.speak(text,textToSpeech.QUEUE_FLUSH,null);


                        }
                        break;




                }




                Intent intent=new Intent(Profile.this,SignIn.class);
                startActivity(intent);
            }
        });

    }
}
