package com.example.ngoyal.myarti;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;


public class MainActivity extends ActionBarActivity implements CallBack{

	Button fab, fab1;

	MediaPlayer mPlayer;

	private int num = 0;
	private int count = 0;
	private int length = 0;
	
	GridView gv;
	public static String [] artiNameList ={"नवरात्रि माता शैलपुत्री","नवरात्री माता ब्रह्मचारिणी","नवरात्रि माता चंद्रघंटा","नवरात्रि माता कूष्माण्डा","नवरात्रि\nस्कंदमाता ","नवरात्रि माता कात्यायनी","नवरात्रि माता कालरात्रि पूजा","नवरात्रि माता महागौरी","नवरात्रि माता सिद्धिदात्री"};
	public static int [] artiImages = {R.drawable.icon_1,R.drawable.icon_2,R.drawable.icon_3,R.drawable.icon_4,R.drawable.icon_5,R.drawable.icon_6,R.drawable.icon_7,R.drawable.icon_8,R.drawable.icon_9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gv = (GridView)findViewById(R.id.gridView1);
		fab = (Button)findViewById(R.id.fab);
		fab1 = (Button)findViewById(R.id.fab1);
        fab.setBackgroundResource(R.drawable.play_1);

        gv.setAdapter(new GridAdapter(this, artiNameList, artiImages));

		mPlayer = MediaPlayer.create(getApplicationContext(),
				R.raw.jay_ambey_gauri);

		setVolumeControlStream(AudioManager.STREAM_MUSIC);

		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				count = num % 2;

				Log.d("Naveen", "Inside the OnClick and Count is " + count + "Num is" + num);
				switch (count) {
					case 0:
						Thread thread = new Thread(new Runnable() {
							public void run() {
								mPlayer.seekTo(length);
								mPlayer.start();
							}
						});
						thread.start();

						fab.setBackgroundResource(R.drawable.pause_1);
						//fabImageButton.setImageDrawable(R.drawable.action_pause);
						num++;
						break;
					case 1:

						if (mPlayer != null && mPlayer.isPlaying()) {
							mPlayer.pause();
							length = mPlayer.getCurrentPosition();
						}
						//fabImageButton.setBackgroundResource(R.drawable.action_play);
						fab.setBackgroundResource(R.drawable.play_1);
						num++;

						break;
				}
			}
		});

		fab1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,DurgaChalisa.class);
				startActivity(intent);
			}
		});
    }



	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (mPlayer != null) {
			mPlayer.stop();
			mPlayer = null;
		}
	}

	@Override
	public void startMyActivity(int position) {
		
		Intent intent = new Intent(MainActivity.this,HomeActivity.class);
		intent.putExtra("Position", position);
		startActivity(intent);

		
	}

}
