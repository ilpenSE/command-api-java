package dev.elite;

import dev.elite.CmdExecutors.CopyStrCmd;
import dev.elite.CmdExecutors.HelpCmd;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public enum Command {
    COPYSTR ("copystr", "copystr <string>", "Copies the string to clipboard.", new CopyStrCmd()),
    HELP ("help", "help <command (opt)>", "Shows all commands", new HelpCmd());

    private final String cmdStr;
    private final String usage;
    private final String description;
    private final CommandExecutor executor;
    Command(String cmdStr, String usage, String description, CommandExecutor executor) {
        this.cmdStr = cmdStr;
        this.usage = usage;
        this.description = description;
        this.executor = executor;
    }

    public CommandExecutor getExecutor() {
        return executor;
    }

    public String getCmdStr() {
        return cmdStr;
    }

    public String getDescription() {
        return description;
    }

    public String getUsage() {
        return usage;
    }

    private static final Set<String> commandNames = new HashSet<>();

    static {
        for (Command command : Command.values()) {
            commandNames.add(command.cmdStr);
        }
    }

    public static boolean contains(String param) {
        return commandNames.contains(param);
    }

    public static Optional<Command> fromString(String name) {
        if (name == null) {
            return Optional.empty();
        }
        try {
            return Optional.of(Command.valueOf(name.toUpperCase()));
        } catch (IllegalArgumentException e) {
            return Optional.empty();
        }
    }
}
