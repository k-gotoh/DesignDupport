package html5api.jp.gls;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * Created by gotoh on 2016/04/25.
 */
public class DetailActivity extends Activity {

    public static final String GOODS_INFO = "goods_info";

    private ViewPager mViewPager;
    private ViewPagerIndicator mViewPagerIndicator;

    private LinearLayout sizeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        GoodsInfo goodsInfo = (GoodsInfo) intent.getSerializableExtra(GOODS_INFO);

      //  ((ImageView) findViewById(R.id.img)).setImageResource(goodsInfo.resource);
        ((TextView) findViewById(R.id.header_title)).setText(goodsInfo.desc);

        sizeLayout = (LinearLayout) findViewById(R.id.size_select);
        sizeLayout.setVisibility(View.GONE);

        ((TextView) findViewById(R.id.title2)).setText(goodsInfo.desc);
        ((TextView) findViewById(R.id.price)).setText(goodsInfo.price);

        ((TextView) findViewById(R.id.kosu)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sizeLayout.setVisibility(View.VISIBLE);
            }
        });

        ((RelativeLayout) findViewById(R.id.outline2)).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                sizeLayout.setVisibility(View.GONE);
                return false;
            }
        });

        ((ScrollView) findViewById(R.id.sv_outline)).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                sizeLayout.setVisibility(View.GONE);
                return false;
            }
        });

        CustomPagerAdapter adapter = new CustomPagerAdapter(this);
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(adapter);

        mViewPagerIndicator = (ViewPagerIndicator) findViewById(R.id.indicator);
        mViewPagerIndicator.setCount(adapter.getCount());

//        mViewPager
//                .setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
//                    @Override
//                    public void onPageSelected(int position) {
//                        super.onPageSelected(position);
//                        mViewPagerIndicator.setCurrentPosition(position);
//                    }
//                });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //super.onPageSelected(position);
                mViewPagerIndicator.setCurrentPosition(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    static class CustomPagerAdapter extends PagerAdapter {

        private static int[] imgs = {R.drawable.ind1, R.drawable.ind2, R.drawable.ind3 };
        private static String[] descs = {" 前身頃" , " 後ろ身頃", "テキスタイル" };

        Context mContext;

        public CustomPagerAdapter(Context context) {
            mContext = context;
        }

        @Override
        public int getCount() {
            return imgs.length;
        }

        @Override
        public boolean isViewFromObject(View v, Object o) {
            return ((View) o).equals(v);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            TextView tv = new TextView(mContext);
           // PinchView tv = new PinchView(mContext);
            tv.setText(descs[position]);
            tv.setTextColor(Color.BLACK);
            tv.setShadowLayer(3.0f, 1.5f, 1.5f, Color.WHITE);
            tv.setTextSize(30);
            tv.setBackgroundResource(imgs[position]);
            container.addView(tv);


            return tv;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View v = (View) object;
            container.removeView(v);
        }
    }
}

