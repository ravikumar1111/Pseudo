package com.pseudoi.app.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pseudoi.app.R;
import com.pseudoi.app.model.BeerCraft;

import java.util.List;

public class BeerChartRecyclerView extends RecyclerView.Adapter<BeerChartRecyclerView.MyViewHolder> {

    private List<BeerCraft> moviesList;
    private Context mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{
        public TextView title, category, content;
        public ImageView addItem;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.name);
            category = (TextView) view.findViewById(R.id.category);
            content = (TextView) view.findViewById(R.id.content);
            addItem = (ImageView) view.findViewById(R.id.addItem);
            addItem.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            switch (view.getId()){

                case R.id.addItem:

                    break;

                default:
                    break;
            }

        }
    }

    public void UpdateData(List<BeerCraft> moviesList){

        this.moviesList = moviesList;
        notifyDataSetChanged();
    }


    public BeerChartRecyclerView(List<BeerCraft> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_list_items, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        BeerCraft movie = moviesList.get(position);
        holder.title.setText(movie.getName());
        holder.content.setText("Alcohol Content: "+movie.getAbv());
        holder.category.setText(movie.getStyle());
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

}