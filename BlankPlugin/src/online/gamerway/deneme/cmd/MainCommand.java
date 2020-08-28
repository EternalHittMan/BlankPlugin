package online.gamerway.deneme.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;


public class MainCommand implements CommandExecutor {

    private Plugin plugin;


    public MainCommand(Plugin plugin) {
        this.plugin = plugin;

    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        Player player = (Player) sender;

        if (args.length > 0) {
            switch (args[0].toLowerCase()) {

                case "test": { //test argümanı
                    String test = plugin.getConfig().getString("test").replace("&", "§");
                    player.sendTitle(" ", test, 10, 70, 20);
                    break;
                }

                case "reload": { //test argümanı
                    String reload = plugin.getConfig().getString("reload").replace("&", "§");
                    player.sendTitle(" ", reload, 10, 70, 20);
                    plugin.reloadConfig();
                    plugin.saveConfig();
                    break;
                }


                default: { // geçersiz argüman
                    Boolean def = plugin.getConfig().getBoolean("default");

                    player.sendTitle(" ", "default " + def.toString(), 10, 70, 20);
                    break;

                }

            }
        }else{// ana komut
            player.sendTitle(" ", "nothing", 10, 70, 20);


        }
        return true;
    }
}
