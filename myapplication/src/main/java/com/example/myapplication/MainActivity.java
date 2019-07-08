package com.example.myapplication;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.myapplication.fragment.ChatListFragment;
import com.example.myapplication.fragment.HomeFragment;
import com.example.myapplication.fragment.RecordUploadFragment;
import com.example.myapplication.fragment.UserFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager pager = findViewById(R.id.view_pager);
//        pager .setOffscreenPageLimit(1);
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                switch (i) {
                    case 0:
                        return new HomeFragment();
                    case 1:
                        return new RecordUploadFragment();
                    case 2:
                        return new ChatListFragment();
                    case 3:
                        return new UserFragment();
                    default:
                        return new HomeFragment();
                }
            }

            @Override
            public int getCount() {
                return 4;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position) {
                    case 0:
                        return "首页";
                    case 1:
                        return "上传";
                    case 2:
                        return "消息";
                    case 3:
                        return "我的";
                    default:
                        return "首页";
                }
            }
        });
        tabLayout.setupWithViewPager(pager);
    }
}
