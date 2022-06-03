package liven.emojiplugin.Commands;

import liven.emojiplugin.EmojiPlugin;
import liven.emojiplugin.Utils.RepeatingTask;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import java.util.Arrays;
import java.util.Timer;

import static liven.emojiplugin.Utils.getCustomSkull.createCustomSkull;

public class EmojiCommand implements CommandExecutor {
    public boolean isUp = false;
    public static boolean Test1;
    public static boolean isEnabled = false;


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        if (sender instanceof Player) {


            if (args.length == 1 && args[0].equalsIgnoreCase("help")) {

                player.sendMessage(ChatColor.GREEN + "truly helping you");
            } else if (args.length == 1 && args[0].equalsIgnoreCase("qm")) {
                Test1 = false;
                player.sendMessage("Command working fine");
                if(!isEnabled){

                    RepeatingTask repeatingTask = new RepeatingTask(0, 20) {
                        @Override
                        public void run() {

                            if (!Test1){
                                    player.sendMessage("test " + String.valueOf(Test1) + " " + String.valueOf(isEnabled));
                            } else {
                                canncel();
                            }






                        }
                    };
                    Test1 = false;

                } else {

                    isEnabled = false;
                    player.sendMessage("isEnabled is False now");
                }
                if (!Test1 && isEnabled == true){

                    Test1 = true;
                    player.sendMessage("Test1 is true now");
                }else{

                    Test1 = false;
                    player.sendMessage("Test1 is false now");

                }






                player.sendMessage(String.valueOf(Test1) + " " + String.valueOf(isEnabled));

            }
        }
        return true;
    }
    public void Task(){

    }
}

