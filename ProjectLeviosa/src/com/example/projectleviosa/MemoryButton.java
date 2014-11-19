package com.example.projectleviosa;

import android.widget.ImageButton;

public class MemoryButton {

	private ImageButton button;
	private int id;
	private boolean selectedStatus;
	private boolean turnedStatus;
	private boolean lockedStatus;
	private int bildID;
	private String position;

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
		selectedStatus = false;
		turnedStatus = false;
		lockedStatus = false;
		position = positionP;
	}

	public void setIsSelected(boolean value) {
		selectedStatus = value;
	}

	public void setIsTurned(boolean value) {
		turnedStatus = value;
	}

	public void setIsLocked(boolean value) {
		lockedStatus = value;
	}

	public ImageButton getButton() {
		return button;
	}

	public boolean isSelected() {
		return selectedStatus;
	}

	public boolean isTurned() {
		return turnedStatus;
	}

	public boolean isLocked() {
		return lockedStatus;
	}

	public int getId() {
		return id;
	}

	public int getBildID() {
		return bildID;
	}
	public void setBildID(int id) {
		bildID = id;
	}
	
	public String getPosition() {
		return position;
	}

}
