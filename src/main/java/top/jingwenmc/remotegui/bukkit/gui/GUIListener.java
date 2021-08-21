package top.jingwenmc.remotegui.bukkit.gui;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import top.jingwenmc.mqeasy.api.exception.MQEasyNotLoadException;
import top.jingwenmc.mqeasy.api.json.MQEasyJsonUtil;
import top.jingwenmc.remotegui.bukkit.RemoteGUIBukkit;
import top.jingwenmc.remotegui.common.RemoteGUICommon;
import top.jingwenmc.remotegui.common.item.SendableClickEvent;
import top.jingwenmc.remotegui.common.messaging.type.GUIActionMessage;
import top.jingwenmc.remotegui.common.messaging.type.RemoteGUIMessage;
import top.jingwenmc.remotegui.common.messaging.type.RemoteGUIMessageType;

public class GUIListener implements Listener {
    @EventHandler
    public void onLeft(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        RemoteGUIBukkit.getInstance().getGuiManager().remove(player);
    }

    @EventHandler
    public void onGuiClick(InventoryClickEvent event) throws JsonProcessingException, MQEasyNotLoadException {
        String playerName = event.getWhoClicked().getName();
        if(RemoteGUIBukkit.getInstance().getGuiManager().isExist(playerName)) {
            //click logic
            RemoteGUICommon.getCommon().getMqEasyPlugin().getApi().sendMessageToServerNoReturn("bungee",
                    MQEasyJsonUtil.parseObject(new RemoteGUIMessage(RemoteGUIMessageType.GUI_ACTION,
                            MQEasyJsonUtil.parseObject(new GUIActionMessage(playerName,new SendableClickEvent(event))))));
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onGuiClose(InventoryCloseEvent event) {
        String player = event.getPlayer().getName();
        if(RemoteGUIBukkit.getInstance().getGuiManager().isExist(player)) {
            RemoteGUIBukkit.getInstance().getGuiManager().remove(player);
        }
    }
}
