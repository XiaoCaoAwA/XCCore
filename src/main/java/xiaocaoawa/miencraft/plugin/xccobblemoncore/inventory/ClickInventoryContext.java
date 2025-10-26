package xiaocaoawa.miencraft.plugin.xccobblemoncore.inventory;

import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

/**
 * @author XiaoCaoAwA
 * @version 1.0
 */
public class ClickInventoryContext extends CancelInventoryContext {

    @Getter
    private final int slot;
    private final int hotbarKey;
    private final ClickType click;
    private final InventoryAction action;
    private final InventoryType.SlotType slot_type;

    public ClickInventoryContext(Player player, Inventory inventory, InventoryType.SlotType type, int slot, ClickType click, InventoryAction action, int hotbarButton) {
        super(player, inventory);
        this.hotbarKey = hotbarButton;
        this.slot_type = type;
        this.slot = slot;
        this.click = click;
        this.action = action;
    }

    @NotNull
    public InventoryType.SlotType getSlotType() {
        return this.slot_type;
    }

    public boolean isRightClick() {
        return this.click.isRightClick();
    }

    public boolean isLeftClick() {
        return this.click.isLeftClick();
    }

    public boolean isShiftClick() {
        return this.click.isShiftClick();
    }

    public int getHotbarButton() {
        return this.hotbarKey;
    }

    @NotNull
    public InventoryAction getAction() {
        return this.action;
    }

    @NotNull
    public ClickType getClick() {
        return this.click;
    }

}
