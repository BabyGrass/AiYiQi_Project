package com.aiyiqi.aiyiqi_project.decorate_budget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;

public class LineView extends ViewGroup{
	private View childView;
	private Scroller scroller;
	public LineView(Context context, AttributeSet attrs) {
		super(context, attrs);
		scroller = new Scroller(context);
	}
	public LineView(Context context) {
		super(context);
	}

	public LineView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		childView  = this.getChildAt(0);
		childView.layout(l, t, this.getWidth()/2, b);
	}

	@Override
	public void computeScroll() {
		int currX = 0,currY=0,x=0,y=0;
		if(!scroller.isFinished()){
			if(scroller.computeScrollOffset()){
				currX = this.getScrollX();
				currY = this.getScrollY();
				x = scroller.getCurrX();
				y = scroller.getCurrY();
				if(currX !=x || currY != y){
					this.scrollTo(x, y);
				}
				invalidate();
			}else {
				childView.setDrawingCacheEnabled(false);
			}
		}else {
			childView.setDrawingCacheEnabled(false);
		}
	}

	/**
	 * 活动移动接口
	 * @param destx
	 * @param desty
     */
	public void smoothScrollTo(int destx,int desty){
		int oldScrollX = this.getScrollX();
		int oldScrollY = this.getScrollY();
		int dx = destx-oldScrollX;
		int dy = desty-oldScrollY;
		scroller.startScroll(oldScrollX, oldScrollY, dx, dy, 500);
		invalidate();
	}

}
