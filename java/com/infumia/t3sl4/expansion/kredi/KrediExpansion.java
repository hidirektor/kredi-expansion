package com.infumia.t3sl4.expansion.kredi;

import com.infumia.t3sl4.kredi.KrediAPI;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class KrediExpansion extends PlaceholderExpansion {
    private final String VERSION = getClass().getPackage().getImplementationVersion();

    private KrediAPI plugin;

    public String getIdentifier() {
        return "kredi";
    }

    public String getAuthor() {
        return "SYN_T3SL4";
    }

    public String getVersion() {
        return this.VERSION;
    }

    public String getRequiredPlugin() {
        return "Kredi";
    }

    public boolean canRegister() {
        return (Bukkit.getPluginManager().getPlugin(getRequiredPlugin()) != null);
    }

    public boolean register() {
        if (!canRegister()) {
            return false;
        } else {
            return super.register();
        }
    }

    public String onRequest(OfflinePlayer offlinePlayer, String params) {
        if (params.equals("test")) {
            return "success";
        } else if (offlinePlayer == null || !offlinePlayer.isOnline()) {
            return "player is not online";
        }
        Player player = offlinePlayer.getPlayer();
        switch (params) {
            case "miktar":
                return String.valueOf(KrediAPI.getKredi(player.getUniqueId().toString()));
        }
        return null;
    }
}
