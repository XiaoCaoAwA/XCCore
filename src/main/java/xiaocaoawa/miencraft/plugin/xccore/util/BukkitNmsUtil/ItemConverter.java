package xiaocaoawa.miencraft.plugin.xccore.util.BukkitNmsUtil;

import net.minecraft.*;
import org.bukkit.craftbukkit.v1_21_R1.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * 物品转换工具类
 * 提供Bukkit物品对象与NMS物品对象之间的转换功能
 * 
 * @author XiaoCaoAwA
 * @version 1.0
 */
public final class ItemConverter {

    private ItemConverter() {}

    /**
     * 将NMS物品堆叠转换为Bukkit物品堆叠
     * 
     * @param itemStack NMS物品堆叠对象
     * @return Bukkit物品堆叠对象
     */
    public static ItemStack toItemStack(@NotNull class_1799 itemStack) {
        net.minecraft.world.item.ItemStack nmsItem = net.minecraft.world.item.ItemStack.class.cast(itemStack);
        return CraftItemStack.asBukkitCopy(nmsItem);
    }

    /**
     * 将Bukkit物品堆叠转换为NMS物品堆叠
     * 
     * @param bukkitItem Bukkit物品堆叠对象
     * @return NMS物品堆叠对象
     */
    public static class_1799 toItemStack(@NotNull ItemStack bukkitItem) {
        net.minecraft.world.item.ItemStack nmsItem = CraftItemStack.asNMSCopy(bukkitItem);
        return class_1799.class.cast(nmsItem);
    }
}