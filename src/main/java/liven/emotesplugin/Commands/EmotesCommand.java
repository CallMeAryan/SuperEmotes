package liven.emotesplugin.Commands;

import liven.emotesplugin.EmotesPlugin;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import static liven.emotesplugin.EmotesPlugin._Emojinumber;
import static liven.emotesplugin.EmotesPlugin.isEnabled;

public class EmotesCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        if (sender instanceof Player) {


            if (args.length == 1 && args[0].equalsIgnoreCase("help")) {

                player.sendMessage(ChatColor.GREEN + "Choose between 1-8! Eg. /emotes 5");
            } else if (args.length == 1 && args[0].equalsIgnoreCase("1")) {


                if (!isEnabled) {
                    _Emojinumber = 1;
                    player.sendMessage(ChatColor.GREEN + "Enabled 1" + _Emojinumber);
                    isEnabled = true;

                } else {
                    _Emojinumber = 0;
                    ItemStack air = new ItemStack(Material.AIR);
                    player.getInventory().setHelmet(air);
                    player.sendMessage(ChatColor.RED + "Disabled" + _Emojinumber);
                    isEnabled = false;

                }


            }else if (args.length == 1 && args[0].equalsIgnoreCase("2")) {


                if (!isEnabled) {
                    _Emojinumber = 2;
                    player.sendMessage(ChatColor.GREEN + "Enabled " + _Emojinumber);
                    isEnabled = true;

                } else {
                    _Emojinumber = 0;
                    ItemStack air = new ItemStack(Material.AIR);
                    player.getInventory().setHelmet(air);
                    player.sendMessage(ChatColor.RED + "Disabled" + _Emojinumber);
                    isEnabled = false;

                }
        }else if (args.length == 1 && args[0].equalsIgnoreCase("3")) {


                if (!isEnabled) {
                    _Emojinumber = 3;
                    player.sendMessage(ChatColor.GREEN + "Enabled " + _Emojinumber);
                    isEnabled = true;

                } else {
                    _Emojinumber = 0;
                    ItemStack air = new ItemStack(Material.AIR);
                    player.getInventory().setHelmet(air);
                    player.sendMessage(ChatColor.RED + "Disabled" + _Emojinumber);
                    isEnabled = false;

                }
            }else if (args.length == 1 && args[0].equalsIgnoreCase("4")) {


                if (!isEnabled) {
                    _Emojinumber = 4;
                    player.sendMessage(ChatColor.GREEN + "Enabled " + _Emojinumber);
                    isEnabled = true;

                } else {
                    _Emojinumber = 0;
                    ItemStack air = new ItemStack(Material.AIR);
                    player.getInventory().setHelmet(air);
                    player.sendMessage(ChatColor.RED + "Disabled" + _Emojinumber);
                    isEnabled = false;

                }
            }else if (args.length == 1 && args[0].equalsIgnoreCase("5")) {


                if (!isEnabled) {
                    _Emojinumber = 5;
                    player.sendMessage(ChatColor.GREEN + "Enabled " + _Emojinumber);
                    isEnabled = true;

                } else {
                    _Emojinumber = 0;
                    ItemStack air = new ItemStack(Material.AIR);
                    player.getInventory().setHelmet(air);
                    player.sendMessage(ChatColor.RED + "Disabled" + _Emojinumber);
                    isEnabled = false;

                }
            }else if (args.length == 1 && args[0].equalsIgnoreCase("6")) {


                if (!isEnabled) {
                    _Emojinumber = 6;
                    player.sendMessage(ChatColor.GREEN + "Enabled " + _Emojinumber);
                    isEnabled = true;

                } else {
                    _Emojinumber = 0;
                    ItemStack air = new ItemStack(Material.AIR);
                    player.getInventory().setHelmet(air);
                    player.sendMessage(ChatColor.RED + "Disabled" + _Emojinumber);
                    isEnabled = false;

                }
            }else if (args.length == 1 && args[0].equalsIgnoreCase("7")) {


                if (!isEnabled) {
                    _Emojinumber = 7;
                    player.sendMessage(ChatColor.GREEN + "Enabled " + _Emojinumber);
                    isEnabled = true;

                } else {
                    _Emojinumber = 0;
                    ItemStack air = new ItemStack(Material.AIR);
                    player.getInventory().setHelmet(air);
                    player.sendMessage(ChatColor.RED + "Disabled" + _Emojinumber);
                    isEnabled = false;

                }
            }else if (args.length == 1 && args[0].equalsIgnoreCase("8")) {


                if (!isEnabled) {
                    _Emojinumber = 8;
                    player.sendMessage(ChatColor.GREEN + "Enabled " + _Emojinumber);
                    isEnabled = true;

                } else {
                    _Emojinumber = 0;
                    ItemStack air = new ItemStack(Material.AIR);
                    player.getInventory().setHelmet(air);
                    player.sendMessage(ChatColor.RED + "Disabled" + _Emojinumber);
                    isEnabled = false;

                }
            } else {
                player.sendMessage(ChatColor.RED + "Invalid Emoji");

            }
    }
        return true;
    } }



