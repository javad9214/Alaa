package com.example.alaa.views.Dashboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter_shop extends RecyclerView.Adapter<Adapter_shop.ViewHolder>{

    private LayoutInflater mInflater;
    private Context context ;
    private int pos ;
    private int resource ;

    public Adapter_shop(Context context , int resource) {
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        this.resource  = resource ;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate( resource , parent, false);
        return new ViewHolder(view );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        this.pos = position ;
    }


    public int getPosition(){
        return pos ;
    }

    @Override
    public int getItemCount() {
        return 5 ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        TextView textView ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

           // textView = itemView.findViewById(R.id.tx_title);

        }
    }

}
