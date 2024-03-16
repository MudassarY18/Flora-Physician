package com.example.floraphysician;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> implements Filterable {


    Context mContext;
    List<NewsItem> mData ;
    List<NewsItem> mDataFiltered ;
    boolean isDark = false;


    public NewsAdapter(Context mContext, List<NewsItem> mData, boolean isDark) {
        this.mContext = mContext;
        this.mData = mData;
        this.isDark = isDark;
        this.mDataFiltered = mData;
    }

    public NewsAdapter(Context mContext, List<NewsItem> mData) {
        this.mContext = mContext;
        this.mData = mData;
        this.mDataFiltered = mData;

    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View layout;
        layout = LayoutInflater.from(mContext).inflate(R.layout.item_news,viewGroup,false);
        return new NewsViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder newsViewHolder, int position) {

        // bind data here

        // we apply animation to views here
        // first lets create an animation for user photo
        newsViewHolder.img_user.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.fade_transition_animation));

        // lets create the animation for the whole card
        // first lets create a reference to it
        // you can use the previous same animation like the following

        // but i want to use a different one so lets create it ..
        newsViewHolder.container.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.fade_scale_animation));



        newsViewHolder.tv_title.setText(mDataFiltered.get(position).getTitle());
        newsViewHolder.tv_content.setText(mDataFiltered.get(position).getContent());
        newsViewHolder.tv_date.setText(mDataFiltered.get(position).getDate());
        newsViewHolder.img_user.setImageResource(mDataFiltered.get(position).getUserPhoto());
        newsViewHolder.img_medicine.setImageResource(mDataFiltered.get(position).getUserPhoto());



            if (position == 0) {
                newsViewHolder.tv_link.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext,Web_View.class);
                        intent.putExtra("Url","https://petstoreluna.net/dithane-m45-mancozeb-80-fruit-vegetable-flowers-disease-control-1kg/");
                        mContext.startActivity(intent);

                    }
                });
            } else if (position == 1) {
                newsViewHolder.tv_link.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext,Web_View.class);
                        intent.putExtra("Url","https://www.planetnatural.com/product/orchard-spray/");
                        mContext.startActivity(intent);

                    }
                });
            } else if (position == 2) {
                newsViewHolder.tv_link.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext,Web_View.class);
                        intent.putExtra("Url","https://www.alibaba.com/product-detail/High-quality-fungicide-Mancozeb-Mancozeb-80_62190007570.html?spm=a2700.7735675.normalList.1.1045135ct2dpss");
                        mContext.startActivity(intent);

                    }
                });
            } else if (position == 3) {
                newsViewHolder.tv_link.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext,Web_View.class);
                        intent.putExtra("Url","https://petstoreluna.net/fungicide-ridomil-gold-mz-68wg-25g-for-vegetables-syngenta/");
                        mContext.startActivity(intent);

                    }
                });
            } else if (position == 4) {
                newsViewHolder.tv_link.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext,Web_View.class);
                        intent.putExtra("Url","https://www.indiamart.com/proddetail/gramoxone-24-sl-herbicides-16092316191.html");
                        mContext.startActivity(intent);

                    }
                });
            }else if (position == 5) {
                newsViewHolder.tv_link.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext,Web_View.class);
                        intent.putExtra("Url","https://www.planetnatural.com/product/liquid-copper-spray/");
                        mContext.startActivity(intent);

                    }
                });
            }else if (position ==6){
                newsViewHolder.tv_link.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext,Web_View.class);
                        intent.putExtra("Url","https://www.planetnatural.com/product/natural-disease-control/");
                        mContext.startActivity(intent);

                    }
                });
            }else if (position ==7){
                newsViewHolder.tv_link.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext,Web_View.class);
                        intent.putExtra("Url","https://www.planetnatural.com/product/safer-garden-fungicide/");
                        mContext.startActivity(intent);

                    }
                });
            }

    }

    @Override
    public int getItemCount() {
        return mDataFiltered.size();
    }

    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                String Key = constraint.toString();
                if (Key.isEmpty()) {

                    mDataFiltered = mData ;

                }
                else {
                    List<NewsItem> lstFiltered = new ArrayList<>();
                    for (NewsItem row : mData) {

                        if (row.getTitle().toLowerCase().contains(Key.toLowerCase())){
                            lstFiltered.add(row);
                        }

                    }

                    mDataFiltered = lstFiltered;

                }


                FilterResults filterResults = new FilterResults();
                filterResults.values= mDataFiltered;
                return filterResults;

            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {


                mDataFiltered = (List<NewsItem>) results.values;
                notifyDataSetChanged();

            }
        };


    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {



        TextView tv_title,tv_content,tv_date,tv_link;
        ImageView img_user,img_medicine;
        RelativeLayout container;





        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            container = itemView.findViewById(R.id.container);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_content = itemView.findViewById(R.id.tv_description);
            tv_link = itemView.findViewById(R.id.tv_link);
            tv_date = itemView.findViewById(R.id.tv_date);
            img_user = itemView.findViewById(R.id.img_user);
            img_medicine = itemView.findViewById(R.id.img_medicine);



            if (isDark) {
                setDarkTheme();
            }



        }


        private void setDarkTheme() {

            container.setBackgroundResource(R.drawable.card_bg_dark);

        }



    }
}
