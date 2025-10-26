package xiaocaoawa.miencraft.plugin.xccobblemoncore.util;

import com.cobblemon.mod.common.api.abilities.Ability;
import com.cobblemon.mod.common.api.abilities.AbilityTemplate;
import com.cobblemon.mod.common.pokeball.PokeBall;
import com.cobblemon.mod.common.pokemon.Gender;
import com.cobblemon.mod.common.pokemon.Nature;
import com.cobblemon.mod.common.util.MiscUtilsKt;
import net.minecraft.class_1799;
import org.jetbrains.annotations.NotNull;

/**
 * @author langle__
 * @version 1.0
 */
public final class LocalizedName {

    private LocalizedName() {}

    /**
     * 获取特性（性格）的本地化名称
     */
    public static String getNatureName(@NotNull Nature nature) {
        return MiscUtilsKt.asTranslated(nature.getDisplayName()).getString();
    }

    /**
     * 获取性别本地化名称
     */
    public static String getGenderName(@NotNull Gender gender) {
        return MiscUtilsKt.asTranslated("cobblemon.gender." + gender.name().toLowerCase()).getString();
    }

    /**
     * 获取物品（道具）的本地化名称
     */
    public static String getItemName(@NotNull class_1799 itemStack) {
        return MiscUtilsKt.asTranslated(itemStack.method_7922()).getString();
    }

    /**
     * 获取精灵球的本地化名称
     */
    public static String getPokeBallName(PokeBall pokeBall) {
        return MiscUtilsKt.asTranslated("item.cobblemon." + pokeBall.getName().method_12832()).getString();
    }

    /**
     * 获取特技（Ability）的本地化名称
     */
    public static String getAbilityName(@NotNull Ability ability) {
        return MiscUtilsKt.asTranslated(ability.getDisplayName()).getString();
    }

    public static String getAbilityName(AbilityTemplate ability) {
        return MiscUtilsKt.asTranslated(ability.getDisplayName()).getString();
    }

}
