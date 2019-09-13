package com.arefbhrn.usefulcustomviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by Aref Bahreini Nejad on 2019-09-01
 * Updated on 2019-09-01
 */
public class RelativeSizeLayout extends RelativeLayout {

	private final static float DEFAULT_WIDTH_RATIO = 1;
	private final static float DEFAULT_HEIGHT_RATIO = 1;

	private float widthRatio;
	private float heightRatio;

	public RelativeSizeLayout(Context context) {
		this(context, null);
	}

	public RelativeSizeLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(attrs);
	}

	private void init(AttributeSet attrs) {
		if (attrs == null) {
			return;
		}
		TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.RelativeSizeLayout);
		setWidthRatio(
				typedArray.getFloat(R.styleable.RelativeSizeLayout_rsl_width_ratio, DEFAULT_WIDTH_RATIO)
		);
		setHeightRatio(
				typedArray.getFloat(R.styleable.RelativeSizeLayout_rsl_height_ratio, DEFAULT_HEIGHT_RATIO)
		);
		typedArray.recycle();
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		View parent = (View) getParent();
		if (parent != null) {
			int parentWidth = parent.getMeasuredWidth();
			int parentHeight = parent.getMeasuredHeight();

			int calculatedWidth = (int) (parentWidth * widthRatio);
			int calculatedHeight = (int) (parentHeight * heightRatio);

			super.onMeasure(
					MeasureSpec.makeMeasureSpec(calculatedWidth, MeasureSpec.EXACTLY),
					MeasureSpec.makeMeasureSpec(calculatedHeight, MeasureSpec.EXACTLY));
		}
	}

	public void setWidthRatio(float widthRatio) {
		if (widthRatio < 0)
			widthRatio = 0;
		else if (widthRatio > 1)
			widthRatio = 1;
		this.widthRatio = widthRatio;
	}

	public void setHeightRatio(float heightRatio) {
		if (heightRatio < 0)
			heightRatio = 0;
		else if (heightRatio > 1)
			heightRatio = 1;
		this.heightRatio = heightRatio;
	}

}
