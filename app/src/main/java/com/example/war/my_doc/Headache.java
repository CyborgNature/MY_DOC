package com.example.war.my_doc;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.Locale;

public class Headache extends AppCompatActivity {

    String data;
    int at=0;
    TextToSpeech textToSpeech;
    String text;
    int result;
    CheckBox cb1,cb2,cb3,cb4,cb5,cb6,cb7,cb8,cb9,cb10,cb11;
    double predictions[][]=new double[1][4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_headache);



        textToSpeech=new TextToSpeech(Headache.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {

                if(i==TextToSpeech.SUCCESS){

                    result=textToSpeech.setLanguage(Locale.UK);

                }else
                    Toast.makeText(Headache.this, "Your device is not supported for this", Toast.LENGTH_SHORT).show();

            }
        });

        cb1=(CheckBox)findViewById(R.id.checkBox);
        cb2=(CheckBox)findViewById(R.id.checkBox2);
        cb3=(CheckBox)findViewById(R.id.checkBox3);
        cb4=(CheckBox)findViewById(R.id.checkBox4);
        cb5=(CheckBox)findViewById(R.id.checkBox5);
        cb6=(CheckBox)findViewById(R.id.checkBox6);
        cb7=(CheckBox)findViewById(R.id.checkBox7);
        cb8=(CheckBox)findViewById(R.id.checkBox8);
        cb9=(CheckBox)findViewById(R.id.checkBox9);
        cb10=(CheckBox)findViewById(R.id.checkBox10);
        cb11=(CheckBox)findViewById(R.id.checkBox11);






    }

   public void headache(View view){







       double theta[][]={{-2.55110,-1.73093,-1.73093,-1.32321},
               {1.28567,-0.30924,-0.30924,-0.74708},
               {1.28567,-0.30924,-0.30924,-0.74708},
               {1.28567,-0.30924,-0.30924,-0.74708},
               {0.60779,-0.78618,-0.78618,1.04793},
               {-0.30390,1.23134,-0.44515,-0.52396},
               {-0.30390,1.23134,-0.44515,-0.52396},
               {-0.30390,1.23134,-0.44515,-0.52396},
               {-0.30390,-0.44515,1.23134,-0.52396},
               {-0.30390,-0.44515,1.23134,-0.52396},
               {-0.30390,-0.44515,1.23134,-0.52396},
               {-0.67787,-0.47695,-0.47695,1.79501} };


       // geting input for
       double y1[][]=new double [1][12];
       y1[0][0]=1;

       if(cb1.isChecked())
           y1[0][1]=1;
       else
           y1[0][1]=0;

       if(cb2.isChecked())
           y1[0][2]=1;
       else
           y1[0][2]=0;

       if(cb3.isChecked())
           y1[0][3]=1;
       else
           y1[0][3]=0;
       if(cb4.isChecked())
           y1[0][4]=1;
       else
           y1[0][4]=0;


       if(cb5.isChecked())
           y1[0][5]=1;
       else
           y1[0][5]=0;

       if(cb6.isChecked())
           y1[0][6]=1;
       else
           y1[0][6]=0;

       if(cb7.isChecked())
           y1[0][7]=1;
       else
           y1[0][7]=0;

       if(cb8.isChecked())
           y1[0][8]=1;
       else
           y1[0][8]=0;

       if(cb9.isChecked())
           y1[0][9]=1;
       else
           y1[0][9]=0;

       if(cb10.isChecked())
           y1[0][10]=1;
       else
           y1[0][10]=0;

       if(cb11.isChecked())
           y1[0][11]=1;
       else
           y1[0][11]=0;




       // Multiplication of X and all_theta
       double sum=0;

       for(int i=0;i<y1.length;i++){

           for(int j=0;j<theta[0].length;j++){

               for(int a=0;a<y1[0].length;a++){

                   sum=sum+y1[i][a]*theta[a][j];

               }

               predictions[i][j]=sum;

               sum=0;
           }

       }



   }
   // returning position of max value
   public static int getMaxValue(double [][] numbers){
       int a=0;
       double maxValue = numbers[0][0];
       int index=0;
       for(int i=0;i < numbers[0].length;i++){
           if(numbers[0][i] > maxValue){
               maxValue=numbers[0][i];
               index = i;
           }
       }
       return index;
   }
   public void sol(View view) {

       if (!cb1.isChecked() && !cb2.isChecked() && !cb3.isChecked() && !cb4.isChecked() && !cb5.isChecked()
               && !cb6.isChecked() && !cb7.isChecked() && !cb8.isChecked() && !cb9.isChecked() && !cb10.isChecked()
               && !cb11.isChecked()
               ) {

           switch (view.getId()) {

               case R.id.button2:
                   if (result == textToSpeech.LANG_MISSING_DATA || result == textToSpeech.LANG_NOT_SUPPORTED) {

                       Toast.makeText(this, "feautre not supported in your device", Toast.LENGTH_SHORT).show();


                   } else {
                       text = "Please first select the symptoms ,," +
                               "                                  ";
                       textToSpeech.speak(text, textToSpeech.QUEUE_FLUSH, null);


                       at++;

                   }
                   break;


           }


       } /*else if (predictions[0][0] >= 10.666 && predictions[0][0]<11.333 ) {


           switch (view.getId()) {

               case R.id.button2:
                   if (result == textToSpeech.LANG_MISSING_DATA || result == textToSpeech.LANG_NOT_SUPPORTED) {

                       Toast.makeText(this, "feautre not supported in your device", Toast.LENGTH_SHORT).show();


                   } else {
                       text = "there are 69 percent chances that you have sinus headache dear ,," +
                               "                                  ";
                       textToSpeech.speak(text, textToSpeech.QUEUE_FLUSH, null);
                        data="69% chances of SINUS HEADACHE";

                        at=0;
                   }
                   break;


           }

       } */
         else if(getMaxValue(predictions)==0){
           switch (view.getId()) {

               case R.id.button2:
                   if (result == textToSpeech.LANG_MISSING_DATA || result == textToSpeech.LANG_NOT_SUPPORTED) {

                       Toast.makeText(this, "feautre not supported in your device", Toast.LENGTH_SHORT).show();


                   } else {
                       text = "there good chances of sinus headache dear ,," +
                               "                                  ";
                       textToSpeech.speak(text, textToSpeech.QUEUE_FLUSH, null);
                       data="chances of SINUS HEADACHE";

                       at=0;
                   }
                   break;


           }
       }
       else if(getMaxValue(predictions)==1){
           switch (view.getId()) {

               case R.id.button2:
                   if (result == textToSpeech.LANG_MISSING_DATA || result == textToSpeech.LANG_NOT_SUPPORTED) {

                       Toast.makeText(this, "feautre not supported in your device", Toast.LENGTH_SHORT).show();


                   } else {
                       text = "there good chances of tension headache dear ,," +
                               "                                  ";
                       textToSpeech.speak(text, textToSpeech.QUEUE_FLUSH, null);
                       data="chances of TENSION HEADACHE";

                       at=0;
                   }
                   break;


           }
       }
       else if(getMaxValue(predictions)==2){
           switch (view.getId()) {

               case R.id.button2:
                   if (result == textToSpeech.LANG_MISSING_DATA || result == textToSpeech.LANG_NOT_SUPPORTED) {

                       Toast.makeText(this, "feautre not supported in your device", Toast.LENGTH_SHORT).show();


                   } else {
                       text = "there good chances of migrane headache dear ,," +
                               "                                  ";
                       textToSpeech.speak(text, textToSpeech.QUEUE_FLUSH, null);
                       data="chances of MIGRANE HEADACHE";

                       at=0;
                   }
                   break;


           }
       }
       else if(getMaxValue(predictions)==3){
           switch (view.getId()) {

               case R.id.button2:
                   if (result == textToSpeech.LANG_MISSING_DATA || result == textToSpeech.LANG_NOT_SUPPORTED) {

                       Toast.makeText(this, "feautre not supported in your device", Toast.LENGTH_SHORT).show();


                   } else {
                       text = "there good chances of cluster headache dear ,," +
                               "                                  ";
                       textToSpeech.speak(text, textToSpeech.QUEUE_FLUSH, null);
                       data="chances of CLUSTER HEADACHE";

                       at=0;
                   }
                   break;


           }
       }


       if(at==0)
       startActivity(new Intent(this,Headache2.class).putExtra("data",data));



   }

}