package Event;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class RemoveMainRole extends ListenerAdapter {
    public void onGuildMessageReactionRemove(@NotNull GuildMessageReactionRemoveEvent event) {
        String currentReaction = event.getReaction().getReactionEmote().getName();
        Guild currentGuild = event.getGuild();
        Member currentUser = event.retrieveMember().complete();
        switch (currentReaction) {
            case "Astrologian" -> {
                Role astro = event.getGuild().getRolesByName("Astrologian Main", false).get(0);
                if (Objects.requireNonNull(currentUser).getRoles().contains(astro)) {
                    currentGuild.removeRoleFromMember(currentUser, astro).queue();
                }
            }
            case "Bard" -> {
                Role brd = event.getGuild().getRolesByName("Bard Main", false).get(0);
                if (Objects.requireNonNull(currentUser).getRoles().contains(brd)) {
                    currentGuild.removeRoleFromMember(currentUser, brd).queue();
                }
            }
            case "BlackMage" -> {
                Role blm = event.getGuild().getRolesByName("Black Mage Main", false).get(0);
                if (Objects.requireNonNull(currentUser).getRoles().contains(blm)) {
                    currentGuild.removeRoleFromMember(currentUser, blm).queue();
                }
            }
            case "Dancer" -> {
                Role dnc = event.getGuild().getRolesByName("Dancer Main", false).get(0);
                if (Objects.requireNonNull(currentUser).getRoles().contains(dnc)) {
                    currentGuild.removeRoleFromMember(currentUser, dnc).queue();
                }
            }
            case "DarkKnight" -> {
                Role drk = event.getGuild().getRolesByName("Dark Knight Main", false).get(0);
                if (Objects.requireNonNull(currentUser).getRoles().contains(drk)) {
                    currentGuild.removeRoleFromMember(currentUser, drk).queue();
                }
            }

            case "Dragoon" -> {
                Role drg = event.getGuild().getRolesByName("Dragoon Main", false).get(0);
                if (Objects.requireNonNull(currentUser).getRoles().contains(drg)) {
                    currentGuild.removeRoleFromMember(currentUser, drg).queue();
                }
            }
            case "Gunbreaker" -> {
                Role gnb = event.getGuild().getRolesByName("Gunbreaker Main", false).get(0);
                if (Objects.requireNonNull(currentUser).getRoles().contains(gnb)) {
                    currentGuild.removeRoleFromMember(currentUser, gnb).queue();
                }
            }
            case "Machinist" -> {
                Role mch = event.getGuild().getRolesByName("Machinist Main", false).get(0);
                if (Objects.requireNonNull(currentUser).getRoles().contains(mch)) {
                    currentGuild.removeRoleFromMember(currentUser, mch).queue();
                }
            }
            case "Monk" -> {
                Role mnk = event.getGuild().getRolesByName("Monk Main", false).get(0);
                if (Objects.requireNonNull(currentUser).getRoles().contains(mnk)) {
                    currentGuild.removeRoleFromMember(currentUser, mnk).queue();
                }
            }
            case "Ninja" -> {
                Role nin = event.getGuild().getRolesByName("Ninja Main", false).get(0);
                if (Objects.requireNonNull(currentUser).getRoles().contains(nin)) {
                    currentGuild.removeRoleFromMember(currentUser, nin).queue();
                }
            }
            case "Paladin" -> {
                Role pld = event.getGuild().getRolesByName("Paladin Main", false).get(0);
                if (Objects.requireNonNull(currentUser).getRoles().contains(pld)) {
                    currentGuild.removeRoleFromMember(currentUser, pld).queue();
                }
            }
            case "RedMage" -> {
                Role rdm = event.getGuild().getRolesByName("Red Mage Main", false).get(0);
                if (Objects.requireNonNull(currentUser).getRoles().contains(rdm)) {
                    currentGuild.removeRoleFromMember(currentUser, rdm).queue();
                }
            }
            case "Samurai" -> {
                Role sam = event.getGuild().getRolesByName("Samurai Main", false).get(0);
                if (Objects.requireNonNull(currentUser).getRoles().contains(sam)) {
                    currentGuild.removeRoleFromMember(currentUser, sam).queue();
                }
            }
            case "Scholar" -> {
                Role sam = event.getGuild().getRolesByName("Scholar Main", false).get(0);
                if (Objects.requireNonNull(currentUser).getRoles().contains(sam)) {
                    currentGuild.removeRoleFromMember(currentUser, sam).queue();
                }
            }
            case "Summoner" -> {
                Role smn = event.getGuild().getRolesByName("Summoner Main", false).get(0);
                if (Objects.requireNonNull(currentUser).getRoles().contains(smn)) {
                    currentGuild.removeRoleFromMember(currentUser, smn).queue();
                }
            }
            case "Warrior" -> {
                Role war = event.getGuild().getRolesByName("Warrior Main", false).get(0);
                if (Objects.requireNonNull(currentUser).getRoles().contains(war)) {
                    currentGuild.removeRoleFromMember(currentUser, war).queue();
                }
            }
            case "WhiteMage" -> {
                Role whm = event.getGuild().getRolesByName("White Mage Main", false).get(0);
                if (Objects.requireNonNull(currentUser).getRoles().contains(whm)) {
                    currentGuild.removeRoleFromMember(currentUser, whm).queue();
                }
            }
            case "Sage" -> {
                Role sge = event.getGuild().getRolesByName("Sage Main", false).get(0);
                if (Objects.requireNonNull(currentUser).getRoles().contains(sge)) {
                    currentGuild.removeRoleFromMember(currentUser, sge).queue();
                }
            }
            case "Reaper" -> {
                Role rpr = event.getGuild().getRolesByName("Reaper Main", false).get(0);
                if (Objects.requireNonNull(currentUser).getRoles().contains(rpr)) {
                    currentGuild.removeRoleFromMember(currentUser, rpr).queue();
                }
            }
        }
    }
}
