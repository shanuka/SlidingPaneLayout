package com.example.slidinglayer;

import android.content.Context;
import android.support.v4.widget.SlidingPaneLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class MySlidingLayout extends SlidingPaneLayout {

	public MySlidingLayout(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public MySlidingLayout(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	public MySlidingLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	private boolean mTouchedDown = false;
	private boolean mForwardTouchesToChildren = false;

	@Override
	public boolean onInterceptTouchEvent(MotionEvent e) {
		/*
		 * If not slideable or if the "sliding" pane is open, let super method
		 * handle it.
		 */
		if (!isSlideable() || isOpen())
			return super.onInterceptTouchEvent(e);

		switch (e.getActionMasked()) {
		case MotionEvent.ACTION_DOWN: {
			mTouchedDown = true;

			/*
			 * "50" should be defined as a constant. Also this should be
			 * re-calculated in case the "sliding" pane is put at right side.
			 */
			if (e.getX() > 50) {
				mForwardTouchesToChildren = true;
				return false;
			} else
				mForwardTouchesToChildren = false;

			break;
		}

		case MotionEvent.ACTION_UP:
		case MotionEvent.ACTION_CANCEL: {
			mTouchedDown = false;
			mForwardTouchesToChildren = false;

			break;
		}
		}

		if (mTouchedDown && mForwardTouchesToChildren)
			return false;

		if (mTouchedDown)
			return true;

		return super.onInterceptTouchEvent(e);
	}// onInterceptTouchEvent()

}
