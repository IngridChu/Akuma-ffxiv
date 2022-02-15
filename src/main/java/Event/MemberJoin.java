package Event;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MemberJoin extends ListenerAdapter {

    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        if(!event.getUser().isBot()) {
            Random rng = new Random();
            Role role = event.getGuild().getRolesByName("Register Loadstone", false).get(0);
            event.getGuild().addRoleToMember(event.getMember(), role).queue();
            EmbedBuilder join = new EmbedBuilder();
            join.setColor(Color.pink);
            try {
                join.setImage(generatePictureLink(rng));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            join.setFooter("Any bugs? Contact Granadis#8876 or Kenji Miyama in game.","https://media.discordapp.net/attachments/808220485917474877/848794323465011210/Untitled-1-Recovered_copy.jpg?width=1154&height=1154");
            join.addField("Welcome to Akuma!","Welcome, " + event.getMember().getAsMention()
                    + "! \nPlease go to #character-loadstone and use the command \n**!iam server firstName lastName** \nto register your user name!\nExample: **!iam Leviathan Kenji Miyama**\n" +
                    "After you've done that, you will be able to see the rest of the server!", true);

            event.getGuild().getDefaultChannel().sendMessage(join.build()).queue();
        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        Random rng = new Random();
        String test = generatePictureLink(rng);
        System.out.println(test);
    }

    public static String generatePictureLink(Random rng) throws FileNotFoundException {
        ArrayList<String> picSources = new ArrayList<>();
        Scanner input = new Scanner(new File("src/main/java/Sources/Pictures.txt"));
        while(input.hasNext()) {
            picSources.add(input.next());
        }
        int index = rng.nextInt(picSources.size());
        return picSources.get(index);
    }

}


