package html5api.jp.gls;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created by kgotoh on 2016/04/24.
 */
public class ItemListActivity extends AppCompatActivity {


   //public static final String[] TAB_TITLE = {"LIKE", "MEN", "WOMEN", "BEAUETY", "HOME&\nLIFESTYLE", "KIDS"};

    private Animation scale;
    private Animation orgScale;
    private ImageView search;
    private CoordinatorLayout cl;
    private LayoutInflater mInflater;

    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_list);

        this.mInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //naivigationMenuの各メニューがタップされた場合のリスナーを指定する
        NavigationView mNavigationView = (NavigationView) findViewById(R.id.navigation_header);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.ex_effect:
                        Intent intent = new Intent(ItemListActivity.this, ExEffectActivity.class);
                        startActivity(intent);

                        break;
                    default:
                        break;
                }

                return false;
            }
        });




        scale = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale);
        orgScale = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.org_scale);

        cl = (CoordinatorLayout) findViewById(R.id.layout);

        search = (ImageView) findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ItemListActivity.this, SearchActivity.class);
                startActivity(intent);

            }
        });


        final ImageView bag = (ImageView) findViewById(R.id.bag);
        bag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ItemListActivity.this, Login.class);
                startActivity(intent);
            }
        });


        final ImageView menu = (ImageView) findViewById(R.id.menu);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        //tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);



        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());

        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);

        ViewPagerAdapter vpa = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(vpa);
        viewPager.setCurrentItem(1, false);




//        tabs[0].setIcon(R.drawable.listd);
//        tabs[1].setIcon(R.drawable.list4e);
//        tabs[2].setIcon(R.drawable.list9d);

       tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.listd);
        tabLayout.getTabAt(1).setIcon(R.drawable.list4e);
        tabLayout.getTabAt(2).setIcon(R.drawable.list9d);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tabLayout.getTabAt(0).setIcon(R.drawable.listd);
                tabLayout.getTabAt(1).setIcon(R.drawable.list4d);
                tabLayout.getTabAt(2).setIcon(R.drawable.list9d);

                switch (position) {
                    case 0:
                        tabLayout.getTabAt(0).setIcon(R.drawable.liste);
                        break;
                    case 1:
                        tabLayout.getTabAt(1).setIcon(R.drawable.list4e);
                        break;
                    case 2:
                        tabLayout.getTabAt(2).setIcon(R.drawable.list9e);
                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }




    private class ViewPagerAdapter extends FragmentPagerAdapter {



        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;

            switch (position) {
                case 0:
                    fragment = new ListFragment1();
                    break;
                case 1:
                    fragment = new ListFragment2();
                    break;
                case 2:
                    fragment = new ListFragment3();
                    break;

                default:
                    break;
            }

            return fragment;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return null;
        }

    }


    private boolean onIconTouch(ImageView v, MotionEvent event, int r) {
        switch(event.getAction()){
            //押した
            case MotionEvent.ACTION_DOWN:
                v.startAnimation(scale);
                break;
            //離した
            case MotionEvent.ACTION_UP:
                v.startAnimation(orgScale);
                break;
            //キャンセルした
            case MotionEvent.ACTION_CANCEL:

                break;
        }
        return false;

    }


}