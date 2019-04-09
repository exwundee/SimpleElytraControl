package xyz.exwundee.SEC;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.exwundee.SEC.commands.ElytraCommand;

/**
 * Created by Nicholas on 2019-04-02.
 */
public class SEC extends JavaPlugin {

    public static Plugin plugin;

    @Override
    public void onEnable() {
        plugin = this;
        registerEvents(this, new CheckElytraUse());
        getCommand("toggleelytra").setExecutor(new ElytraCommand());
    }

    @Override
    public void onDisable() {}

    public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
        for (Listener listener : listeners) {
            Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
        }
    }

    public static Plugin getPlugin() {
        return plugin;
    }

}
