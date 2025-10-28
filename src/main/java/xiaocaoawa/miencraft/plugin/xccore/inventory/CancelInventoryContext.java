package xiaocaoawa.miencraft.plugin.xccore.inventory;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;

/**
 * @author langle__
 * @version 1.0
 */
@Getter
@Setter
public class CancelInventoryContext extends InventoryContext {

    private boolean cancelled;

    public CancelInventoryContext(Player player) {
        super(player);
    }

}
