package com.arefbhrn.usefulcustomviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by Aref Bahreini Nejad on 2019-09-01
 * Updated on 2019-09-01
 */
public class RoundedCornerLayout extends RelativeLayout {

	private final static float DEFAULT_RADIUS = 15.0F;
	private final static int DEFAULT_COLOR = Color.LTGRAY;

	private float topLeftRadius;
	private float topRightRadius;
	private float bottomRightRadius;
	private float bottomLeftRadius;
	private int mBackgroundColor;

	public RoundedCornerLayout(Context context) {
		this(context, null);
	}

	public RoundedCornerLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(attrs);
	}

	private void init(AttributeSet attrs) {
		if (attrs == null) {
			return;
		}
		TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.RoundedCornerLayout);
		if (typedArray.hasValue(R.styleable.RoundedCornerLayout_rcl_radius)) {
			setRadius(
					typedArray.getDimension(
							R.styleable.RoundedCornerLayout_rcl_radius, DEFAULT_RADIUS
					),
					typedArray.getDimension(
							R.styleable.RoundedCornerLayout_rcl_radius, DEFAULT_RADIUS
					),
					typedArray.getDimension(
							R.styleable.RoundedCornerLayout_rcl_radius, DEFAULT_RADIUS
					),
					typedArray.getDimension(
							R.styleable.RoundedCornerLayout_rcl_radius, DEFAULT_RADIUS
					)
			);
		} else {
			setRadius(
					typedArray.getDimension(
							R.styleable.RoundedCornerLayout_rcl_radius_top_left, DEFAULT_RADIUS
					),
					typedArray.getDimension(
							R.styleable.RoundedCornerLayout_rcl_radius_top_right, DEFAULT_RADIUS
					),
					typedArray.getDimension(
							R.styleable.RoundedCornerLayout_rcl_radius_bottom_right, DEFAULT_RADIUS
					),
					typedArray.getDimension(
							R.styleable.RoundedCornerLayout_rcl_radius_bottom_left, DEFAULT_RADIUS
					)
			);
		}
		setBackgroundColor(
				typedArray.getColor(
						R.styleable.RoundedCornerLayout_rcl_color, DEFAULT_COLOR
				)
		);
		typedArray.recycle();
		setBackground(getRoundRect(topLeftRadius, topRightRadius, bottomRightRadius, bottomLeftRadius));
	}

	private Drawable getRoundRect(float topLeftRadius, float topRightRadius, float bottomRightRadius, float bottomLeftRadius) {
		RoundRectShape rectShape = new RoundRectShape(new float[]{
				topLeftRadius, topLeftRadius,
				topRightRadius, topRightRadius,
				bottomRightRadius, bottomRightRadius,
				bottomLeftRadius, bottomLeftRadius,
		}, null, null);

		ShapeDrawable shapeDrawable = new ShapeDrawable(rectShape);
		shapeDrawable.getPaint().setColor(mBackgroundColor);
		shapeDrawable.getPaint().setStyle(Paint.Style.FILL);
		shapeDrawable.getPaint().setAntiAlias(true);
		shapeDrawable.getPaint().setFlags(Paint.ANTI_ALIAS_FLAG);
		return shapeDrawable;
	}

	public void setRadius(float radius) {
		this.topLeftRadius = radius;
		this.topRightRadius = radius;
		this.bottomRightRadius = radius;
		this.bottomLeftRadius = radius;
	}

	public void setRadius(float topLeftRadius, float topRightRadius, float bottomRightRadius, float bottomLeftRadius) {
		this.topLeftRadius = topLeftRadius;
		this.topRightRadius = topRightRadius;
		this.bottomRightRadius = bottomRightRadius;
		this.bottomLeftRadius = bottomLeftRadius;
	}

	public void setBackgroundColor(int backgroundColor) {
		this.mBackgroundColor = backgroundColor;
	}

}
