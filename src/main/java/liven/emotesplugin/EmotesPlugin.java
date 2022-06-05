package liven.emotesplugin;

import liven.emojiplugin.Commands.EmotesCommand;
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

import java.util.*;

import static liven.emojiplugin.Utils.getCustomSkull.createCustomSkull;

public final class EmotesPlugin extends JavaPlugin implements Listener {
    public static boolean isEnabled = false;
    public static boolean isUp = true;
    public static int _Emojinumber = 0;
    public static List<UUID> EnabledEmojis = new ArrayList<UUID>();

    @Override
    public void onEnable() {





        EnabledEmojis.forEach(uuidd -> System.out.println("::::::::::::::::::::::::::::::" + uuidd));



        Bukkit.getPluginManager().registerEvents(this, this);
        getLogger().info(ChatColor.GREEN + "plugin enabled successfully");
        this.getCommand("emoji").setExecutor(new EmotesCommand());


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
                        player.getInventory().setHelmet(createCustomSkull(1, "idk", Collections.singletonList("idk"), "80546009349781f548ba9ac1118efeca00a7d27ed79e53e4d54dfd218f9b694b"));
                        isUp = false;
                    } else if (!isUp && _Emojinumber == 1) {
                        player.getInventory().setHelmet(createCustomSkull(1, "idk", Collections.singletonList("idk"), "52e98165deef4ed621953921c1ef817dc638af71c1934a4287b69d7a31f6b8"));
                        isUp = true;
                    } else if  (isUp && _Emojinumber == 2) {
                        player.getInventory().setHelmet(createCustomSkull(1, "idk", Collections.singletonList("idk"), "2a1898b4147c6f7137b256fb468640738fdae532692b90e4e9ef2e62976c7a7d"));
                        isUp = false;
                    } else if (!isUp && _Emojinumber == 2) {
                        player.getInventory().setHelmet(createCustomSkull(1, "idk", Collections.singletonList("idk"), "705682eb2f96e76aa7a4e44ae3d54f519f3485f6beedeab0d0d889aaa5e3ecb8"));
                        isUp = true;
                    }
                }
            }
        };
    }
}

