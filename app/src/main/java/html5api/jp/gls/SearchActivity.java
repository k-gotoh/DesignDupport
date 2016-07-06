package html5api.jp.gls;

import android.app.Activity;
import android.content.Intent;
import android.opengl.Visibility;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * Created by kgotoh on 2016/04/23.
 */
public class SearchActivity extends Activity {

    public int search1Table[] = {R.id.s101, R.id.s102, R.id.s103, R.id.s104, R.id.s105, R.id.s106, R.id.s107, R.id.s108};
    public int search2Table[] = {R.id.s201, R.id.s202, R.id.s203, R.id.s204, R.id.s205, R.id.s206, R.id.s207, R.id.s208, R.id.s209, R.id.s2010};
    public int search3Table[] = {R.id.s301, R.id.s302, R.id.s303, R.id.s304, R.id.s305, R.id.s306, R.id.s307, R.id.s308, R.id.s309, R.id.s3010,
            R.id.s311, R.id.s312, R.id.s313, R.id.s314, R.id.s315};
    public int search4Table[] = {R.id.s401, R.id.s402, R.id.s403, R.id.s404, R.id.s405};

    private TextView search1;
    private TextView search2;
    private TextView search3;
    private TextView search4;

    private ScrollView sv1;
    private ScrollView sv2;
    private ScrollView sv3;
    private ScrollView sv4;

    private LinearLayout ll1;
    private LinearLayout ll2;
    private LinearLayout ll3;
    private LinearLayout ll4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);

        ll1 = (LinearLayout) findViewById(R.id.search1_layout);
        ll2 = (LinearLayout) findViewById(R.id.search2_layout);
        ll3 = (LinearLayout) findViewById(R.id.search3_layout);
        ll3.setVisibility(View.GONE);
        ll4 = (LinearLayout) findViewById(R.id.search4_layout);
        ll4.setVisibility(View.GONE);

        search1 = (TextView) findViewById(R.id.search1);
        search2 = (TextView) findViewById(R.id.search2);
        search3 = (TextView) findViewById(R.id.search3);
        search4 = (TextView) findViewById(R.id.search4);


        sv1 = (ScrollView) findViewById(R.id.scroll1);
        sv1.setVisibility(View.GONE);
        sv2 = (ScrollView) findViewById(R.id.scroll2);
        sv2.setVisibility(View.GONE);
        sv3 = (ScrollView) findViewById(R.id.scroll3);
        sv3.setVisibility(View.GONE);
        sv4 = (ScrollView) findViewById(R.id.scroll4);
        sv4.setVisibility(View.GONE);

        ((RelativeLayout) findViewById(R.id.outline)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sv1.setVisibility(View.GONE);
                sv2.setVisibility(View.GONE);
                sv3.setVisibility(View.GONE);
                sv4.setVisibility(View.GONE);
            }
        });

        search1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sv1.setVisibility(View.VISIBLE);
                sv2.setVisibility(View.GONE);
                sv3.setVisibility(View.GONE);
                sv4.setVisibility(View.GONE);

                ll3.setVisibility(View.GONE);
                ll4.setVisibility(View.GONE);
            }
        });

        search2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sv1.setVisibility(View.GONE);
                sv2.setVisibility(View.VISIBLE);
                sv3.setVisibility(View.GONE);
                sv4.setVisibility(View.GONE);

                ll3.setVisibility(View.GONE);
                ll4.setVisibility(View.GONE);
            }
        });

        search3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sv1.setVisibility(View.GONE);
                sv2.setVisibility(View.GONE);
                sv3.setVisibility(View.VISIBLE);
                sv4.setVisibility(View.GONE);

                ll4.setVisibility(View.GONE);
            }
        });

        search4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sv1.setVisibility(View.GONE);
                sv2.setVisibility(View.GONE);
                sv3.setVisibility(View.GONE);
                sv4.setVisibility(View.VISIBLE);
            }
        });

        for (int i = 0; i < search1Table.length; i++) {
            ((TextView) findViewById(search1Table[i])).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    search1.setText(((TextView) v).getText().toString());
                    sv1.setVisibility(View.GONE);
                }
            });
        }

        for (int i = 0; i < search2Table.length; i++) {
            ((TextView) findViewById(search2Table[i])).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    search2.setText(((TextView) v).getText().toString());
                    sv2.setVisibility(View.GONE);

                    ll3.setVisibility(View.VISIBLE);
                }
            });
        }

        for (int i = 0; i < search3Table.length; i++) {
            ((TextView) findViewById(search3Table[i])).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    search3.setText(((TextView) v).getText().toString());
                    sv3.setVisibility(View.GONE);

                    ll4.setVisibility(View.VISIBLE);
                }
            });
        }

        for (int i = 0; i < search4Table.length; i++) {
            ((TextView) findViewById(search4Table[i])).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    search4.setText(((TextView) v).getText().toString());
                    sv4.setVisibility(View.GONE);
                }
            });
        }

        ((TextView) findViewById(R.id.search_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchActivity.this, ItemListActivity.class);
                startActivity(intent);
            }
        });

    }
}
