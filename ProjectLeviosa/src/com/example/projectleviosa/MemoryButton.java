package com.example.projectleviosa;

import android.widget.ImageButton;

public class MemoryButton {

	ImageButton button;
	int id;
	boolean isSelected;
	boolean isTurned;
	boolean isLocked;
	int bildID;
	String position;

	MemoryButton(ImageButton buttonP, int idP, int bildIDP, String positionP) {
		if (idP >= 0) {
			id = idP;
		} else {
			throw new IllegalArgumentException();
		}
		if (buttonP != null) {
			button = buttonP;
		} else {
			throw new IllegalArgumentException();
		}
		bildID = bildIDP;
		isSelected = false;
		isTurned = false;
		isLocked = false;
		position = positionP;
	}

	public void setIsSelected(boolean value) {
		isSelected = value;
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

	public boolean isSelected() {
		return isSelected;
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

	public int getbildID() {
		return bildID;
	}
	public void setbildID(int id) {
		bildID = id;
	}
	
	public String getPosition() {
		return position;
	}

}
