package io.github.kevinsu917.xpro;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MotionEvent;

public class BaseActivity extends ActionBarActivity {

    private int mTempX;
    private int mDownX;
    private int mTouchSlop;
    private int mDownY;
    private boolean isSilding;
    private int totalMoveX;
    private int viewWidth;
    private SwipeListener swipeListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        swipeListener = new SwipeListener(this);
    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                int moveX = (int) event.getRawX();
                int deltaX = mTempX - moveX;
//			Log.i("debug", "deltaX:" + deltaX + "mTouchSlop:" + mTouchSlop);
                mTempX = moveX;
                if (Math.abs(moveX - mDownX) > mTouchSlop
                        && Math.abs((int) event.getRawY() - mDownY) < mTouchSlop) {
                    isSilding = true;
                }

                if (Math.abs(moveX - mDownX) >= 0 && isSilding) {
//				mContentView.scrollBy(deltaX, 0);
                    totalMoveX += deltaX;
                }
                break;
            case MotionEvent.ACTION_UP:
                isSilding = false;
//			Log.i("debug", "TotoalMoveX:" + totalMoveX + "viewVidth:" + viewWidth);
                if (Math.abs(totalMoveX) >= viewWidth / 3) {
                    if (totalMoveX > 0) {
                        swipeListener.onLeftSwipe();
                    }else {
                        swipeListener.onRightSwipe();
                    }
                }
                totalMoveX = 0;
                break;
        }

        return true;
    }

    public class SwipeListener {

        Context context;
        public SwipeListener(Context mContext){
            context = mContext;
        }

        public void onRightSwipe(){
//            finish();
//            Toast.makeText(context, "right退出", Toast.LENGTH_LONG).show();
        }

        public void onLeftSwipe(){
//            finish();
//            Toast.makeText(context, "left退出", Toast.LENGTH_LONG).show();
        }
    }
}
