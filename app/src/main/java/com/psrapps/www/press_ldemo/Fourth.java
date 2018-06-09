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

/**
 * Created by poornashekarreddy.p on 07-09-2017.
 */

public class Fourth extends Fragment {
    private AppBarLayout appBar;
    private TabLayout tabs;
    private ViewPager viewPager;
    View myview;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myview = inflater.inflate(R.layout.fourth,container,false);
        View contenedor = (View)container.getParent();
        appBar=(AppBarLayout)contenedor.findViewById(R.id.appbar);
        tabs=new TabLayout(getActivity());
        tabs.setTabTextColors(Color.parseColor("#FFFFFF"),Color.parseColor("#FFFFFF"));
        appBar.addView(tabs);

        viewPager=(ViewPager)myview.findViewById(R.id.pagerfourth);
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
        String[] tituloTabs={"VIDEOS","SONGS","FILES"};

        @Override
        public android.support.v4.app.Fragment getItem(int position){

            switch (position){
                case 0:
                    Fsma a = new Fsma();
                    return a;
                case 1:
                    Fsmb b = new Fsmb();
                    return b;
                case 2:
                    Fsmc c = new Fsmc();
                    return c;
            }
            return null;
        }

        @Override
        public int getCount(){
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position){
            return tituloTabs[position];
        }
    }

}
