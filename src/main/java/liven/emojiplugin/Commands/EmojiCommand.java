package liven.emojiplugin.Commands;

import liven.emojiplugin.Utils.RepeatingTask;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Collections;

import static liven.emojiplugin.EmojiPlugin._Emojinumber;
import static liven.emojiplugin.EmojiPlugin.isEnabled;
import static liven.emojiplugin.Utils.getCustomSkull.createCustomSkull;

public class EmojiCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        if (sender instanceof Player) {


            if (args.length == 1 && args[0].equalsIgnoreCase("help")) {

                player.sendMessage(ChatColor.GREEN + " ");
            } else if (args.length == 1 && args[0].equalsIgnoreCase("qm")) {


                if (!isEnabled) {
                    _Emojinumber = 1;
                    player.sendMessage("Enabled");
                    isEnabled = true;

                } else {
                    _Emojinumber = 0;
                    ItemStack air = new ItemStack(Material.AIR);
                    player.getInventory().setHelmet(air);
                    player.sendMessage("Disabled");
                    isEnabled = false;

                }


            }
        }
        return true;
    }
}



