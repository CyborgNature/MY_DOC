package com.example.war.my_doc;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.war.my_doc.model.Users;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.Map;

public class SignUpp extends AppCompatActivity {


    private int counter=0;
    private Firebase mRef;
       Button btnsignup;
      EditText editTextphone,editTextname,editTextpassword;
   // private DatabaseReference databaseReferenceuser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_upp);

        mRef=new Firebase("https://mydoc-4cc21.firebaseio.com/Users");
//          databaseReferenceuser= FirebaseDatabase.getInstance().getReference("users");

            editTextname=(MaterialEditText)findViewById(R.id.namee);
            editTextphone=(MaterialEditText)findViewById(R.id.editPhonee);
            editTextpassword=(MaterialEditText)findViewById(R.id.editpassword);
           btnsignup=(Button)findViewById(R.id.btnsignuppp);


        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final ProgressDialog mDialog=new ProgressDialog(SignUpp.this);
                mDialog.setMessage("Please Wait ...");
                mDialog.show();

                final String name = editTextname.getText().toString().trim();
               final  String phone = editTextphone.getText().toString().trim();
               final  String password = editTextpassword.getText().toString().trim();


//               if(name.equals("") || phone.equals("") || password.equals("") ){

//                   Toast.makeText(SignUpp.this, "Please fill the missing data", Toast.LENGTH_SHORT).show();

//               }

  //             else {


                   mRef.addValueEventListener(new ValueEventListener() {


                       @Override
                       public void onDataChange(DataSnapshot dataSnapshot) {
                        //         Map<String,String> map=dataSnapshot.getValue(Map.class);


                          // Log.v("E_VALUE ","Name :"+name);
                         //  Log.v("E_VALUE ","Phone :"+phone);
                         //  Log.v("E_VALUE ","Password :"+password);


                           if(dataSnapshot.child(editTextphone.getText().toString()).exists()){


                               mDialog.dismiss();
                               if(counter==0)
                               Toast.makeText(SignUpp.this, "Some data is missing or user already exist ...", Toast.LENGTH_SHORT).show();

                           }

                           else{

                               mDialog.dismiss();
                           Users user = new Users(name, phone, password);
                           Firebase mRefChilf = mRef.child(phone);
                           mRefChilf.setValue(user);
                               finish();

                           Toast.makeText(SignUpp.this, "Signed up ...", Toast.LENGTH_SHORT).show();

                           counter++;
                            }
                       }


                       @Override
                       public void onCancelled(FirebaseError firebaseError) {

                       }


                   });}
   //            }


        });

/*




    }

 /*   void adduser(){
        String name=editTextname.getText().toString().trim();
        String phone=editTextphone.getText().toString().trim();

        if(!TextUtils.isEmpty(name)){

            String id= databaseReferenceuser.push().getKey();
            Users user=new Users(id,name,phone);
            databaseReferenceuser.child(id).setValue(user);

        }else
            Toast.makeText(this, "You should enter a name ", Toast.LENGTH_SHORT).show();




    }*/



}}
