package mock;

import com.sucy.sxitem.SXItem;
import com.sucy.sxitem.SXItemManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class MockSXItem implements JavaPlugin, Listener {
    private SXItemManager manager;

    @Override
    public void onEnable() {
        manager = new SXItemManager();
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("MockSXItem enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("MockSXItem disabled!");
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if (event.getPlayer() instanceof Player) {
            event.getPlayer().sendMessage("§7[MockSXItem] Interacted!");
        }
    }
}
