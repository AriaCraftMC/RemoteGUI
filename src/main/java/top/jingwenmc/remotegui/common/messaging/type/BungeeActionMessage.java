package top.jingwenmc.remotegui.common.messaging.type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//To player
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BungeeActionMessage {
    private ActionType actionType;
}

