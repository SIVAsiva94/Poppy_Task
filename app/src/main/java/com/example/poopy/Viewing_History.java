package com.example.poopy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Viewing_History extends AppCompatActivity {
    DatabaseReference databaseReference;
    List<Datamodel> list=new ArrayList<>();
    private RecyclerView recyclerView;
    DataAdapter1 adapter;
    ImageView i1;
    public static final String Database_path="Poppy";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewing_history);
        i1=findViewById(R.id.back3);
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(Viewing_History.this,MainActivity.class);
                startActivity(i);
            }
        });
        databaseReference = FirebaseDatabase.getInstance().getReference(Database_path);
        recyclerView=findViewById(R.id.history);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                    Datamodel datamodel=dataSnapshot.getValue(Datamodel.class);
                    list.add(datamodel);
                }
                adapter=new DataAdapter1(Viewing_History.this,list);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}