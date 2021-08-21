package top.jingwenmc.remotegui.common;

import lombok.Getter;
import lombok.Setter;
import top.jingwenmc.mqeasy.api.plugin.MQEasyPlugin;

import java.util.logging.Level;
import java.util.logging.Logger;

public class RemoteGUICommon {
    @Getter
    private static final RemoteGUICommon common = new RemoteGUICommon();

    @Setter
    @Getter
    private MQEasyPlugin mqEasyPlugin;

    @Getter
    @Setter
    private Logger logger;

    public static void log(Level level,String message) {
        getCommon().getLogger().log(level, message);
    }
}
