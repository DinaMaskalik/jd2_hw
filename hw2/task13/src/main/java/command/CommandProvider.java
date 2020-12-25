package command;

import command.impl.CubeCommand;
import command.impl.ParaCommand;
import command.impl.SphereCommand;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class CommandProvider {

    private static final Map<String, Command> commands;

    static {
        commands = new HashMap<>();
        commands.put("para", new ParaCommand());
        commands.put("cube", new CubeCommand());
        commands.put("sphere", new SphereCommand());
    }

    private CommandProvider() {
    }

    public static Command getCommandByName(String commandName) {
        return commands.get(commandName);
    }
}
