[![](https://jitpack.io/v/arefbhrn/UsefulCustomViews.svg)](https://jitpack.io/#arefbhrn/UsefulCustomViews)

Useful Custom Views
==============================

An Android library, containing a collection of useful custom views

####  Includes these views:

| View Class Name | Description |
| ----------------------| ---------|
| AspectRatioLayout     | A view group with aspect ratio attribute (Its width/height sets by a ratio to its height/width). |
| AutoFitEditText       | An EditText which fits text in bounds by changing text size. |
| CustomViewPager       | A ViewPager having ability to turn on/off swiping between pages. |
| JustifiedTextView     | A TextView that justifies text for both RTL and LTR texts |
| RelativeSizeLayout    | A view group which its width and height will be set by a ratio to its parent's width and height separately. |
| RoundedCornerLayout   | A container layout that every corner's radius and its background color can be controlled. |
| ShadowLayout          | A container layout which drops shadow over its children. |

Installation
===============================

Gradle

```
dependencies {
    implementation 'com.github.arefbhrn:usefulcustomviews:1.0.0'
}
```

Usage
===========================

Define 'app' namespace on root view in your layout

``` xml
xmlns:app="http://schemas.android.com/apk/res-auto"
```

###  Using AspectRatioLayout :

Use this library in your layout like this:
```
<com.arefbhrn.usefulcustomviews.AspectRatioLayout
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    app:arl_aspect_ratio="0.5"
    app:arl_is_ratio_height_to_width="true">
    
    // any other layouts
    
</com.arefbhrn.usefulcustomviews.AspectRatioLayout>
 ```
 
####  Supported Attributes

| XML Attribute | Programmatic Setter | Description  |
| ---------------------------------- |-------------| ---------|
| app:arl_aspect_ratio               | setAspectRatio(float ratio) | Aspect ratio (height / width). |
| app:arl_is_ratio_height_to_width   | setIsRatioHeightToWidth(boolean isRatioHeightToWidth) | If true: aspect ratio = (height / width), otherwise: aspect ratio = (width / height) |
 
 ---
 
###  Using CustomViewPager :

Use this library in your layout like this:
```
<com.arefbhrn.usefulcustomviews.CustomViewPager
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    app:swipe_enabled="false" />
 ```
 
####  Supported Attributes

| XML Attribute | Programmatic Setter | Description  |
| --------------------- |-------------| ---------|
| app:swipe_enabled     | setSwipeEnabled(boolean isSwipeEnabled) | Sets swiping between pages enable/disabled. |
 
 ---
 
###  Using JustifiedTextView :

Use this library in your layout like this:
```
<com.arefbhrn.usefulcustomviews.JustifiedTextView
    android:layout_width="match_parent"
    android:layout_height="wrap_content" />
 ```

 ---
 
###  Using RelativeSizeLayout :

Use this library in your layout like this:
```
<com.arefbhrn.usefulcustomviews.RelativeSizeLayout
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    app:swipe_enabled="false">
    
    // any other layouts
    
</com.arefbhrn.usefulcustomviews.RelativeSizeLayout>
 ```
 
####  Supported Attributes

| XML Attribute | Programmatic Setter | Description  |
| --------------------- |-------------| ---------|
| app:rsl_width_ratio   | setWidthRatio(float widthRatio) | Sets width ratio to parent's width. |
| app:rsl_height_ratio  | setHeightRatio(float heightRatio) | Sets height ratio to parent's height. |
 
 ---
 
###  Using RoundedCornerLayout :

Use this library in your layout like this:
```
<com.arefbhrn.usefulcustomviews.RoundedCornerLayout
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    app:rcl_color="#FF0000"
    app:rcl_radius="7dp"
    app:rcl_radius_top_left="7dp"
    app:rcl_radius_top_right="7dp"
    app:rcl_radius_bottom_right="7dp"
    app:rcl_radius_bottom_left="7dp">
    
    // any other layouts
    
</com.arefbhrn.usefulcustomviews.RoundedCornerLayout>
 ```
 
####  Supported Attributes

| XML Attribute | Programmatic Setter | Description  |
| --------------------- |-------------| ---------|
| app:rcl_color  | setBackgroundColor(int backgroundColor) | Sets rounded background color. |
| app:rcl_radius   | setRadius(float radius) | Sets radius on all corners. This overrides other corner radius settings. |
| app:rcl_radius_top_left , app:rcl_radius_top_right , app:rcl_radius_bottom_right , app:rcl_radius_bottom_left | setRadius(float topLeftRadius, float topRightRadius, float bottomRightRadius, float bottomLeftRadius) | Sets radius on each corner. |
 
 ---
 
###  Using ShadowLayout :

Use this library in your layout like this:
```
<com.arefbhrn.usefulcustomviews.ShadowLayout
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    app:sl_shadowed="true"
    app:sl_shadow_color="#000"
    app:sl_shadow_distance="3dp"
    app:sl_shadow_angle="90"
    app:sl_shadow_radius="3dp">
    
    // any other layouts
    
</com.arefbhrn.usefulcustomviews.ShadowLayout>
 ```
 
####  Supported Attributes

| XML Attribute | Programmatic Setter | Description  |
| ----------------------- |-----------| ---------|
| app:sl_shadowed         | setIsShadowed(boolean isShadowed) | Sets shadow enabled/disabled. |
| app:sl_shadow_color     | setShadowColor(int shadowColor) | Sets shadow color. |
| app:sl_shadow_distance  | setShadowDistance(float shadowDistance) | Sets shadow distance. |
| app:sl_shadow_angle     | setShadowAngle(float shadowAngle) | Sets shadow drop angle. |
| app:sl_shadow_radius    | setShadowRadius(float shadowRadius) | Sets shadow radius. |
 
 ---

Contact me
===========================

If you have a better idea or way on this project, please let me know, thanks :)

[Email](mailto:arefprivate@gmail.com)

License
===========================

This project is licensed under the Apache 2.0 License - see the [LICENSE.md](LICENSE.md) file for details
