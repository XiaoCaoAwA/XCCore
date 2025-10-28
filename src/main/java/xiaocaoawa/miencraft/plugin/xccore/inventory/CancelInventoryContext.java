package xiaocaoawa.miencraft.plugin.xccore.inventory;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

/**
 * @author XiaoCaoAwA
 * @version 1.0
 */
@Getter
@Setter
public class CancelInventoryContext extends InventoryContext {

    private boolean cancelled;

    public CancelInventoryContext(Player player, Inventory inventory) {
        super(player, inventory);
    }

}
