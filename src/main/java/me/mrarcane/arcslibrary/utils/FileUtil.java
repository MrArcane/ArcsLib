package me.mrarcane.arcslibrary.utils;


import me.mrarcane.arcslibrary.Main;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;

import static me.mrarcane.arcslibrary.utils.ChatUtil.log;

public class FileUtil extends YamlConfiguration {

    private String name;
    private Plugin plugin;

    public FileUtil(Plugin plugin, String name){
        this.name = name + (name.endsWith(".yml") ? "" : ".yml");
        this.plugin = plugin;
        createFile();
        if (Main.getDebug()) {
            log(plugin + " opened " + name + ".yml");
        }
    }
    private void createFile() {
        try {
            File file = new File(plugin.getDataFolder(), name);
            if (!file.exists()) {
                if (plugin.getResource(name) != null) {
                    plugin.saveResource(name, false);
                } else {
                    save(file);
                }
            } else {
                load(file);
                save(file);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void save(){
        try {
            save(new File(plugin.getDataFolder(), name));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
