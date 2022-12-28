package com.example.mylineapp.listeners;

import android.view.ScaleGestureDetector;

import com.example.mylineapp.MyView;

public class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {

    MyView mView;

    public ScaleListener(MyView view) {
        this.mView = view;
    }

    @Override
    public boolean onScale(ScaleGestureDetector detector) {
        if (this.mView.rectSelected != null) {
            this.mView.rectSelected.resize(detector.getScaleFactor());
        }

        return true;
    }
}