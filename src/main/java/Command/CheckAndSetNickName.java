package Command;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class CheckAndSetNickName extends ListenerAdapter{

    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event){
        try {
            Guild currentGuild = event.getChannel().getGuild();
            // System.out.println(NameChange.nickName);
            // System.out.println(NameChange.shouldChange);
            if (event.getAuthor().isBot() && NameChange.shouldChange) {
                NameChange.shouldChange = false;
                event.getChannel().retrieveMessageById(event.getMessageId()).queue(p -> {
                    // System.out.println(p.getEmbeds().get(0).getTitle());
                    if (p.getEmbeds().size() > 0 && p.getEmbeds().get(0) != null &&
                            Objects.equals(p.getEmbeds().get(0).getTitle(), "Success!") ||
                            Objects.equals(p.getEmbeds().get(0).getDescription(), "That character is already verified to yourself Kupo!")) {
                        // p.getEmbeds().get(0).getFooter().getText();
                        // TODO need testing
                        Role registerLoadstone = event.getGuild().getRolesByName("Register Loadstone", false).get(0);
                        if (NameChange.currentMember.getRoles().contains(registerLoadstone)) {
                            Role visitor = event.getGuild().getRolesByName("Visitor", false).get(0);
                            currentGuild.modifyMemberRoles(NameChange.currentMember,visitor).queue();
                            currentGuild.modifyNickname(Objects.requireNonNull(NameChange.currentMember),NameChange.nickName).queue();
                        }
                    }
                });
            }
        } catch (Exception e) {
            // TODO write to file
        }

    }

}