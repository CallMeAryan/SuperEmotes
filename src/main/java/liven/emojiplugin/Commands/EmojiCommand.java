package liven.emojiplugin.Commands;

import liven.emojiplugin.Utils.RepeatingTask;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EmojiCommand implements CommandExecutor {
    public boolean isUp = false;
    public static boolean isEnabled = false;


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        if (sender instanceof Player) {


            if (args.length == 1 && args[0].equalsIgnoreCase("help")) {

                player.sendMessage(ChatColor.GREEN + " ");
            } else if (args.length == 1 && args[0].equalsIgnoreCase("qm")) {
                if (!isEnabled) {

                    RepeatingTask repeatingTask = new RepeatingTask(0, 20) {
                        @Override
                        public void run() {
                            canncel();
                        }
                    };

                }
            }
        }
        return true;
    }
}

