package com.example.administrator.myscrollview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2017/5/13.
 */

public class MyScrollView extends ViewGroup{
    private GestureDetector detector;
    private int currentIndex;
    private  float startX ;
    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        detector=new GestureDetector(context,new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                scrollBy((int)distanceX,0);
                return true;
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        detector.onTouchEvent(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                System.out.println("onTouchEvent==ACTION_DOWN");
                startX = event.getRawX();
                break;
            case MotionEvent.ACTION_MOVE:
                System.out.println("onTouchEvent==ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                System.out.println("onTouchEvent==ACTION_UP");
                float endX = event.getRawX();
                float distanceX = endX - startX;
                int tempIndex = currentIndex;
                if (endX - startX > getWidth() / 2) {
                    tempIndex--;
                } else if (startX - endX > getWidth() / 2) {
                    tempIndex++;
                }

                moveTo(tempIndex);

                break;
        }
        return true;
    }

    private void moveTo(int tempIndex) {
        if(tempIndex < 0){
            tempIndex = 0;
        }
        if(tempIndex >getChildCount()-1){
            tempIndex = getChildCount()-1;
        }
        currentIndex = tempIndex;
        scrollTo(currentIndex*getWidth(), 0);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        for (int i = 0; i < getChildCount(); i++) {
            View view = getChildAt(i);
            view.layout(i * getWidth(), 0, i * getWidth() + getWidth(),
                    getHeight());
        }
    }
}
