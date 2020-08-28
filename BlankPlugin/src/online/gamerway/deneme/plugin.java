package online.gamerway.deneme;

import online.gamerway.deneme.cmd.MainCommand;
import online.gamerway.deneme.listener.MainListener;
import org.bukkit.plugin.java.JavaPlugin;

public class plugin extends JavaPlugin {
    private static plugin plugin;



    @Override
    public void onEnable() {

        getLogger().info("Plugin Enabled");


        //eventler
        getServer().getPluginManager().registerEvents(new MainListener(this), this);


        loadconfig();

        //Komutlar
        getCommand("testcmd").setExecutor(new MainCommand(this));
    }


    @Override
    public void onDisable(){
        getLogger().info("Plugin Disabled");

    }

    public void loadconfig(){
        getConfig().options().copyDefaults(true);
        saveConfig();
    }
}