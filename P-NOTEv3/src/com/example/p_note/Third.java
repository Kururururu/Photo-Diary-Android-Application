package com.example.p_note;


import java.io.File;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

public class Third extends Activity {
	static final int REQUEST_IMAGE_CAPTURE = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.instructions);
		//ImageButton b = (ImageButton) findViewById(R.id.imageButton1);
	}
	
	public void swaptointro(View v)
	{
		 Intent intro = new Intent(this,clang.class);
 		
 		startActivity(intro);
		//setContentView(R.layout.activity_main);
	}
public void swapto1(View v)
{
	Intent intent2 = new Intent(Third.this,Main.class);
	intent2.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
	startActivity(intent2);
	//setContentView(R.layout.activity_main);
}
public void swapto3(View v)
{
	Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
	startActivity(intent);
	//
	//Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
	//startActivityForResult(intent, 0);
}
public void swapto2(View v)
{
	Intent intent1 = new Intent(Third.this,Second.class);
	intent1.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
	startActivity(intent1);
	//setContentView(R.layout.second);
}
public void swapto4(View v)
{
	Intent intent = new Intent(Intent.ACTION_VIEW,null);
	intent.setType("image/*");
	startActivity(intent);
}
}
