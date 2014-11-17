package com.example.projectleviosa;

import android.accessibilityservice.AccessibilityService;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.accessibility.AccessibilityManager;

public class MainActivity extends Activity {

	private Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.activity_main);
		AccessibilityManager am = (AccessibilityManager) getSystemService(ACCESSIBILITY_SERVICE);
		boolean isAccessibilityEnabled = am.isEnabled();
		boolean isExploreByTouchEnabled = am.isTouchExplorationEnabled();
		
		
		if (isExploreByTouchEnabled) {
			intent = new Intent(this, WithTalkBack.class);
			startActivity(intent);
			
//sdsdasdasdas
		} else {
			intent = new Intent(this, NoTalkBack.class);
			startActivity(intent);
		}
	}
}