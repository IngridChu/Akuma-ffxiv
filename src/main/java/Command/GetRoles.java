package Command;

import Sources.Emotes;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import Event.GrantInitialJobs;
import java.awt.*;
import java.util.Objects;

public class GetRoles extends ListenerAdapter {



    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        try {
            String[] message = event.getMessage().getContentRaw().split(" ");
            Role demonKing = event.getGuild().getRolesByName("Demon King", false).get(0);
            if (message[0].equals("!setUpRoles") && Objects.requireNonNull(event.getMember()).getRoles().contains(demonKing)) {
                EmbedBuilder rolesEmbed = new EmbedBuilder();
                rolesEmbed.setColor(Color.GREEN);
                rolesEmbed.setTitle("Please React to the Job you Play!");
                rolesEmbed.setDescription("Please put down the roles you're most comfortable using in high end content and use the reaction below to grant you the job!\n\n" +
                        "To remove a role, simply unreact to the embed again!");
                rolesEmbed.setFooter("\"GNB best job\" - Sun Tzu");
                rolesEmbed.setThumbnail("https://snazzyj.github.io/xivcharactertracker/images/job-icons/gnb.png");
                // TODO use \:name: to get name and ID of an emoji, get all
                sendMessageWithReactions(event.getChannel(), rolesEmbed.build(),
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
        String currentJob = event.getReactionEmote().getName();
        // TODO remove debug statement
        System.out.println(currentJob);
        TextChannel getRoles = event.getGuild().getTextChannelsByName("get-roles", false).get(0);
        if (!event.getUser().isBot() && event.getChannel().equals(getRoles)) {
            switch (currentJob.toLowerCase()) {

                case "astrologian" -> {
                    Role astro = event.getGuild().getRolesByName("Astrologian", false).get(0);
                    currentGuild.addRoleToMember(event.getMember(), astro).queue();
                    currentGuild.addRoleToMember(event.getMember(), GrantInitialJobs.healers).queue();
                }
                case "blackmage" -> {
                    Role blackMage = event.getGuild().getRolesByName("Black Mage", false).get(0);
                    currentGuild.addRoleToMember(event.getMember(), blackMage).queue();
                    currentGuild.addRoleToMember(event.getMember(), GrantInitialJobs.mrDPS).queue();
                }
                case "bard" -> {
                    Role bard = event.getGuild().getRolesByName("Bard", false).get(0);
                    currentGuild.addRoleToMember(event.getMember(), bard).queue();
                    currentGuild.addRoleToMember(event.getMember(), GrantInitialJobs.rDPS).queue();
                }
                case "paladin" -> {
                    Role paladin = event.getGuild().getRolesByName("Paladin", false).get(0);
                    currentGuild.addRoleToMember(event.getMember(), paladin).queue();
                    currentGuild.addRoleToMember(event.getMember(), GrantInitialJobs.tanks).queue();
                }
                case "dancer" -> {
                    Role dancer = event.getGuild().getRolesByName("Dancer", false).get(0);
                    currentGuild.addRoleToMember(event.getMember(), dancer).queue();
                    currentGuild.addRoleToMember(event.getMember(), GrantInitialJobs.rDPS).queue();
                }
                case "dragoon" -> {
                    Role dragoon = event.getGuild().getRolesByName("Dragoon", false).get(0);
                    currentGuild.addRoleToMember(event.getMember(), dragoon).queue();
                    currentGuild.addRoleToMember(event.getMember(), GrantInitialJobs.mDPS).queue();
                }
                case "darkknight" -> {
                    Role darkKnight = event.getGuild().getRolesByName("Dark Knight", false).get(0);
                    currentGuild.addRoleToMember(event.getMember(), darkKnight).queue();
                    currentGuild.addRoleToMember(event.getMember(), GrantInitialJobs.tanks).queue();
                }
                case "gunbreaker" -> {
                    Role gunBreaker = event.getGuild().getRolesByName("Gunbreaker", false).get(0);
                    currentGuild.addRoleToMember(event.getMember(), gunBreaker).queue();
                    currentGuild.addRoleToMember(event.getMember(), GrantInitialJobs.tanks).queue();
                }
                case "machinist" -> {
                    Role mach = event.getGuild().getRolesByName("Machinist", false).get(0);
                    currentGuild.addRoleToMember(event.getMember(), mach).queue();
                    currentGuild.addRoleToMember(event.getMember(), GrantInitialJobs.rDPS).queue();
                }
                case "monk" -> {
                    Role monk = event.getGuild().getRolesByName("Monk", false).get(0);
                    currentGuild.addRoleToMember(event.getMember(), monk).queue();
                    currentGuild.addRoleToMember(event.getMember(), GrantInitialJobs.mDPS).queue();
                }
                case "ninja" -> {
                    Role ninja = event.getGuild().getRolesByName("Ninja", false).get(0);
                    currentGuild.addRoleToMember(event.getMember(), ninja).queue();
                    currentGuild.addRoleToMember(event.getMember(), GrantInitialJobs.mDPS).queue();
                }
                case "redmage" -> {
                    Role rmage = event.getGuild().getRolesByName("Red Mage", false).get(0);
                    currentGuild.addRoleToMember(event.getMember(), rmage).queue();
                    currentGuild.addRoleToMember(event.getMember(), GrantInitialJobs.mrDPS).queue();
                }
                case "samurai" -> {
                    Role samurai = event.getGuild().getRolesByName("Samurai", false).get(0);
                    currentGuild.addRoleToMember(event.getMember(), samurai).queue();
                    currentGuild.addRoleToMember(event.getMember(), GrantInitialJobs.mDPS).queue();
                }
                case "scholar" -> {
                    Role scholar = event.getGuild().getRolesByName("Scholar", false).get(0);
                    currentGuild.addRoleToMember(event.getMember(), scholar).queue();
                    currentGuild.addRoleToMember(event.getMember(), GrantInitialJobs.healers).queue();
                }
                case "summoner" -> {
                    Role smon = event.getGuild().getRolesByName("Summoner", false).get(0);
                    currentGuild.addRoleToMember(event.getMember(), smon).queue();
                    currentGuild.addRoleToMember(event.getMember(), GrantInitialJobs.mrDPS).queue();
                }
                case "warrior" -> {
                    Role warrior = event.getGuild().getRolesByName("Warrior", false).get(0);
                    currentGuild.addRoleToMember(event.getMember(), warrior).queue();
                    currentGuild.addRoleToMember(event.getMember(), GrantInitialJobs.tanks).queue();
                }
                case "whitemage" -> {
                    Role whm = event.getGuild().getRolesByName("White Mage", false).get(0);
                    currentGuild.addRoleToMember(event.getMember(), whm).queue();
                    System.out.println(GrantInitialJobs.healers);
                    currentGuild.addRoleToMember(event.getMember(), GrantInitialJobs.healers).queue();
                }
                case "sage" -> {
                    Role sge = event.getGuild().getRolesByName("Sage", false).get(0);
                    currentGuild.addRoleToMember(event.getMember(), sge).queue();
                    currentGuild.addRoleToMember(event.getMember(), GrantInitialJobs.healers).queue();
                }
                case "reaper" -> {
                    Role rpr = event.getGuild().getRolesByName("Reaper", false).get(0);
                    currentGuild.addRoleToMember(event.getMember(), rpr).queue();
                    currentGuild.addRoleToMember(event.getMember(), GrantInitialJobs.mDPS).queue();
                }

            }
        }
    }

    public static void sendMessageWithReactions(MessageChannel channel, MessageEmbed embed, String... reactions) {
        channel.sendMessage(embed).queue(msg -> {
            for (String reaction : reactions) {
                msg.addReaction(reaction).queue();
            }
        });

    }

}
