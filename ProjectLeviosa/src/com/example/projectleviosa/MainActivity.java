package com.example.projectleviosa;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends Activity implements OnClickListener, OnInitListener {

	private Intent intent;
	private Button restart, menuButton;
	private int isClicked;
	private int isNeustartClicked;
	private List<MemoryButton> buttons;
	private final int[] bildIDs = { R.drawable.auto, R.drawable.bahn, R.drawable.ball, R.drawable.blume, R.drawable.elefant, R.drawable.flugzeug,
			R.drawable.klammer, R.drawable.lampe, R.drawable.rakete, R.drawable.schmetterling, R.drawable.telefon, R.drawable.vogel };
	private TextToSpeech tts;
	private boolean blindenmodus;
	private float sprachgeschwindigkeit;
	private Bundle extras;
	private boolean isAccessibilityEnabled;
	private boolean isExploreByTouchEnabled;
	private AccessibilityManager am;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		am = (AccessibilityManager) getSystemService(ACCESSIBILITY_SERVICE);
		isAccessibilityEnabled = am.isEnabled();
		isExploreByTouchEnabled = am.isTouchExplorationEnabled();
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		extras = getIntent().getExtras();
		blindenmodus = true;
		sprachgeschwindigkeit = 1.0f;
		if (extras != null) {
			if (extras.getString("blindenmodus").equals("Blindenmodus aus")) {
				blindenmodus = false;
			}
			if (extras.getString("sprachgeschwindigkeit").equals("Sprachgeschwindigkeit: doppelt")) {
				sprachgeschwindigkeit = 2.0f;
			}
			if (extras.getString("sprachgeschwindigkeit").equals("Sprachgeschwindigkeit: dreifach")) {
				sprachgeschwindigkeit = 3.0f;
			}
		}
		restart = (Button) findViewById(R.id.button1);
		menuButton = (Button) findViewById(R.id.button2);
		isClicked = 0;
		isNeustartClicked = 0;
		tts = new TextToSpeech(this, this);

		tts.setSpeechRate(sprachgeschwindigkeit);
		buttons = new ArrayList<MemoryButton>();
		shuffleArray(bildIDs);
		buttons.add(new MemoryButton((ImageButton) findViewById(R.id.imageButton1), 0, bildIDs[0], "A 1"));
		buttons.add(new MemoryButton((ImageButton) findViewById(R.id.imageButton2), 1, bildIDs[1], "A 2"));
		buttons.add(new MemoryButton((ImageButton) findViewById(R.id.imageButton3), 2, bildIDs[2], "A 3"));
		buttons.add(new MemoryButton((ImageButton) findViewById(R.id.imageButton4), 3, bildIDs[3], "A 4"));
		buttons.add(new MemoryButton((ImageButton) findViewById(R.id.imageButton5), 4, bildIDs[4], "B 1"));
		buttons.add(new MemoryButton((ImageButton) findViewById(R.id.imageButton6), 5, bildIDs[5], "B 2"));
		buttons.add(new MemoryButton((ImageButton) findViewById(R.id.imageButton7), 6, bildIDs[6], "B 3"));
		buttons.add(new MemoryButton((ImageButton) findViewById(R.id.imageButton8), 7, bildIDs[7], "B 4"));
		buttons.add(new MemoryButton((ImageButton) findViewById(R.id.imageButton9), 8, bildIDs[8], "C 1"));
		buttons.add(new MemoryButton((ImageButton) findViewById(R.id.imageButton10), 9, bildIDs[9], "C 2"));
		buttons.add(new MemoryButton((ImageButton) findViewById(R.id.imageButton11), 10, bildIDs[10], "C 3"));
		buttons.add(new MemoryButton((ImageButton) findViewById(R.id.imageButton12), 11, bildIDs[11], "C 4"));
		shuffleArray(bildIDs);
		buttons.add(new MemoryButton((ImageButton) findViewById(R.id.imageButton13), 12, bildIDs[0], "D 1"));
		buttons.add(new MemoryButton((ImageButton) findViewById(R.id.imageButton14), 13, bildIDs[1], "D 2"));
		buttons.add(new MemoryButton((ImageButton) findViewById(R.id.imageButton15), 14, bildIDs[2], "D 3"));
		buttons.add(new MemoryButton((ImageButton) findViewById(R.id.imageButton16), 15, bildIDs[3], "D 4"));
		buttons.add(new MemoryButton((ImageButton) findViewById(R.id.imageButton17), 16, bildIDs[4], "E 1"));
		buttons.add(new MemoryButton((ImageButton) findViewById(R.id.imageButton18), 17, bildIDs[5], "E 2"));
		buttons.add(new MemoryButton((ImageButton) findViewById(R.id.imageButton19), 18, bildIDs[6], "E 3"));
		buttons.add(new MemoryButton((ImageButton) findViewById(R.id.imageButton20), 19, bildIDs[7], "E 4"));
		buttons.add(new MemoryButton((ImageButton) findViewById(R.id.imageButton21), 20, bildIDs[8], "F 1"));
		buttons.add(new MemoryButton((ImageButton) findViewById(R.id.imageButton22), 21, bildIDs[9], "F 2"));
		buttons.add(new MemoryButton((ImageButton) findViewById(R.id.imageButton23), 22, bildIDs[10], "F 3"));
		buttons.add(new MemoryButton((ImageButton) findViewById(R.id.imageButton24), 23, bildIDs[11], "F 4"));

		restart = (Button) findViewById(R.id.button1);
		menuButton = (Button) findViewById(R.id.button2);

		for (int i = 0; i < buttons.size(); i++) {
			buttons.get(i).getButton().setOnClickListener(this);
		}
		restart.setOnClickListener(this);
		menuButton.setOnClickListener(this);

		if (isAccessibilityEnabled && isExploreByTouchEnabled) {
			menuButton.setVisibility(View.INVISIBLE);
		}

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
			if (!(isAccessibilityEnabled && isExploreByTouchEnabled)) {
				isNeustartClicked++;
				if (isNeustartClicked == 1) {
					convertTextToSpeech("Möchten Sie das Spiel neustarten?");
				}
				if (isNeustartClicked == 2) {
					restartGame();
					convertTextToSpeech("Spiel neu gestartet!");
					isNeustartClicked = 0;
				}
			} else {
				restartGame();
				convertTextToSpeech("Spiel neu gestartet!");
			}
			break;
		case R.id.button2:
			isNeustartClicked = 0;
			convertTextToSpeech("Menü wird aufgerufen");
			intent = new Intent(getApplicationContext(), OptionMenu.class);
			if (extras != null) {
				intent.putExtra("blindenmodus", extras.getString("blindenmodus"));
				intent.putExtra("sprachgeschwindigkeit", extras.getString("sprachgeschwindigkeit"));
				startActivity(intent);
			} else {
				startActivity(intent);
			}
			break;
		}
	}

	private void turnOverCard(MemoryButton button) {
		if (blindenmodus && !(isAccessibilityEnabled && isExploreByTouchEnabled)) {
			isNeustartClicked = 0;
			if (button.isSelected() && (!button.isTurned()) && (!button.isLocked())) {
				isClicked++;
				if (isClicked == 3) {
					for (int i = 0; i < buttons.size(); i++) {
						if (!buttons.get(i).isLocked()) {
							buttons.get(i).getButton().setImageResource(R.drawable.ic_launcher);
							buttons.get(i).setIsTurned(false);
						}
					}
					isClicked = 1;
				}
				button.getButton().setImageResource(button.getBildID());
				button.setIsSelected(false);
				button.setIsTurned(true);
				readImage(button.getBildID());

				if (isClicked == 2) {
					if (checkIfPair(button)) {
						convertTextToSpeech("Paar gefunden.");
					}
				}
			} else if ((!button.isSelected()) && (!button.isLocked()) && (!button.isTurned())) {
				deleteSelections();
				button.setIsSelected(true);
				if (!(isAccessibilityEnabled && isExploreByTouchEnabled)) {
					convertTextToSpeech(button.getPosition());
				}
			} else if ((!button.isSelected()) && (!button.isLocked()) && (button.isTurned())) {
				readImage(button.getBildID());

			} else if (button.isLocked()) {
				readImage(button.getBildID());
			}
		} else {
			turnOverCardNoBlind(button);
		}

	}

	private void turnOverCardNoBlind(MemoryButton button) {
		if (isAccessibilityEnabled && isExploreByTouchEnabled){
			readImage(button.getBildID());
		}
			isNeustartClicked = 0;
		if ((!button.isTurned()) && (!button.isLocked())) {
			isClicked++;
			if (isClicked == 3) {
				for (int i = 0; i < buttons.size(); i++) {
					if (!buttons.get(i).isLocked()) {
						buttons.get(i).getButton().setImageResource(R.drawable.ic_launcher);
						buttons.get(i).setIsTurned(false);
					}
				}
				isClicked = 1;
			}
			if (isClicked == 2) {
				if (checkIfPair(button) && (isAccessibilityEnabled && isExploreByTouchEnabled)) {
					convertTextToSpeech("Paar gefunden.");
				}
			}
			button.getButton().setImageResource(button.getBildID());
			button.setIsTurned(true);

		}
	}

	private void deleteSelections() {
		for (int i = 0; i < buttons.size(); i++) {
			buttons.get(i).setIsSelected(false);
		}
	}

	private boolean checkIfPair(MemoryButton button) {
		for (int i = 0; i < buttons.size(); i++) {
			if (buttons.get(i).isTurned() && (buttons.get(i).getBildID() == button.getBildID() && (buttons.get(i).getId() != button.getId()))) {
				button.setIsLocked(true);
				buttons.get(i).setIsLocked(true);
				return true;
			}
		}
		return false;
	}

	static void shuffleArray(int[] ar) {
		Random rnd = new Random();
		for (int i = ar.length - 1; i > 0; i--) {
			int index = rnd.nextInt(i + 1);
			// Simple swap
			int a = ar[index];
			ar[index] = ar[i];
			ar[i] = a;
		}
	}

	private void restartGame() {
		shuffleArray(bildIDs);
		for (int i = 0; i < 12; i++) {
			resetMemoryButtonBools(buttons.get(i));
			buttons.get(i).setBildID(bildIDs[i]);
			buttons.get(i).getButton().setImageResource(R.drawable.ic_launcher);

		}
		shuffleArray(bildIDs);
		for (int i = 12; i < 24; i++) {
			resetMemoryButtonBools(buttons.get(i));
			buttons.get(i).setBildID(bildIDs[i - 12]);
			buttons.get(i).getButton().setImageResource(R.drawable.ic_launcher);
		}

	}

	private void resetMemoryButtonBools(MemoryButton buttonP) {
		buttonP.setIsLocked(false);
		buttonP.setIsTurned(false);
		buttonP.setIsSelected(false);
	}

	@Override
	public void onInit(int status) {
		// TODO Auto-generated method stub
		if (status == TextToSpeech.SUCCESS) {
			int result = tts.setLanguage(Locale.GERMAN);
			if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
				Log.e("error", "This Language is not supported");
			} else {
				// ConvertTextToSpeech("Leviosa");
			}
		} else
			Log.e("error", "Initilization Failed!");
	}

	private void convertTextToSpeech(String s) {
		// TODO Auto-generated method stub
		// text = et.getText().toString();
		if (s == null || "".equals(s)) {
			s = "Content not available";
			tts.speak(s, TextToSpeech.QUEUE_FLUSH, null);
		} else
			tts.speak(s, TextToSpeech.QUEUE_FLUSH, null);
	}

	private void readImage(int imgId) {
		switch (imgId) {
		case R.drawable.auto:
			tts.speak("Auto", TextToSpeech.QUEUE_FLUSH, null);
			break;
		case R.drawable.bahn:
			tts.speak("Bahn", TextToSpeech.QUEUE_FLUSH, null);
			break;
		case R.drawable.ball:
			tts.speak("Ball", TextToSpeech.QUEUE_FLUSH, null);
			break;
		case R.drawable.blume:
			tts.speak("Blume", TextToSpeech.QUEUE_FLUSH, null);
			break;
		case R.drawable.elefant:
			tts.speak("Elefant", TextToSpeech.QUEUE_FLUSH, null);
			break;
		case R.drawable.flugzeug:
			tts.speak("Flugzeug", TextToSpeech.QUEUE_FLUSH, null);
			break;
		case R.drawable.klammer:
			tts.speak("Klammer", TextToSpeech.QUEUE_FLUSH, null);
			break;
		case R.drawable.lampe:
			tts.speak("Lampe", TextToSpeech.QUEUE_FLUSH, null);
			break;
		case R.drawable.rakete:
			tts.speak("Rakete", TextToSpeech.QUEUE_FLUSH, null);
			break;
		case R.drawable.schmetterling:
			tts.speak("Schmetterling", TextToSpeech.QUEUE_FLUSH, null);
			break;
		case R.drawable.telefon:
			tts.speak("Telefon", TextToSpeech.QUEUE_FLUSH, null);
			break;
		case R.drawable.vogel:
			tts.speak("Vogel", TextToSpeech.QUEUE_FLUSH, null);
			break;
		default:
			// Brandy
			break;
		}
	}
}
