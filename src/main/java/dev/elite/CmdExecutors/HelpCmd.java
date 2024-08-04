package dev.elite.CmdExecutors;

import dev.elite.CommandExecutor;
import dev.elite.Command;
import dev.elite.Exceptions.ArgumentException;

import java.util.Optional;

public class HelpCmd implements CommandExecutor {
    @Override
    public void onCommand(String[] args) {
        if (args.length > 0) {
            Optional<Command> command = Command.fromString(args[0]);
            command.ifPresentOrElse(
                    command1 -> {
                        System.out.println("==== " + command1.getCmdStr() + " command ====");
                        System.out.println("Usage: " + command1.getUsage());
                        System.out.println("Description: " + command1.getDescription());
                    },
                    () ->  {
                        throw new RuntimeException(new ArgumentException("Invalid command: " + args[0]));
                    }
            );
            return;
        }

        System.out.println("======= Commands =======");
        for (Command cmd : Command.values()) {
            System.out.println("==== " + cmd.getCmdStr() + " command ====");
            System.out.println("Usage: " + cmd.getUsage());
            System.out.println("Description: " + cmd.getDescription());
        }
    }
}
