package top.jingwenmc.remotegui.bungee;

import lombok.Getter;
import net.md_5.bungee.api.plugin.Plugin;
import top.jingwenmc.remotegui.bungee.gui.GUIManager;
import top.jingwenmc.remotegui.bungee.messaging.MQEasyListener;
import top.jingwenmc.remotegui.common.RemoteGUICommon;

import java.util.logging.Level;

public class RemoteGUIBungee extends Plugin {
    @Getter
    private static RemoteGUIBungee instance;

    @Getter
    private final GUIManager guiManager = new GUIManager();

    @Override
    public void onEnable() {
        instance = this;
        RemoteGUICommon.getCommon().setLogger(getLogger());
        RemoteGUICommon.log(Level.INFO,"Loading plugin...");
        RemoteGUICommon.getCommon().setMqEasyPlugin(new MQEasyListener());
        try {
            top.jingwenmc.mqeasy.api.MQEasyApi.registerPlugin(RemoteGUICommon.getCommon().getMqEasyPlugin());
        } catch (Exception e) {
            e.printStackTrace();
        }
        RemoteGUICommon.log(Level.INFO,"Load complete!");
    }

    @Override
    public void onDisable() {
        RemoteGUICommon.log(Level.INFO,"Disable complete!");
    }
}
