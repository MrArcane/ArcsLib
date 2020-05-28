package me.mrarcane.arcslibrary;

import me.mrarcane.arcslibrary.commands.ArcsLibCommand;
import org.bukkit.plugin.java.JavaPlugin;

import static me.mrarcane.arcslibrary.utils.CommandUtil.loadCommand;

public class Main extends JavaPlugin {

    private static Main instance;

    public static Main getInstance() {
        return instance;
    }
    public static Boolean getDebug() {
        return Main.getInstance().getConfig().getBoolean("Debug");
    }
    public void onEnable() {
        instance = this;
        this.saveConfig();
        this.saveDefaultConfig();
        this.reloadConfig();
        loadCommand("arcslibrary", new ArcsLibCommand());
    }
}
