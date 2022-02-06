package top.jingwenmc.remotegui.api;

import top.jingwenmc.mqeasy.api.json.MQEasyJsonUtil;
import top.jingwenmc.remotegui.api.gui.CallableGUI;
import top.jingwenmc.remotegui.api.gui.GUIController;
import top.jingwenmc.remotegui.api.gui.SendableGUI;
import top.jingwenmc.remotegui.bungee.RemoteGUIBungee;
import top.jingwenmc.remotegui.common.RemoteGUICommon;
import top.jingwenmc.remotegui.common.messaging.type.*;

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
