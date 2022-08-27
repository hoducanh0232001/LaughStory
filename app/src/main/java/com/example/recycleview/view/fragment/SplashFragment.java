package com.example.recycleview.view.fragment;

import android.os.Handler;
import android.widget.Toast;
import androidx.lifecycle.Observer;
import com.example.recycleview.OnActionCallBack;
import com.example.recycleview.R;
import com.example.recycleview.view.viewmodel.SplashViewModel;

public class SplashFragment extends BaseFragment<SplashViewModel>{
    private OnActionCallBack mCallBack;

    public void setmCallBack(OnActionCallBack mCallBack) {
        this.mCallBack = mCallBack;
    }

    public static final String KEY_SHOW_MENU_FRAGMENT = "KEY_SHOW_MENU_FRAGMENT";
    @Override
    protected void initView() {
        mModel.isSplash.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean){
                    goToMainFragment();
                }
                else {
                    Toast.makeText(mContext, "ERROR", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected Class<SplashViewModel> getClassViewModel() {
        return SplashViewModel.class;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.splash_fragment;
    }
    void goToMainFragment(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mCallBack.onCallBack(KEY_SHOW_MENU_FRAGMENT,null);
            }
        },2000);
    }
}
