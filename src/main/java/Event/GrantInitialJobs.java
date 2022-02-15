package Event;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import Sources.Jobs;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;


import java.util.List;

public class GrantInitialJobs extends ListenerAdapter {
    public static Role tanks;
    public static Role healers;
    public static Role mDPS;
    public static Role rDPS;
    public static Role mrDPS;

    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event){

        // Role demonKing = event.getGuild().getRolesByName("Demon King", false).get(0);
        //  && Objects.requireNonNull(event.getMember()).getRoles().contains(demonKing)
        if(event.getMessage().getContentRaw().equals("!giveJobSetUp everyone")) {
            // Guild currentGuild = event.getGuild();
            event.getChannel().sendMessage("Role added to list (view terminal)").queue();
            tanks = event.getGuild().getRolesByName("Tanks", false).get(0);
            healers = event.getGuild().getRolesByName("Healers", false).get(0);
            mDPS = event.getGuild().getRolesByName("Melee DPS", false).get(0);
            rDPS = event.getGuild().getRolesByName("Physical Ranged DPS", false).get(0);
            mrDPS = event.getGuild().getRolesByName("Magical Ranged DPS", false).get(0);

            // TODO uncomment for all guild, current build is only for QA channel
            // List<Member> allMembers = event.getGuild().getMembers();
            // List<Member> allMembers = event.getChannel().getMembers();
            // System.out.println(event.getGuild().getMemberCount());
            // System.out.println(allMembers);
            Jobs.sepRolesToJobs(event);

            /* event.getChannel().sendMessage(Jobs.tanks.toString() + "\n" +
                    Jobs.healers.toString() + "\n" +
                    Jobs.mDPS.toString() + "\n" +
                    Jobs.rDPS.toString() + "\n" +
                    Jobs.mrDPS.toString()).queue();
            */


//            for (Member allMember : allMembers) {
//                for (int j = 0; j < Jobs.tanks.size(); j++) {
//                    if (allMember.getRoles().contains(Jobs.tanks.get(j))) {
//                        currentGuild.addRoleToMember(allMember, tanks).queue();
//                    }
//                }
//                for (int j = 0; j < Jobs.healers.size(); j++) {
//                    if (allMember.getRoles().contains(Jobs.healers.get(j))) {
//                        currentGuild.addRoleToMember(allMember, healers).queue();
//                    }
//                }
//                for (int j = 0; j < Jobs.mDPS.size(); j++) {
//                    if (allMember.getRoles().contains(Jobs.mDPS.get(j))) {
//                        currentGuild.addRoleToMember(allMember, mDPS).queue();
//                    }
//                }
//                for (int j = 0; j < Jobs.rDPS.size(); j++) {
//                    if (allMember.getRoles().contains(Jobs.rDPS.get(j))) {
//                        currentGuild.addRoleToMember(allMember, rDPS).queue();
//                    }
//                }
//                for (int j = 0; j < Jobs.mrDPS.size(); j++) {
//                    if (allMember.getRoles().contains(Jobs.mrDPS.get(j))) {
//                        currentGuild.addRoleToMember(allMember, mrDPS).queue();
//                    }
//                }
//            }



        }


    }




}
