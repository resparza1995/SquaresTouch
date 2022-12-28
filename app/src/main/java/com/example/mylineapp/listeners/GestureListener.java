package com.example.mylineapp.listeners;

import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.example.mylineapp.MyView;
import com.example.mylineapp.Rectangle;

public class GestureListener extends GestureDetector.SimpleOnGestureListener {

    MyView mView;

    public GestureListener(MyView view) {
        this.mView = view;
    }

    @Override
    public boolean onDown(MotionEvent event) {
        int x = Math.round(event.getX());
        int y = Math.round(event.getY());

        int i = 0;
        while (i < mView.rectangles.size()) {
            Rectangle rect = mView.rectangles.get(i);
            if (rect.rectangle.contains(x,y)) {
                mView.rectSelected = mView.rectangles.get(i);
                return true;
            }
            else i++;
        }

        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        int x = Math.round(e1.getX());
        int y = Math.round(e1.getY());
        if (this.mView.rectSelected != null) {
            this.mView.rectSelected.move(distanceX, distanceY);
        }
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent event) {
        int x = Math.round(event.getX());
        int y = Math.round(event.getY());
        this.mView.rectangles.add(new Rectangle(x, y));

        return true;
    }
}