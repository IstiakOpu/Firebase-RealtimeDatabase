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
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {
Button login;
EditText usernamelogin,userpasslogin;
DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login=(Button)findViewById(R.id.loginbutton);
        usernamelogin=(EditText)findViewById(R.id.loginusernameid);
        userpasslogin=(EditText)findViewById(R.id.loginpasswordid);
        databaseReference= FirebaseDatabase.getInstance().getReference();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginUser();
            }
        });
    }

    private void LoginUser() {

      final String user=usernamelogin.getText().toString().trim();
       final String pass=userpasslogin.getText().toString().trim();

        if(user.isEmpty())
        {
            usernamelogin.setError("Enter Username");;
            userpasslogin.requestFocus();
            return;
        }

        if(pass.isEmpty())
        {
            userpasslogin.setError("Enter Password");
            userpasslogin.requestFocus();
            return;

        }
        Query query = databaseReference.child("User").orderByChild("username").equalTo(user.trim());
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if(dataSnapshot.exists())
                {


                    for (DataSnapshot user : dataSnapshot.getChildren()) {


                    User userclass=user.getValue(User.class);


                        if (userclass.getUserpass().equals(userpasslogin.getText().toString())) {

                            Toast.makeText(LoginActivity.this, "Logged In Success...", Toast.LENGTH_SHORT).show();

                            finish();
                            Intent intent=new Intent(LoginActivity.this,Details.class);
                            startActivity(intent);

                        }

                        if (!(userclass.getUserpass().equals(userpasslogin.getText().toString()))) {

                            Toast.makeText(LoginActivity.this, "Incorrect Password...", Toast.LENGTH_SHORT).show();
                          }

                    }
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "Logged In Failed...", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public void signinuser(View view) {

        finish();
        Intent intent=new Intent(LoginActivity.this,MainActivity.class);
        startActivity(intent);
    }
}
