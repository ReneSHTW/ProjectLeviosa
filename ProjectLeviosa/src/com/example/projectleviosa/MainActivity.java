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
		buttons.add(new MemoryButton(
				(ImageButton) findViewById(R.id.imageButton1), 0));
		buttons.add(new MemoryButton(
				(ImageButton) findViewById(R.id.imageButton2), 1));
		buttons.add(new MemoryButton(
				(ImageButton) findViewById(R.id.imageButton3), 2));
		buttons.add(new MemoryButton(
				(ImageButton) findViewById(R.id.imageButton4), 3));
		buttons.add(new MemoryButton(
				(ImageButton) findViewById(R.id.imageButton5), 4));
		buttons.add(new MemoryButton(
				(ImageButton) findViewById(R.id.imageButton6), 5));
		buttons.add(new MemoryButton(
				(ImageButton) findViewById(R.id.imageButton7), 6));
		buttons.add(new MemoryButton(
				(ImageButton) findViewById(R.id.imageButton8), 7));
		buttons.add(new MemoryButton(
				(ImageButton) findViewById(R.id.imageButton9), 8));
		buttons.add(new MemoryButton(
				(ImageButton) findViewById(R.id.imageButton10), 9));
		buttons.add(new MemoryButton(
				(ImageButton) findViewById(R.id.imageButton11), 10));
		buttons.add(new MemoryButton(
				(ImageButton) findViewById(R.id.imageButton12), 11));
		buttons.add(new MemoryButton(
				(ImageButton) findViewById(R.id.imageButton13), 12));
		buttons.add(new MemoryButton(
				(ImageButton) findViewById(R.id.imageButton14), 13));
		buttons.add(new MemoryButton(
				(ImageButton) findViewById(R.id.imageButton15), 14));
		buttons.add(new MemoryButton(
				(ImageButton) findViewById(R.id.imageButton16), 15));
		buttons.add(new MemoryButton(
				(ImageButton) findViewById(R.id.imageButton17), 16));
		buttons.add(new MemoryButton(
				(ImageButton) findViewById(R.id.imageButton18), 17));
		buttons.add(new MemoryButton(
				(ImageButton) findViewById(R.id.imageButton19), 18));
		buttons.add(new MemoryButton(
				(ImageButton) findViewById(R.id.imageButton20), 19));
		buttons.add(new MemoryButton(
				(ImageButton) findViewById(R.id.imageButton21), 20));
		buttons.add(new MemoryButton(
				(ImageButton) findViewById(R.id.imageButton22), 21));
		buttons.add(new MemoryButton(
				(ImageButton) findViewById(R.id.imageButton23), 22));
		buttons.add(new MemoryButton(
				(ImageButton) findViewById(R.id.imageButton24), 23));

		restart = (Button) findViewById(R.id.button1);
		end = (Button) findViewById(R.id.button2);

		for (int i = 0; i < buttons.size(); i++) {
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
			break;
		case R.id.imageButton2:
			turnOverCard(buttons.get(1));
			break;
		case R.id.imageButton3:
			turnOverCard(buttons.get(2));
			break;
		case R.id.imageButton4:
			turnOverCard(buttons.get(3));
			break;
		case R.id.imageButton5:
			turnOverCard(buttons.get(4));
			break;
		case R.id.imageButton6:
			turnOverCard(buttons.get(5));
			break;
		case R.id.imageButton7:
			turnOverCard(buttons.get(6));
			break;
		case R.id.imageButton8:
			turnOverCard(buttons.get(7));
			break;
		case R.id.imageButton9:
			turnOverCard(buttons.get(8));
			break;
		case R.id.imageButton10:
			turnOverCard(buttons.get(9));
			break;
		case R.id.imageButton11:
			turnOverCard(buttons.get(10));
			break;
		case R.id.imageButton12:
			turnOverCard(buttons.get(11));
			break;
		case R.id.imageButton13:
			turnOverCard(buttons.get(12));
			break;
		case R.id.imageButton14:
			turnOverCard(buttons.get(13));
			break;
		case R.id.imageButton15:
			turnOverCard(buttons.get(14));
			break;
		case R.id.imageButton16:
			turnOverCard(buttons.get(15));
			break;
		case R.id.imageButton17:
			turnOverCard(buttons.get(16));
			break;
		case R.id.imageButton18:
			turnOverCard(buttons.get(17));
			break;
		case R.id.imageButton19:
			turnOverCard(buttons.get(18));
			break;
		case R.id.imageButton20:
			turnOverCard(buttons.get(19));
			break;
		case R.id.imageButton21:
			turnOverCard(buttons.get(20));
			break;
		case R.id.imageButton22:
			turnOverCard(buttons.get(21));
			break;
		case R.id.imageButton23:
			turnOverCard(buttons.get(22));
			break;
		case R.id.imageButton24:
			turnOverCard(buttons.get(23));
			break;

		case R.id.button1:
			break;
		case R.id.button2:

			break;
		}

	}

	private void turnOverCard(MemoryButton button) {
		if (button.isSelected && (!button.isLocked)) {
			isClicked += 1;
			if (isClicked == 3) {
				for (int i = 0; i < buttons.size(); i++) {
					buttons.get(i).getButton()
							.setImageResource(R.drawable.ic_launcher);
					buttons.get(i).setIsTurned(false);
				}
				isClicked = 1;
			}
			button.getButton().setImageResource(R.drawable.levizoa);
			button.setIsSelected(false);
			button.setIsTurned(true);
			// Sprachausgabe: "Ein xyz!"

			if (isClicked == 2) { // Jetzt muss hier geprueft werden, ob die
									// Partnerkarte gefunden worden ist
				checkIfPair(button);

			}
		} else if ((!button.isSelected) && (!button.isLocked)) {
			deleteSelections();
			button.setIsSelected(true);
			// Sprachausgabe: "A1"
		} else if (button.isLocked = true) {
			// Tue nichts, optional Sprachausgabe:
			// "Diese Karte hat Ihren Partner bereits gefunden! ect."
		}

	}

	private void deleteSelections() {
		for (int i = 0; i < buttons.size(); i++) {
			buttons.get(i).setIsSelected(false);
		}
	}

	private void checkIfPair(MemoryButton button) {
		//Implementierung folgt, vorher muessen verschiedene Bilder mit jeweiligen IDs gespeichert werden
	}

}
