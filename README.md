# Command API for Java
This is more like a library than an API. It might be a good example learning inheritence in Java. NOTE: Inheritence might be slow but it doesn't significantly impact performance.<br/>
In this example we have 2 commands whose help and copystr.
## Usage
The usage was given in [Main file.](src/main/dev/elite/Main.java) <br/>
You can use `registerCommand(Command cmd)` method to add a command and you can handle commands by using `executeCommand(String cmd, String[] args)`.
## Commands
### Help Command
Usage: help <command (optional)><br/>
Description: Shows all commands
### Copystr Command
Usage: copystr <string><br/>
Description: Copies the string to the clipboard.
