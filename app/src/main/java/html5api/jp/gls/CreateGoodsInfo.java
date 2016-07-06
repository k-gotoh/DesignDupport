package html5api.jp.gls;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gotoh on 2016/04/25.
 */
public class CreateGoodsInfo {
    private CreateGoodsInfo(){}

    public static  List<GoodsInfo> getInitData() {
        List<GoodsInfo> list = new ArrayList<>();
        list.add(new GoodsInfo(R.drawable.pic1,"CHELLIA","ホワイト ボーダフリルブラウス","6,400円","15,984円"));
        list.add(new GoodsInfo(R.drawable.pic2,"SCAPA","ホワイト微ストレッチフリル比翼シャツ","9,400円","31,320円"));
        list.add(new GoodsInfo(R.drawable.pic3,"SCAPA","ネイビー オパール加工調ペイズリー柄ブラウス","12,700円","42,120円"));
        list.add(new GoodsInfo(R.drawable.pic4,"LAURA ASHLEY LONDON","インディゴ　グラフィックウィンドウズプリントペプラムトップス","3,300円","11,880円"));
        list.add(new GoodsInfo(R.drawable.pic5,"SCAPA","ベージュ オパール加工調ペイズリー柄ブラウス","12,700円","42,120円"));
        list.add(new GoodsInfo(R.drawable.pic6,"LAURA ASHLEY LONDON","ネイビー　セーラースカーフ天竺プルオーバー","3,200円","6,372円"));
        list.add(new GoodsInfo(R.drawable.pic7,"SCAPA","ホワイト　リーフ刺繍ブラウス","10,700円","36,640円"));
        list.add(new GoodsInfo(R.drawable.pic8,"SCAPA","サックス　リーフ刺繍ブラウス","10,700円","36,640円"));
        list.add(new GoodsInfo(R.drawable.pic9,"LAURA ASHLEY LONDON","ピンク　リーフパッチスモック","5,200円","14,040円"));
        list.add(new GoodsInfo(R.drawable.pic10,"Nombre Premier","ブラウン系　シルクレオパードプリントブラウス","8,800円","43,200円"));
        return list;
    }
}
