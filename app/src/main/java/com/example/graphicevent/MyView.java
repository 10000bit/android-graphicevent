package com.example.graphicevent;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

class MyPoint {
    float x,y;
    int color;
    MyPoint(float x, float y, int c) {
        this.x = x; this.y = y; this.color = c;
    }
}

public class MyView extends View {
    private static final int R = 10;
    private ArrayList<MyPoint> mPoints = new ArrayList<>();
    private Paint mPaint = new Paint();
    static private int mCurColor = Color.RED;

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    static public void setPaintColor(int color) {
        mCurColor = color;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        for (int i = 0; i < mPoints.size(); i += 2) {
            com.example.graphicevent.MyPoint myPoint = mPoints.get(i);
            mPaint.setColor(myPoint.color);
            canvas.drawRect(myPoint.x - R, myPoint.y - R, myPoint.x + R, myPoint.y + R, mPaint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                mPoints.add(new com.example.graphicevent.MyPoint(event.getX(), event.getY(), mCurColor));
                invalidate();
                return true;
            case MotionEvent.ACTION_UP:
                return true;
        }
        return super.onTouchEvent(event);
    }
}