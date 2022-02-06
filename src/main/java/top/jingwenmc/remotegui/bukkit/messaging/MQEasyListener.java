package top.jingwenmc.remotegui.bukkit.messaging;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import top.jingwenmc.mqeasy.api.json.MQEasyJsonUtil;
import top.jingwenmc.mqeasy.api.message.CommonMessage;
import top.jingwenmc.mqeasy.api.message.MessageType;
import top.jingwenmc.mqeasy.api.message.Receipt;
import top.jingwenmc.mqeasy.api.plugin.MQEasyPlugin;
import top.jingwenmc.mqeasy.api.plugin.MQEasyPluginInfo;
import top.jingwenmc.remotegui.api.gui.SendableGUI;
import top.jingwenmc.remotegui.bukkit.RemoteGUIBukkit;
import top.jingwenmc.remotegui.bukkit.gui.GUIManager;
import top.jingwenmc.remotegui.common.RemoteGUICommon;
import top.jingwenmc.remotegui.common.messaging.type.*;

import java.io.IOException;
import java.util.logging.Level;

public class MQEasyListener extends MQEasyPlugin {

    private final MQEasyPluginInfo pluginInfo;

    public MQEasyListener(MQEasyPluginInfo pluginInfo) {
        this.pluginInfo = pluginInfo;
    }
    @Override
    public MQEasyPluginInfo getPluginInfo() {
        return pluginInfo;
    }

    @Override
    public void onReceiveNoReturn(MessageType messageType, String to, CommonMessage<String> message) {
        if(messageType.equals(MessageType.BUKKIT_PLAYER_NO_RETURN)) {
            try {
                Player target = Bukkit.getPlayerExact(to);
                RemoteGUIMessage remoteGUIMessage = MQEasyJsonUtil.parseJSON(message.getBody(),RemoteGUIMessage.class);
                if(remoteGUIMessage.getType().equals(RemoteGUIMessageType.BUNGEE_GUI_ACTION)) {
                    BungeeActionMessage bungeeActionMessage = MQEasyJsonUtil.parseJSON(remoteGUIMessage.getMessage(),BungeeActionMessage.class);
                    if(bungeeActionMessage.getActionType().equals(ActionType.CLOSE_GUI)) {
                        target.closeInventory();
                    }
                    //MORE?
                }
                if(remoteGUIMessage.getType().equals(RemoteGUIMessageType.SEND_GUI)) {
                    RemoteGUICommon.log(Level.INFO,"Sending GUI to: "+to);
                    GUISendMessage guiSendMessage = MQEasyJsonUtil.parseJSON(remoteGUIMessage.getMessage(),GUISendMessage.class);
                    SendableGUI gui = guiSendMessage.getGui();
                    if (RemoteGUIBukkit.getInstance().getGuiManager().isExist(target)) {
                        target.closeInventory();
                        RemoteGUIBukkit.getInstance().getGuiManager().remove(target);
                    }
                    Inventory inventory = gui.getNewInventory(target);
                    target.openInventory(inventory);
                    RemoteGUIBukkit.getInstance().getGuiManager().add(target,gui);
                }
                //TODO:GUI Update
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Receipt onReceiveNeedReturn(MessageType messageType, String to, CommonMessage<String> message) {
        //No logic
        return null;
    }
}
