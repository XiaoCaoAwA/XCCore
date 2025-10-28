package xiaocaoawa.miencraft.plugin.xccobblemoncore.inventory;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import xiaocaoawa.miencraft.plugin.xccobblemoncore.XCCobblemonCore;

/**
 * @author XiaoCaoAwA
 * @version 1.0
 */
@Getter
public abstract class XCInventory {

    private final int size;
    private final String title;
    private final Inventory inventory;

    public XCInventory(int line, String title) {
        line = line < 0 || line > 6 ? 1 : line;
        this.size = line * 9;
        this.title = title;
        this.inventory = Bukkit.createInventory(null, size, title);
    }

    public XCInventory(int line) {
        this(line, "inventory");
    }

    public final void openInventory(Player player) {
        player.getOpenInventory().close();
        XCCobblemonCore.getXCInventoryMap().put(player, this);
        player.openInventory(inventory);
    }

    public abstract void onInventoryOpen(CancelInventoryContext context);

    public abstract void onInventoryClick(ClickInventoryContext context);

    public abstract void onInventoryClose(InventoryContext context);

}
