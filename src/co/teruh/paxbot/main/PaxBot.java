package co.teruh.paxbot.main;

import java.io.IOException;

import javax.security.auth.login.LoginException;

import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;

import co.teruh.paxbot.commands.CommandLastTweet;
import co.teruh.paxbot.util.TwitterChecker;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class PaxBot extends ListenerAdapter {
	
	public static void main(String[] args) throws LoginException, IOException {
		BotConfiguration botConfig = new BotConfiguration("bot.properties");
		
		String[] twitterTokens = {
				botConfig.getTwitterConsumerKey(),
				botConfig.getTwitterConsumerSecret(),
				botConfig.getTwitterAccessToken(),
				botConfig.getTwitterAccessTokenSecret()};
		
		TwitterChecker twitter = new TwitterChecker(twitterTokens);

		CommandClientBuilder builder = new CommandClientBuilder()
				.setOwnerId(botConfig.getToken())
				.setPrefix(botConfig.getPrefix())
				.addCommands(new CommandLastTweet());
		
		EventWaiter waiter = new EventWaiter();
		CommandClient client = builder.build();
		
		try {
			new JDABuilder(AccountType.BOT)
			.setToken(botConfig.getToken())
			.addEventListener(waiter)
			.addEventListener(client)
			.build();
		} catch (IllegalArgumentException e) {
			
		}
	}
}
