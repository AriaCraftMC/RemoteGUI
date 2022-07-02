package cn.accentry.remotegui.api.gui;


import cn.accentry.remotegui.common.item.SendableClickEvent;

public interface GUIController {
    void onGuiClick(int row, int column, SendableClickEvent clickEventCopy,String playerName);
}
