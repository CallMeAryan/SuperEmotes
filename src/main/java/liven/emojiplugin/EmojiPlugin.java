package liven.emojiplugin;

import com.mojang.util.UUIDTypeAdapter;
import liven.emojiplugin.Commands.EmojiCommand;
import liven.emojiplugin.Utils.RepeatingTask;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import java.util.*;

import static liven.emojiplugin.Utils.getCustomSkull.createCustomSkull;

public final class EmojiPlugin extends JavaPlugin implements Listener {
    public static boolean isEnabled = false;
    public static boolean isUp = true;
    public static int _Emojinumber = 0;
    public static List<UUID> EnabledEmojis = new ArrayList<UUID>();

    @Override
    public void onEnable() {





        EnabledEmojis.forEach(uuidd -> System.out.println("::::::::::::::::::::::::::::::" + uuidd));

        Bukkit.getPluginManager().registerEvents(this, this);
        getLogger().info(ChatColor.GREEN + "plugin enabled successfully");
        this.getCommand("emoji").setExecutor(new EmojiCommand());


    }

    @Override
    public void onDisable() {
        getLogger().info(ChatColor.RED + "plugin disabled successfully");
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        ItemStack air = new ItemStack(Material.AIR);
        Player player = e.getPlayer();

        RepeatingTask repeatingTask = new RepeatingTask(0, 20) {
            @Override
            public void run() {

                if (isEnabled) {
                    if (isUp && _Emojinumber == 1) {
                        player.getInventory().setHelmet(createCustomSkull(1, "idk", Collections.singletonList("idk"), "uc?id=1d4CsPPchGVm4fYhTt9bX8vs2MWqx9Dz2&export=download"));
                        isUp = false;
                    } else if (!isUp && _Emojinumber == 1) {
                        player.getInventory().setHelmet(air);
                        isUp = true;
                    } else {

                    }
                } else {
                }
            }
        };
    }
}

