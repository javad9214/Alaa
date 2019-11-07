package com.example.alaa.views.ViewPager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.example.alaa.R;

import java.util.List;

public class PagerAdapter extends androidx.viewpager.widget.PagerAdapter {


    private Context mContext;
    private List<ImageSlider> imageList;
    private LayoutInflater inflater;

    public PagerAdapter(Context context, List<ImageSlider> list) {
        mContext = context;
        imageList = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {
        int modelPosition = mapPagerPositionToModelPosition(position);
        ViewGroup imageLayout = (ViewGroup) inflater.inflate(R.layout.slider_home, collection, false);
        ((ImageView) imageLayout.findViewById(R.id.imageView)).setImageResource(imageList.get(modelPosition).getResId());
        collection.addView(imageLayout);
        return imageLayout;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }



    @Override
    public int getCount() {
       // return CustomPagerEnum.values().length;

        return imageList.size() == 0 ? 0 : imageList.size() + 2;
        //return  imageList.size() ;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return  view == object;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return imageList.get(position).getName();
    }

    public int getRealCount() {
        return imageList.size();
    }

    private int mapPagerPositionToModelPosition(int pagerPosition) {
        // Put last page model to the first position.
        if (pagerPosition == 0) {
            return getRealCount() - 1;
        }
        // Put first page model to the last position.
        if (pagerPosition == getRealCount() + 1) {
            return 0;
        }
        return pagerPosition - 1;
    }


}
