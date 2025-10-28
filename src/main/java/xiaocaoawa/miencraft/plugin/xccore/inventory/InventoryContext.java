package xiaocaoawa.miencraft.plugin.xccore.inventory;

import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

/**
 * @author XiaoCaoAwA
 * @version 1.0
 */
@Getter
public class InventoryContext {

    private final Player player;
    private final Inventory inventory;

    public InventoryContext(Player player, Inventory inventory) {
        this.player = player;
        this.inventory = inventory;
    }

}
