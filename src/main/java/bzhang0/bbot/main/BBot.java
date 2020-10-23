package bzhang0.bbot.main;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BBot {
    public static void main(String[] args) throws FileNotFoundException, LoginException {
        System.out.println("hi");
        String token = new Scanner(new File("token.txt")).next();

        JDA jda = JDABuilder
                .createDefault(token)
                .build();

        System.out.println(jda.getInviteUrl());
    }
}
