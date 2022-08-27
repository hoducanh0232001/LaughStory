package com.example.recycleview.view.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview.OnActionCallBack;
import com.example.recycleview.R;
import com.example.recycleview.Utils;
import com.example.recycleview.model.Story;
import com.example.recycleview.model.Topic;
import com.example.recycleview.view.adapter.StoryAdapter;
import com.example.recycleview.view.adapter.TopicAdapter;
import com.example.recycleview.view.viewmodel.MenuViewModel;

import java.util.ArrayList;
import java.util.List;

public class MenuFragment extends BaseFragment<MenuViewModel> implements TopicAdapter.onItemClick, StoryAdapter.OnClickStory {
    private RecyclerView recyclerView, recyclerViewStory;
    private OnActionCallBack mCallBack;
    private LinearLayout actBarHome;
    private DrawerLayout drawerLayout;
    private ImageView imgActBarHome;
    private List<Story> listStory;
    public static final String KEY_SHOW_DETAIL = "KEY_SHOW_DETAIL";

    public void setmCallBack(OnActionCallBack mCallBack) {
        this.mCallBack = mCallBack;
    }
    public MenuFragment(){

    }
    public MenuFragment(List<Story> listStory) {
        this.listStory = listStory;
    }

    @Override
    protected void initView() {
        Utils.getInstance().initTopicData();
        recyclerView = findViewById(R.id.rv_menu);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        TopicAdapter topicAdapter = new TopicAdapter(Utils.getInstance().getListTopic(), mContext);
        topicAdapter.setOnItemClick(this);
        recyclerView.setAdapter(topicAdapter);

        drawerLayout = findViewById(R.id.drawer);
        actBarHome = findViewById(R.id.act_bar_home);
        imgActBarHome = findViewById(R.id.iv_menu);
        imgActBarHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

    }

    @Override
    protected Class<MenuViewModel> getClassViewModel() {
        return MenuViewModel.class;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.menu_fragment;
    }

    @Override
    public void onItemClick(Topic topic) {
        initListStory(topic.getIdName());
        recyclerViewStory = findViewById(R.id.rv_story);
        recyclerViewStory.setLayoutManager(new LinearLayoutManager(mContext));
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(mContext,DividerItemDecoration.VERTICAL);
        recyclerViewStory.addItemDecoration(itemDecoration);
        StoryAdapter storyAdapter = new StoryAdapter(listStory,mContext);
        storyAdapter.setOnClickStory(this);
        recyclerViewStory.setAdapter(storyAdapter);

        drawerLayout.closeDrawer(GravityCompat.START);
    }

    @Override
    public void onClickStory(Story story) {
        GoToDeTail(story);
    }
    public void GoToDeTail(Story story){
        mCallBack.onCallBack(KEY_SHOW_DETAIL,story);
    }


    public void initListStory(String fileName){
        listStory = new ArrayList<>();
        String story = Utils.getInstance().getTextAs("data/" + fileName + ".txt");  // đọc file để lấy dữ liệu
        // Toast.makeText(this,""+story,Toast.LENGTH_LONG).show();
        if (story == null) return;

        String[] items = story.split("','0'\\);");
        if (items.length == 0) return;

        for (String text : items) {
            int start = text.indexOf("\n", 2);
            if(start==-1){
                continue;
            }
            String name = text.substring(0, start).trim();      //cắt khoảng trắng 2 đầu
            String content = text.substring(start+1);
            //  Toast.makeText(this,"Name"+name,Toast.LENGTH_LONG).show();
            listStory.add(new Story(name,content));


        }


    }


}

