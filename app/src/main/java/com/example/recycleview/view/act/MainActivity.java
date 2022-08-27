package com.example.recycleview.view.act;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview.OnActionCallBack;
import com.example.recycleview.R;
import com.example.recycleview.model.Story;
import com.example.recycleview.view.fragment.DetailFragment;
import com.example.recycleview.view.fragment.MenuFragment;
import com.example.recycleview.view.fragment.SplashFragment;
import com.example.recycleview.view.viewmodel.MainViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<MainViewModel> implements OnActionCallBack {

    @Override
    protected Class<MainViewModel> getClassViewModel() {
        return MainViewModel.class;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        SplashFragment splashFragment = new SplashFragment();
        splashFragment.setmCallBack(this);
        showFragment(R.id.container_view,splashFragment,false);
    }

    @Override
    public void onCallBack(String key, Object... listObject) {
        switch (key){
            case
                    SplashFragment.KEY_SHOW_MENU_FRAGMENT:
                MenuFragment menuFragment = new MenuFragment();
                menuFragment.setmCallBack(this);
                showFragment(R.id.container_view,menuFragment,false);
                break;
            case
                    MenuFragment.KEY_SHOW_DETAIL:
                DetailFragment detailFragment = new DetailFragment();
                Story story = (Story) listObject[0];
                detailFragment.setStory(story);
                showFragment(R.id.detail_story,detailFragment,true);

        }
    }
}