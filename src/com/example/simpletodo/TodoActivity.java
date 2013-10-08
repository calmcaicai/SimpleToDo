package com.example.simpletodo;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class TodoActivity extends Activity {

	ArrayList<String> items;
	ArrayAdapter<String> itemsAdapter;
	ListView lvItems;
	EditText etNewItem;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_todo);
		lvItems = (ListView)findViewById(R.id.lvitems);
		items = new ArrayList<String>();
		itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
		etNewItem = (EditText)findViewById(R.id.etNewItem);
		
		lvItems.setAdapter(itemsAdapter);
		setupListViewListener();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.todo, menu);
		return true;
	}
	
	public void addTodoItem(View v){
		//etNewItem = (EditText)findViewById(R.id.etNewItem);
		String str = etNewItem.getText().toString();
		if(!str.trim().isEmpty()){
			itemsAdapter.add(str);
			etNewItem.setText("");
		}
	}
	
	private void setupListViewListener(){
		lvItems.setOnItemLongClickListener(new OnItemLongClickListener(){

			@Override
			public boolean onItemLongClick(AdapterView<?> aView, View item, int pos,
					long id) {
				items.remove(pos);
				itemsAdapter.notifyDataSetInvalidated();
				return true;
			}
			
		});
	}
}
