package com.example.poopy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Details extends AppCompatActivity {
    TextView t1,t2,t3,t4,t5,t6;
    ImageView i1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        t1=findViewById(R.id.name);
        t2=findViewById(R.id.list_date);
        t3=findViewById(R.id.list_time);
        t4=findViewById(R.id.login);
        t5=findViewById(R.id.logout);
        t6=findViewById(R.id.descrip);
        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            t1.setText(bundle.getString("Name"));
            t2.setText(bundle.getString("Date"));
            t3.setText(bundle.getString("Login"));
            t4.setText(bundle.getString("Login"));
            t5.setText(bundle.getString("Logout"));
            t6.setText(bundle.getString("Description"));
        }
        i1=findViewById(R.id.back1);
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Details.this,Viewing_History.class);
                startActivity(i);
            }
        });
    }
}