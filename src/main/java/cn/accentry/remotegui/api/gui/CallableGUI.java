package cn.accentry.remotegui.api.gui;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CallableGUI {
    private SendableGUI gui;
    private GUIController controller;
}
