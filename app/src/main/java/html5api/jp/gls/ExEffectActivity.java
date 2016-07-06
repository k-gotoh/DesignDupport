package html5api.jp.gls;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kgotoh on 2016/04/24.
 */
public class ExEffectActivity extends AppCompatActivity {

    public static int RESOUECE[] = {R.drawable.moon01,R.drawable.moon02,R.drawable.moon03,R.drawable.moon08,R.drawable.moon10,R.drawable.moon13,
            R.drawable.moon14,R.drawable.moon15,R.drawable.moon16,R.drawable.moon17,R.drawable.moon18,R.drawable.moon19,R.drawable.moon20,
            R.drawable.moon23,R.drawable.moon26,R.drawable.moon30};

    public static String NAME[] = {"新月（しんげつ）１日頃","繊月（せんげつ）２日頃","三日月（みかづき）３日頃","上弦の月（じょうげんのつき）７日頃"
            ,"十日夜の月（とおかんやのつき）１０日頃","十三夜月（じゅうさんやづき）１３日頃","小望月（こもちづき）１４日頃","満月（まんげつ）１５日頃","十六夜（いざよい）１６日頃","立待月（たちまちづき）１７日頃"
            ,"居待月（いまちづき）１８日頃","寝待月（ねまちづき）１９日頃","更待月（ふけまちづき）２０日頃","下弦の月（かげんのつき）２３日頃","有明月（ありあけづき）２６日頃","三十日月（みそかづき）３０日頃"};

    public static String RECO[] = {"スニーカー","トートバッグ","Tシャツ","ネックレス","ゴールドのアクセサリー","ストール","ヘアアクセサリー","スヌード","キャミソール","アナログ時計"
            ,"レギンス","ショルダーバッグ","ピアス","フラットシューズ","ジャケット","パンプス"};
    private static final String KEY_GROUP_NAME = "key_group_name";

    private static final int REQUEST_CREATE_TASK_ACTIVITY = 1000;

    private String mGroupName;
    private Object GroupHelper;
    private List<Moon> moonList;

    private LayoutInflater mInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex_effect);

        this.mInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


        Intent intent = getIntent();
        mGroupName = intent.getStringExtra(KEY_GROUP_NAME);

        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle("GLS-Japan");
        collapsingToolbar.setCollapsedTitleTextColor(getResources().getColor(android.R.color.white));
        collapsingToolbar.setExpandedTitleColor(getResources().getColor(android.R.color.white));


        LinearLayout ll = (LinearLayout) findViewById(R.id.list_area);

        //moonList = new ArrayList<>();
        for (int i = 0; i < RESOUECE.length; i++) {
            View v = this.mInflater.inflate(R.layout.luna_row, null, false);

            ((ImageView)v.findViewById(R.id.img)).setImageResource(RESOUECE[i]);
            ((TextView)v.findViewById(R.id.name)).setText(NAME[i]);
            ((TextView)v.findViewById(R.id.reco)).setText(RECO[i]);

            ll.addView(v);
        }
//        ListView listView = (ListView) findViewById(R.id.listView);
//        listView.setAdapter(new MoonAdapter(this, moonList));
    }




}