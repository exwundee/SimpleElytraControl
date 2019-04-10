package xyz.exwundee.SEC;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.exwundee.SEC.commands.ElytraCommand;

/**
 * Created by Nicholas on 2019-04-02.
 * Modified by Nicholas on 2019-04-09.
 */
public class SEC extends JavaPlugin {

    public static Plugin plugin;


    // TODO - Create checks for elytra slot.
    // TODO - Create option to remove elytras from inventory.

    // TODO - v1.0 RELEASE : Cleaned up code & added final features.


    @Override
    public void onEnable() {
        plugin = this;

        if (getConfig().get("removeElytraInstances") == null) getConfig().set("removeElytraInstances", false);
        if (getConfig().get("checkElytraArmorSlot") == null) getConfig().set("checkElytraArmorSlot", false);
        saveConfig();

        registerEvents(this, new CheckElytraUse(), new InventoryCheck());
        getCommand("toggleelytra").setExecutor(new ElytraCommand());

    }

    @Override
    public void onDisable() {}

    public static void registerEvents(Plugin plugin, Listener... listeners) {
        for (Listener listener : listeners) {
            Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
        }
    }

    public static Plugin getPlugin() {
        return plugin;
    }

}
