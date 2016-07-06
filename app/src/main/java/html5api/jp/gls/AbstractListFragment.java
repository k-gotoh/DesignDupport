package html5api.jp.gls;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import java.util.List;

/**
 * Created by gotoh on 2016/04/25.
 */
public class AbstractListFragment extends Fragment implements OnRecyclerListener {


    private Activity mActivity = null;
    private View mView;
    private RecyclerFragmentListener mFragmentListener = null;
    private GridLayoutManager mLayoutManage;

    // RecyclerViewとAdapter
    private RecyclerView mRecyclerView = null;
    private RecyclerAdapter mAdapter = null;

    protected int type;

    private  GridLayoutManager mLayoutManager;

    public interface RecyclerFragmentListener {
        void onRecyclerEvent();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = activity;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.list_fragment1, container, false);

        // RecyclerViewの参照を取得
        mRecyclerView = (RecyclerView) mView.findViewById(R.id.recycler_view);

        switch (type) {
            case 1:
                // レイアウトマネージャを設定(ここで縦方向の標準リストであることを指定)
                mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
                break;
            case 2:
                mRecyclerView.setHasFixedSize(true);
                mLayoutManager = new GridLayoutManager(mActivity.getApplicationContext(), 2);
                mRecyclerView.setLayoutManager(mLayoutManager);
                break;

            case 3:
                mRecyclerView.setHasFixedSize(true);
                 mLayoutManager = new GridLayoutManager(mActivity.getApplicationContext(), 3);
                mRecyclerView.setLayoutManager(mLayoutManager);
                break;
        }


        return mView;
    }

    private List<GoodsInfo> goodsInfoList;
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // 適当にデータ作成
        goodsInfoList = CreateGoodsInfo.getInitData();
//        array.add("A");
//        array.add("B");
//        array.add("C");

        // この辺りはListViewと同じ
        // 今回は特に何もしないけど、一応クリック判定を取れる様にする
        mAdapter = new RecyclerAdapter(mActivity, goodsInfoList, this, type);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onRecyclerClicked(View v, int position) {
        // セルクリック処理
        Intent intent = new Intent(mActivity, DetailActivity.class);
        intent.putExtra(DetailActivity.GOODS_INFO, goodsInfoList.get(position));
        startActivity(intent);

    }
}