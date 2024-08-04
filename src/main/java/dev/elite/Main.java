package dev.elite;

import dev.elite.Exceptions.CommandNotFoundException;

import java.util.Scanner;

public class Main {
    public static CommandHandler handler;

    public static void main(String[] args) {
        initializeCommands();
        System.out.println("Type a command:");
        Scanner sc = new Scanner(System.in);

        String cmdStr = sc.nextLine();
        String[] cmdSplitted = cmdStr.split(" ");
        String[] arguments = new String[cmdSplitted.length - 1];

        System.arraycopy(cmdSplitted, 1, arguments, 0, cmdSplitted.length - 1);

        try {
            handler.executeCommand(cmdSplitted[0], arguments);
        } catch (CommandNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void initializeCommands() {
        CommandHandler handler1 = new CommandHandler();
        handler1.registerCommands();
        handler = handler1;
    }
}