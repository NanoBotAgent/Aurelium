package mock;

import com.nexomc.nexo.items.NexoItem;
import com.nexomc.nexo.items.NexoItems;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class MockNexo implements JavaPlugin, Listener {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        NexoItems.getInstance();
        getLogger().info("MockNexo enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("MockNexo disabled!");
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if (event.getPlayer() instanceof Player) {
            event.getPlayer().sendMessage("§7[MockNexo] Interacted!");
        }
    }
}
