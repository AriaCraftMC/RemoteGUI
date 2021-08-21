package top.jingwenmc.remotegui.bukkit.gui;

import org.bukkit.entity.Player;
import top.jingwenmc.remotegui.api.gui.SendableGUI;

import java.util.HashMap;
import java.util.Map;

public class GUIManager {
    private final Map<String, SendableGUI> guiMap = new HashMap<>();
    public boolean add(Player player, SendableGUI gui) {
        if(guiMap.containsKey(player.getName()))return false;
        guiMap.put(player.getName(), gui);
        return true;
    }

    public boolean add(String player, SendableGUI gui) {
        if(guiMap.containsKey(player))return false;
        guiMap.put(player, gui);
        return true;
    }

    public boolean remove(Player player) {
        if(!guiMap.containsKey(player.getName()))return false;
        guiMap.remove(player.getName());
        return true;
    }

    public boolean remove(String player) {
        if(!guiMap.containsKey(player))return false;
        guiMap.remove(player);
        return true;
    }

    public SendableGUI get(Player player) {
        return guiMap.getOrDefault(player.getName(),null);
    }

    public SendableGUI get(String player) {
        return guiMap.getOrDefault(player,null);
    }

    public boolean update(Player player,SendableGUI gui) {
        if(!guiMap.containsKey(player.getName()))return false;
        guiMap.replace(player.getName(),gui);
        return true;
    }

    public boolean update(String player,SendableGUI gui) {
        if(!guiMap.containsKey(player))return false;
        guiMap.replace(player,gui);
        return true;
    }

    public boolean isExist(Player player) {
        return guiMap.containsKey(player.getName());
    }

    public boolean isExist(String player) {
        return guiMap.containsKey(player);
    }
}
