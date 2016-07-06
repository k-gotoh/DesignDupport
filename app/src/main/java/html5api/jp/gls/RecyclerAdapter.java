package html5api.jp.gls;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gotoh on 2016/04/25.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private LayoutInflater mInflater;
    private List<GoodsInfo> mData;
    private Context mContext;
    private OnRecyclerListener mListener;

    private int type;

    public RecyclerAdapter(Context context, List<GoodsInfo> data, OnRecyclerListener listener, int type) {
        mInflater = LayoutInflater.from(context);
        mContext = context;
        mData = data;
        mListener = listener;
        this.type = type;
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        // 表示するレイアウトを設定

        switch (type) {
            case 1:
                return new ViewHolder(mInflater.inflate(R.layout.list_fragment1_item, viewGroup, false));

            case 2:
                return new ViewHolder(mInflater.inflate(R.layout.list_fragment2_item, viewGroup, false));

            case 3:
                return new ViewHolder(mInflater.inflate(R.layout.list_fragment3_item, viewGroup, false));
        }
        return new ViewHolder(mInflater.inflate(R.layout.list_fragment1_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        // データ表示
        if (mData != null && mData.size() > position && mData.get(position) != null) {
            GoodsInfo goodsInfo = mData.get(position);

            if (viewHolder.img != null && goodsInfo.resource != 0) {
                viewHolder.img.setImageResource(goodsInfo.resource);
            }

            if (viewHolder.tvCode != null) {
                viewHolder.tvCode.setText(goodsInfo.code);
            }

            if (viewHolder.tvDesc != null) {
                viewHolder.tvDesc.setText(goodsInfo.desc);
            }

            if (viewHolder.tvPrice != null) {
                viewHolder.tvPrice.setText(goodsInfo.price);
            }

            if (viewHolder.tvRealPrice != null) {
                viewHolder.tvRealPrice.setText(goodsInfo.realPrice);
            }
        }

        // クリック処理
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onRecyclerClicked(v, position);
            }
        });

    }

    @Override
    public int getItemCount() {
        if (mData != null) {
            return mData.size();
        } else {
            return 0;
        }
    }

    // ViewHolder(固有ならインナークラスでOK)
    class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView img;
        public TextView tvCode;
        public TextView tvDesc;
        public TextView tvPrice;
        public TextView tvRealPrice;


        public ViewHolder(View itemView) {
            super(itemView);

            img = (ImageView) itemView.findViewById(R.id.img);
            tvCode = (TextView) itemView.findViewById(R.id.code);
            tvDesc = (TextView) itemView.findViewById(R.id.desc);
            tvPrice = (TextView) itemView.findViewById(R.id.price);
            tvRealPrice = (TextView) itemView.findViewById(R.id.real_price);
        }
    }

}