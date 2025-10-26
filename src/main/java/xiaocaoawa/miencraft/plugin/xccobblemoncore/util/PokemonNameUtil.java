package xiaocaoawa.miencraft.plugin.xccobblemoncore.util;

import com.cobblemon.mod.common.api.abilities.Ability;
import com.cobblemon.mod.common.pokeball.PokeBall;
import com.cobblemon.mod.common.pokemon.Gender;
import com.cobblemon.mod.common.pokemon.Nature;
import com.cobblemon.mod.common.pokemon.Species;
import com.cobblemon.mod.common.util.MiscUtilsKt;
import net.minecraft.class_1799;
import org.jetbrains.annotations.NotNull;

/**
 * 宝可梦名称获取工具类
 * 提供各种宝可梦相关元素的本地化名称获取方法
 * 
 * @author XiaoCaoAwA
 * @version 1.0
 */
public final class PokemonNameUtil {

    // 私有构造函数防止实例化
    private PokemonNameUtil() {}

    /**
     * 获取宝可梦种族的本地化名称
     * 
     * @param species 宝可梦种族
     * @return 本地化的种族名称
     */
    public static String getPokemonName(@NotNull Species species) {
        return species.getTranslatedName().getString();
    }

    /**
     * 获取性格的本地化名称
     * 
     * @param nature 宝可梦性格
     * @return 本地化的性格名称
     */
    public static String getNatureName(@NotNull Nature nature) {
        return MiscUtilsKt.asTranslated(nature.getDisplayName()).getString();
    }

    /**
     * 获取性别的本地化名称
     * 
     * @param gender 宝可梦性别
     * @return 本地化的性别名称
     */
    public static String getGenderName(@NotNull Gender gender) {
        return MiscUtilsKt.asTranslated("cobblemon.gender." + gender.name().toLowerCase()).getString();
    }

    /**
     * 获取物品的本地化名称
     * 
     * @param item 物品堆叠
     * @return 本地化的物品名称
     */
    public static String getItemName(@NotNull class_1799 item) {
        return MiscUtilsKt.asTranslated(item.method_7922()).getString();
    }

    /**
     * 获取精灵球的本地化名称
     * 
     * @param pokeBall 精灵球类型
     * @return 本地化的精灵球名称
     */
    public static String getPokeBallName(@NotNull PokeBall pokeBall) {
        return MiscUtilsKt.asTranslated("item.cobblemon." + pokeBall.getName().method_12832()).getString();
    }

    /**
     * 获取特性的本地化名称
     * 
     * @param ability 宝可梦特性
     * @return 本地化的特性名称
     */
    public static String getAbilityName(@NotNull Ability ability) {
        return MiscUtilsKt.asTranslated(ability.getDisplayName()).getString();
    }
}