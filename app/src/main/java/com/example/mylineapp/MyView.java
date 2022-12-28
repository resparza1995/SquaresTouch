package com.example.mylineapp;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.mylineapp.listeners.GestureListener;
import com.example.mylineapp.listeners.ScaleListener;
import java.util.ArrayList;

public class MyView extends View {

    GestureDetector mGestureDetector;
    ScaleGestureDetector mScaleDetector;
    ScaleListener mScaleListener;
    GestureListener mGestureListener;

    public ArrayList<Rectangle> rectangles = new ArrayList<>();
    public Rectangle rectSelected = null;

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        mGestureListener = new GestureListener(this);
        mGestureDetector = new GestureDetector(getContext(), mGestureListener);
        mScaleListener = new ScaleListener(this);
        mScaleDetector = new ScaleGestureDetector(getContext(), mScaleListener);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mGestureDetector.onTouchEvent(event);
        mScaleDetector.onTouchEvent(event);
        invalidate();

        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        this.rectangles.forEach((rectangle) -> {
            canvas.drawRect(rectangle.rectangle, rectangle.paint);
        });
    }
}