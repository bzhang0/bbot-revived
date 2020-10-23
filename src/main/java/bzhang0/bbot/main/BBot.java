package bzhang0.bbot.main;

import bzhang0.bbot.listener.MasterMessageRespond;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BBot extends ListenerAdapter {
    public static void main(String[] args) throws LoginException, FileNotFoundException {
        System.out.println("hi");
        String token = new Scanner(new File("token.txt")).next();

        JDA jda = JDABuilder
                .createDefault(token)

                .addEventListeners(new BBot())
                .addEventListeners(new MasterMessageRespond())

                .build();

        System.out.println(jda.getInviteUrl());
    }
}
