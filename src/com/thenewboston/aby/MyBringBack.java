package com.thenewboston.aby;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;

public class MyBringBack extends View {

	Bitmap gBall;
	float changingY = 0;
	Typeface font;

	public MyBringBack(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		gBall = BitmapFactory.decodeResource(getResources(), R.drawable.ball);
		font = Typeface.createFromAsset(context.getAssets(), "verdana.ttf");
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		canvas.drawColor(Color.WHITE);
		
		Paint textPaint = new Paint();
		textPaint.setARGB(50, 254, 10, 50);
		textPaint.setTextAlign(Align.CENTER);
		textPaint.setTextSize(25);
		textPaint.setTypeface(font);
		canvas.drawText("I am Aby Sebastian", canvas.getWidth()/2, 350, textPaint);
		
		canvas.drawBitmap(gBall, canvas.getWidth() / 2 - gBall.getWidth() / 2,
				changingY, null);
		if (changingY < canvas.getHeight()) {
			changingY += 1;
		} else {
			changingY = 0;
		}
		Rect middleRect = new Rect();
		middleRect.set(0, 100, canvas.getWidth(), 200);
		Paint ourBlue = new Paint();
		ourBlue.setColor(Color.BLUE);
		canvas.drawRect(middleRect, ourBlue);
		invalidate();
	}
}
