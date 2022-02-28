import Command.*;
import Event.*;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

public class Main {

    // TODO: \ Before sending the emotes
    public static void main(String[] args) throws Exception {
        JDA jda = JDABuilder.createDefault(TOKEN)
                .setChunkingFilter(ChunkingFilter.ALL)
                .setMemberCachePolicy(MemberCachePolicy.ALL)
                .enableIntents(GatewayIntent.GUILD_MEMBERS)
                .build();
        jda.addEventListener(new NameChange());
        jda.addEventListener(new MemberJoin());
        jda.addEventListener(new CheckAndSetNickName());
        jda.addEventListener(new GetRoles());
        jda.addEventListener(new RemoveRoles());
        jda.addEventListener(new MainRole());
        jda.addEventListener(new RemoveMainRole());
        jda.addEventListener(new GrantInitialJobs());
        jda.addEventListener(new PronounsRole());
        jda.addEventListener(new RandomEventSender());
        jda.addEventListener(new Static2RaidReminder());


        jda.getPresence().setActivity(Activity.playing("with Rory❤️❤️❤️"));
    }

}
