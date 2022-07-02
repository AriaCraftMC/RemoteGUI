package top.jingwenmc.remotegui.api.gui;


import top.jingwenmc.remotegui.common.item.SendableClickEvent;

public interface GUIController {
    void onGuiClick(int row, int column, SendableClickEvent clickEventCopy,String playerName);
}
