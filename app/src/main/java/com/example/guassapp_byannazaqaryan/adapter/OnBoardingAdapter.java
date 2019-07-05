package com.example.guassapp_byannazaqaryan.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import com.example.guassapp_byannazaqaryan.R;

public class OnBoardingAdapter extends PagerAdapter {
    private Context context;

    public OnBoardingAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup collection, int position) {

        View layout = null;
        switch (position){
            case 0:
                layout = View.inflate(context, R.layout.pager_onboarding1, null);
                break;
            case 1:
                layout = View.inflate(context, R.layout.pager_onboarding2, null);
                break;
            case 2:
                layout = View.inflate(context, R.layout.pager_onboarding3, null);
                break;
        }

        collection.addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup collection, int position,@NonNull Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view,@NonNull Object object) {
        return view == object;
    }
}
