package mock;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class MockCMDGiver implements JavaPlugin, Listener, CommandExecutor {
    @Override
    public void onEnable() {
        // Register command executor
        getCommand("mockcmd").setExecutor(this);
        // Register event listener
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length > 0 && args[0].equalsIgnoreCase("give") && sender instanceof Player) {
            Player player = (Player) sender;
            player.getInventory().addItem(new org.bukkit.inventory.ItemStack(org.bukkit.Material.DIAMOND, 1));
            sender.sendMessage("§aGave you 1 diamond!");
            return true;
        }
        return false;
    }

    @Override
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().sendMessage("§7[MockCMDGiver] Plugin loaded successfully!");
    }

    @Override
    public void onDisable() {
        getLogger().info("MockCMDGiver disabled!");
    }
}
