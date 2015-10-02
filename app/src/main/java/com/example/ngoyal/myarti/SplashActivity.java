package com.example.ngoyal.myarti;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends Activity  {
	
	ImageView iv;
	TextView tv;
	ObjectAnimator alpha;
	ObjectAnimator text;
	AnimatorListener listener;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.flash_screen);
		iv = (ImageView)findViewById(R.id.imageview);
		tv = (TextView)findViewById(R.id.textView1);
		listener = new AnimatorListener() {
			
			@Override
			public void onAnimationStart(Animator animation) {
				// TODO Auto-generated method stub
				Log.d("GAGAN","onAnimationStart");
			}
			
			@Override
			public void onAnimationRepeat(Animator animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animator animation) {
				// TODO Auto-generated method stub
				Log.d("GAGAN","onAnimationEnd");
				Intent start = new Intent();
				start.setClass(getApplicationContext(), MainActivity.class);
				startActivity(start);
				finish();
				
			}
			
			@Override
			public void onAnimationCancel(Animator animation) {
				// TODO Auto-generated method stub
				
			}
		};
		
		alpha = ObjectAnimator.ofFloat(iv, "alpha", 0.0f,1.0f);
		alpha.setInterpolator(new AccelerateDecelerateInterpolator());
		alpha.setDuration(2000);
		alpha.addListener(listener);
		alpha.start();
		text = ObjectAnimator.ofFloat(tv, "ScaleX",.8f );
		text.setDuration(1800);
		text.start();
		
	}

	


	
	
	

}
