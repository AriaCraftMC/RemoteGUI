package cn.accentry.remotegui.common.messaging.type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RemoteGUIMessage {
    private RemoteGUIMessageType type;
    private String message;
}
