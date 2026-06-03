package mock;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class MockExecutableItems implements JavaPlugin, Listener, CommandExecutor {
    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("mockei").setExecutor(this);
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("MockExecutableItems has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("MockExecutableItems has been disabled!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("mockei")) {
            if (args.length == 0) {
                sender.sendMessage("§eUsage: /mockei <item>");
                return true;
            }
            sender.sendMessage("§aMockExecutableItems: §f" + String.join(" ", args));
            return true;
        }
        return false;
    }

    @Override
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().sendMessage("§7[MockExecutableItems] Plugin loaded!");
    }
}
