package top.jingwenmc.remotegui.common.item;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SendableClickEvent {
    private ClickType click;
    private int whichSlot;

    public SendableClickEvent(InventoryClickEvent inventoryClickEvent) {
        click = inventoryClickEvent.getClick();
        whichSlot = inventoryClickEvent.getSlot();
    }
}
