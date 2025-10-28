package xiaocaoawa.miencraft.plugin.xccore.listener;

import xiaocaoawa.miencraft.plugin.xccore.inventory.CancelInventoryContext;
import xiaocaoawa.miencraft.plugin.xccore.inventory.ClickInventoryContext;
import xiaocaoawa.miencraft.plugin.xccore.inventory.InventoryContext;
import xiaocaoawa.miencraft.plugin.xccore.inventory.XCInventory;
import org.bukkit.Bukkit;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.Inventory;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author langle__
 * @version 1.0
 */
public class InventoryEvent implements Listener {

    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent event) {
        Inventory inventory = event.getInventory();
        HumanEntity entity = event.getPlayer();

        if (!(entity instanceof Player)) return;
        Player player = (Player) entity;

        if (checkInventory(inventory)) return;
        XCInventory tInventory = XCInventory.getInventory(player);
        if (tInventory == null || tInventory.getInventory() != inventory) return;
        CancelInventoryContext context = new CancelInventoryContext(player);

        try {
            tInventory.onInventoryOpen(context);
        } catch (Throwable e) {
            Logger logger = Bukkit.getLogger();
            logger.log(Level.SEVERE, "InventoryEvent.onInventoryOpen() 错误 - 玩家: {1}, 菜单: {2}", new Object[]{player.getName(), tInventory.getClass().getName()});
            logger.log(Level.SEVERE, "异常堆栈信息: ", e);
        }

        event.setCancelled(context.isCancelled());
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Inventory inventory = event.getInventory();
        HumanEntity entity = event.getWhoClicked();

        if (!(entity instanceof Player)) return;
        Player player = (Player) entity;

        Inventory clickedInventory = event.getClickedInventory();

        InventoryType.SlotType slotType = event.getSlotType();
        int slot = event.getSlot();
        ClickType click = event.getClick();
        InventoryAction action = event.getAction();
        int hotbarButton = event.getHotbarButton();

        if (slotType == InventoryType.SlotType.OUTSIDE || clickedInventory == null) return;

        if (checkInventory(inventory)) return;
        XCInventory tInventory = XCInventory.getInventory(player);
        if (tInventory == null || tInventory.getInventory() != inventory) return;

        if (clickedInventory.getType() == InventoryType.PLAYER) {
            event.setCancelled(true);
            return;
        }

        ClickInventoryContext context = new ClickInventoryContext(player, slotType, slot, click, action, hotbarButton);

        try {
            tInventory.onInventoryClick(context);
        } catch (Throwable e) {
            Logger logger = Bukkit.getLogger();
            logger.log(Level.SEVERE, "InventoryEvent.onInventoryClose() 错误 - 玩家: {0}, 菜单: {1}", new Object[]{player.getName(), tInventory.getClass().getName()});
            logger.log(Level.SEVERE, "异常堆栈信息: ", e);
        }

        event.setCancelled(context.isCancelled());
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        Inventory inventory = event.getInventory();
        HumanEntity entity = event.getPlayer();

        if (!(entity instanceof Player)) return;
        Player player = (Player) entity;

        if (checkInventory(inventory)) return;
        XCInventory tInventory = XCInventory.getInventory(player);
        if (tInventory == null || tInventory.getInventory() != inventory) return;
        InventoryContext context = new InventoryContext(player);

        try {
            tInventory.onInventoryClose(context);
        } catch (Throwable e) {
            Logger logger = Bukkit.getLogger();
            logger.log(Level.SEVERE, "InventoryEvent.onInventoryClose() 错误 - 玩家: {0}, 菜单: {1}", new Object[]{player.getName(), tInventory.getClass().getName()});
            logger.log(Level.SEVERE, "异常堆栈信息: ", e);
        }

        XCInventory.removeInventory(player, tInventory);
    }

    private boolean checkInventory(Inventory inventory) {
        return inventory.getType() != InventoryType.CHEST || inventory.getHolder() != null;
    }

}
