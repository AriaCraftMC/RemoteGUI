package cn.accentry.remotegui.api;

import cn.accentry.remotegui.api.gui.CallableGUI;
import cn.accentry.remotegui.bungee.RemoteGUIBungee;
import cn.accentry.remotegui.common.messaging.type.*;
import top.jingwenmc.mqeasy.api.json.MQEasyJsonUtil;
import cn.accentry.remotegui.api.gui.GUIController;
import cn.accentry.remotegui.api.gui.SendableGUI;
import cn.accentry.remotegui.common.RemoteGUICommon;

public class RemoteGUIApi {
    public static void showRemotePlayerGui(String target, SendableGUI gui, GUIController controller) {
        showRemotePlayerGui(target,new CallableGUI(gui,controller));
    }

    public static void showRemotePlayerGui(String target, CallableGUI gui) {
        try {
            RemoteGUICommon.getCommon().getMqEasyPlugin().getApi().sendMessageToBukkitPlayerNoReturn(target,MQEasyJsonUtil.parseObject(
                    new RemoteGUIMessage(RemoteGUIMessageType.SEND_GUI,MQEasyJsonUtil.parseObject(new GUISendMessage(gui.getGui())))));
            if(RemoteGUIBungee.getInstance().getGuiManager().isExist(target)) {
                RemoteGUIBungee.getInstance().getGuiManager().remove(target);
            }
            RemoteGUIBungee.getInstance().getGuiManager().add(target,gui);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void closeRemotePlayerGui(String target) {
        try {
            RemoteGUICommon.getCommon().getMqEasyPlugin().getApi().sendMessageToBukkitPlayerNoReturn(target,
                    MQEasyJsonUtil.parseObject(new RemoteGUIMessage(RemoteGUIMessageType.BUNGEE_GUI_ACTION
                            , MQEasyJsonUtil.parseObject(new BungeeActionMessage(ActionType.CLOSE_GUI)))));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    //TODO: GUI Update
}
