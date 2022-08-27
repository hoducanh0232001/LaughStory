package com.example.recycleview.view.fragment;

import android.widget.TextView;

import com.example.recycleview.R;
import com.example.recycleview.model.Story;
import com.example.recycleview.view.viewmodel.DetailViewModel;

public class DetailFragment extends BaseFragment<DetailViewModel> {
    private Story story;

    public void setStory(Story story) {
        this.story = story;
    }

    private TextView textViewName, textViewDes;
    @Override
    protected void initView() {
        textViewName = findViewById(R.id.name_story);
        textViewDes = findViewById(R.id.textDesStory);
        textViewName.setText(story.getContent());
        textViewDes.setText(story.getName());
    }

    @Override
    protected Class<DetailViewModel> getClassViewModel() {
        return DetailViewModel.class;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.detail_fragment;
    }
}
