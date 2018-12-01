package com.example.chenshuyu.dreamer.search;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.chenshuyu.dreamer.R;
import com.example.chenshuyu.dreamer.detail.DetailActivity;
import com.example.chenshuyu.dreamer.entity.Dreamer;

import java.util.List;

import static android.support.v4.content.ContextCompat.startActivity;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.VH> {
    private List<Dreamer.DataBean> dataBeans;
    private SearchActivity searchActivity;
    private final String data = "data";
    private final String title = "title";

    public SearchAdapter(List<Dreamer.DataBean> dataBeans,SearchActivity searchActivity){
        this.dataBeans = dataBeans;
        this.searchActivity = searchActivity;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_search,viewGroup,false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH vh, int i) {
        final int ps = i;
        vh.title.setText(dataBeans.get(i).getTitle());
        vh.content.setText(dataBeans.get(i).getDesc());
        vh.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(searchActivity,DetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString(title,dataBeans.get(ps).getTitle());
                bundle.putSerializable(data, dataBeans.get(ps));
                intent.putExtras(bundle);
                searchActivity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataBeans.size();
    }

    public static class VH extends RecyclerView.ViewHolder{
        public final TextView title;
        public final TextView content;
        private final CardView cardView;
        private VH(View v){
            super(v);
            title = v.findViewById(R.id.item_title);
            content = v.findViewById(R.id.item_content);
            cardView = v.findViewById(R.id.search_card);
        }
    }

    public void update(List<Dreamer.DataBean> dataBeans){
        this.dataBeans = dataBeans;
        notifyDataSetChanged();
    }
}
