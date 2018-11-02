package co.teruh.paxbot.commands;

import java.io.IOException;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import co.teruh.paxbot.main.BotConfiguration;
import co.teruh.paxbot.util.TwitterChecker;

public class CommandLastTweet extends Command {
	
	public CommandLastTweet() {
		this.name = "lastTweet";
	}

	@Override
	protected void execute(CommandEvent event) {
		event.reply("Here is @Official_PAX's latest tweet: " + TwitterChecker.getLastTweetURL("Official_PAX"));
		event.reply("Here is @PAX_badges' latest tweet: " + TwitterChecker.getLastTweetURL("pax_badges"));
	}

}
