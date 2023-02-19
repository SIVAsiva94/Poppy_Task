package com.example.poopy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Customer_List extends AppCompatActivity {
TextView t1,t2,t3,t4;
ImageView i1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list);
        t1=findViewById(R.id.list_name);
        t2=findViewById(R.id.list_address);
        t3=findViewById(R.id.list_gstin);
        t4=findViewById(R.id.list_type);
        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            t1.setText(bundle.getString("Name"));
            t2.setText(bundle.getString("Address"));
            t3.setText(bundle.getString("Gstin"));
            t4.setText(bundle.getString("Type"));

        }
        i1=findViewById(R.id.back2);
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Customer_List.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}