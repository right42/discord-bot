package me.right42.discordbot.bot;

import me.right42.discordbot.listener.HelloListener;
import me.right42.discordbot.listener.ReadyListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.security.auth.login.LoginException;

@Component
public class HelloBot {

    @Value("#{discord.token}")
    private static String token;

    public static void start() throws InterruptedException, LoginException {
        JDA jda = JDABuilder.createDefault(token)
                .addEventListeners(new HelloListener())
                .addEventListeners(new ReadyListener())
                .build();

        jda.awaitReady();
    }

}
