package me.mrarcane.arcslibrary.utils;

import me.mrarcane.arcslibrary.Main;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.TabCompleter;

public class CommandUtil {

    public static void loadCommand(String cmd, CommandExecutor executor) {
        Main.getInstance().getServer().getPluginCommand(cmd).setExecutor(executor);
    }
    public static void commandCompleter(String cmd, TabCompleter tabCompleter) {
        Main.getInstance().getServer().getPluginCommand(cmd).setTabCompleter(tabCompleter);
    }
}
