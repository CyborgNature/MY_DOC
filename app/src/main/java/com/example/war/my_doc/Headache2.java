package com.example.war.my_doc;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Headache2 extends AppCompatActivity {

    TextView textView;
    Button btnr,btns;
    String data2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_headache2);

        textView=(TextView)findViewById(R.id.textView);

        textView.setText(getIntent().getStringExtra("data"));
        data2=(String)textView.getText();

        btnr=(Button)findViewById(R.id.btnsignup);
        btns=(Button)findViewById(R.id.btnsigin);




    }


    public void r(View v) {


        if(data2.equalsIgnoreCase("chances of SINUS HEADACHE")) {
            new AlertDialog.Builder(this)
                    .setTitle("Reason")
                    .setMessage("Your sinuses are air-filled spaces inside your forehead, cheekbones, and behind the bridge of your nose. When they get inflamed -- usually because of an allergic reaction or an infection -- they swell, make more mucus, and the channels that drain them can get blocked.\n" +
                            "\n" +
                            "The build-up of pressure in your sinuses causes pain that feels like a headache." +
                            "")
                    .setNegativeButton("Exit", null)
                    .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).create().show();
        }
        else {
            new AlertDialog.Builder(this)
                    .setTitle("Solution")
                    .setMessage("T")
                    .setNegativeButton("", null)
                    .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).create().show();

        }
    }


    public void s(View v) {
        if(data2.equalsIgnoreCase("chances of SINUS HEADACHE")) {
            new AlertDialog.Builder(this)
                    .setTitle("Solution")
                    .setMessage("The goal is usually to relieve your symptoms and treat an infection if you have one. You might take antibiotics, as well as antihistamines or decongestants for a short time. You can also use inhaled nasal decongestants, but only for up to 3 days. Longer use can make your symptoms worse.\n" +
                            "\n" +
                            "You can also take pain relievers, or if they don't help, your doctor can prescribe corticosteroids to ease the inflammation in your sinuses. If an allergic reaction causes your sinus flare-ups, you might need a preventive allergy treatment.\n" +
                            "\n" +
                            "You can also feel better with simple at-home tricks, such as drinking more fluids, using a humidifier, or saltwater nasal spray.\n" +
                            "\n" +
                            "If you take decongestant and pain-relieving medicines too often, you might get medication overuse headaches. It's important to touch base with your doctor if you’re using any medication for a long time to relieve your headaches. Decongestants also can raise your blood pressure, so if you have high blood pressure, talk to your doctor before you take one.\n" +
                            "\n" +
                            "In rare cases, he may recommend sinus surgery to remove polyps or open up small or constantly swollen sinuses.")
                    .setNegativeButton("", null)
                    .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).create().show();
        }
        else {
            new AlertDialog.Builder(this)
                    .setTitle("Solution")
                    .setMessage("T")
                    .setNegativeButton("", null)
                    .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).create().show();


        }
    }







}
