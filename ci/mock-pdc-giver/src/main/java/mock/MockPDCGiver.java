package mock;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class MockPDCGiver implements JavaPlugin, Listener {
    @Override
n    public void onEnable() {
        getCommand("mockpdc").setExecutor(this);
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("MockPDCGiver enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("MockPDCGiver disabled!");
    }

    @Override
    public boolean onCommand(org.bukkit.command.CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("mockpdc") && sender instanceof Player p) {
            p.sendMessage("§aMockPDC data given!");
            return true;
        }
        return false;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        e.getPlayer().sendMessage("§7[MockPDCGiver] Loaded!");
    }
}
