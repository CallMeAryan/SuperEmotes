package net.liven;

import net.liven.Commands.EmotesCommand;
import net.liven.Utils.RepeatingTask;
import net.liven.Utils.getTexture;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static net.liven.Utils.getCustomSkull.createCustomSkull;

public final class SuperEmotes extends JavaPlugin implements Listener {


    public static List<UUID> LS_PlayerList = new ArrayList<>();
    ItemStack air = new ItemStack(Material.AIR);
    public static HashMap<UUID, getTexture> HM_PlayerData = new HashMap<>();

    
    @Override
    public void onEnable() {

        File conf_emotes = new File(getDataFolder(), "Emotes.yml");
        if (!conf_emotes.exists()){
            try {
                conf_emotes.createNewFile();
            } catch (IOException e) {
                getLogger().info("can't load Emotes.yml");
            }

            YamlConfiguration yml_emotes = YamlConfiguration.loadConfiguration(conf_emotes);

            yml_emotes.set("Emotes.1.Texture", "idk");

            try {
                yml_emotes.save(conf_emotes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



        YamlConfiguration yml_emotes = YamlConfiguration.loadConfiguration(conf_emotes);
        try {
            yml_emotes.save(conf_emotes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Bukkit.getPluginManager().registerEvents(this, this);
        getLogger().info(ChatColor.GREEN + "plugin enabled successfully");
        this.getCommand("emotes").setExecutor(new EmotesCommand(this, yml_emotes));



        RepeatingTask repeatingTask = new RepeatingTask(0, 10) {
            @Override
            public void run() {

                //loop through all UUIDs present in Array list


                for (UUID enabledEmoji : LS_PlayerList) {

                    Player player = Bukkit.getPlayer(enabledEmoji);
                    getTexture idk = HM_PlayerData.get(player.getUniqueId());
                    player.sendMessage(String.valueOf(idk.getCurrentTexture()));

                    if (player != null) {

                            if (idk != null && idk.getCurrentTexture() == 1) {
                                player.getInventory().setHelmet(createCustomSkull(1, "Emote " + null, Collections.singletonList("em" + player.getUniqueId())
                                        , idk.getTexture_1()));
                                idk.setCur(idk.getCurrentTexture() + 1);
                            } else if (idk != null && idk.getCurrentTexture() == 2){
                                player.getInventory().setHelmet(createCustomSkull(1, "Emote " + null, Collections.singletonList("em" + player.getUniqueId())
                                       , idk.getTexture_2()));
                                idk.setCur(idk.getCurrentTexture() - 1);

                        }


                    }


                }

            }
        };


    }

    @Override
    public void onDisable() {
        getLogger().info(ChatColor.RED + "plugin disabled successfully");
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {

        Player player = e.getPlayer();
        LS_PlayerList.add(player.getUniqueId());

    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerInteract(InventoryClickEvent e) {

        Player player = (Player) e.getWhoClicked();
        ItemStack skull = player.getInventory().getHelmet();


        if (skull != null && e.getInventory().getType() == InventoryType.CRAFTING && e.getSlot() == 39 && skull.getItemMeta().getLore().equals(Collections.singletonList("em" + player.getUniqueId()))) {
            e.setCancelled(true);
        }

    }


    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e) {

        Player player = e.getPlayer();


        LS_PlayerList.remove(player.getUniqueId());
        HM_PlayerData.remove(player.getUniqueId());


        player.getInventory().setHelmet(air);
    }
}

