package html5api.jp.gls;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.DialogInterface;
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
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    public static final String[] TAB_TITLE = {"LIKE", "MEN", "WOMEN", "BEAUETY", "HOME&\nLIFESTYLE", "KIDS"};

    private Animation scale;
    private Animation orgScale;
    private ImageView search;
    private CoordinatorLayout cl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //naivigationMenuの各メニューがタップされた場合のリスナーを指定する
        NavigationView mNavigationView = (NavigationView) findViewById(R.id.navigation_header);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.ex_effect:
                        Intent intent = new Intent(MainActivity.this, ExEffectActivity.class);
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
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);

            }
        });
//        search.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//
//                return  onIconTouch(search, event, R.drawable.seardh);
//            }
//        });

        final ImageView bag = (ImageView) findViewById(R.id.bag);
        bag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
            }
        });
//        bag.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//
//                return onIconTouch(bag, event, R.drawable.bag);
//            }
//        });


        final ImageView menu = (ImageView) findViewById(R.id.menu);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
//        menu.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//
//                return onIconTouch(menu, event, R.drawable.menu);
//            }
//        });


        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());



        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        ViewPagerAdapter vpa = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(vpa);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 1) {

                    snacKBar();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        tabLayout.setupWithViewPager(viewPager);
        viewPager.setCurrentItem(2, false);
    }



//    private Fragment createFragment(int position) {
//        Fragment fragment = null;
//        switch (position) {
//            case 0:
//                fragment = new Fragment1();
//                break;
//            case 1:
//                fragment = new Fragment2();
//                break;
//            case 2:
//                fragment = new Fragment3();
//                break;
//            case 3:
//                fragment = new Fragment4();
//                break;
//            case 4:
//                fragment = new Fragment5();
//                break;
//            case 5:
//                fragment = new Fragment6();
//                break;
//
//            default:
//                break;
//        }
//        return fragment;
//    }


    private class ViewPagerAdapter extends FragmentPagerAdapter {



        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;

            switch (position) {
                case 0:
                    fragment = new Fragment1();
                    break;
                case 1:
                    fragment = new Fragment2();
                    break;
                case 2:
                    fragment = new Fragment3();
                    break;
                case 3:
                    fragment = new Fragment4();
                    break;
                case 4:
                    fragment = new Fragment5();
                    break;
                case 5:
                    fragment = new Fragment6();
                    break;

                default:
                    break;
            }

            return fragment;
        }

        @Override
        public int getCount() {
            return 6;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TAB_TITLE[position];
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

    private void snacKBar() {
        Snackbar.make(cl, "本日限りのお得な情報が届きました！", Snackbar.LENGTH_LONG)
                .setAction("確認する", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                })
                .setActionTextColor(Color.rgb(255,100,100))
                .show();
    }
}