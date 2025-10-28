package xiaocaoawa.miencraft.plugin.xccore.inventory;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author langle__
 * @version 1.0
 */
@Getter
public abstract class XCInventory {

    private static final Map<Player, XCInventory> inventoryMap = new HashMap<>();

    protected final int size;
    protected final String title;
    protected final Inventory inventory;

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
        XCInventory.setInventory(player, this);
        player.openInventory(inventory);
    }

    public abstract void onInventoryOpen(CancelInventoryContext context);

    public abstract void onInventoryClick(ClickInventoryContext context);

    public abstract void onInventoryClose(InventoryContext context);

    public static XCInventory getInventory(Player player) {
        return inventoryMap.get(player);
    }

    public static void setInventory(Player player, XCInventory inventory) {
        inventoryMap.put(player, inventory);
    }

    public static void removeInventory(Player player) {
        inventoryMap.remove(player);
    }

    public static void removeInventory(Player player, XCInventory tInventory) {
        inventoryMap.remove(player, tInventory);
    }

    public static boolean hasInventory(Player player) {
        return inventoryMap.containsKey(player);
    }

}
