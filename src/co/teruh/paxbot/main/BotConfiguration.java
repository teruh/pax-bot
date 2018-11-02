package co.teruh.paxbot.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BotConfiguration {
	
	private String token;
	private String twitterConsumerKey;
	private String twitterConsumerSecret;
	private String twitterAccessToken;
	private String twitterAccessTokenSecret;
	private String prefix;
	
	public BotConfiguration(String propFile) throws IOException {		
		InputStream ioStream = getClass().getClassLoader().getResourceAsStream(propFile);
		Properties config = new Properties();
		config.load(ioStream);
		
		setToken(config.getProperty("token"));
		setTwitterConsumerKey(config.getProperty("twitterConsumerKey"));
		setTwitterConsumerSecret(config.getProperty("twitterConsumerSecret"));
		setTwitterAccessToken(config.getProperty("twitterAccessToken"));
		setTwitterAccessTokenSecret(config.getProperty("twitterAccessTokenSecret"));
		setPrefix(config.getProperty("prefix"));
	}
	
	public void setToken(String token) {
		this.token = token;
	}
	
	public String getToken() {
		return token;
	}
	
	public String getTwitterConsumerKey() {
		return twitterConsumerKey;
	}

	public void setTwitterConsumerKey(String twitterConsumerKey) {
		this.twitterConsumerKey = twitterConsumerKey;
	}

	public String getTwitterConsumerSecret() {
		return twitterConsumerSecret;
	}

	public void setTwitterConsumerSecret(String twitterConsumerSecret) {
		this.twitterConsumerSecret = twitterConsumerSecret;
	}

	public String getTwitterAccessToken() {
		return twitterAccessToken;
	}

	public void setTwitterAccessToken(String twitterAccessToken) {
		this.twitterAccessToken = twitterAccessToken;
	}

	public String getTwitterAccessTokenSecret() {
		return twitterAccessTokenSecret;
	}

	public void setTwitterAccessTokenSecret(String twitterAccessTokenSecret) {
		this.twitterAccessTokenSecret = twitterAccessTokenSecret;
	}
	
	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
}
