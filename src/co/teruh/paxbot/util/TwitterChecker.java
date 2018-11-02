package co.teruh.paxbot.util;

import java.util.List;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterChecker {
	
	private static Twitter twitter;
	
	public TwitterChecker(String[] key) {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
			.setOAuthConsumerKey(key[0])
			.setOAuthConsumerSecret(key[1])
			.setOAuthAccessToken(key[2])
			.setOAuthAccessTokenSecret(key[3]);
		TwitterFactory twitterFactory = new TwitterFactory(cb.build());
		twitter = twitterFactory.getInstance();
	}

	public static String getLastTweetURL(String twitterHandle) {
		List<Status> statusList = null;
		
		try {
			statusList = twitter.getUserTimeline("@" + twitterHandle);
		} catch (TwitterException e) {
			e.printStackTrace();
		}
		
		String url = null;
		for (Status status : statusList) {
			url = ("https://twitter.com/" + status.getUser().getScreenName() + "/status/" + status.getId());
			break;
		}
		
		return url;
	}
}
