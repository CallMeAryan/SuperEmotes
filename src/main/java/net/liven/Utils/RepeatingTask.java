package net.liven.Utils;

import net.liven.SuperEmotes;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class RepeatingTask implements Runnable {

    private final int INT_TaskId;

    public RepeatingTask(int arg1, int arg2) {
        INT_TaskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(JavaPlugin.getPlugin(SuperEmotes.class), this, arg1, arg2);
    }

    public void cancelTask() {
        Bukkit.getScheduler().cancelTask(INT_TaskId);
    }

}
