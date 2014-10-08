package fei.customview;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class BoxDrawingView extends View {
	public static final String TAG = "BOXDRAWINGVIEW";
	private Box mCurrentBox;
	private ArrayList<Box> mBoxs = new ArrayList<Box>();

	public BoxDrawingView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public BoxDrawingView(Context content, AttributeSet attSet) {
		super(content, attSet);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		PointF curr = new PointF(event.getX(), event.getY());
		Log.i(TAG, "received event at x: " + curr.x + " y: " + curr.y);
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			mCurrentBox = new Box(curr);
			mBoxs.add(mCurrentBox);
			break;
		case MotionEvent.ACTION_MOVE:
			if (mCurrentBox != null) {
				mCurrentBox.setCurrent(curr);
				invalidate();
			}
			break;
		case MotionEvent.ACTION_UP:
			mCurrentBox = null;
			break;
		case MotionEvent.ACTION_CANCEL:
			mCurrentBox = null;
			break;
		default:
			break;
		}
		return true;
	}

}
