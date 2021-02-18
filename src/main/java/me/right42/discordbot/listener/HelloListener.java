package me.right42.discordbot.listener;


import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HelloListener extends ListenerAdapter  {

    @Value("#{discord.botName}")
    private static String botName;

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        User messageAuthor = event.getAuthor();
        if(!botName.equals(messageAuthor.getName())) {
            Message msg = event.getMessage();

            if (msg.getContentRaw().startsWith("ㅎㅇ")){
                MessageChannel channel = event.getChannel();

                channel.sendMessage("ㅎㅇ")
                        .queue(response -> response.editMessageFormat("ㅎㅇ %s", messageAuthor.getName()).queue());
            }
        }
    }
}
