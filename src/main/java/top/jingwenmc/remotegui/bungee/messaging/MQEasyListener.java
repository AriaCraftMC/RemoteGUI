package top.jingwenmc.remotegui.bungee.messaging;

import top.jingwenmc.mqeasy.api.json.MQEasyJsonUtil;
import top.jingwenmc.mqeasy.api.message.CommonMessage;
import top.jingwenmc.mqeasy.api.message.MessageType;
import top.jingwenmc.mqeasy.api.message.Receipt;
import top.jingwenmc.mqeasy.api.plugin.MQEasyPlugin;
import top.jingwenmc.mqeasy.api.plugin.MQEasyPluginInfo;
import top.jingwenmc.remotegui.api.gui.CallableGUI;
import top.jingwenmc.remotegui.bungee.RemoteGUIBungee;
import top.jingwenmc.remotegui.common.messaging.type.GUIActionMessage;
import top.jingwenmc.remotegui.common.messaging.type.RemoteGUIMessage;
import top.jingwenmc.remotegui.common.messaging.type.RemoteGUIMessageType;

import java.util.Collections;
import java.util.List;

public class MQEasyListener extends MQEasyPlugin {
    @Override
    public MQEasyPluginInfo getPluginInfo() {
        return new MQEasyPluginInfo() {
            @Override
            public String getName() {
                return RemoteGUIBungee.getInstance().getDescription().getName();
            }

            @Override
            public List<String> getAuthors() {
                return Collections.singletonList(RemoteGUIBungee.getInstance().getDescription().getAuthor());
            }

            @Override
            public String getVersion() {
                return RemoteGUIBungee.getInstance().getDescription().getVersion();
            }

            @Override
            public String getDescription() {
                return RemoteGUIBungee.getInstance().getDescription().getDescription();
            }

            @Override
            public String getWebsite() {
                return "www.jingwenmc.top";
            }
        };
    }

    @Override
    public void onReceiveNoReturn(MessageType messageType, String to, CommonMessage<String> message) {
        if(messageType.equals(MessageType.SERVER_NO_RETURN)) {
            try {
                RemoteGUIMessage remoteGUIMessage = MQEasyJsonUtil.parseJSON(message.getBody(),RemoteGUIMessage.class);
                if(remoteGUIMessage.getType().equals(RemoteGUIMessageType.GUI_ACTION)) {
                    GUIActionMessage guiActionMessage = MQEasyJsonUtil.parseJSON(remoteGUIMessage.getMessage(),GUIActionMessage.class);
                    CallableGUI callableGUI = RemoteGUIBungee.getInstance().getGuiManager().get(guiActionMessage.getPlayerName());
                    if(callableGUI==null)return;
                    int row;
                    int column;
                    int num = guiActionMessage.getEvent().getWhichSlot();
                    column = num % 9;
                    row = (num - column)/9;
                    callableGUI.getController().onGuiClick(row,column, guiActionMessage.getEvent(), guiActionMessage.getPlayerName());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Receipt onReceiveNeedReturn(MessageType messageType, String to, CommonMessage<String> message) {
        return null;
    }
}
