package me.mrarcane.arcslibrary.utils;

import me.mrarcane.arcslibrary.Main;
import org.bukkit.event.Listener;

public class EventRegisterUtil {

    public static void registerEvent(Listener listener) {
        Main.getInstance().getServer().getPluginManager().registerEvents(listener, Main.getInstance());
    }
}
