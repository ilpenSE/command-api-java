package dev.elite;

import dev.elite.Exceptions.CommandNotFoundException;

import java.util.Arrays;
import java.util.HashMap;

public class CommandHandler {
    public CommandHandler() {
        commands = new HashMap<>();
    }
    private HashMap<String, CommandExecutor> commands;

    public void registerCommand(Command cmd) {
        commands.put(cmd.getCmdStr(), cmd.getExecutor());
    }

    public HashMap<String, CommandExecutor> getCommands() {
        return new HashMap<>(commands);
    }

    public void registerCommands() {
        Command[] commands = Command.values();

        Arrays.stream(commands).parallel().forEach(this::registerCommand);
    }

    public void executeCommand(String cmd, String[] args) throws CommandNotFoundException {
        if (!commands.containsKey(cmd)) {
            throw new CommandNotFoundException("Command not found: " + cmd);
        }

        commands.get(cmd).onCommand(args);
    }
}
