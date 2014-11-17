package com.example.projectleviosa;

import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class OptionMenu extends Activity implements OnClickListener, OnInitListener {

	private Button blindenmodusBtn;
	private Button sprachgeschwindigkeitBtn;
	private Button saveAndQuit;
	private Toast toast;
	private Intent intent;
	private Bundle extras;
	private TextToSpeech tts;
	private float sprachgeschwindigkeit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_option_menu);
		sprachgeschwindigkeit = 1.0f;
		tts = new TextToSpeech(this, this);
		extras = getIntent().getExtras();
		blindenmodusBtn = (Button) findViewById(R.id.button1);
		blindenmodusBtn.setOnClickListener(this);
		sprachgeschwindigkeitBtn = (Button) findViewById(R.id.button2);
		sprachgeschwindigkeitBtn.setOnClickListener(this);
		saveAndQuit = (Button) findViewById(R.id.button3);
		saveAndQuit.setOnClickListener(this);
		if (extras != null) {
			if (extras.getString("blindenmodus").equals("Blindenmodus aus")) {
				blindenmodusBtn.setText("Blindenmodus aus");
			}
			if (extras.getString("sprachgeschwindigkeit").equals(
					"Sprachgeschwindigkeit: doppelt")) {
				sprachgeschwindigkeitBtn
						.setText("Sprachgeschwindigkeit: doppelt");
				sprachgeschwindigkeit = 2.0f;
			}
			if (extras.getString("sprachgeschwindigkeit").equals(
					"Sprachgeschwindigkeit: dreifach")) {
				sprachgeschwindigkeitBtn
						.setText("Sprachgeschwindigkeit: dreifach");
				sprachgeschwindigkeit = 3.0f;
			}
		}
		tts.setSpeechRate(sprachgeschwindigkeit);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:
			if (blindenmodusBtn.getText().toString().equals("Blindenmodus an")) {
				blindenmodusBtn.setText(R.string.blindenmodusAus);
				convertTextToSpeech("Blindenmodus ausgeschaltet");
			} else if (blindenmodusBtn.getText().toString()
					.equals("Blindenmodus aus")) {
				blindenmodusBtn.setText(R.string.blindenmodusAn);
				convertTextToSpeech("Blindenmodus eingeschaltet");
			}

			break;
		case R.id.button2:
			if (sprachgeschwindigkeitBtn.getText().toString()
					.equals("Sprachgeschwindigkeit: normal")) {
				sprachgeschwindigkeitBtn
						.setText(R.string.sprachgeschwindigkeitdoppelt);
				convertTextToSpeech("doppelte Sprachgeschwindigkeit");
			} else if (sprachgeschwindigkeitBtn.getText().toString()
					.equals("Sprachgeschwindigkeit: doppelt")) {
				sprachgeschwindigkeitBtn
						.setText(R.string.sprachgeschwindigkeitdreifach);
				convertTextToSpeech("dreifache Sprachgeschwindigkeit");
			} else if (sprachgeschwindigkeitBtn.getText().toString()
					.equals("Sprachgeschwindigkeit: dreifach")) {
				sprachgeschwindigkeitBtn
						.setText(R.string.sprachgeschwindigkeitnormal);
				convertTextToSpeech("normale Sprachgeschwindigkeit");
			}
			break;
		case R.id.button3:
			intent = new Intent(getApplicationContext(), NoTalkbackActivity.class);
			intent.putExtra("blindenmodus", blindenmodusBtn.getText()
					.toString());
			intent.putExtra("sprachgeschwindigkeit", sprachgeschwindigkeitBtn
					.getText().toString());
			convertTextToSpeech("Speichern und zurück");
			startActivity(intent);
			break;
		}

	}

	@Override
	public void onBackPressed() {
		finish();
	}

	@Override
	public void onInit(int status) {
		// TODO Auto-generated method stub
		if (status == TextToSpeech.SUCCESS) {
			int result = tts.setLanguage(Locale.GERMAN);
			if (result == TextToSpeech.LANG_MISSING_DATA
					|| result == TextToSpeech.LANG_NOT_SUPPORTED) {
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

}
