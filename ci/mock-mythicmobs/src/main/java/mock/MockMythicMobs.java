package mock;

import io.lumine.mythic.bukkit.MythicBukkit;
import io.lumine.mythic.bukkit.MythicItemManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class MockMythicMobs implements JavaPlugin, Listener {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        MythicBukkit inst = MythicBukkit.inst();
        getLogger().info("MockMythicMobs enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("MockMythicMobs disabled!");
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getPlayer() instanceof Player) {
            event.getPlayer().sendMessage("§7[MockMythicMobs] Interacted!");
        }
    }
}
