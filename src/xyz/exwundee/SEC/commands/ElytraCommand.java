package xyz.exwundee.SEC.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import xyz.exwundee.SEC.SEC;

/**
 * Created by Nicholas on 2019-04-08.
 * Modified by Nicholas on 2019-04-08.
 */
public class ElytraCommand implements CommandExecutor {

    public static Plugin plugin = SEC.getPlugin();
    Boolean a = plugin.getConfig().getBoolean("isElytraDisbaled");

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("toggleelytra")) {
            setElytraStatus(sender, getOppositeES());
        }
        return false;
    }

    public void setElytraStatus(CommandSender sender, boolean isElytraDisabled) {
        plugin.getConfig().set("isElytraDisabled", isElytraDisabled);
        plugin.saveConfig();
        sender.sendMessage("§eElytra status has been toggled to " + isElytraDisabled);
    }

    // Temporary workaround.
    public Boolean getOppositeES() {
        if ((Boolean) plugin.getConfig().getBoolean("isElytraDisabled") == false) return true;
        else return false;
    }

}
