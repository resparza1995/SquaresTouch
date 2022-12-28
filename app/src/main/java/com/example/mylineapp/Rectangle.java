package com.example.mylineapp;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import java.util.Random;

public class Rectangle {

    public Rect rectangle;
    public Paint paint = new Paint();
    private Random rdm = new Random();

    public Rectangle() {}

    public Rectangle(int left, int top) {
        this.rectangle = new Rect(left, top, left+200, top+200);
        this.initPaint();
    }

    private void initPaint() {
        this.paint.setAntiAlias(true);
        this.paint.setStrokeWidth(6f);
        this.paint.setColor(rdm.nextInt());
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeJoin(Paint.Join.ROUND);
    }

    public void resize(float factor) {
        int dFactor = factor < 1 ? Math.round(factor) : Math.round(factor)*-1;
        this.rectangle.inset(dFactor*5, dFactor*5);
    }

    public void move(float distanceX, float distanceY) {
        int ddx = Math.round(distanceX)*-1;
        int ddy = Math.round(distanceY)*-1;
        this.rectangle.offset(ddx, ddy);
    }

}
