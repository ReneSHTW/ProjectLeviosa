package com.example.projectleviosa;

import android.widget.ImageButton;

public class MemoryButton {

	ImageButton button;
	boolean isTurned;
	int id;
	boolean isLocked;
	
	MemoryButton(ImageButton buttonP, int idP) {
		if (idP >= 0) {
			id = idP;
		}
		else {
			throw new IllegalArgumentException();
		}
		button = buttonP;
		isTurned = false;
		isLocked = false;
	}
	
	public void setIsTurned(boolean value) {
		isTurned = value;
	}

	public void setIsLocked(boolean value) {
		isLocked = value;
	}

	public ImageButton getButton() {
		return button;
	}


	public boolean isTurned() {
		return isTurned;
	}
	
	public boolean isLocked() {
		return isLocked;
	}


	public int getId() {
		return id;
	}

	
	
}
