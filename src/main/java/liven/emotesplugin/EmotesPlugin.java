package liven.emotesplugin;

import liven.emotesplugin.Commands.EmotesCommand;
import liven.emotesplugin.Utils.RepeatingTask;
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

import static liven.emotesplugin.Utils.getCustomSkull.createCustomSkull;

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
        this.getCommand("emotes").setExecutor(new EmotesCommand());


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
                    }else if  (isUp && _Emojinumber == 3) {
                        player.getInventory().setHelmet(createCustomSkull(1, "idk", Collections.singletonList("idk"), "6e66deda153ce20abd7652257498cb1616ab61e460960a88ea3307cfe8e48907"));
                        isUp = false;
                    } else if (!isUp && _Emojinumber == 3) {
                        player.getInventory().setHelmet(createCustomSkull(1, "idk", Collections.singletonList("idk"), "66d23e6f231daca64f9c9726de824de93e7f2272202d7fd9e3db1a6298ac08d9"));
                        isUp = true;
                    }else if  (isUp && _Emojinumber == 4) {
                        player.getInventory().setHelmet(createCustomSkull(1, "idk", Collections.singletonList("idk"), "865ef8cc8c6461a7c45203b249d130f066086a9bb80307ecaedae8356800cea4"));
                        isUp = false;
                    } else if (!isUp && _Emojinumber == 4) {
                        player.getInventory().setHelmet(createCustomSkull(1, "idk", Collections.singletonList("idk"), "2ae17e1fabb1c319469b752f7a47165d82242a14dbea756bcc6ac040ee21f21e"));
                        isUp = true;
                    }else if  (isUp && _Emojinumber == 5) {
                        player.getInventory().setHelmet(createCustomSkull(1, "idk", Collections.singletonList("idk"), "42737e99e4c0596a3712e7711baecae8d1ddb774ac1cf531896862380753e16"));
                        isUp = false;
                    } else if (!isUp && _Emojinumber == 5) {
                        player.getInventory().setHelmet(createCustomSkull(1, "idk", Collections.singletonList("idk"), "11952258929188b6549d03a8181228052b0364b986e8d2e9e7c39f7530530fdf"));
                        isUp = true;
                    }else if  (isUp && _Emojinumber == 6) {
                        player.getInventory().setHelmet(createCustomSkull(1, "idk", Collections.singletonList("idk"), "52e98165deef4ed621953921c1ef817dc638af71c1934a4287b69d7a31f6b8"));
                        isUp = false;
                    } else if (!isUp && _Emojinumber == 6) {
                        player.getInventory().setHelmet(createCustomSkull(1, "idk", Collections.singletonList("idk"), "545bd18a2aaf469fad72e52cde6cfb02bfbaa5bfed2a8151277f779ebcdcec1"));
                        isUp = true;
                    }else if  (isUp && _Emojinumber == 7) {
                        player.getInventory().setHelmet(createCustomSkull(1, "idk", Collections.singletonList("idk"), "63611b5724e091854e79926fd11e486bfd0f99042721c3b34177f818639c19d"));
                        isUp = false;
                    } else if (!isUp && _Emojinumber == 7) {
                        player.getInventory().setHelmet(createCustomSkull(1, "idk", Collections.singletonList("idk"), "732fe121a63eaabd99ced6d1acc91798652d1ee8084d2f9127d8a315cad5ce4"));
                        isUp = true;
                    }else if  (isUp && _Emojinumber == 8) {
                        player.getInventory().setHelmet(createCustomSkull(1, "idk", Collections.singletonList("idk"), "2d2175ebe9ae0e1a658d9af82dacfb8369052d8121d4ea3886738a1cca5"));
                        isUp = false;
                    } else if (!isUp && _Emojinumber == 8) {
                        player.getInventory().setHelmet(createCustomSkull(1, "idk", Collections.singletonList("idk"), "285c789b1bafeb6274d5c3314e0333ccf6ab92d7312ef214f89793c959d25"));
                        isUp = true;
                    }
                }
            }
        };
    }
}

