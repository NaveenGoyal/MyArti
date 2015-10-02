package com.example.ngoyal.myarti;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GridAdapter extends BaseAdapter {

	String[] artiName;
	Context context;
	int[] imageId;
	CallBack cb;
	private static LayoutInflater inflater = null;

	public GridAdapter(MainActivity mainActivity, String[] artiNameList,
			int[] artiImages) {
		// TODO Auto-generated constructor stub
		artiName = artiNameList;
		context = mainActivity;
		cb = (CallBack)mainActivity;
		imageId = artiImages;
		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return artiName.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	public class Holder {
		TextView tv;
		ImageView img;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Holder holder = new Holder();
		View rowView;

		rowView = inflater.inflate(R.layout.arti_main, null);
		holder.tv = (TextView) rowView.findViewById(R.id.textView1);
		holder.img = (ImageView) rowView.findViewById(R.id.imageView1);
		holder.img.setImageResource(imageId[position]);
		holder.tv.setText(artiName[position]);
		

		rowView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				
				
				cb.startMyActivity(position);
				
		                
				//Toast.makeText(context, "You Clicked " + artiName[position],
					//	Toast.LENGTH_LONG).show();
			}
		});

		return rowView;
	}
	
	
	

}