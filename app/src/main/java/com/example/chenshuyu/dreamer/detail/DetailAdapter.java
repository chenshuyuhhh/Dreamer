package com.example.chenshuyu.dreamer.detail;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.chenshuyu.dreamer.R;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.VH> {
    private List<String> contents = new ArrayList<>();

    public DetailAdapter(List<String> contents){
        this.contents = contents;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_detail,viewGroup,false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH vh, int i) {
        vh.position.setText(String.valueOf(i+1));
        vh.content.setText(contents.get(i));
    }

    @Override
    public int getItemCount() {
        return contents.size();
    }

    class VH extends RecyclerView.ViewHolder{
        TextView position;
        TextView content;
        public VH(View view){
            super(view);
            position = view.findViewById(R.id.detail_tv_postion);
            content = view.findViewById(R.id.detail_tv_content);
        }
    }

    public void update(List<String> contents){
        this.contents = contents;
        notifyDataSetChanged();
    }
}
