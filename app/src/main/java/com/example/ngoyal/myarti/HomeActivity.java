package com.example.ngoyal.myarti;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends Activity {

    TextView tvMataName;
    TextView tvArtiBody;
    TextView tvMantraBody;
    TextView tvDhyanBody;
    TextView tvSrotBody;
    TextView tvKavachBody;
    TextView tvpoojaVidhi;
    ImageView iv;
    private String[] navMantraItems;
    private String[] navMataName;
    private String[] navMataPoojaVidhi;
    private String[] navMataArti;
    private String[] navMataDhyan;
    private String[] navMataStrot;
    private String[] navMataKavach;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tvMataName = (TextView) findViewById(R.id.txtLabel);
        tvArtiBody = (TextView) findViewById(R.id.aarti_body);
        tvMantraBody = (TextView) findViewById(R.id.mantra_body);
        tvDhyanBody = (TextView) findViewById(R.id.dhyan_body);
        tvSrotBody = (TextView) findViewById(R.id.srota_body);
        tvKavachBody = (TextView) findViewById(R.id.kavach_body);
        tvpoojaVidhi = (TextView) findViewById(R.id.vidhi_body);

        iv = (ImageView) findViewById(R.id.imgLabel);
        int position = getIntent().getExtras().getInt("Position");
        navMantraItems = getResources().getStringArray(R.array.nav_mantra);
        navMataName = getResources().getStringArray(R.array.nav_mata_name);
        navMataPoojaVidhi =getResources().getStringArray(R.array.nav_MataPoojaVidhi);
        navMataArti =getResources().getStringArray(R.array.nav_arti);
        navMataDhyan =getResources().getStringArray(R.array.nav_MataDhyan);
        navMataStrot =getResources().getStringArray(R.array.nav_MataSrot);
        navMataKavach =getResources().getStringArray(R.array.nav_MataKavach);
        tvMantraBody.setText(navMantraItems[position]);
        tvMataName.setText(navMataName[position]);
        Typeface tf = Typeface.createFromAsset(getAssets(), "font/k010.TTF");
        
        tvArtiBody.setTypeface(tf);
        tvArtiBody.setText(navMataArti[position]);
        tvDhyanBody.setText(navMataDhyan[position]);
        tvSrotBody.setText(navMataStrot[position]);
        tvKavachBody.setText(navMataKavach[position]);
        tvpoojaVidhi.setText(navMataPoojaVidhi[position]);
        setDetails(position);
    }

    private void setDetails(int pos) {
        //Toast.makeText(this, "Position" + pos, Toast.LENGTH_SHORT).show();
        switch (pos) {
            case 0:

                iv.setImageResource(R.drawable.big0);
//                tvArtiBody.setText(R.string.head0);;
//                tvMantraBody.setText(navMantraItems[pos]);
//                tvDhyanBody.setText(R.string.head0);
//                tvSrotBody.setText(R.string.head0);
//                tvKavachBody.setText(R.string.head0);
                break;
            case 1:

                iv.setImageResource(R.drawable.big1);
                break;
            case 2:
                tvMataName.setText(R.string.head2);
                iv.setImageResource(R.drawable.big2);
                break;
            case 3:

                iv.setImageResource(R.drawable.big3);
                break;
            case 4:

                iv.setImageResource(R.drawable.big4);
                break;
            case 5:

                iv.setImageResource(R.drawable.big5);
                break;
            case 6:

                iv.setImageResource(R.drawable.big6);
                break;
            case 7:

                iv.setImageResource(R.drawable.big7);
                break;
            case 8:

                iv.setImageResource(R.drawable.big8);
                break;

            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        tvMataName.setText(null);
       // iv.setImageBitmap(null);
    }

    @Override
    protected void onStop() {
        super.onStop();

        //ImageView imageView = (ImageView)findViewById(R.id.imgLabel);
//        Drawable drawable = iv.getDrawable();
//
//        if (drawable instanceof BitmapDrawable) {
//            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
//            Bitmap bitmap = bitmapDrawable.getBitmap();
//
//            if (bitmap != null && !bitmap.isRecycled()) {
//                bitmap.recycle();
//
//            }
//
//        }
    }
}
