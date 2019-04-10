package xyz.exwundee.SEC;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.Plugin;

/**
 * Created by Nicholas on 2019-04-02.
 * Modified by Nicholas on 2019-04-08.
 */
public class CheckElytraUse implements Listener {

    public static Plugin plugin = SEC.getPlugin();

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Boolean a = plugin.getConfig().getBoolean("isElytraDisabled");
        if (event.getPlayer().isGliding()) {
            if (a == true) {
                event.getPlayer().setGliding(false);
            }
        }
    }

}
