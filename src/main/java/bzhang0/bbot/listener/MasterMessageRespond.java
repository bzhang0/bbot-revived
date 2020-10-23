package bzhang0.bbot.listener;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Scanner;

public class MasterMessageRespond extends ListenerAdapter {

    public static String PREFIX = "b.";
    public static String galaxiID = "143076303736668160";

    public static TextChannel channel;
    public static Member member;

    public static Message message;
    public static String msg;
    public static String msgDisplay;

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        channel = e.getChannel();
        member = e.getMember();

        message = e.getMessage();
        msg = message.getContentRaw();
        msgDisplay = message.getContentDisplay();

        messageLog(e);

        if (msg.length() > PREFIX.length() && msg.startsWith(PREFIX) && !e.getAuthor().isBot()) {
            long startTime = System.nanoTime();
            Scanner sentMessageInput = new Scanner(msg.substring(PREFIX.length()));

            String prompt = sentMessageInput.next();

            if (prompt.equalsIgnoreCase("quit") && member.getId().equals(galaxiID)) {
                channel.sendMessage("shutting down...").complete();
                System.exit(1);
            } else if (prompt.equalsIgnoreCase("ping")) {
                channel.sendMessage("pong!").complete();
            }
        }

    }

    public void messageLog(GuildMessageReceivedEvent e) {
        System.out.println("Message in " + e.getGuild().getName() + " sent by " +
                e.getAuthor().getName() + " [" + e.getAuthor().getId() + "] in " + e.getChannel().getName() +
                ": " + e.getMessage().getContentRaw() + " ");
    }
}
