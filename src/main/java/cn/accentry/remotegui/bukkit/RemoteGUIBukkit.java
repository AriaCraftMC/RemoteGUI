package cn.accentry.remotegui.bukkit;

import cn.accentry.remotegui.bukkit.gui.GUIListener;
import cn.accentry.remotegui.bukkit.gui.GUIManager;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import top.jingwenmc.mqeasy.api.MQEasyApi;
import top.jingwenmc.mqeasy.api.plugin.BukkitMQEasyPluginInfo;
import cn.accentry.remotegui.bukkit.messaging.MQEasyListener;
import cn.accentry.remotegui.common.RemoteGUICommon;

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
