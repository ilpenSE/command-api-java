package dev.elite.CmdExecutors;

import dev.elite.CommandExecutor;
import dev.elite.Exceptions.ArgumentException;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class CopyStrCmd implements CommandExecutor {
    @Override
    public void onCommand(String[] args) {
        if (args.length == 0) {
            throw new RuntimeException(new ArgumentException("You must provide a string."));
        }

        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection strse1 = new StringSelection(String.join(" ", args));
        clipboard.setContents(strse1, null);
        System.out.println("Copied to clipboard!");
    }
}
