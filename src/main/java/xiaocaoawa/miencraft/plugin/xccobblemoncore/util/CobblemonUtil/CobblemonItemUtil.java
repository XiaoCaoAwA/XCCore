package xiaocaoawa.miencraft.plugin.xccobblemoncore.util.CobblemonUtil;

import com.cobblemon.mod.common.item.PokemonItem;
import com.cobblemon.mod.common.pokeball.PokeBall;
import com.cobblemon.mod.common.pokemon.Pokemon;
import com.cobblemon.mod.common.pokemon.Species;
import net.minecraft.class_1799;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import xiaocaoawa.miencraft.plugin.xccobblemoncore.util.BukkitNmsUtil.BukkitNmsConverter;

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
}