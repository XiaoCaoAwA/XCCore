package xiaocaoawa.miencraft.plugin.xccore.inventory;

import lombok.Getter;
import org.bukkit.entity.Player;

/**
 * @author langle__
 * @version 1.0
 */
@Getter
public class InventoryContext {

    private final Player player;

    public InventoryContext(Player player) {
        this.player = player;
    }

}
