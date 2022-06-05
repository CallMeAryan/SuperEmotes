package liven.emotesplugin.Commands;

import liven.emotesplugin.EmotesPlugin;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import javax.swing.plaf.IconUIResource;
import java.util.UUID;

import static liven.emotesplugin.EmotesPlugin.*;

public class EmotesCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        if (sender instanceof Player) {


            if (args.length == 1 && args[0].equalsIgnoreCase("help")) {

                player.sendMessage(ChatColor.GREEN + "Choose between 1-8! Eg. /emotes 5");
            } else if (args.length == 1 && args[0].equalsIgnoreCase("1")) {


                dic.put(player.getDisplayName(), 1);
                EnabledEmojis.add(player.getUniqueId());


            }else if (args.length == 1 && args[0].equalsIgnoreCase("2")) {


                dic.put(player.getDisplayName(), 2);
                EnabledEmojis.add(player.getUniqueId());


        }else if (args.length == 1 && args[0].equalsIgnoreCase("3")) {


                dic.put(player.getDisplayName(), 3);
                EnabledEmojis.add(player.getUniqueId());


            }else if (args.length == 1 && args[0].equalsIgnoreCase("4")) {


                dic.put(player.getDisplayName(), 4);
                EnabledEmojis.add(player.getUniqueId());


            }else if (args.length == 1 && args[0].equalsIgnoreCase("5")) {


                dic.put(player.getDisplayName(), 5);
                EnabledEmojis.add(player.getUniqueId());


            }else if (args.length == 1 && args[0].equalsIgnoreCase("6")) {


                dic.put(player.getDisplayName(), 6);
                EnabledEmojis.add(player.getUniqueId());


            }else if (args.length == 1 && args[0].equalsIgnoreCase("7")) {


                dic.put(player.getDisplayName(), 7);
                EnabledEmojis.add(player.getUniqueId());


            }else if (args.length == 1 && args[0].equalsIgnoreCase("8")) {


                dic.put(player.getDisplayName(), 8);
                EnabledEmojis.add(player.getUniqueId());


            } else {

                dic.put(player.getDisplayName(), 0);
                ItemStack air = new ItemStack(Material.AIR);
                player.getInventory().setHelmet(air);

            }
    }
        return true;
    } }



