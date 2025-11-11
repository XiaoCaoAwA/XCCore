package xiaocaoawa.miencraft.plugin.xccore.util.CobblemonUtil;

import com.cobblemon.mod.common.item.PokemonItem;
import com.cobblemon.mod.common.pokeball.PokeBall;
import com.cobblemon.mod.common.pokemon.Pokemon;
import com.cobblemon.mod.common.pokemon.Species;
import net.minecraft.class_1799;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import xiaocaoawa.miencraft.plugin.xccore.util.BukkitNmsUtil.BukkitNmsConverter;

/**
 * Cobblemon宝可梦物品工具类
 * 提供宝可梦相关物品的创建功能
 * 
 * @author XiaoCaoAwA
 * @version 1.0
 */
public final class CobblemonItemUtil {

    /**
     * 静态初始化标志
     */
    private static boolean initialized = false;

    private CobblemonItemUtil() {}

    /**
     * 设置初始化状态
     */
    public static void setInitialized() {
        initialized = true;
    }

    /**
     * 根据宝可梦对象创建对应的Bukkit物品堆叠
     * 
     * @param pokemon 宝可梦对象
     * @return 包含宝可梦信息的Bukkit物品堆叠，如果未初始化则返回null
     */
    public static ItemStack getPokemonItem(@NotNull Pokemon pokemon) {
        if (!initialized) {
            return null;
        }
        class_1799 item = PokemonItem.from(pokemon);
        return BukkitNmsConverter.toItemStack(item);
    }

    /**
     * 根据宝可梦种族创建对应的Bukkit物品堆叠
     * 
     * @param species 宝可梦种族对象
     * @return 包含宝可梦种族信息的Bukkit物品堆叠，如果未初始化则返回null
     */
    public static ItemStack getPokemonItem(@NotNull Species species) {
        if (!initialized) {
            return null;
        }
        class_1799 item = PokemonItem.from(species);
        return BukkitNmsConverter.toItemStack(item);
    }

    /**
     * 根据精灵球类型创建对应的Bukkit物品堆叠
     * 会自动添加所有物品标志以隐藏额外信息
     * 
     * @param pokeBall 精灵球类型
     * @return 精灵球物品堆叠，如果未初始化则返回null
     */
    public static ItemStack getPokeBallItem(PokeBall pokeBall) {
        if (!initialized) {
            return null;
        }
        ItemStack item = BukkitNmsConverter.toItemStack(pokeBall.stack(1));
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.addItemFlags(ItemFlag.values());
            item.setItemMeta(meta);
        }
        return item;
    }

    /**
     * 将Minecraft NMS物品堆叠转换为Bukkit物品堆叠
     * 主要用于处理宝可梦携带物或其他NMS物品
     * 
     * @param nmsItemStack Minecraft NMS物品堆叠 (class_1799)
     * @return Bukkit物品堆叠，如果NMS物品为空或未初始化则返回null
     */
    public static ItemStack fromNmsItemStack(@NotNull class_1799 nmsItemStack) {
        if (!initialized) {
            return null;
        }
        if (nmsItemStack == null || nmsItemStack.method_7960()) { // method_7960() = isEmpty()
            return null;
        }
        return BukkitNmsConverter.toItemStack(nmsItemStack);
    }

    /**
     * 根据宝可梦的携带物创建对应的Bukkit物品堆叠
     * 
     * @param pokemon 宝可梦对象
     * @return 携带物的Bukkit物品堆叠，如果宝可梦没有携带物或未初始化则返回null
     */
    public static ItemStack getHeldItem(@NotNull Pokemon pokemon) {
        if (!initialized) {
            return null;
        }
        class_1799 heldItem = pokemon.heldItem();
        if (heldItem == null || heldItem.method_7960()) { // method_7960() = isEmpty()
            return null;
        }
        return BukkitNmsConverter.toItemStack(heldItem);
    }

    /**
     * 检查宝可梦是否携带物品
     * 
     * @param pokemon 宝可梦对象
     * @return 是否携带物品，如果未初始化则返回false
     */
    public static boolean hasHeldItem(@NotNull Pokemon pokemon) {
        if (!initialized) {
            return false;
        }
        class_1799 heldItem = pokemon.heldItem();
        return heldItem != null && !heldItem.method_7960(); // method_7960() = isEmpty()
    }
}