package liven.emotesplugin;

import liven.emotesplugin.Commands.EmotesCommand;
import liven.emotesplugin.Utils.RepeatingTask;
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
import org.bukkit.util.Vector;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static liven.emotesplugin.Utils.getCustomSkull.createCustomSkull;

public final class EmotesPlugin extends JavaPlugin implements Listener {
    public static HashMap<String, Boolean> PlayerBoolean = new HashMap<>();
    public static Dictionary<String, Integer> dic = new Hashtable<>();
    public static List<UUID> EnabledEmojis = new ArrayList<UUID>();
    ItemStack air = new ItemStack(Material.AIR);


    @Override
    public void onEnable() {

        File conf_emotes = new File(getDataFolder(), "Emotes.yml");
        if (!conf_emotes.exists()) {
            try {
                conf_emotes.createNewFile();
            } catch (IOException e) {
                getLogger().info("can't load Emotes.yml");
            }
        }

        YamlConfiguration yml_emotes = YamlConfiguration.loadConfiguration(conf_emotes);

        yml_emotes.set("Emotes.1.Texture2", "Henlo");
        try {
            yml_emotes.save(conf_emotes);
        } catch (IOException e) {
            getLogger().info("Falied to save Emotes.yml");
        }


        Bukkit.getPluginManager().registerEvents(this, this);
        getLogger().info(ChatColor.GREEN + "plugin enabled successfully");
        this.getCommand("emotes").setExecutor(new EmotesCommand(this, yml_emotes));
        String TextureValue;
        List<String> DisplayLore = new ArrayList<>();


        String DisplayName = null;

        RepeatingTask repeatingTask = new RepeatingTask(0, 10) {
            @Override
            public void run() {


                //loop through all UUIDs present in Array list


                for (UUID enabledEmoji : EnabledEmojis) {

                    Player player = Bukkit.getPlayer(enabledEmoji);


                    if (player != null) {

                        List<String> lis = (yml_emotes.getStringList("Emotes." + dic.get(player.getDisplayName()) + ".Texture"));

                        if (lis.size() > 0) {

                            if (PlayerBoolean.get(player.getDisplayName())) {
                                player.getInventory().setHelmet(createCustomSkull(1, "Emote " + dic.get(player.getDisplayName()), Collections.singletonList("em" + player.getUniqueId().toString())
                                        , lis.get(1)));
                                PlayerBoolean.put(player.getDisplayName(), false);
                            } else {
                                player.getInventory().setHelmet(createCustomSkull(1, "Emote " + dic.get(player.getDisplayName()), Collections.singletonList("em" + player.getUniqueId().toString())
                                        , lis.get(2)));
                                PlayerBoolean.put(player.getDisplayName(), true);
                            }

                        } else {

                        }


                    }


                }


//                EnabledEmojis.forEach(uuidd -> {
//
//                            Player player = Bukkit.getPlayer(uuidd);
//
//
//                            if (player != null) {
//                                String DisplayName = player.getDisplayName();
//
//
//
//                                if (dic.get(DisplayName) == 1) {
//
//                                    if (PlayerBoolean.get(player.getDisplayName())) {
//                                        player.getInventory().setHelmet(createCustomSkull(1, String.valueOf(dic.get(DisplayName)), DisplayLore
//                                                , (String) yml_emotes.get("Emotes.1.Texture1")));
//                                        PlayerBoolean.put(player.getName(), false);
//                                    } else {
//                                        player.getInventory().setHelmet(createCustomSkull(1, String.valueOf(dic.get(DisplayName)), Collections.singletonList("em" + player.getUniqueId().toString())
//                                                , "52e98165deef4ed621953921c1ef817dc638af71c1934a4287b69d7a31f6b8"));
//                                        PlayerBoolean.put(player.getDisplayName(), true);
//                                    }
//
//                                } else if (dic.get(DisplayName) == 2) {
//
//                                    if (PlayerBoolean.get(player.getDisplayName())) {
//                                        player.getInventory().setHelmet(createCustomSkull(1, "Emote " + String.valueOf(dic.get(DisplayName)), Collections.singletonList("em" + player.getUniqueId().toString())
//                                                , "2a1898b4147c6f7137b256fb468640738fdae532692b90e4e9ef2e62976c7a7d"));
//                                        PlayerBoolean.put(player.getDisplayName(), false);
//                                    } else {
//                                        player.getInventory().setHelmet(createCustomSkull(1, "Emote " + String.valueOf(dic.get(DisplayName)), Collections.singletonList("em" + player.getUniqueId().toString())
//                                                , "705682eb2f96e76aa7a4e44ae3d54f519f3485f6beedeab0d0d889aaa5e3ecb8"));
//                                        PlayerBoolean.put(player.getDisplayName(), true);
//                                    }
//
//                                } else if (dic.get(DisplayName) == 3) {
//
//                                    if (PlayerBoolean.get(player.getDisplayName())) {
//                                        player.getInventory().setHelmet(createCustomSkull(1, "Emote " + String.valueOf(dic.get(DisplayName)), Collections.singletonList("em" + player.getUniqueId().toString())
//                                                , "66d23e6f231daca64f9c9726de824de93e7f2272202d7fd9e3db1a6298ac08d9"));
//                                        PlayerBoolean.put(player.getDisplayName(), false);
//                                    } else {
//                                        player.getInventory().setHelmet(createCustomSkull(1, "Emote " + String.valueOf(dic.get(DisplayName)), Collections.singletonList("em" + player.getUniqueId().toString())
//                                                , "6e66deda153ce20abd7652257498cb1616ab61e460960a88ea3307cfe8e48907"));
//                                        PlayerBoolean.put(player.getDisplayName(), true);
//                                    }
//
//                                } else if (dic.get(DisplayName) == 4) {
//
//                                    if (PlayerBoolean.get(player.getDisplayName())) {
//                                        player.getInventory().setHelmet(createCustomSkull(1, "Emote " + String.valueOf(dic.get(DisplayName)), Collections.singletonList("em" + player.getUniqueId().toString())
//                                                , "865ef8cc8c6461a7c45203b249d130f066086a9bb80307ecaedae8356800cea4"));
//                                        PlayerBoolean.put(player.getDisplayName(), false);
//                                    } else {
//                                        player.getInventory().setHelmet(createCustomSkull(1, "Emote " + String.valueOf(dic.get(DisplayName)), Collections.singletonList("em" + player.getUniqueId().toString())
//                                                , "2ae17e1fabb1c319469b752f7a47165d82242a14dbea756bcc6ac040ee21f21e"));
//                                        PlayerBoolean.put(player.getDisplayName(), true);
//                                    }
//
//                                } else if (dic.get(DisplayName) == 5) {
//
//                                    if (PlayerBoolean.get(player.getDisplayName())) {
//                                        player.getInventory().setHelmet(createCustomSkull(1, "Emote " + String.valueOf(dic.get(DisplayName)), Collections.singletonList("em" + player.getUniqueId().toString()), "42737e99e4c0596a3712e7711baecae8d1ddb774ac1cf531896862380753e16"));
//                                        PlayerBoolean.put(player.getDisplayName(), false);
//                                    } else {
//                                        player.getInventory().setHelmet(createCustomSkull(1, "Emote " + String.valueOf(dic.get(DisplayName)), Collections.singletonList("em" + player.getUniqueId().toString())
//                                                , "11952258929188b6549d03a8181228052b0364b986e8d2e9e7c39f7530530fdf"));
//                                        PlayerBoolean.put(player.getDisplayName(), true);
//                                    }
//
//                                } else if (dic.get(DisplayName) == 6) {
//
//                                    if (PlayerBoolean.get(player.getDisplayName())) {
//                                        player.getInventory().setHelmet(createCustomSkull(1, "Emote " + String.valueOf(dic.get(DisplayName)), Collections.singletonList("em" + player.getUniqueId().toString())
//                                                , "52e98165deef4ed621953921c1ef817dc638af71c1934a4287b69d7a31f6b8"));
//                                        PlayerBoolean.put(player.getDisplayName(), false);
//                                    } else {
//                                        player.getInventory().setHelmet(createCustomSkull(1, "Emote " + String.valueOf(dic.get(DisplayName)), Collections.singletonList("em" + player.getUniqueId().toString())
//                                                , "545bd18a2aaf469fad72e52cde6cfb02bfbaa5bfed2a8151277f779ebcdcec1"));
//                                        PlayerBoolean.put(player.getDisplayName(), true);
//                                    }
//
//                                } else if (dic.get(DisplayName) == 7) {
//
//                                    if (PlayerBoolean.get(player.getDisplayName())) {
//                                        player.getInventory().setHelmet(createCustomSkull(1, "Emote " + String.valueOf(dic.get(DisplayName)), Collections.singletonList("em" + player.getUniqueId().toString())
//                                                , "63611b5724e091854e79926fd11e486bfd0f99042721c3b34177f818639c19d"));
//                                        PlayerBoolean.put(player.getDisplayName(), false);
//                                    } else {
//                                        player.getInventory().setHelmet(createCustomSkull(1, "Emote " + String.valueOf(dic.get(DisplayName)), Collections.singletonList("em" + player.getUniqueId().toString())
//                                                , "732fe121a63eaabd99ced6d1acc91798652d1ee8084d2f9127d8a315cad5ce4"));
//                                        PlayerBoolean.put(player.getDisplayName(), true);
//                                    }
//
//                                } else if (dic.get(DisplayName) == 8) {
//
//                                    if (PlayerBoolean.get(player.getDisplayName())) {
//                                        player.getInventory().setHelmet(createCustomSkull(1, "Emote " + String.valueOf(dic.get(DisplayName)), Collections.singletonList("em" + player.getUniqueId().toString())
//                                                , "2d2175ebe9ae0e1a658d9af82dacfb8369052d8121d4ea3886738a1cca5"));
//                                        PlayerBoolean.put(player.getDisplayName(), false);
//                                    } else {
//                                        player.getInventory().setHelmet(createCustomSkull(1, "Emote " + String.valueOf(dic.get(DisplayName)), Collections.singletonList("em" + player.getUniqueId().toString())
//                                                , "285c789b1bafeb6274d5c3314e0333ccf6ab92d7312ef214f89793c959d25"));
//                                        PlayerBoolean.put(player.getDisplayName(), true);
//                                    }
//
//                                } else {
//
//                                }
//
//
//                            }
//
//
//                        }
//                );

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
        Vector playerloc = player.getLocation().toVector();

        //sets player bool to true

        PlayerBoolean.put(player.getDisplayName(), true);

    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerInteract(InventoryClickEvent e) {

        Player player = (Player) e.getWhoClicked();
        String DisplayName = player.getDisplayName();
        ItemStack skull = player.getInventory().getHelmet();


        if (skull != null && e.getInventory().getType() == InventoryType.CRAFTING && e.getSlot() == 39 && skull.getItemMeta().getLore().equals(Collections.singletonList("em" + player.getUniqueId().toString()))) {
            e.setCancelled(true);
        }

    }


    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e) {

        Player player = e.getPlayer();

        PlayerBoolean.remove(player.getDisplayName());
        dic.remove(player.getDisplayName());
        EnabledEmojis.remove(player.getUniqueId());
        player.getInventory().setHelmet(air);
    }
}

