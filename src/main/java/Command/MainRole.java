package Command;

import Sources.Emotes;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.Objects;

public class MainRole extends ListenerAdapter {

    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        try {
            String[] message = event.getMessage().getContentRaw().split(" ");
            Role demonKing = event.getGuild().getRolesByName("Demon King", false).get(0);
            if (message[0].equals("!setUpMainRoles") && Objects.requireNonNull(event.getMember()).getRoles().contains(demonKing)) {
                EmbedBuilder rolesEmbed = new EmbedBuilder();
                rolesEmbed.setColor(Color.GREEN);
                rolesEmbed.setTitle("Please Select your **MAIN** job!");
                rolesEmbed.setDescription("Please react to your **MAIN** job! \n" +
                        "Note that this will be the icon that appears next to your name, so please only select **ONE**!");
                rolesEmbed.setFooter("\"GNB best job\" - Sun Tzu");
                rolesEmbed.setThumbnail("https://snazzyj.github.io/xivcharactertracker/images/job-icons/gnb.png");
                // TODO use \:name: to get name and ID of an emoji, get all
                GetRoles.sendMessageWithReactions(event.getChannel(), rolesEmbed.build(),
                        Emotes.PLD, Emotes.WAR, Emotes.DRK, Emotes.GNB,
                        Emotes.WHM, Emotes.SCH, Emotes.AST, Emotes.SGE,
                        Emotes.MNK, Emotes.DRG, Emotes.NIN, Emotes.SAM, Emotes.RPR,
                        Emotes.BRD, Emotes.MCH, Emotes.DNC,
                        Emotes.BLM, Emotes.SMN, Emotes.RDM);
            }

        } catch (Exception e) {
            // TODO write to file
        }

    }

    public void onGuildMessageReactionAdd(GuildMessageReactionAddEvent event) {
        Guild currentGuild = event.getGuild();
        String messageID = event.getMessageId();
        String currentJob = event.getReactionEmote().getName();
        // TODO how do i make sure the bot assign the correct role?
        TextChannel getRoles = event.getGuild().getTextChannelsByName("get-roles", false).get(0);
        event.getChannel().retrieveMessageById(messageID).queue(p -> {
            // System.out.println(p.getEmbeds().get(0).getTitle());
            if (!event.getUser().isBot() && event.getChannel().equals(getRoles) && p.getEmbeds().size() > 0 && p.getEmbeds().get(0) != null &&
                    Objects.equals(p.getEmbeds().get(0).getTitle(), "Please Select your **MAIN** job!")) {
                switch (currentJob.toLowerCase()) {
                    case "astrologian" -> {
                        Role astro = event.getGuild().getRolesByName("Astrologian Main", false).get(0);
                        currentGuild.addRoleToMember(event.getMember(), astro).queue();
                    }
                    case "blackmage" -> {
                        Role blackMage = event.getGuild().getRolesByName("Black Mage Main", false).get(0);
                        currentGuild.addRoleToMember(event.getMember(), blackMage).queue();
                    }
                    case "bard" -> {
                        Role bard = event.getGuild().getRolesByName("Bard Main", false).get(0);
                        currentGuild.addRoleToMember(event.getMember(), bard).queue();
                    }
                    case "paladin" -> {
                        Role paladin = event.getGuild().getRolesByName("Paladin Main", false).get(0);
                        currentGuild.addRoleToMember(event.getMember(), paladin).queue();
                    }
                    case "dancer" -> {
                        Role dancer = event.getGuild().getRolesByName("Dancer Main", false).get(0);
                        currentGuild.addRoleToMember(event.getMember(), dancer).queue();
                    }
                    case "dragoon" -> {
                        Role dragoon = event.getGuild().getRolesByName("Dragoon Main", false).get(0);
                        currentGuild.addRoleToMember(event.getMember(), dragoon).queue();
                    }
                    case "darkknight" -> {
                        Role darkKnight = event.getGuild().getRolesByName("Dark Knight Main", false).get(0);
                        currentGuild.addRoleToMember(event.getMember(), darkKnight).queue();
                    }
                    case "gunbreaker" -> {
                        Role gunBreaker = event.getGuild().getRolesByName("Gunbreaker Main", false).get(0);
                        currentGuild.addRoleToMember(event.getMember(), gunBreaker).queue();
                    }
                    case "machinist" -> {
                        Role mach = event.getGuild().getRolesByName("Machinist Main", false).get(0);
                        currentGuild.addRoleToMember(event.getMember(), mach).queue();
                    }
                    case "monk" -> {
                        Role monk = event.getGuild().getRolesByName("Monk Main", false).get(0);
                        currentGuild.addRoleToMember(event.getMember(), monk).queue();
                    }
                    case "ninja" -> {
                        Role ninja = event.getGuild().getRolesByName("Ninja Main", false).get(0);
                        currentGuild.addRoleToMember(event.getMember(), ninja).queue();
                    }
                    case "redmage" -> {
                        Role rmage = event.getGuild().getRolesByName("Red Mage Main", false).get(0);
                        currentGuild.addRoleToMember(event.getMember(), rmage).queue();
                    }
                    case "samurai" -> {
                        Role samurai = event.getGuild().getRolesByName("Samurai Main", false).get(0);
                        currentGuild.addRoleToMember(event.getMember(), samurai).queue();
                    }
                    case "scholar" -> {
                        Role scholar = event.getGuild().getRolesByName("Scholar Main", false).get(0);
                        currentGuild.addRoleToMember(event.getMember(), scholar).queue();
                    }
                    case "summoner" -> {
                        Role smon = event.getGuild().getRolesByName("Summoner Main", false).get(0);
                        currentGuild.addRoleToMember(event.getMember(), smon).queue();
                    }
                    case "warrior" -> {
                        Role warrior = event.getGuild().getRolesByName("Warrior Main", false).get(0);
                        currentGuild.addRoleToMember(event.getMember(), warrior).queue();
                    }
                    case "whitemage" -> {
                        Role whm = event.getGuild().getRolesByName("White Mage Main", false).get(0);
                        currentGuild.addRoleToMember(event.getMember(), whm).queue();
                    }
                    case "reaper" -> {
                        Role rpr = event.getGuild().getRolesByName("Reaper Main", false).get(0);
                        currentGuild.addRoleToMember(event.getMember(), rpr).queue();
                    }
                    case "sage" -> {
                        Role sge = event.getGuild().getRolesByName("Sage Main", false).get(0);
                        currentGuild.addRoleToMember(event.getMember(), sge).queue();
                    }

                }
            }
        });
    }
}