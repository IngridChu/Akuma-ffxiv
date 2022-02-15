package Command;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import static Command.GetRoles.sendMessageWithReactions;

public class RandomEventSender extends ListenerAdapter {

    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event){
        try{
            String[] message = event.getMessage().getContentRaw().split(" ");
            if (message[0].equals("!ARandomEvent") && !event.getAuthor().isBot()) {
                AkumasEvent currentEvent = generateRandomEvents();
                EmbedBuilder randomEventEmbed = new EmbedBuilder();
                randomEventEmbed.setTitle(currentEvent.getEventName());
                randomEventEmbed.setDescription("Time: " + currentEvent.getEventTime() + " \n"+
                        currentEvent.getDescription() + " \n"
                        + "Please react ✅ if you accept this suggestion or ❌ to reject.");
                randomEventEmbed.setImage(currentEvent.getImage());
                randomEventEmbed.setColor(Color.YELLOW); // TODO: Death: cuz we're all Asians!!!
                sendMessageWithReactions(event.getChannel(), randomEventEmbed.build(), "✅","❌");

            }
        } catch (Exception ignored){
            // TODO: write to file
        }
    }



    public static AkumasEvent generateRandomEvents() {
        ArrayList<AkumasEvent> eventArray = new ArrayList<>();
        AkumasEvent rpNight = new AkumasEvent("RP Night","placeHolder","placeHolder","https://static.wikia.nocookie.net/gintama/images/4/45/Elimovie2.jpg/revision/latest/scale-to-width-down/250?cb=20140207155336");
        AkumasEvent mountFarm = new AkumasEvent("Mount Farm","placeHolder","placeHolder","https://static.wikia.nocookie.net/gintama/images/4/45/Elimovie2.jpg/revision/latest/scale-to-width-down/250?cb=20140207155336");
        AkumasEvent teachOldEx = new AkumasEvent("Teaching Old Extremes","placeHolder","placeHolder","https://static.wikia.nocookie.net/gintama/images/4/45/Elimovie2.jpg/revision/latest/scale-to-width-down/250?cb=20140207155336");
        AkumasEvent teachOldSav = new AkumasEvent("Teaching Old Savages","placeHolder","placeHolder","https://static.wikia.nocookie.net/gintama/images/4/45/Elimovie2.jpg/revision/latest/scale-to-width-down/250?cb=20140207155336");
        AkumasEvent rorysPlace = new AkumasEvent("Go to Rory's Cafe","placeHolder","placeHolder","https://static.wikia.nocookie.net/gintama/images/4/45/Elimovie2.jpg/revision/latest/scale-to-width-down/250?cb=20140207155336");
        AkumasEvent giveKenjiGil = new AkumasEvent("Give Kenji Gil","placeHolder","placeHolder","https://static.wikia.nocookie.net/gintama/images/4/45/Elimovie2.jpg/revision/latest/scale-to-width-down/250?cb=20140207155336");
        AkumasEvent giveDeathGil = new AkumasEvent("Give Death Gil","placeHolder","placeHolder","https://static.wikia.nocookie.net/gintama/images/4/45/Elimovie2.jpg/revision/latest/scale-to-width-down/250?cb=20140207155336");

        eventArray.add(rpNight);
        eventArray.add(mountFarm);
        eventArray.add(teachOldEx);
        eventArray.add(teachOldSav);
        eventArray.add(rorysPlace);
        eventArray.add(giveKenjiGil);
        eventArray.add(giveDeathGil);

        Random rng = new Random();
        int randomEventIndex = rng.nextInt(eventArray.size());

        return eventArray.get(randomEventIndex);
    }

}
