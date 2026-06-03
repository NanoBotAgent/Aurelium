package mock;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class InventoryGiver implements Listener {
    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent event) {
        if (event.getPlayer() instanceof Player) {
            event.getPlayer().sendMessage("§7[MockInventoryGiver] Inventory opened!");
        }
    }
}
