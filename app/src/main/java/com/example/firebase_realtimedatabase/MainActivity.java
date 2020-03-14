package com.example.firebase_realtimedatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
Button submitbtn,loginbtn;
EditText usernametxt,useragetxt,usernumbertxt,userpassword;
DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseReference=FirebaseDatabase.getInstance().getReference("User");

        submitbtn=(Button)findViewById(R.id.submitbtn);
        loginbtn=(Button)findViewById(R.id.login);
        usernametxt=(EditText)findViewById(R.id.usernameid);
        useragetxt=(EditText)findViewById(R.id.ageid);
        usernumbertxt=(EditText)findViewById(R.id.phoneid);
        userpassword=(EditText)findViewById(R.id.passwordid);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
                Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);

            }
        });


        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UserData();
            }
        });

    }

    private void UserData() {

        final String username=usernametxt.getText().toString().trim();
        final String userage=useragetxt.getText().toString().trim();
        final String userphone=usernumbertxt.getText().toString().trim();
        final String userpass=userpassword.getText().toString().trim();

        if(username.isEmpty())
        {
            usernametxt.setError("Enter username:");
            usernametxt.requestFocus();
            return;

        }


        if(userage.isEmpty())
        {
            useragetxt.setError("Enter userage:");
            useragetxt.requestFocus();
            return;
        }

        if(userphone.isEmpty())

        {
            usernumbertxt.setError("Enter Phone:");
            usernumbertxt.requestFocus();
            return;
        }
        if(userpass.isEmpty())

        {
            userpassword.setError("Enter Phone:");
            userpassword.requestFocus();
            return;
        }

        String key=databaseReference.push().getKey();
        User user=new User(username,userage,userphone,userpass);
        databaseReference.child(key).setValue(user);
        Toast.makeText(getApplicationContext(),"User Added Successfully",Toast.LENGTH_SHORT).show();
        usernametxt.setText("");
        useragetxt.setText("");
        usernumbertxt.setText("");
        userpassword.setText("");


                    }


        }






