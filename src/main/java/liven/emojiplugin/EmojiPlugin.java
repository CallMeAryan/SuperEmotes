package liven.emojiplugin;

import liven.emojiplugin.Commands.EmojiCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

public final class EmojiPlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        getLogger().info(ChatColor.GREEN + "plugin enabled successfully");
        this.getCommand("emoji").setExecutor(new EmojiCommand());


    }
    @Override
    public void onDisable(){
        getLogger().info(ChatColor.RED + "plugin disabled successfully");
    }
}

