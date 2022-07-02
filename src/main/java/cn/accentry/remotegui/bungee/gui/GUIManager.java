package cn.accentry.remotegui.bungee.gui;

import cn.accentry.remotegui.api.gui.CallableGUI;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.util.HashMap;
import java.util.Map;

public class GUIManager {
    private final Map<String, CallableGUI> guiMap = new HashMap<>();
    public boolean add(ProxiedPlayer player, CallableGUI gui) {
        if(guiMap.containsKey(player.getName()))return false;
        guiMap.put(player.getName(), gui);
        return true;
    }

    public boolean add(String player, CallableGUI gui) {
        if(guiMap.containsKey(player))return false;
        guiMap.put(player, gui);
        return true;
    }

    public boolean remove(ProxiedPlayer player) {
        if(!guiMap.containsKey(player.getName()))return false;
        guiMap.remove(player.getName());
        return true;
    }

    public boolean remove(String player) {
        if(!guiMap.containsKey(player))return false;
        guiMap.remove(player);
        return true;
    }

    public CallableGUI get(ProxiedPlayer player) {
        return guiMap.getOrDefault(player.getName(),null);
    }

    public CallableGUI get(String player) {
        return guiMap.getOrDefault(player,null);
    }

    public boolean update(ProxiedPlayer player,CallableGUI gui) {
        if(!guiMap.containsKey(player.getName()))return false;
        guiMap.replace(player.getName(),gui);
        return true;
    }

    public boolean update(String player,CallableGUI gui) {
        if(!guiMap.containsKey(player))return false;
        guiMap.replace(player,gui);
        return true;
    }

    public boolean isExist(ProxiedPlayer player) {
        return guiMap.containsKey(player.getName());
    }

    public boolean isExist(String player) {
        return guiMap.containsKey(player);
    }
}
