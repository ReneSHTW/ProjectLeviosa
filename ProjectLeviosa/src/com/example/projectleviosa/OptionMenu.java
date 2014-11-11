package com.example.projectleviosa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class OptionMenu extends Activity implements OnClickListener {

	private Button blindenmodusBtn;
	private Button sprachgeschwindigkeitBtn;
	private Button saveAndQuit;
	private Toast toast;
	private Intent intent;
	private Bundle extras;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_option_menu);
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
			}
			if (extras.getString("sprachgeschwindigkeit").equals(
					"Sprachgeschwindigkeit: dreifach")) {
				sprachgeschwindigkeitBtn
						.setText("Sprachgeschwindigkeit: dreifach");
			}
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:
			if (blindenmodusBtn.getText().toString().equals("Blindenmodus an")) {
				blindenmodusBtn.setText(R.string.blindenmodusAus);
			} else if (blindenmodusBtn.getText().toString()
					.equals("Blindenmodus aus")) {
				blindenmodusBtn.setText(R.string.blindenmodusAn);
			}

			break;
		case R.id.button2:
			if (sprachgeschwindigkeitBtn.getText().toString()
					.equals("Sprachgeschwindigkeit: normal")) {
				sprachgeschwindigkeitBtn
						.setText(R.string.sprachgeschwindigkeitdoppelt);
			} else if (sprachgeschwindigkeitBtn.getText().toString()
					.equals("Sprachgeschwindigkeit: doppelt")) {
				sprachgeschwindigkeitBtn
						.setText(R.string.sprachgeschwindigkeitdreifach);
			} else if (sprachgeschwindigkeitBtn.getText().toString()
					.equals("Sprachgeschwindigkeit: dreifach")) {
				sprachgeschwindigkeitBtn
						.setText(R.string.sprachgeschwindigkeitnormal);
			}
			break;
		case R.id.button3:
			intent = new Intent(getApplicationContext(), MainActivity.class);
			intent.putExtra("blindenmodus", blindenmodusBtn.getText()
					.toString());
			intent.putExtra("sprachgeschwindigkeit", sprachgeschwindigkeitBtn
					.getText().toString());
			startActivity(intent);
			break;
		}

	}

	@Override
	public void onBackPressed() {
		finish();
	}

}
