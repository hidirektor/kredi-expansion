package com.infumia.t3sl4.expansion.kredi;

import com.infumia.t3sl4.kredi.KrediAPI;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;

public class KrediExpansion extends PlaceholderExpansion {

    private final String VERSION = getClass().getPackage().getImplementationVersion();
    private KrediAPI plugin;

    @Override
    public String getIdentifier() {
        return "kredi";
    }

    @Override
    public String getAuthor() {
        return "SYN_T3SL4";
    }

    @Override
    public String getVersion() {
        return VERSION;
    }

    @Override
    public String getRequiredPlugin() {
        return "Kredi";
    }

    public boolean canRegister(){
        if (!Bukkit.getPluginManager().isPluginEnabled(getRequiredPlugin())) { return false; }
        return super.register();
    }

    @Override
    public boolean register(){

        if(!canRegister()){
            return false;
        }

        plugin = (KrediAPI) Bukkit.getPluginManager().getPlugin(getPlugin());

        if(plugin == null){
            return false;
        }

        return super.register();
    }

    @Override
    public String onRequest(OfflinePlayer offlinePlayer, String params) {
        if (params.equals("test")) { return "success"; }
        if (offlinePlayer == null || !offlinePlayer.isOnline()) { return "player is not online"; }

        Player player = offlinePlayer.getPlayer();
        switch (params) {
            case "miktar":
                return String.valueOf(KrediAPI.getKredi(player.getUniqueId().toString()));

            default:
                return null;
        }
    }

}
