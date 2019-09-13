package com.arefbhrn.usefulcustomviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

/**
 * Created by Aref Bahreini Nejad on 2019-09-01
 * Updated on 2019-09-01
 */
public class CustomViewPager extends ViewPager {

	private boolean isSwipeEnabled = true;

	public CustomViewPager(@NonNull Context context) {
		this(context, null);
	}

	public CustomViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
		if (attrs == null) {
			return;
		}
		TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.CustomViewPager);
		setSwipeEnabled(
				typedArray.getBoolean(R.styleable.CustomViewPager_swipe_enabled, true)
		);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		return this.isSwipeEnabled && super.onTouchEvent(event);
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent event) {
		return this.isSwipeEnabled && super.onInterceptTouchEvent(event);
	}

	public void setSwipeEnabled(boolean isSwipeEnabled) {
		this.isSwipeEnabled = isSwipeEnabled;
	}

}
