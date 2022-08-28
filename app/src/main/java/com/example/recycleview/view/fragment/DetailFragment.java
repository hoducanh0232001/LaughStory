package com.example.recycleview.view.fragment;

import android.widget.TextView;

import androidx.viewpager.widget.ViewPager;

import com.example.recycleview.App;
import com.example.recycleview.R;
import com.example.recycleview.model.Story;
import com.example.recycleview.view.adapter.DetailStoryAdapter;
import com.example.recycleview.view.viewmodel.DetailViewModel;

import java.util.List;

public class DetailFragment extends BaseFragment<DetailViewModel> {
    private ViewPager vpStory;
    private List<Story> listStory;
    private Story story;
    private TextView tvIndex;


    public List<Story> getListStory() {
        return listStory;
    }

    public void setListStory(List<Story> listStory) {
        this.listStory = listStory;
    }

    @Override
    protected void initView() {
        tvIndex = rootView.findViewById(R.id.tv_index);
        vpStory = rootView.findViewById(R.id.vp_story);
        initData();
    }

    private void initData() {
        DetailStoryAdapter adapter
                = new DetailStoryAdapter(listStory, getContext());

        vpStory.setAdapter(adapter);

        int pos = listStory.indexOf(story);

        vpStory.setCurrentItem(pos, true);
        tvIndex.setText(String.format("%s/%s", (pos + 1), listStory.size()));

        vpStory.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int pos) {
                Story story = listStory.get(pos);
                App.getInstance().getStorage().setM002Story(story);

                tvIndex.setText(String.format("%s/%s", (pos + 1), listStory.size()));
            }
        });
    }

    public void setStory(Story story) {
        this.story = story;
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
