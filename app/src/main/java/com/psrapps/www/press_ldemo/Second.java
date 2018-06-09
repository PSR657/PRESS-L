package com.psrapps.www.press_ldemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import static android.support.design.widget.TabLayout.MODE_SCROLLABLE;

/**
 * Created by poornashekarreddy.p on 07-09-2017.
 */

public class Second extends Fragment {
    private AppBarLayout appBar;
    private TabLayout tabs;
    private ViewPager viewPager;
    View myview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myview = inflater.inflate(R.layout.second,container,false);
        View contenedor = (View)container.getParent();
        appBar=(AppBarLayout)contenedor.findViewById(R.id.appbar);
        tabs=new TabLayout(getActivity());
        tabs.setTabTextColors(Color.parseColor("#FFFFFF"),Color.parseColor("#FFFFFF"));
        appBar.addView(tabs);
        tabs.setTabMode(MODE_SCROLLABLE);
        tabs.setMinimumWidth(100);

        viewPager=(ViewPager)myview.findViewById(R.id.pagersecond);
        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        tabs.setupWithViewPager(viewPager);
        return myview;
    }
    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        appBar.removeView(tabs);
    }
    public class ViewPagerAdapter extends FragmentStatePagerAdapter
    {
        public ViewPagerAdapter (FragmentManager fragmentManager)
        {
            super(fragmentManager);
        }
        String[] tituloTabs={"DEPRESSION","ANXIETY","SUICIDE","SUICIDE PREVENTION"};

        @Override
        public android.support.v4.app.Fragment getItem(int position){

            switch (position){
                case 0:
                    Fpedep a = new Fpedep();
                    return a;
                case 1:
                    Fpeanx b = new Fpeanx();
                    return b;
                case 2:
                    Fpescd c = new Fpescd();
                    return c;
                case 3:
                    Fpescp d = new Fpescp();
                    return d;
            }
            return null;
        }

        @Override
        public int getCount(){
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position){
            return tituloTabs[position];
        }
    }

}
