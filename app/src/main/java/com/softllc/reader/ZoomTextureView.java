package com.softllc.reader;

import android.content.Context;
import android.view.TextureView;
import android.view.ScaleGestureDetector;
import android.view.MotionEvent;
import android.util.AttributeSet;
import android.util.Log;
import android.os.Handler;

public class ZoomTextureView extends TextureView {

    private ScaleGestureDetector mDetector;
    private float mScaleFactor = 2.5f;

    public ZoomTextureView(Context context) {
        this(context, null, 0);
    }

    public ZoomTextureView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ZoomTextureView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        // Create our ScaleGestureDetector
        mDetector = new ScaleGestureDetector(context, new ScaleListener());

    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            mScaleFactor *= detector.getScaleFactor();

            // Don't let the object get too small or too large.
            mScaleFactor = Math.max(.5f, Math.min(mScaleFactor, 5.0f));
            Log.d("djm", "mScaleFactor=" + mScaleFactor);
            return true;
        }

    }


    @Override
    public boolean onTouchEvent(MotionEvent event){
        mDetector.onTouchEvent(event);
        return true;
    }


    public float getScaleFactor() {
        return mScaleFactor;
    }

}