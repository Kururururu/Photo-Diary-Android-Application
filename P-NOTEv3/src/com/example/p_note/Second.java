package com.example.p_note;

import java.io.File;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.ImageView;
import android.widget.SimpleCursorAdapter;
import android.widget.AdapterView.AdapterContextMenuInfo;

public class Second extends ListActivity {
	static final int REQUEST_IMAGE_CAPTURE = 1;
	ImageView iv;
	private NotesDbAdapter mDbHelper;
    private Cursor notesCursor;
    private static final int DELETE_ID = Menu.FIRST + 1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);
		mDbHelper = new NotesDbAdapter(this);
        mDbHelper.open();
        fillData();
        registerForContextMenu(getListView());
		iv = (ImageView) findViewById(R.id.iv1);
		//ImageButton b = (ImageButton) findViewById(R.id.imageButton1);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	private void fillData() {
        // Get all of the rows from the database and create the item list
        notesCursor = mDbHelper.fetchAllNotes();
        startManagingCursor(notesCursor);

        // Create an array to specify the fields we want to display in the list (only TITLE)
        String[] from = new String[]{NotesDbAdapter.KEY_TITLE, NotesDbAdapter.KEY_COLOR,NotesDbAdapter.KEY_PLACE};

        // and an array of the fields we want to bind those fields to (in this case just text1)
        int[] to = new int[]{R.id.text1t,R.id.text2t,R.id.text3t};

        // Now create a simple cursor adapter and set it to display
        SimpleCursorAdapter notes = 
            new SimpleCursorAdapter(this, R.layout.list_item, notesCursor, from, to);
        setListAdapter(notes);
    }
	@Override
    public void onCreateContextMenu(ContextMenu menu, View v,
            ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, DELETE_ID, 0, R.string.menu_delete);
    }
	
	@Override
    public boolean onContextItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case DELETE_ID:
                AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
                mDbHelper.deleteNote(info.id);
                fillData();
                return true;
        }
        return super.onContextItemSelected(item);
    }
	public void swapto1(View v)
	{
		Intent intent2 = new Intent(Second.this,Main.class);
		intent2.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
		startActivity(intent2);
		//setContentView(R.layout.activity_main);
	}
	public void swapto3(View v)
	{
		Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
		startActivity(intent);
		//Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
		//startActivityForResult(intent, 0);
	}
	public void swapto4(View v)
	{
		Intent intent = new Intent(Intent.ACTION_VIEW,null);
		intent.setType("image/*");
		startActivity(intent);
	}
	public void swapto5(View v)
	{
		Intent intent1 = new Intent(Second.this,Third.class);
		intent1.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
		startActivity(intent1);
		//setContentView(R.layout.second);
	}
	 /*@Override
	 protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	 	// TODO Auto-generated method stub
	 	super.onActivityResult(requestCode, resultCode, data);
	 	
	 	Bitmap bm = (Bitmap) data.getExtras().get("data");
	 	iv.setImageBitmap(bm);
	 }*/
	}

	

