package com.example.chenshuyu.dreamer.search;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.chenshuyu.dreamer.R;

import cn.edu.twt.retrox.recyclerviewdsl.Item;
import cn.edu.twt.retrox.recyclerviewdsl.ItemController;

public class CardItem implements Item {
    private String title;
    private String content;

    // 外部类私有的构造方法
    public CardItem(String title,String content){
        setTitle(title);
        setContent(content);
    }

    @Override
    public ItemController getController() {
        return new CardItem.Controller();
    }

    @Override
    public boolean areContentsTheSame(Item item) {
        return false;
    }

    @Override
    public boolean areItemsTheSame(Item item) {
        return false;
    }

    //静态内部类
    public static final class Controller implements ItemController{
//        private String title;
//        private String content;
        private Controller(){
        }

//        public Controller title(String val){
//            this.title = val;
//            return this;
//        }
//
//        public Controller content(String val){
//            this.content = val;
//            return this;
//        }

//        //通过内部类的build方法，实例化外部类，并给其实例各个字段赋值
//        public CardItem build(){
//            return new CardItem(this);
//        }

        @Override
        public android.support.v7.widget.RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_search,viewGroup,false);
            TextView title = view.findViewById(R.id.title);
            TextView content = view.findViewById(R.id.content);
            return new ViewHolder(view,title,content);
        }

        @Override
        public void onBindViewHolder(android.support.v7.widget.RecyclerView.ViewHolder viewHolder, Item item) {
            ViewHolder vh = (ViewHolder)viewHolder;
            CardItem cd = (CardItem) item;
            vh.title.setText(cd.title);
            vh.content.setText(cd.content);
        }

        /**
         * define your ViewHolder here to pass view from OnCreateViewViewHolder to OnBindViewHolder
         * this ViewHolder class should be private and only use in this scope
         *
         * 在这里声明此Item所对应的ViewHolder，用来从OnCreateViewHolder传View到OnBindViewHolder中。
         * 这个ViewHolder类应该是私有的，只在这里用
         */
        private static class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder{
            private TextView title;
            private TextView content;

            ViewHolder(View itemview,TextView title,TextView content){
                super(itemview);
                this.title = title;
                this.content = content;
            }
        }

    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}


