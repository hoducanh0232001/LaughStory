package com.example.recycleview.view.act;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.recycleview.R;

public abstract class BaseActivity <T extends ViewModel> extends AppCompatActivity implements View.OnClickListener {
    protected T mModel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        mModel = new ViewModelProvider(this).get(getClassViewModel());            // cách khởi tạo view model
        initView();
    }

    protected abstract Class<T> getClassViewModel();

    protected abstract int getLayoutID();

    protected abstract void initView();

    public final <T extends View> T findViewById(int id,View.OnClickListener event) {
        T v=findViewById(id);
        if(v!=null && event!=null){
            v.setOnClickListener(this);
        }
        return v;
    }

    @Override
    public void onClick(View v) {
        // do something
    }

    protected void showFragment(int layoutID,Fragment fragment,boolean addToBackStack){         //show từ activity sang fragment

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();            //khởi tạo 1 transaction
        transaction.replace(R.id.container_view,fragment);                                          // sử dụng phương thức add hoặc repalce phải đính vào activity
        if(addToBackStack){
            transaction.addToBackStack("add");                                                  // add vào BackStack
        }
        transaction.commit();                                                                   // bắt buộc phải commit
    }
}