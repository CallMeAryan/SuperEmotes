package liven.emotesplugin.Commands;

import liven.emotesplugin.EmotesPlugin;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import static liven.emotesplugin.EmotesPlugin.EnabledEmojis;
import static liven.emotesplugin.EmotesPlugin.dic;

public class EmotesCommand implements CommandExecutor {

    private final EmotesPlugin main;
    private final YamlConfiguration conf_emotes;


    public EmotesCommand(EmotesPlugin main, YamlConfiguration conf) {
        this.conf_emotes = conf;
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        ItemStack air = new ItemStack(Material.AIR);


        if (sender instanceof Player) {



            Set<String> list = conf_emotes.getConfigurationSection("Emotes").getKeys(false);


            List<String> lis = (conf_emotes.getStringList("Emotes." + args[0] + ".Texture"));


            if(args.length == 0 && conf_emotes.contains("Emotes")){

                player.sendMessage(ChatColor.GREEN + "Avaliable Emojis: " + list);


            }

            if (args.length == 1 && list.contains(args[0])){

                EnabledEmojis.add(player.getUniqueId());
                dic.put(player.getDisplayName(), Integer.parseInt(args[0]));
                player.sendMessage(String.valueOf(dic.get(player.getDisplayName())));

            }






//            if (args.length == 1 && args[0].equalsIgnoreCase("help")) {
//
//                player.sendMessage(ChatColor.GREEN + "Choose between 1-8! Eg. /emotes 5");
//            }else if(args.length == 1 && args[0].equalsIgnoreCase("reload")){
//
//
//            }
//            if (player.hasPermission("emote.get." + args[0])) if (args.length == 1 && args[0].equalsIgnoreCase("1")) {
//
//
//                dic.put(player.getDisplayName(), 1);
//                EnabledEmojis.add(player.getUniqueId());
//
//
//            } else if (args.length == 1 && args[0].equalsIgnoreCase("2")) {
//
//
//                dic.put(player.getDisplayName(), 2);
//                EnabledEmojis.add(player.getUniqueId());
//
//
//            } else if (args.length == 1 && args[0].equalsIgnoreCase("3")) {
//
//
//                dic.put(player.getDisplayName(), 3);
//                EnabledEmojis.add(player.getUniqueId());
//
//
//            } else if (args.length == 1 && args[0].equalsIgnoreCase("4")) {
//
//
//                dic.put(player.getDisplayName(), 4);
//                EnabledEmojis.add(player.getUniqueId());
//
//
//            } else if (args.length == 1 && args[0].equalsIgnoreCase("5")) {
//
//
//                dic.put(player.getDisplayName(), 5);
//                EnabledEmojis.add(player.getUniqueId());
//
//
//            } else if (args.length == 1 && args[0].equalsIgnoreCase("6")) {
//
//
//                dic.put(player.getDisplayName(), 6);
//                EnabledEmojis.add(player.getUniqueId());
//
//
//            } else if (args.length == 1 && args[0].equalsIgnoreCase("7")) {
//
//
//                dic.put(player.getDisplayName(), 7);
//                EnabledEmojis.add(player.getUniqueId());
//
//
//            } else if (args.length == 1 && args[0].equalsIgnoreCase("8")) {
//
//
//                dic.put(player.getDisplayName(), 8);
//                EnabledEmojis.add(player.getUniqueId());
//
//
//            } else {
//                player.sendMessage(ChatColor.RED + "Emote Disabled");
//                dic.remove(player.getDisplayName());
//                EnabledEmojis.remove(player.getUniqueId());
//                player.getInventory().setHelmet(air);
//
//            }
        }
        return true;
    }
}



