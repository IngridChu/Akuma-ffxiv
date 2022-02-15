package Event;

import Event.GrantInitialJobs;
import Sources.Jobs;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

public class RemoveRoles extends ListenerAdapter {

    public void onGuildMessageReactionRemove(@NotNull GuildMessageReactionRemoveEvent event) {
        String currentReaction = event.getReaction().getReactionEmote().getName();
        Guild currentGuild = event.getGuild();
        Member currentUser = event.retrieveMember().complete();
        // System.out.println("reaction " + currentReaction);
        // System.out.println("guild " + currentGuild);
        // System.out.println("user " + currentUser);
        switch (currentReaction) {
            case "Astrologian" -> {
                Role astro = event.getGuild().getRolesByName("Astrologian", false).get(0);
                if (Objects.requireNonNull(currentUser).getRoles().contains(astro)) {
                    currentGuild.removeRoleFromMember(currentUser, astro).queue();
                    removeJobIfNone(currentUser, currentGuild, astro);
                }
            }
            case "Bard" -> {
                Role brd = event.getGuild().getRolesByName("Bard", false).get(0);
                if (Objects.requireNonNull(currentUser).getRoles().contains(brd)) {
                    currentGuild.removeRoleFromMember(currentUser, brd).queue();
                    removeJobIfNone(currentUser, currentGuild, brd);
                }
            }
            case "BlackMage" -> {
                Role blm = event.getGuild().getRolesByName("Black Mage", false).get(0);
                if (Objects.requireNonNull(currentUser).getRoles().contains(blm)) {
                    currentGuild.removeRoleFromMember(currentUser, blm).queue();
                    removeJobIfNone(currentUser, currentGuild, blm);
                }
            }
            case "Dancer" -> {
                Role dnc = event.getGuild().getRolesByName("Dancer", false).get(0);
                if (Objects.requireNonNull(currentUser).getRoles().contains(dnc)) {
                    currentGuild.removeRoleFromMember(currentUser, dnc).queue();
                    removeJobIfNone(currentUser, currentGuild, dnc);
                }
            }
            case "DarkKnight" -> {
                Role drk = event.getGuild().getRolesByName("Dark Knight", false).get(0);
                if (Objects.requireNonNull(currentUser).getRoles().contains(drk)) {
                    currentGuild.removeRoleFromMember(currentUser, drk).queue();
                    removeJobIfNone(currentUser, currentGuild, drk);
                }
            }

            case "Dragoon" -> {
                Role drg = event.getGuild().getRolesByName("Dragoon", false).get(0);
                if (Objects.requireNonNull(currentUser).getRoles().contains(drg)) {
                    currentGuild.removeRoleFromMember(currentUser, drg).queue();
                    removeJobIfNone(currentUser, currentGuild, drg);
                }
            }
            case "Gunbreaker" -> {
                Role gnb = event.getGuild().getRolesByName("Gunbreaker", false).get(0);
                if (Objects.requireNonNull(currentUser).getRoles().contains(gnb)) {
                    currentGuild.removeRoleFromMember(currentUser, gnb).queue();
                    removeJobIfNone(currentUser, currentGuild, gnb);
                }
            }
            case "Machinist" -> {
                Role mch = event.getGuild().getRolesByName("Machinist", false).get(0);
                if (Objects.requireNonNull(currentUser).getRoles().contains(mch)) {
                    currentGuild.removeRoleFromMember(currentUser, mch).queue();
                    removeJobIfNone(currentUser, currentGuild, mch);
                }
            }
            case "Monk" -> {
                Role mnk = event.getGuild().getRolesByName("Monk", false).get(0);
                if (Objects.requireNonNull(currentUser).getRoles().contains(mnk)) {
                    currentGuild.removeRoleFromMember(currentUser, mnk).queue();
                    removeJobIfNone(currentUser, currentGuild, mnk);
                }
            }
            case "Ninja" -> {
                Role nin = event.getGuild().getRolesByName("Ninja", false).get(0);
                if (Objects.requireNonNull(currentUser).getRoles().contains(nin)) {
                    currentGuild.removeRoleFromMember(currentUser, nin).queue();
                    removeJobIfNone(currentUser, currentGuild, nin);
                }
            }
            case "Paladin" -> {
                Role pld = event.getGuild().getRolesByName("Paladin", false).get(0);
                if (Objects.requireNonNull(currentUser).getRoles().contains(pld)) {
                    currentGuild.removeRoleFromMember(currentUser, pld).queue();
                    removeJobIfNone(currentUser, currentGuild, pld);
                }
            }
            case "RedMage" -> {
                Role rdm = event.getGuild().getRolesByName("Red Mage", false).get(0);
                if (Objects.requireNonNull(currentUser).getRoles().contains(rdm)) {
                    currentGuild.removeRoleFromMember(currentUser, rdm).queue();
                    removeJobIfNone(currentUser, currentGuild, rdm);
                }
            }
            case "Samurai" -> {
                Role sam = event.getGuild().getRolesByName("Samurai", false).get(0);
                if (Objects.requireNonNull(currentUser).getRoles().contains(sam)) {
                    currentGuild.removeRoleFromMember(currentUser, sam).queue();
                    removeJobIfNone(currentUser, currentGuild, sam);
                }
            }
            case "Scholar" -> {
                Role sam = event.getGuild().getRolesByName("Scholar", false).get(0);
                if (Objects.requireNonNull(currentUser).getRoles().contains(sam)) {
                    currentGuild.removeRoleFromMember(currentUser, sam).queue();
                    removeJobIfNone(currentUser, currentGuild, sam);
                }
            }
            case "Summoner" -> {
                Role smn = event.getGuild().getRolesByName("Summoner", false).get(0);
                if (Objects.requireNonNull(currentUser).getRoles().contains(smn)) {
                    currentGuild.removeRoleFromMember(currentUser, smn).queue();
                    removeJobIfNone(currentUser, currentGuild, smn);
                }
            }
            case "Warrior" -> {
                Role war = event.getGuild().getRolesByName("Warrior", false).get(0);
                if (Objects.requireNonNull(currentUser).getRoles().contains(war)) {
                    currentGuild.removeRoleFromMember(currentUser, war).queue();
                    removeJobIfNone(currentUser, currentGuild, war);
                }
            }
            case "WhiteMage" -> {
                Role whm = event.getGuild().getRolesByName("White Mage", false).get(0);
                if (Objects.requireNonNull(currentUser).getRoles().contains(whm)) {
                    currentGuild.removeRoleFromMember(currentUser, whm).queue();
                    removeJobIfNone(currentUser, currentGuild, whm);
                }
            }
            case "Sage" -> {
                Role sge = event.getGuild().getRolesByName("Sage", false).get(0);
                if (Objects.requireNonNull(currentUser).getRoles().contains(sge)) {
                    // System.out.println("in sage function");
                    currentGuild.removeRoleFromMember(currentUser, sge).queue();
                    // System.out.println("After remove: " + currentUser.getRoles());
                    removeJobIfNone(currentUser, currentGuild, sge);

                }
            }
            case "Reaper" -> {
                Role rpr = event.getGuild().getRolesByName("Reaper", false).get(0);
                if (Objects.requireNonNull(currentUser).getRoles().contains(rpr)) {
                    currentGuild.removeRoleFromMember(currentUser, rpr).queue();
                    removeJobIfNone(currentUser, currentGuild, rpr);
                }
            }
        }

    }

    public void removeJobIfNone(Member user, Guild guild, Role role) {
        List<Role> userRoles = user.getRoles();
        // System.out.println(userRoles);
        int hasTank = 0;
        int hasHealer = 0;
        int hasmDPS = 0;
        int hasrDPS = 0;
        int hasmrDPS = 0;

        boolean checkTank = false;
        boolean checkHealer = false;
        boolean checkmDPS = false;
        boolean checkrDPS = false;
        boolean checkmrDPS = false;

        for (Role userRole : userRoles) {
            for (int j = 0; j < Jobs.tanks.size(); j++) {
                if (userRole.equals(Jobs.tanks.get(j))) {
                    hasTank++;
                }
                if(role.equals(Jobs.tanks.get(j))) {
                    checkTank = true;
                }
            }
            for (int j = 0; j < Jobs.healers.size(); j++) {
                if (userRole.equals(Jobs.healers.get(j))) {
                    hasHealer++;
                }
                if(role.equals(Jobs.healers.get(j))) {
                    checkHealer = true;
                }
            }
            for (int j = 0; j < Jobs.mDPS.size(); j++) {
                if (userRole.equals(Jobs.mDPS.get(j))) {
                    hasmDPS++;
                }
                if(role.equals(Jobs.mDPS.get(j))) {
                    checkmDPS = true;
                }
            }
            for (int j = 0; j < Jobs.rDPS.size(); j++) {
                if (userRole.equals(Jobs.rDPS.get(j))) {
                    hasrDPS++;
                }
                if(role.equals(Jobs.rDPS.get(j))) {
                    checkrDPS = true;
                }
            }
            for (int j = 0; j < Jobs.mrDPS.size(); j++) {
                if (userRole.equals(Jobs.mrDPS.get(j))) {
                    hasmrDPS++;
                }
                if(role.equals(Jobs.mrDPS.get(j))) {
                    checkmrDPS = true;
                }
            }
        }

        // System.out.println(hasTank + "\n" + hasHealer + "\n" + hasmDPS + "\n" + hasrDPS + "\n" + hasmrDPS);
        if (hasTank < 2 && checkTank) {
            guild.removeRoleFromMember(user, GrantInitialJobs.tanks).queue();
        }
        if (hasHealer < 2 && checkHealer) {
            guild.removeRoleFromMember(user, GrantInitialJobs.healers).queue();
        }
        if (hasmDPS < 2 && checkmDPS) {
            guild.removeRoleFromMember(user, GrantInitialJobs.mDPS).queue();
        }
        if (hasrDPS < 2 && checkrDPS) {
            guild.removeRoleFromMember(user, GrantInitialJobs.rDPS).queue();
        }
        if (hasmrDPS < 2 && checkmrDPS) {
            guild.removeRoleFromMember(user, GrantInitialJobs.mrDPS).queue();
        }

    }

}
