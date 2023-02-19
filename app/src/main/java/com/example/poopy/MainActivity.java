package com.example.poopy;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    ImageView i1;
    public DrawerLayout drawerLayout;
    DatabaseReference databaseReference;
    List<Datamodel> list=new ArrayList<>();
    private RecyclerView recyclerView;
  DataAdapter adapter;
    public static final String Database_path="Poppy";
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavigationView bottomNavigationView=findViewById(R.id.navi);
       bottomNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
              switch (item.getItemId()){
                   case R.id.history2:
                       startActivity(new Intent(getApplicationContext(),Viewing_History.class));
                        overridePendingTransition(0, 0);
                        return true;
            }
                return false;
         }
       });

       i1=findViewById(R.id.drawer1);
       i1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               drawerLayout=findViewById(R.id.my_drawer_layout);
               drawerLayout.openDrawer(Gravity.LEFT);

           }
       });
       databaseReference = FirebaseDatabase.getInstance().getReference(Database_path);
       recyclerView=findViewById(R.id.popoy_first_rv);
       LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
       databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
               for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                  Datamodel datamodel=dataSnapshot.getValue(Datamodel.class);
                 list.add(datamodel);
              }
                adapter=new DataAdapter(MainActivity.this,list);
                recyclerView.setAdapter(adapter);
            }

            @Override
           public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}