package cn.accentry.remotegui.api.gui;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import cn.accentry.remotegui.common.item.SendableItem;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
public class ItemContainer {
    @Setter
    @Getter
    private Map<Integer , SendableItem> itemMap = new HashMap<>();
    public void add(GUIPosition position, SendableItem itemStack) {
        itemMap.put(position.toValue(),itemStack);
    }

    public void add(int row, int column, SendableItem itemStack) {
        add(new GUIPosition(row,column),itemStack);
    }

    public void prepare(Inventory inventory) {
        //System.out.println(itemMap);
        int size = inventory.getSize();
        for(int row = 0;row<=size/9;row++) {
            for(int column = 0;column<9;column++) {
                GUIPosition position = new GUIPosition(row,column);
                SendableItem sendableItem = itemMap.getOrDefault(position.toValue(), new SendableItem(Material.AIR));
                ItemStack itemReady = sendableItem.convert();
                if(row*9+column<size) {
                    inventory.setItem(row*9+column,itemReady);
                }
            }
        }
    }
}
