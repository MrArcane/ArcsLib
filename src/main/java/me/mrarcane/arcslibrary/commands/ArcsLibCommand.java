package me.mrarcane.arcslibrary.commands;

import me.mrarcane.arcslibrary.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static me.mrarcane.arcslibrary.utils.ChatUtil.sendChat;

public class ArcsLibCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length == 0) {
            sendChat(sender, String.format("&6Name: &7%s", Main.getInstance().getDescription().getName()));
            sendChat(sender, String.format("&6Author: &7%s", Main.getInstance().getDescription().getAuthors()).replace("[", "").replace("]", ""));
            sendChat(sender, String.format("&6Version: &7%s", Main.getInstance().getDescription().getVersion()));
            if (sender.hasPermission("arcslibrary.admin")) {
                sendChat(sender, "&7---- &6Admin commands &7----");
                sendChat(sender, "&c/arcslibrary reload &7- Reloads the plugin");
                sendChat(sender, "&c/arcslibrary debug &7- Turns debugger on/off");
                return true;
            }
            return true;
        }
        if (sender.hasPermission("arcslibrary.admin")) {
            if (args[0].equalsIgnoreCase("reload")) {
                Main.getInstance().saveConfig();
                Main.getInstance().reloadConfig();
                Bukkit.getServer().getPluginManager().disablePlugin(Main.getInstance());
                Bukkit.getServer().getPluginManager().enablePlugin(Main.getInstance());
                sendChat(sender, "&6Reloaded successfully");
                return true;
            }
            if (args[0].equalsIgnoreCase("debug")) {
                if (Main.getDebug()) {
                    Main.getInstance().getConfig().set("Debug", false);
                    Main.getInstance().saveConfig();
                    sendChat(sender, "&7[&c&6ArcsLibrary&7] &aDebugger turned off!");
                    return true;
                } else {
                    Main.getInstance().getConfig().set("Debug", true);
                    Main.getInstance().saveConfig();
                    sendChat(sender, "&7[&c&6ArcsLibrary&7] &aDebugger turned on!");
                }
                return true;
            }
            return false;
        }
        return true;
    }
}
