package com.example.firebase_realtimedatabase;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class Custom_Adaptar extends ArrayAdapter<User> {

    private Activity context;
    private  List<User> userlist;

    public Custom_Adaptar( Activity context,List<User> userlist) {
        super(context,R.layout.sample_view,userlist);
        this.context = context;
        this.userlist = userlist;
    }


    @Override
    public View getView(int position,  View convertView,ViewGroup parent) {

        LayoutInflater layoutInflater=context.getLayoutInflater();
        View view=layoutInflater.inflate(R.layout.sample_view,null,true);

        User user=userlist.get(position);

        TextView textViewname=view.findViewById(R.id.nametextviewid);
        TextView textViewage=view.findViewById(R.id.agetextviewid);
        TextView textViewphone=view.findViewById(R.id.phonetextviewid);

        textViewname.setText("Name:"+user.getUsername());
        textViewage.setText("Age:"+user.getUserage());
        textViewphone.setText("Phone"+user.userphone);



        return view;
    }
}
