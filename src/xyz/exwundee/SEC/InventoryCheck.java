package xyz.exwundee.SEC;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

/**
 * Created by Nicholas on 2019-04-09.
 * Modified by Nicholas on 2019-04-09.
 */
public class InventoryCheck implements Listener {

    static Plugin plugin = SEC.getPlugin();
    static boolean a = plugin.getConfig().getBoolean("removeElytraInstances");
    static boolean b = plugin.getConfig().getBoolean("checkElytraArmorSlot");

    static int c = 38;

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getClickedInventory().getItem(c).getType() == Material.ELYTRA
                && a == true
                && event.getClickedInventory().getItem(c).getType() != null) {
            for (ItemStack is : event.getClickedInventory().getContents()) {
                if (is.getType() == Material.ELYTRA) is.setType(Material.AIR);
            }
        }
    }

    public static void main(String[] args) {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            @Override
            public void run() {
                if (b == true) {
                    for (Player p : Bukkit.getOnlinePlayers()) {
                        if (p.getInventory().getItem(c).getType() == Material.ELYTRA) {
                            p.getInventory().getItem(c).setType(Material.AIR);
                        }
                    }
                }
            }
        }, 0L, 20);
    }


}
