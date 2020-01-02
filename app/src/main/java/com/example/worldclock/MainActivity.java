package com.example.worldclock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private final ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            /* do nothing. */
        }

        @Override
        public void onPageSelected(int position) {
            FragmentManager manager = getSupportFragmentManager();
            for (Fragment fragment : manager.getFragments()) {
                if (fragment instanceof MainFragment) {
                    ((MainFragment) fragment).updateDate();
                }
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            /* do nothing. */
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.viewPager);
        MainPagerAdapter adapter = new MainPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(pageChangeListener);
        // ViewPager.setOffscreenPageLimit() can't set 0.(less than 1)
    }
}
