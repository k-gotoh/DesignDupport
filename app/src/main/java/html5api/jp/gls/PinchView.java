package html5api.jp.gls;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.TextView;

/**
 * Created by kgotoh on 2016/04/25.
 */
public class PinchView extends TextView {
   // private static final int RECT_SIZE = 64;

    private int width = this.getWidth();

    private float mScale = 1.0f; // 描画する倍率
    private ScaleGestureDetector mScaleDetector;

    private Paint mRectPaint = new Paint();
//    private Paint mTextPaint = new Paint();
//    {
//        mRectPaint.setStyle(Paint.Style.STROKE);
//        mRectPaint.setColor(Color.BLUE);
//        mRectPaint.setStrokeWidth(2.0f);
//
//        mTextPaint.setTextSize(64.0f);
//    }

    public PinchView(Context context) {
        super(context);
        width = this.getWidth();
        mScaleDetector = new ScaleGestureDetector(context,
                new ScaleGestureDetector.OnScaleGestureListener() {
                    @Override
                    public boolean onScale(ScaleGestureDetector detector) {
                        // ピンチイン・アウト中に継続して呼び出される
                        // getScaleFactor()は
                        // 『今回の2点タッチの距離/前回の2点タッチの距離』を返す


                        // 表示倍率の計算
                        mScale *= detector.getScaleFactor();
                        invalidate();
                        return true;
                    }

                    @Override
                    public boolean onScaleBegin(ScaleGestureDetector detector) {
                        return true;
                    }

                    @Override
                    public void onScaleEnd(ScaleGestureDetector detector) {

                    }
                });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // 受けたMotionEventを
        // そのままScaleGestureDetector#onTouchEvent()に渡す
        return mScaleDetector.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // 現在の表示倍率を表示
        //canvas.drawText("Scale:" + mScale, 0, 72, mTextPaint);

        // 正方形の1辺の長さを求める
        float rectSize = width * mScale;

        // 描画位置をViewの中心にする
        float left = getWidth() / 2 - rectSize / 2;
        float top = getHeight() / 2 - rectSize / 2;
        float bottom = top + rectSize;
        float right = left + rectSize;

        // 正方形の描画
        canvas.drawRect(left, top, right, bottom, mRectPaint);
    }
}
