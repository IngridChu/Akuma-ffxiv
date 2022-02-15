package Event;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.Objects;

import static Command.GetRoles.sendMessageWithReactions;

public class PronounsRole extends ListenerAdapter {

    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        if (event.getMessage().getContentRaw().equals("!setUp gender")) {
            EmbedBuilder gender = new EmbedBuilder();
            gender.setColor(Color.CYAN);
            gender.setTitle("Pronouns");
            gender.setDescription("❤: She/Her/Hers\n" +
                    "\uD83E\uDD0D: He/Him/His\n" +
                    "\uD83D\uDC9B: They/Them/Theirs\n" +
                    "\uD83D\uDC9A: He/They\n" +
                    "\uD83D\uDC99: She/They\n" +
                    "\uD83D\uDC9C: Any Pronouns");
            gender.setImage("https://cdn.discordapp.com/attachments/848049474827583548/925736068144320552/2021-11-08_18-58-15-724_GlaceEorzea_Milk_CottonCandy.png");
            sendMessageWithReactions(event.getChannel(), gender.build(), "❤", "\uD83E\uDD0D", "\uD83D\uDC9B"
                    , "\uD83D\uDC9A", "\uD83D\uDC99", "\uD83D\uDC9C");
        }
    }

    public void onGuildMessageReactionAdd(GuildMessageReactionAddEvent event) {
        String currentReaction = event.getReaction().getReactionEmote().getName();
        Guild currentGuild = event.getGuild();
        TextChannel getRoles = event.getGuild().getTextChannelsByName("get-roles", false).get(0);

        if(!event.getUser().isBot() && event.getChannel().equals(getRoles)) {

            switch (currentReaction) {
                case "❤" -> {
                    Role role = event.getGuild().getRolesByName("She/Her/Hers", false).get(0);
                    currentGuild.addRoleToMember(event.getMember(), role).queue();
                }
                case "\uD83E\uDD0D" -> {
                    Role role = event.getGuild().getRolesByName("He/Him/His", false).get(0);
                    currentGuild.addRoleToMember(event.getMember(), role).queue();
                }
                case "\uD83D\uDC9B" -> {
                    Role role = event.getGuild().getRolesByName("They/Them/Theirs", false).get(0);
                    currentGuild.addRoleToMember(event.getMember(), role).queue();
                }
                case "\uD83D\uDC9A" -> {
                    Role role = event.getGuild().getRolesByName("He/They", false).get(0);
                    currentGuild.addRoleToMember(event.getMember(), role).queue();
                }
                case "\uD83D\uDC99" -> {
                    Role role = event.getGuild().getRolesByName("She/They", false).get(0);
                    currentGuild.addRoleToMember(event.getMember(), role).queue();
                }
                case "\uD83D\uDC9C" -> {
                    Role role = event.getGuild().getRolesByName("Any Pronouns", false).get(0);
                    currentGuild.addRoleToMember(event.getMember(), role).queue();
                }

            }
        }



    }

    public void onGuildMessageReactionRemove(@NotNull GuildMessageReactionRemoveEvent event) {
        String currentReaction = event.getReaction().getReactionEmote().getName();
        Guild currentGuild = event.getGuild();
        Member currentUser = event.retrieveMember().complete();
        // TODO change to get-roles
        TextChannel getRoles = event.getGuild().getTextChannelsByName("get-roles", false).get(0);

        if (!event.getUser().isBot() && event.getChannel().equals(getRoles)) {
            switch (currentReaction.toLowerCase()) {
                case "❤" -> {
                    Role role = event.getGuild().getRolesByName("She/Her/Hers", false).get(0);
                    if (Objects.requireNonNull(currentUser).getRoles().contains(role)) {
                        currentGuild.removeRoleFromMember(currentUser, role).queue();
                    }
                }
                case "\uD83E\uDD0D" -> {
                    Role role = event.getGuild().getRolesByName("He/Him/His", false).get(0);
                    if (Objects.requireNonNull(currentUser).getRoles().contains(role)) {
                        currentGuild.removeRoleFromMember(currentUser, role).queue();
                    }
                }
                case "\uD83D\uDC9B" -> {
                    Role role = event.getGuild().getRolesByName("They/Them/Theirs", false).get(0);
                    if (Objects.requireNonNull(currentUser).getRoles().contains(role)) {
                        currentGuild.removeRoleFromMember(currentUser, role).queue();
                    }
                }
                case "\uD83D\uDC9A" -> {
                    Role role = event.getGuild().getRolesByName("He/They", false).get(0);
                    if (Objects.requireNonNull(currentUser).getRoles().contains(role)) {
                        currentGuild.removeRoleFromMember(currentUser, role).queue();
                    }
                }
                case "\uD83D\uDC99" -> {
                    Role role = event.getGuild().getRolesByName("She/They", false).get(0);
                    if (Objects.requireNonNull(currentUser).getRoles().contains(role)) {
                        currentGuild.removeRoleFromMember(currentUser, role).queue();
                    }
                }
                case "\uD83D\uDC9C" -> {
                    Role role = event.getGuild().getRolesByName("Any Pronouns", false).get(0);
                    if (Objects.requireNonNull(currentUser).getRoles().contains(role)) {
                        currentGuild.removeRoleFromMember(currentUser, role).queue();
                    }
                }

            }

        }

    }
}
