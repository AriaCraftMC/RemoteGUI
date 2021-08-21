package top.jingwenmc.remotegui.bukkit;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import top.jingwenmc.mqeasy.api.MQEasyApi;
import top.jingwenmc.mqeasy.api.plugin.BukkitMQEasyPluginInfo;
import top.jingwenmc.remotegui.bukkit.gui.GUIListener;
import top.jingwenmc.remotegui.bukkit.gui.GUIManager;
import top.jingwenmc.remotegui.bukkit.messaging.MQEasyListener;
import top.jingwenmc.remotegui.common.RemoteGUICommon;

import java.util.logging.Level;

public final class RemoteGUIBukkit extends JavaPlugin {

    @Getter
    private static RemoteGUIBukkit instance;

    @Getter
    private final GUIManager guiManager = new GUIManager();

    @Override
    public void onEnable() {
        instance = this;
        RemoteGUICommon.getCommon().setLogger(getLogger());
        RemoteGUICommon.log(Level.INFO,"Loading plugin...");
        RemoteGUICommon.getCommon().setMqEasyPlugin(new MQEasyListener(new BukkitMQEasyPluginInfo(this)));
        try {
            MQEasyApi.registerPlugin(RemoteGUICommon.getCommon().getMqEasyPlugin());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Bukkit.getPluginManager().registerEvents(new GUIListener(), this);
        RemoteGUICommon.log(Level.INFO,"Load complete!");
    }

    @Override
    public void onDisable() {
        RemoteGUICommon.log(Level.INFO,"Disable complete!");
    }
}
