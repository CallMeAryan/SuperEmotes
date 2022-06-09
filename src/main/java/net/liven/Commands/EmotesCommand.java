package net.liven.Commands;

import net.liven.SuperEmotes;
import net.liven.Utils.getTexture;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.Set;

import static net.liven.SuperEmotes.HM_PlayerData;

public class EmotesCommand implements CommandExecutor {

    private final SuperEmotes main;
    private final YamlConfiguration conf_emotes;


    public EmotesCommand(SuperEmotes main, YamlConfiguration conf) {
        this.conf_emotes = conf;
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        ItemStack air = new ItemStack(Material.AIR);


        if (sender instanceof Player) {





            Set<String> list = conf_emotes.getConfigurationSection("Emotes").getKeys(false);


            List<String> is = conf_emotes.getStringList("Emotes." + args[0] + ".Texture");


            if(args.length == 0){

                player.sendMessage(ChatColor.GREEN + "Avaliable Emojis: " + list);

            }

            if (args.length == 1 && list.contains(args[0])){



                HM_PlayerData.put(player.getUniqueId(), new getTexture(1, is.get(0), is.get(1)));




            }
        }
        return true;
    }
}



