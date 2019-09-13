package com.arefbhrn.usefulcustomviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by Aref Bahreini Nejad on 2019-09-01
 * Updated on 2019-09-01
 */
public class AspectRatioLayout extends RelativeLayout {

	private final static boolean DEFAULT_IS_RATIO_HEIGHT_TO_WIDTH = true;
	private final static int DEFAULT_ASPECT_RATIO = 1;

	private boolean isRatioHeightToWidth;
	private float aspectRatio;

	public AspectRatioLayout(Context context) {
		this(context, null);
	}

	public AspectRatioLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(attrs);
	}

	private void init(AttributeSet attrs) {
		if (attrs == null) {
			return;
		}
		TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.AspectRatioLayout);
		setIsRatioHeightToWidth(
				typedArray.getBoolean(R.styleable.AspectRatioLayout_arl_is_ratio_height_to_width, DEFAULT_IS_RATIO_HEIGHT_TO_WIDTH)
		);
		setAspectRatio(
				typedArray.getFloat(R.styleable.AspectRatioLayout_arl_aspect_ratio, DEFAULT_ASPECT_RATIO)
		);
		typedArray.recycle();
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		if (aspectRatio <= 0) {
			super.onMeasure(widthMeasureSpec, heightMeasureSpec);
			return;
		}
		if (isRatioHeightToWidth) {
			int originalWidth = MeasureSpec.getSize(widthMeasureSpec);
			int calculatedHeight = (int) (originalWidth * aspectRatio);
			super.onMeasure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(calculatedHeight, MeasureSpec.EXACTLY));
		} else {
			int originalHeight = MeasureSpec.getSize(heightMeasureSpec);
			int calculatedWidth = (int) (originalHeight * aspectRatio);
			super.onMeasure(MeasureSpec.makeMeasureSpec(calculatedWidth, MeasureSpec.EXACTLY), heightMeasureSpec);
		}
	}

	public void setAspectRatio(float aspectRatio) {
		this.aspectRatio = aspectRatio;
	}

	public void setIsRatioHeightToWidth(boolean isRatioHeightToWidth) {
		this.isRatioHeightToWidth = isRatioHeightToWidth;
	}

}
