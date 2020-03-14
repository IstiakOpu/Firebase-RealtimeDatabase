package com.example.firebase_realtimedatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Details extends AppCompatActivity {

ListView listView;
DatabaseReference databaseReference;
List<User> userList;
Custom_Adaptar custom_adaptar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        databaseReference= FirebaseDatabase.getInstance().getReference("User");


        userList=new ArrayList<>();
        custom_adaptar=new Custom_Adaptar(Details.this,userList);
        listView=(ListView)findViewById(R.id.listviewid);
         }

    @Override
    protected void onStart() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                userList.clear();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())

                {

                    User user=dataSnapshot1.getValue(User.class);
                    userList.add(user);

                }
                listView.setAdapter(custom_adaptar);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        super.onStart();
    }
}
