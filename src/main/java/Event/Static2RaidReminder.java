package Event;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static Command.GetRoles.sendMessageWithReactions;

public class Static2RaidReminder extends ListenerAdapter {

    // as soon as 8 yes, bot throws another embed for yes we're meeting at 8.
    // as soon as one person says no, a delay of 10 min bot will throw we will not go over time.
    private List<TextChannel> static2 = new ArrayList<>();
    private List<User> votes = new ArrayList<>();
    private int yesCount = 0;
    private String messageID;

    public void onReady(@NotNull ReadyEvent event) {
        Role static2Role = event.getJDA().getRolesByName("static 2",true).get(0);
        static2 = event.getJDA().getTextChannelsByName("the-virgin-potion-savers", true);
        ZonedDateTime currentTime = ZonedDateTime.now();
        //17 - 2
        ZonedDateTime raidHoursReminder = currentTime.withHour(15).withMinute(0).withSecond(0);

        if (currentTime.compareTo(raidHoursReminder) > 0) {
            raidHoursReminder = raidHoursReminder.plusDays(1);
        }

        Duration durationUntilNextDay = Duration.between(currentTime, raidHoursReminder);
        System.out.println(durationUntilNextDay);
        long delay = durationUntilNextDay.getSeconds();

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(() -> {

                    Calendar calendar = Calendar.getInstance();
                    int day = calendar.get(Calendar.DAY_OF_WEEK);

                    EmbedBuilder reminder = new EmbedBuilder();
                    reminder.setColor(Color.PINK);
                    reminder.setTitle("RAID REMINDER!");
                    reminder.setImage("https://preview.redd.it/mad00rrcots31.gif?width=640&crop=smart&format=png8&s=2c6b704678d915b238459cb9e7b50ee7bebbf7fb");
                    reminder.setDescription("Good afternoon " + static2Role.getAsMention() + "!\n " +
                            "This a reminder that we have raid today! \n " +
                            "Please react to ✅ if you **can start at 8pm EST today!** Its anonymous so don't be afraid to react ❌! \n" +
                            "We will only start at 8pm EST if everyone agrees. If one member didn't vote or voted ❌, we will proceed during our normal hours.\n" +
                            "Final reminder will be sent once 8/8 people have voted or 1 person voted ❌.");

                    if (day == Calendar.FRIDAY) {
                        sendMessageWithReactions(static2.get(0), reminder.build(), "✅", "❌");
                    }
                    if (day == Calendar.SATURDAY) {
                        sendMessageWithReactions(static2.get(0), reminder.build(), "✅", "❌");
                    }
                    if (day == Calendar.SUNDAY) {
                        sendMessageWithReactions(static2.get(0), reminder.build(), "✅", "❌");
                    }

                },
                delay,
                TimeUnit.DAYS.toSeconds(1),
                TimeUnit.SECONDS);

    }

    public void onGuildMessageReactionAdd(@NotNull GuildMessageReactionAddEvent event) {
        TextChannel currentChannel = event.getChannel();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDateTime now = LocalDateTime.now();

        // get message id, for delete after
        if(currentChannel.equals(static2.get(0)) && event.getReactionEmote().getName().equals("✅") && event.getUser().isBot()) {
            messageID = event.getMessageId();
        }
        if (currentChannel.equals(static2.get(0)) && event.getReactionEmote().getName().equals("✅") && !event.getUser().isBot()) {
            User currentVote = event.getUser();
            MessageReaction react = event.getReaction();
            react.removeReaction(currentVote).queue();
            if (votes.size() > 0) {
                for (User vote : votes) {
                    if (vote.equals(currentVote)) {
                        // duplicate person
                        return;
                    }
                }
            }
            votes.add(currentVote);
            yesCount++;

            // add a voting process embed
            EmbedBuilder voteProcessBlock = new EmbedBuilder();
            voteProcessBlock.setColor(Color.PINK);
            voteProcessBlock.setTitle("Vote Count for " + dtf.format(now) + ", " + now.getDayOfWeek().toString());
            voteProcessBlock.setDescription("Current vote count for going at 8pm EST:\n" + yesCount + "/8");
            event.getChannel().sendMessage(voteProcessBlock.build()).queue();

            if (yesCount == 8) {
                // send embed yes
                EmbedBuilder yesBlock = new EmbedBuilder();
                yesBlock.setTitle("Vote Result for " + dtf.format(now) + ", " + now.getDayOfWeek().toString());
                yesBlock.setDescription("Ready Check Complete. \n" +
                        "Ready: 8/8 \n" +
                        "Not Ready: 0/8 \n" +
                        "We will proceed at **8pm EST** today.");
                yesCount = 0;
                votes.clear();
                event.getChannel().sendMessage(yesBlock.build()).queue();
                Message embedToDelete = event.getChannel().retrieveMessageById(messageID).complete();
                embedToDelete.delete().queue();
            }

        }
        if (currentChannel.equals(static2.get(0)) && event.getReactionEmote().getName().equals("❌") && !event.getUser().isBot()) {
            User currentVote = event.getUser();
            MessageReaction react = event.getReaction();
            react.removeReaction(currentVote).queue();
            EmbedBuilder noBlock = new EmbedBuilder();
            noBlock.setTitle("Vote Result for " + dtf.format(now) + ", " + now.getDayOfWeek().toString());
            noBlock.setDescription("Ready Check Complete. \n" +
                    "We will proceed at **9pm EST** today.");
            yesCount = 0;
            votes.clear();
            event.getChannel().sendMessage(noBlock.build()).queue();
            Message embedToDelete = event.getChannel().retrieveMessageById(messageID).complete();
            embedToDelete.delete().queue();


        }

    }

}

