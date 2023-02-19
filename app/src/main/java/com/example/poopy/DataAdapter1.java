package com.example.poopy;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DataAdapter1 extends RecyclerView.Adapter<DataAdapter1.ViewHolder> {
    Context context;
    List<Datamodel> datamodelList;
    public DataAdapter1(Context context,List<Datamodel> datamodelList){
        this.context=context;
        this.datamodelList=datamodelList;

    }
    @NonNull
    @Override
    public DataAdapter1.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.history_rv,parent,false);
        DataAdapter1.ViewHolder viewHolder=new DataAdapter1.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter1.ViewHolder holder, int position) {
        Datamodel model=datamodelList.get(position);
        holder.t1.setText(model.getShop_name());
        holder.t2.setText(model.getDate());
        holder.t3.setText(model.getLogin());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(context,Details.class);
                i.putExtra("Name",model.getShop_name());
                i.putExtra("Date",model.getDate());
                i.putExtra("Login",model.getLogin());
                i.putExtra("Logout",model.getLogout());
                i.putExtra("Description",model.getDescription());
                context.startActivity(i);
            }
        });
    }
    @Override
    public int getItemCount() {
        return datamodelList.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        TextView t1;
        TextView t2,t3;
        CardView cardView;
        public ViewHolder(@NonNull View itemView){
            super((itemView));
            t1=itemView.findViewById(R.id.shop_name1);
            t2=itemView.findViewById(R.id.date);
            t3=itemView.findViewById(R.id.login_time);
            cardView=itemView.findViewById(R.id.history_card);
        }
    }
}

