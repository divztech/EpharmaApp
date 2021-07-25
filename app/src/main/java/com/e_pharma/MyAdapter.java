package com.e_pharma;



import android.content.Context;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentManager;

public class MyAdapter extends FragmentPagerAdapter {
    private int numOfTabs;
   public MyAdapter(FragmentManager fm, int numOfTabs){
       super(fm);
       this.numOfTabs = numOfTabs;
   }
    // this is for fragment tabs
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:

               // Toast.makeText(context)
               // Toast.makeText(,"Payment successful", Toast.LENGTH_SHORT).show();
                return new EWallet();
            case 1:
                return new Card();
            case 2:
                 return new COD();
            default:
                return null;
        }
    }
    // this counts total number of tabs
    @Override
    public int getCount() {
        return numOfTabs;
    }
}