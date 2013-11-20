package com.uncc.gameday.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.uncc.gameday.R;

// TODO: Auto-generated Javadoc
/**
 * The Class Alerts.
 */
public class Alerts extends MenuActivity {
	
	/* (non-Javadoc)
	 * @see com.uncc.gameday.activities.MenuActivity#onCreate(android.os.Bundle)
	 */
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alerts);
	}
	
	/**
	 * On click timed alerts.
	 *
	 * @param view the view
	 */
	public void onClickTimedAlerts(View view) {
		int toastDuration = Toast.LENGTH_SHORT;
		if (((CheckBox) view).isChecked())
			// Enable Timed alerts
			Toast.makeText(this, "Timed alerts enabled.", toastDuration).show();
		else
			// Disable Timed alerts
			Toast.makeText(this, "Timed alerts disabled.", toastDuration).show();
	}
	
	/**
	 * On click organization alerts.
	 *
	 * @param view the view
	 */
	public void onClickOrganizationAlerts(View view) {
		int toastDuration = Toast.LENGTH_SHORT;
		if (((CheckBox) view).isChecked())
			// Enable Organization alerts
			Toast.makeText(this, "Organization alerts enabled.", toastDuration).show();
		else
			// Disable Organization alerts
			Toast.makeText(this, "Organization alerts disabled.", toastDuration).show();
	}
	
	/**
	 * On click university alerts.
	 *
	 * @param view the view
	 */
	public void onClickUniversityAlerts(View view) {
		int toastDuration = Toast.LENGTH_SHORT;
		if (((CheckBox) view).isChecked())
			// Enable University alerts
			Toast.makeText(this, "University alerts enabled.", toastDuration).show();
		else
			// Disable University alerts
			Toast.makeText(this, "University alerts disabled.", toastDuration).show();
	}
}
