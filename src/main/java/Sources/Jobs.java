package Sources;

import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.ArrayList;

public class Jobs extends ListenerAdapter {

    public static ArrayList<Role> tanks = new ArrayList<Role>();
    public static ArrayList<Role> healers = new ArrayList<Role>();
    public static ArrayList<Role> mDPS = new ArrayList<Role>();
    public static ArrayList<Role> rDPS = new ArrayList<Role>();
    public static ArrayList<Role> mrDPS = new ArrayList<Role>();

    public static void sepRolesToJobs(GuildMessageReceivedEvent event) {
        Role pld = event.getGuild().getRolesByName("Paladin", false).get(0);
        Role war = event.getGuild().getRolesByName("Warrior", false).get(0);
        Role drk = event.getGuild().getRolesByName("Dark Knight", false).get(0);
        Role gnb = event.getGuild().getRolesByName("Gunbreaker", false).get(0);
        tanks.add(pld);
        tanks.add(war);
        tanks.add(drk);
        tanks.add(gnb);

        Role whm = event.getGuild().getRolesByName("White Mage", false).get(0);
        Role sch = event.getGuild().getRolesByName("Scholar", false).get(0);
        Role ast = event.getGuild().getRolesByName("Astrologian", false).get(0);
        Role sge = event.getGuild().getRolesByName("Sage", false).get(0);
        healers.add(whm);
        healers.add(sch);
        healers.add(ast);
        healers.add(sge);

        Role mnk = event.getGuild().getRolesByName("Monk", false).get(0);
        Role drg = event.getGuild().getRolesByName("Dragoon", false).get(0);
        Role nin = event.getGuild().getRolesByName("Ninja", false).get(0);
        Role sam = event.getGuild().getRolesByName("Samurai", false).get(0);
        Role rep = event.getGuild().getRolesByName("Reaper", false).get(0);
        mDPS.add(mnk);
        mDPS.add(drg);
        mDPS.add(nin);
        mDPS.add(sam);
        mDPS.add(rep);

        Role brd = event.getGuild().getRolesByName("Bard", false).get(0);
        Role mch = event.getGuild().getRolesByName("Machinist", false).get(0);
        Role dnc = event.getGuild().getRolesByName("Dancer", false).get(0);
        rDPS.add(brd);
        rDPS.add(mch);
        rDPS.add(dnc);

        Role blm = event.getGuild().getRolesByName("Black Mage", false).get(0);
        Role sum = event.getGuild().getRolesByName("Summoner", false).get(0);
        Role rdm = event.getGuild().getRolesByName("Red Mage", false).get(0);
        mrDPS.add(blm);
        mrDPS.add(sum);
        mrDPS.add(rdm);
    }

}
