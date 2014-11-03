package com.example.projectleviosa;

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

	ImageButton a1, a2, a3, a4, b1, b2, b3, b4, c1, c2, c3, c4, d1, d2, d3, d4,
			e1, e2, e3, e4, f1, f2, f3, f4;
	Button restart, end;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		a1 = (ImageButton) findViewById(R.id.imageButton1);
		a2 = (ImageButton) findViewById(R.id.imageButton2);
		a3 = (ImageButton) findViewById(R.id.imageButton3);
		a4 = (ImageButton) findViewById(R.id.imageButton4);
		b1 = (ImageButton) findViewById(R.id.imageButton5);
		b2 = (ImageButton) findViewById(R.id.imageButton6);
		b3 = (ImageButton) findViewById(R.id.imageButton7);
		b4 = (ImageButton) findViewById(R.id.imageButton8);
		c1 = (ImageButton) findViewById(R.id.imageButton9);
		c2 = (ImageButton) findViewById(R.id.imageButton10);
		c3 = (ImageButton) findViewById(R.id.imageButton11);
		c4 = (ImageButton) findViewById(R.id.imageButton12);
		d1 = (ImageButton) findViewById(R.id.imageButton13);
		d2 = (ImageButton) findViewById(R.id.imageButton14);
		d3 = (ImageButton) findViewById(R.id.imageButton15);
		d4 = (ImageButton) findViewById(R.id.imageButton16);
		e1 = (ImageButton) findViewById(R.id.imageButton17);
		e2 = (ImageButton) findViewById(R.id.imageButton18);
		e3 = (ImageButton) findViewById(R.id.imageButton19);
		e4 = (ImageButton) findViewById(R.id.imageButton20);
		f1 = (ImageButton) findViewById(R.id.imageButton21);
		f2 = (ImageButton) findViewById(R.id.imageButton22);
		f3 = (ImageButton) findViewById(R.id.imageButton23);
		f4 = (ImageButton) findViewById(R.id.imageButton24);
		restart = (Button) findViewById(R.id.button1);
		end = (Button) findViewById(R.id.button2);

		a1.setOnClickListener(this);
		a2.setOnClickListener(this);
		a3.setOnClickListener(this);
		a4.setOnClickListener(this);
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		b3.setOnClickListener(this);
		b4.setOnClickListener(this);
		c1.setOnClickListener(this);
		c2.setOnClickListener(this);
		c3.setOnClickListener(this);
		c4.setOnClickListener(this);
		d1.setOnClickListener(this);
		d2.setOnClickListener(this);
		d3.setOnClickListener(this);
		d4.setOnClickListener(this);
		e1.setOnClickListener(this);
		e2.setOnClickListener(this);
		e3.setOnClickListener(this);
		e4.setOnClickListener(this);
		f1.setOnClickListener(this);
		f2.setOnClickListener(this);
		f3.setOnClickListener(this);
		f4.setOnClickListener(this);
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

			break;

		// Menue 

		case R.id.button1:

			break;
		case R.id.button2:

			break;
		}

	}

}
