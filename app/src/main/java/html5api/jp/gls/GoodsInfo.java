package html5api.jp.gls;

import android.graphics.Bitmap;

import java.io.Serializable;

/**
 * Created by gotoh on 2016/04/25.
 */
public class GoodsInfo implements Serializable {

    public int resource;
    public String code;
    public String desc;
    public String price;
    public String realPrice;

    public GoodsInfo(int resource, String code, String desc, String price, String realPrice) {
        this.resource = resource;
        this.code = code;
        this.desc = desc;
        this.price = price;
        this.realPrice = realPrice;
    }
}
