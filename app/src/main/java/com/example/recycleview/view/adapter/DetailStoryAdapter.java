package com.example.recycleview.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import com.example.recycleview.R;
import com.example.recycleview.model.Story;
import java.util.List;

public class DetailStoryAdapter extends PagerAdapter {
    private List<Story> listStory;
    private Context mContext;

    public DetailStoryAdapter(List<Story> listStory, Context mContext) {
        this.listStory = listStory;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return listStory.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);     //so sánh object
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {         //hàm chuyển dữ liệu vào item
        View v= LayoutInflater.from(mContext).inflate(R.layout.item_detail_story,container,false);

        TextView tvContent=v.findViewById(R.id.tv_m003_name);
        TextView tvName=v.findViewById(R.id.tv_content);

        Story data=listStory.get(position);
        tvName.setText(data.getName());
        tvContent.setText(data.getContent());
        container.addView(v);
        return v;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {   // hàm hủy item
        View v = (View) object;
        container.removeView(v);
    }
}

