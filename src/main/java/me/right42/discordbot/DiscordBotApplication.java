package me.right42.discordbot;

import me.right42.discordbot.bot.HelloBot;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import javax.security.auth.login.LoginException;

@SpringBootApplication
public class DiscordBotApplication {

    public static void main(String[] args) throws LoginException, InterruptedException {
        SpringApplicationBuilder builder = new SpringApplicationBuilder();
        builder.web(WebApplicationType.NONE);
        builder.run(args);

    }

    @Component
    public class AppRunner implements ApplicationRunner {

        private final HelloBot helloBot;

        public AppRunner(HelloBot helloBot) {
            this.helloBot = helloBot;
        }

        @Override
        public void run(ApplicationArguments args) throws Exception {
            helloBot.start();
        }
    }

}
