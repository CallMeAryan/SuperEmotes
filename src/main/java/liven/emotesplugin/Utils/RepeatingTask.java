package liven.emotesplugin.Utils;

import liven.emotesplugin.EmotesPlugin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class RepeatingTask implements Runnable {

    private final int taskId;

    public RepeatingTask(int arg1, int arg2) {
        taskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(JavaPlugin.getPlugin(EmotesPlugin.class), this, arg1, arg2);
    }

    public void canncel() {
        Bukkit.getScheduler().cancelTask(taskId);
    }

}
