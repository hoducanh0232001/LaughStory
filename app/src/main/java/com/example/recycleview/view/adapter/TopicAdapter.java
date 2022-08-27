package com.example.recycleview.view.adapter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.recycleview.App;
import com.example.recycleview.R;
import com.example.recycleview.model.Topic;

import java.io.IOException;
import java.util.List;

public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.ViewHolder>{
    private List<Topic> listTopic;
    private Context mContext;
    private onItemClick callBack;

    public TopicAdapter(List<Topic> listTopic, Context mContext) {
        this.listTopic = listTopic;
        this.mContext = mContext;
    }
    public interface onItemClick{
        void onItemClick(Topic topic);
    }
    public void setOnItemClick(onItemClick event){
        callBack = event;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_topic,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(listTopic.get(position).getIdName());
        holder.mTopic = listTopic.get(position);
        try {
            Glide.with(App.getInstance()).load(BitmapFactory.decodeStream(App.getInstance().getAssets().open(listTopic.get(position).getTitle()))).into(holder.imageView);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return listTopic.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        private ImageView imageView;
       private Topic mTopic;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_topic);
            imageView = (ImageView) itemView.findViewById(R.id.img_topic);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    callBack.onItemClick(mTopic);
                }
            });
        }
    }
}
