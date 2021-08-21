package top.jingwenmc.remotegui.common.item;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SendableItem {
    public SendableItem(Material material) {
        this.material = material;
        this.name = material.name();
        this.stack = 1;
    }
    private Material material;
    private String name;
    private List<String> lore = new ArrayList<>();
    private int stack;

    public ItemStack convert() {
        //System.out.println(this);
        ItemStack itemStack = new ItemStack(material);
        if(!material.equals(Material.AIR)) {
            ItemMeta itemMeta;
            itemMeta = itemStack.getItemMeta();
            itemMeta.setLore(lore);
            itemMeta.setDisplayName(name);
            itemStack.setItemMeta(itemMeta);
        }
        return itemStack;
    }
}
