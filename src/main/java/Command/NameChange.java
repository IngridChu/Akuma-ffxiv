package Command;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

// Get the nickname
public class NameChange extends ListenerAdapter {

    public static String nickName;
    public static Member currentMember;
    public static boolean shouldChange;
    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        try {
            String[] command = event.getMessage().getContentRaw().split(" ");
            String[] dataCenter = {"Behemoth", "Excalibur", "Exodus", "Famfrit", "Hyperion", "Lamia", "Leviathan", "Ultros"};
            // !iam [Server] [FirstName] [LastName]
            if (command[0].equals("!iam")){
                for (String s : dataCenter) {
                    if (command[1].equalsIgnoreCase(s)) {
                        // event.getChannel().sendMessage("Entered correct servers.").queue();
                        shouldChange = true;
                        String firstName = command[2];
                        String lastName = command[3];
                        nickName = firstName + " " + lastName;
                        currentMember = event.getMessage().getMember();
                        // currentGuild.modifyNickname(Objects.requireNonNull(event.getMessage().getMember()),firstName + " " + lastName).queue();
                        break;
                    }
                }

            }
        } catch(Exception e){
            // TODO write to file
        }


    }

}