package com.arefbhrn.usefulcustomviews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

/**
 * Created by Aref Bahreini Nejad on 2019-11-10
 * Updated on 2019-11-10
 */
public class ShadowLayoutInScrollView extends ShadowLayout {

	public ShadowLayoutInScrollView(Context context) {
		super(context);
		inScrollViewHandler();
	}

	public ShadowLayoutInScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
		inScrollViewHandler();
	}

	public ShadowLayoutInScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		inScrollViewHandler();
	}

	private void inScrollViewHandler() {
		post(() -> {
			ViewGroup.LayoutParams params = getLayoutParams();
			params.width = getWidth();
			params.height = getHeight();

			setLayoutParams(params);
			requestLayout();
			postInvalidate();
		});
	}

}
