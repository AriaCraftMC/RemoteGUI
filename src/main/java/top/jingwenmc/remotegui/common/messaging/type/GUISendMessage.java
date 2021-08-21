package top.jingwenmc.remotegui.common.messaging.type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.jingwenmc.remotegui.api.gui.SendableGUI;

//To Player
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GUISendMessage {
    private SendableGUI gui;
}
