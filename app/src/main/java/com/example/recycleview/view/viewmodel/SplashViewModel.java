package com.example.recycleview.view.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SplashViewModel extends ViewModel {
    public MutableLiveData<Boolean> isSplash = new MutableLiveData<Boolean>();
    public SplashViewModel(){
        this.isSplash.setValue(true);
    }

}
