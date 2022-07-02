package cn.accentry.remotegui.api.gui;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SendableGUI {
    private String title;
    private int size;
    private ItemContainer itemContainer;

    public Inventory getNewInventory(InventoryHolder holder) {
        Inventory inventory = Bukkit.createInventory(holder,size,title);
        itemContainer.prepare(inventory);
        return inventory;
    }

    public void updateInventory(Inventory inventory) {
        if(inventory.getSize() == size) {
            itemContainer.prepare(inventory);
        }
    }
}
