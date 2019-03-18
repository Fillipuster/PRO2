package application;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import net.fortuna.ical4j.model.Calendar;

public class MainApp extends ListenerAdapter {

    private static ICSExtractor extractor;

    public static void main(String[] args) throws LoginException, InterruptedException {
        JDA jda = new JDABuilder(AccountType.BOT)
                .setToken("NDI1OTkxMTY4MzgwMzcwOTQ5.DZPgdw.pbv6OLtu4kRsnCavj0TOts96SBc").buildBlocking();
        jda.addEventListener(new MainApp());

        extractor = new ICSExtractor();
        
        Calendar c = new Calendar();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Message msg = event.getMessage();
        MessageChannel channel = event.getChannel();
        User user = event.getAuthor();

        if (msg.getContentRaw().substring(0, 4).equals("!ics")) {
            channel.sendMessage("Attempting to extract ICS file at [" + msg.getContentRaw().substring(5) + "]...")
                    .queue();
            extractor.setICSPath(msg.getContentRaw().substring(5));
            try {
                extractor.extract();
                channel.sendMessage("ICS file at [" + msg.getContentRaw().substring(5) + "] successfully extracted.")
                        .queue();
            } catch (Exception e) {
                System.out.println("ICS Extraction Failed!");
                e.printStackTrace();
                channel.sendMessage("Failed to extract ICS file at [" + msg.getContentRaw().substring(5) + "]!")
                        .queue();
            }
        }

        if (!extractor.hasICSPath()) {
            return;
        }

        if (msg.getContentRaw().equals("!today")) {
            LocalDate today = LocalDate.now();
            String moduleString = "";
            for (Module module : extractor.getModules()) {
                LocalDateTime start = module.getStart();
                if (start.getYear() == today.getYear() && start.getMonth() == today.getMonth()
                        && start.getDayOfMonth() == today.getDayOfMonth()) {
                    moduleString += module.getDiscordBlock() + "\n\n";
                }
            }
            channel.sendMessage("Here are todays modules " + user.getAsMention() + ": \n\n" + moduleString).queue();
        }

        if (msg.getContentRaw().equals("!tomorrow")) {
            LocalDate tomorrow = LocalDate.now().plusDays(14);
            String moduleString = "";
            for (Module module : extractor.getModules()) {
                LocalDateTime start = module.getStart();
                if (start.getYear() == tomorrow.getYear() && start.getMonth() == tomorrow.getMonth()
                        && start.getDayOfMonth() == tomorrow.getDayOfMonth()) {
                    moduleString += module.getDiscordBlock() + "\n\n";
                }
            }
            channel.sendMessage("Here are tomorrows modules " + user.getAsMention() + ": \n\n" + moduleString).queue();
        }
    }

}
