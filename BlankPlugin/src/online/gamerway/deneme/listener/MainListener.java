package online.gamerway.deneme.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

public class MainListener implements Listener {


    private Plugin plugin;


    public MainListener(Plugin plugin) {
        this.plugin = plugin;

    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent p) {
        Player player = p.getPlayer();
        String joinmsg = plugin.getConfig().getString("join-message").replace("%player%", player.getName());
        p.getPlayer().sendMessage(joinmsg);



    }



}