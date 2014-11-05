package com.example.projectleviosa;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private ImageButton a1, a2, a3, a4, b1, b2, b3, b4, c1, c2, c3, c4, d1, d2,
			d3, d4, e1, e2, e3, e4, f1, f2, f3, f4;
	private Button restart, end;
	private int isClicked;
	private List<MemoryButton> buttons;
	private int indexButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		isClicked = 0;
		indexButton = -1;
		buttons = new ArrayList<MemoryButton>();
		buttons.add(new MemoryButton((ImageButton) findViewById(R.id.imageButton1), 0));
		buttons.add(new MemoryButton((ImageButton) findViewById(R.id.imageButton2), 1));
		buttons.add(new MemoryButton((ImageButton) findViewById(R.id.imageButton3), 2));
		buttons.add(new MemoryButton((ImageButton) findViewById(R.id.imageButton4), 3));
/*		buttons.add(b1 = (ImageButton) findViewById(R.id.imageButton5));
		buttons.add(b2 = (ImageButton) findViewById(R.id.imageButton6));
		buttons.add(b3 = (ImageButton) findViewById(R.id.imageButton7));
		buttons.add(b4 = (ImageButton) findViewById(R.id.imageButton8));
		buttons.add(c1 = (ImageButton) findViewById(R.id.imageButton9));
		buttons.add(c2 = (ImageButton) findViewById(R.id.imageButton10));
		buttons.add(c3 = (ImageButton) findViewById(R.id.imageButton11));
		buttons.add(c4 = (ImageButton) findViewById(R.id.imageButton12));
		buttons.add(d1 = (ImageButton) findViewById(R.id.imageButton13));
		buttons.add(d2 = (ImageButton) findViewById(R.id.imageButton14));
		buttons.add(d3 = (ImageButton) findViewById(R.id.imageButton15));
		buttons.add(d4 = (ImageButton) findViewById(R.id.imageButton16));
		buttons.add(e1 = (ImageButton) findViewById(R.id.imageButton17));
		buttons.add(e2 = (ImageButton) findViewById(R.id.imageButton18));
		buttons.add(e3 = (ImageButton) findViewById(R.id.imageButton19));
		buttons.add(e4 = (ImageButton) findViewById(R.id.imageButton20));
		buttons.add(f1 = (ImageButton) findViewById(R.id.imageButton21));
		buttons.add(f2 = (ImageButton) findViewById(R.id.imageButton22));
		buttons.add(f3 = (ImageButton) findViewById(R.id.imageButton23));
		buttons.add(f4 = (ImageButton) findViewById(R.id.imageButton24));*/
		restart = (Button) findViewById(R.id.button1);
		end = (Button) findViewById(R.id.button2);

		for(int i = 0; i < buttons.size(); i++)
		{
			buttons.get(i).getButton().setOnClickListener(this);
		}
		restart.setOnClickListener(this);
		end.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.imageButton1:
			
			turnOverCard(buttons.get(0));
			//indexButton = 0;
			break;
		case R.id.imageButton2:
			turnOverCard(buttons.get(1));
			//indexButton = 1;
			break;
		case R.id.imageButton3:
			turnOverCard(buttons.get(2));
			//indexButton = 2;
			break;
		case R.id.imageButton4:
			turnOverCard(buttons.get(3));
			//indexButton = 3;
			break;

		case R.id.button1:
			break;
		case R.id.button2:

			break;
		}

	}

	private void turnOverCard(MemoryButton button) {
		isClicked += 1;
		
		if (isClicked == 3) {
			for(int i = 0; i < buttons.size(); i++)
			{
				buttons.get(i).getButton().setImageResource(R.drawable.ic_launcher);
			}
			isClicked = 1;
		}
		button.getButton().setImageResource(R.drawable.levizoa);
		button.setIsTurned(true);

	}

}
