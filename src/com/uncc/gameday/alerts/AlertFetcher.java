package com.uncc.gameday.alerts;

import java.util.Iterator;
import java.util.List;

import twitter4j.Paging;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import android.widget.Toast;

import com.uncc.gameday.GameDay;
import com.uncc.gameday.R;

public class AlertFetcher {
	// Class responsible for fetching all alerts as necessary.
	
	private int maxTweets = 5;
	
	public void fetchAlerts() {
		/* This method needs to be re-written to use better logic. */
		
		/*
		// Fetch all alerts. Responsible for discovering what sources need to be fetched.
		
		if (((CheckBox)findViewById(R.id.alerts_check_timed)).isChecked())
			// Fetch timed alerts
			this.fetchTimedAlerts();
		else if (((CheckBox)findViewById(R.id.alerts_check_organizations)).isChecked())
			// Fetch organization alerts
			this.fetchOrganizationAlerts();
		else if (((CheckBox)findViewById(R.id.alerts_check_university)).isChecked())
			// Fetch university alerts
			this.fetchUniversityAlerts();
		
		// And always fetch alerts made by us. Period.
		this.fetchGamedayAlerts();
		*/
	}
	
	private void fetchTimedAlerts() {
		// Process the rules for all timed alerts.
	}
	
	private void fetchOrganizationAlerts() {
		// Process fetching organization alerts (alerts retweeted by us)
		int duration = Toast.LENGTH_SHORT;
		
		try {
			String handle = GameDay.getAppContext().getString(R.string.gameday_handle);
			Twitter twitter = TwitterFactory.getSingleton();
			List<Status> statuses = twitter.getUserTimeline(handle, new Paging(1, maxTweets));
			
			// Filter for anything created by us (retweet)
			for (Iterator<Status> it = statuses.iterator(); it.hasNext();){
				// May need to switch to isRetweetByMe (documentation is awful)
				if (!it.next().isRetweet())
					it.remove();
			}
			
			// List contains all valid alerts now
			
		} catch (TwitterException e) {
			Toast.makeText(GameDay.getAppContext(),
					"Unable to fetch alerts for organizations!\nAre you connected to the internet?",
					duration).show();
			e.printStackTrace();
		}
	}
	
	private void fetchUniversityAlerts() {
		// Process fetching university alerts
		int duration = Toast.LENGTH_SHORT;
		
		try {
			String handle = GameDay.getAppContext().getString(R.string.university_handle);
			Twitter twitter = TwitterFactory.getSingleton();
			List<Status> statuses = twitter.getUserTimeline(handle, new Paging(1, maxTweets));
			
			// List contains all valid alerts now
			
		} catch (TwitterException e) {
			Toast.makeText(GameDay.getAppContext(),
					"Unable to fetch alerts for the University!\nAre you connected to the internet?",
					duration).show();
			e.printStackTrace();
		}
	}
	
	private void fetchGamedayAlerts() {
		// Process fetching alerts generated by staff of UNCCGameDay
		int duration = Toast.LENGTH_SHORT;
		
		try {
			String handle = GameDay.getAppContext().getString(R.string.gameday_handle);
			Twitter twitter = TwitterFactory.getSingleton();
			List<Status> statuses = twitter.getUserTimeline(handle, new Paging(1, maxTweets));
			
			// Filter out anything not from us
			for (Iterator<Status> it = statuses.iterator(); it.hasNext();){
				// May need to switch to isRetweetByMe (documentation is awful)
				if (it.next().isRetweet())
					it.remove();
			}
			
			// List contains all valid alerts now.
			
		} catch (TwitterException e) {
			Toast.makeText(GameDay.getAppContext(),
					"Unable to fetch alerts from Gameday!\nAre you connected to the internet?",
					duration).show();
			e.printStackTrace();
		}
	}
}