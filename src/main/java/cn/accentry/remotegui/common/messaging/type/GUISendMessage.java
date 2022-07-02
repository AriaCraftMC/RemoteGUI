package cn.accentry.remotegui.common.messaging.type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import cn.accentry.remotegui.api.gui.SendableGUI;

//To Player
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GUISendMessage {
    private SendableGUI gui;
}
