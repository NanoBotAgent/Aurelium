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
        getCommand("mockcmd").setExecutor(this);
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length > 0 && args[0].equalsIgnoreCase("give") && sender instanceof Player p) {
            p.getInventory().addItem(org.bukkit.Material.DIAMOND.parseItem());
            sender.sendMessage("§aGave §r§f1x Diamond");
        }
        return true;
    }

    @Override
    public void onPlayerJoin(PlayerJoinEvent e) {
        e.getPlayer().sendMessage("§7[MockCMDGiver] Welcome!");
    }
}
