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

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    Context context;
    List<Datamodel> datamodelList;
    public DataAdapter(Context context,List<Datamodel> datamodelList){
        this.context=context;
        this.datamodelList=datamodelList;

    }
    @NonNull
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.first_rv,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.ViewHolder holder, int position) {
        Datamodel model=datamodelList.get(position);
        holder.t1.setText(model.getShop_name());
        holder.t2.setText(model.getAddress());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(context,Customer_List.class);
                i.putExtra("Name",model.getShop_name());
                i.putExtra("Address",model.getAddress());
                i.putExtra("Gstin",model.getGstin());
                i.putExtra("Type",model.getType());
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
        TextView t2;
        CardView cardView;
        public ViewHolder(@NonNull View itemView){
            super((itemView));
            t1=itemView.findViewById(R.id.shop_name);
            t2=itemView.findViewById(R.id.address);
            cardView=itemView.findViewById(R.id.main_card);
        }
    }
}
