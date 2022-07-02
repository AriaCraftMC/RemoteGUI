package cn.accentry.remotegui.common.messaging.type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import cn.accentry.remotegui.common.item.SendableClickEvent;

//To bungee
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GUIActionMessage {
    private String playerName;
    private SendableClickEvent event;
}
