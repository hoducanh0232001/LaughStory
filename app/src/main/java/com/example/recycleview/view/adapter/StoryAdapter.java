package com.example.recycleview.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview.R;
import com.example.recycleview.model.Story;

import java.util.List;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.StoryHolder>{
    private List<Story> listData;
    private Context mContext;
    private OnClickStory IcallBack;
    public interface OnClickStory{
        void onClickStory(Story story);
    }

    public void setOnClickStory(OnClickStory event) {
        IcallBack = event;
    }

    public StoryAdapter(List<Story> listData, Context mContext) {
        this.listData = listData;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public StoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_story,parent,false);
        return new StoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoryHolder holder, int position) {
        holder.textStory.setText(listData.get(position).getContent());
        holder.mStory = listData.get(position);

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class StoryHolder extends RecyclerView.ViewHolder {
        private TextView textStory;
        private LinearLayout linearItemStory;
        private ImageView imgStory;
        private Story mStory;

        public StoryHolder(@NonNull View itemView) {
            super(itemView);
            textStory = (TextView) itemView.findViewById(R.id.tv_story);
            imgStory = (ImageView) itemView.findViewById(R.id.img_story);
            linearItemStory = (LinearLayout) itemView.findViewById(R.id.ln_story);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    IcallBack.onClickStory(mStory);
                }
            });
        }
    }
}
