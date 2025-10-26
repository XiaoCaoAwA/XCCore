package xiaocaoawa.miencraft.plugin.xccobblemoncore.util;

import com.cobblemon.mod.common.api.moves.Move;
import com.cobblemon.mod.common.api.moves.categories.DamageCategory;
import com.cobblemon.mod.common.api.pokemon.Natures;
import com.cobblemon.mod.common.api.types.ElementalType;
import com.cobblemon.mod.common.pokemon.Nature;
import com.cobblemon.mod.common.pokemon.Pokemon;
import net.minecraft.class_1799;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author langle__
 * @version 1.0
 */
public class PokemonUtil {

    public static String yes = "是";
    public static String no = "否";
    public static String none = "无";
    public static String unknownNature = "未知性格";
    public static String natureTypeBalanced = "§e平衡";
    public static String natureTypeAttackDefenceDown = "§a攻击 §c防御";
    public static String natureTypeAttackSpeedDown = "§a攻击 §c速度";
    public static String natureTypeAttackSpecialAttackDown = "§a攻击 §c特攻";
    public static String natureTypeAttackSpecialDefenceDown = "§a攻击 §c特防";
    public static String natureTypeDefenceAttackDown = "§a防御 §c攻击";
    public static String natureTypeDefenceSpeedDown = "§a防御 §c速度";
    public static String natureTypeDefenceSpecialAttackDown = "§a防御 §c特攻";
    public static String natureTypeDefenceSpecialDefenceDown = "§a防御 §c特防";
    public static String natureTypeSpeedAttackDown = "§a速度 §c攻击";
    public static String natureTypeSpeedDefenceDown = "§a速度 §c防御";
    public static String natureTypeSpeedSpecialAttackDown = "§a速度 §c特攻";
    public static String natureTypeSpeedSpecialDefenceDown = "§a速度 §c特防";
    public static String natureTypeSpecialAttackAttackDown = "§a特攻 §c攻击";
    public static String natureTypeSpecialAttackDefenceDown = "§a特攻 §c防御";
    public static String natureTypeSpecialAttackSpeedDown = "§a特攻 §c速度";
    public static String natureTypeSpecialAttackSpecialDefenceDown = "§a特攻 §c特防";
    public static String natureTypeSpecialDefenceAttackDown = "§a特防 §c攻击";
    public static String natureTypeSpecialDefenceDefenceDown = "§a特防 §c防御";
    public static String natureTypeSpecialDefenceSpeedDown = "§a特防 §c速度";
    public static String natureTypeSpecialDefenceSpecialAttackDown = "§a特防 §c特攻";

    // 私有构造器防止实例化
    private PokemonUtil() {}

    /**
     * 判断当前是否为空槽位
     *
     * @return 如果是空槽返回 "空槽"，否则返回 "精灵"
     */
    public static String isAirToString(@Nullable Pokemon pokemon) {
        return BasePokemonUtil.isAir(pokemon) ? "空槽" : "精灵";
    }

    /**
     * 获取宝可梦的物种名称
     *
     * @return 宝可梦名称字符串
     */
    public static String getSpeciesName(@NotNull Pokemon pokemon) {
        return PokemonNameUtil.getPokemonName(BasePokemonUtil.getSpecies(pokemon));
    }

    /**
     * 获取 HP 的努力值字符串表示
     *
     * @return HP 努力值字符串
     */
    public static String getEvHPToString(@NotNull Pokemon pokemon) {
        return String.valueOf(BasePokemonUtil.getEvHP(pokemon));
    }

    /**
     * 获取攻击的努力值字符串表示
     *
     * @return 攻击努力值字符串
     */
    public static String getEvAttackToString(@NotNull Pokemon pokemon) {
        return String.valueOf(BasePokemonUtil.getEvAttack(pokemon));
    }

    /**
     * 获取防御的努力值字符串表示
     *
     * @return 防御努力值字符串
     */
    public static String getEvDefenceToString(@NotNull Pokemon pokemon) {
        return String.valueOf(BasePokemonUtil.getEvDefence(pokemon));
    }

    /**
     * 获取特攻的努力值字符串表示
     *
     * @return 特攻努力值字符串
     */
    public static String getEvSpecialAttackToString(@NotNull Pokemon pokemon) {
        return String.valueOf(BasePokemonUtil.getEvSpecialAttack(pokemon));
    }

    /**
     * 获取特防的努力值字符串表示
     *
     * @return 特防努力值字符串
     */
    public static String getEvSpecialDefenceToString(@NotNull Pokemon pokemon) {
        return String.valueOf(BasePokemonUtil.getEvSpecialDefence(pokemon));
    }

    /**
     * 获取速度的努力值字符串表示
     *
     * @return 速度努力值字符串
     */
    public static String getEvSpeedToString(@NotNull Pokemon pokemon) {
        return String.valueOf(BasePokemonUtil.getEvSpeed(pokemon));
    }

    /**
     * 获取总努力值百分比字符串表示
     *
     * @return 总努力值百分比字符串
     */
    public static String getEvSumToString(@NotNull Pokemon pokemon) {
        return String.valueOf(BasePokemonUtil.getEvSum(pokemon));
    }

    /**
     * 获取 HP 的个体值字符串表示
     *
     * @return HP 个体值字符串
     */
    public static String getIvHPToString(@NotNull Pokemon pokemon) {
        return String.valueOf(BasePokemonUtil.getIvHP(pokemon));
    }

    /**
     * 获取攻击的个体值字符串表示
     *
     * @return 攻击个体值字符串
     */
    public static String getIvAttackToString(@NotNull Pokemon pokemon) {
        return String.valueOf(BasePokemonUtil.getIvAttack(pokemon));
    }

    /**
     * 获取防御的个体值字符串表示
     *
     * @return 防御个体值字符串
     */
    public static String getIvDefenceToString(@NotNull Pokemon pokemon) {
        return String.valueOf(BasePokemonUtil.getIvDefence(pokemon));
    }

    /**
     * 获取特攻的个体值字符串表示
     *
     * @return 特攻个体值字符串
     */
    public static String getIvSpecialAttackToString(@NotNull Pokemon pokemon) {
        return String.valueOf(BasePokemonUtil.getIvSpecialAttack(pokemon));
    }

    /**
     * 获取特防的个体值字符串表示
     *
     * @return 特防个体值字符串
     */
    public static String getIvSpecialDefenceToString(@NotNull Pokemon pokemon) {
        return String.valueOf(BasePokemonUtil.getIvSpecialDefence(pokemon));
    }

    /**
     * 获取速度的个体值字符串表示
     *
     * @return 速度个体值字符串
     */
    public static String getIvSpeedToString(@NotNull Pokemon pokemon) {
        return String.valueOf(BasePokemonUtil.getIvSpeed(pokemon));
    }

    /**
     * 获取个体值总和百分比字符串表示
     *
     * @return 个体值总和百分比字符串
     */
    public static String getIvSumToString(@NotNull Pokemon pokemon) {
        return String.valueOf(BasePokemonUtil.getIvSum(pokemon));
    }

    /**
     * 判断是否为最大个体值组合
     *
     * @return 是则返回“是”，否则返回“否”
     */
    public static String isMaxIvToString(@NotNull Pokemon pokemon) {
        return BasePokemonUtil.isMaxIv(pokemon) ? yes : no;
    }

    /**
     * 获取剩余努力值的字符串表示
     *
     * @return 剩余努力值字符串
     */
    public static String getRemainingEVsToString(@NotNull Pokemon pokemon) {
        return String.valueOf(BasePokemonUtil.getRemainingEVs(pokemon));
    }

    /**
     * 获取等级字符串表示
     *
     * @return 等级字符串
     */
    public static String getLevelToString(@NotNull Pokemon pokemon) {
        return String.valueOf(BasePokemonUtil.getLevel(pokemon));
    }

    /**
     * 判断是否为闪光精灵
     *
     * @return 是则返回“是”，否则返回“否”
     */
    public static String isShinyToString(@NotNull Pokemon pokemon) {
        return BasePokemonUtil.isShiny(pokemon) ? yes : no;
    }

    /**
     * 获取能力名称
     *
     * @return 能力名称字符串
     */
    public static String getAbilityName(@NotNull Pokemon pokemon) {
        return PokemonNameUtil.getAbilityName(BasePokemonUtil.getAbility(pokemon));
    }

    /**
     * 获取性别名称
     *
     * @return 性别名称字符串
     */
    public static String getGenderName(@NotNull Pokemon pokemon) {
        return PokemonNameUtil.getGenderName(BasePokemonUtil.getGender(pokemon));
    }

    /**
     * 获取体型缩放系数字符串表示
     *
     * @return 缩放系数字符串
     */
    public static String getScaleToString(@NotNull Pokemon pokemon) {
        return String.valueOf(BasePokemonUtil.getScale(pokemon));
    }

    /**
     * 获取表单的名称
     * <p>
     * 此方法用于获取当前表单的名称它通过调用getForm()方法获取表单实例，
     * 然后调用表单实例的getName()方法来获取表单的名称
     *
     * @return 表单的名称
     */
    public static String getFormName(@NotNull Pokemon pokemon) {
        return BasePokemonUtil.getForm(pokemon).getName();
    }

    /**
     * 获取性格名称
     *
     * @return 性格名称字符串
     */
    public static String getNatureName(@NotNull Pokemon pokemon) {
        return PokemonNameUtil.getNatureName(BasePokemonUtil.getNature(pokemon));
    }

    public static String getMintedNatureName(@NotNull Pokemon pokemon) {
        Nature mintedNature = BasePokemonUtil.getMintedNature(pokemon);
        return mintedNature != null ? PokemonNameUtil.getNatureName(mintedNature) : none;
    }

    /**
     * 获取性格类型描述（例如：攻击↑防御↓）
     *
     * @return 性格效果描述字符串
     */
    public static String getNatureType(@NotNull Pokemon pokemon) {
        return getNatureType(BasePokemonUtil.getNature(pokemon));
    }

    private static String getNatureType(@NotNull Nature nature) {
        Natures natures = Natures.INSTANCE;

        if (nature == natures.getHARDY() || nature == natures.getSERIOUS() || nature == natures.getDOCILE() || nature == natures.getBASHFUL() || nature == natures.getQUIRKY()) {
            return natureTypeBalanced;
        } else if (nature == natures.getLONELY()) {
            return natureTypeAttackDefenceDown;
        } else if (nature == natures.getBRAVE()) {
            return natureTypeAttackSpeedDown;
        } else if (nature == natures.getADAMANT()) {
            return natureTypeAttackSpecialAttackDown;
        } else if (nature == natures.getNAUGHTY()) {
            return natureTypeAttackSpecialDefenceDown;
        } else if (nature == natures.getBOLD()) {
            return natureTypeDefenceAttackDown;
        } else if (nature == natures.getRELAXED()) {
            return natureTypeDefenceSpeedDown;
        } else if (nature == natures.getIMPISH()) {
            return natureTypeDefenceSpecialAttackDown;
        } else if (nature == natures.getLAX()) {
            return natureTypeDefenceSpecialDefenceDown;
        } else if (nature == natures.getTIMID()) {
            return natureTypeSpeedAttackDown;
        } else if (nature == natures.getHASTY()) {
            return natureTypeSpeedDefenceDown;
        } else if (nature == natures.getJOLLY()) {
            return natureTypeSpeedSpecialAttackDown;
        } else if (nature == natures.getNAIVE()) {
            return natureTypeSpeedSpecialDefenceDown;
        } else if (nature == natures.getMODEST()) {
            return natureTypeSpecialAttackAttackDown;
        } else if (nature == natures.getMILD()) {
            return natureTypeSpecialAttackDefenceDown;
        } else if (nature == natures.getQUIET()) {
            return natureTypeSpecialAttackSpeedDown;
        } else if (nature == natures.getRASH()) {
            return natureTypeSpecialAttackSpecialDefenceDown;
        } else if (nature == natures.getCALM()) {
            return natureTypeSpecialDefenceAttackDown;
        } else if (nature == natures.getGENTLE()) {
            return natureTypeSpecialDefenceDefenceDown;
        } else if (nature == natures.getSASSY()) {
            return natureTypeSpecialDefenceSpeedDown;
        } else if (nature == natures.getCAREFUL()) {
            return natureTypeSpecialDefenceSpecialAttackDown;
        }

        return unknownNature;
    }

    public static String getMintedNatureType(@NotNull Pokemon pokemon) {
        return getNatureType(BasePokemonUtil.getMintedNature(pokemon));
    }

    /**
     * 获取第 i 个招式的名称
     *
     * @param i 招式索引
     * @return 招式名称字符串，如果不存在返回 none
     */
    public static String getMoveName(@NotNull Pokemon pokemon, int i) {
        Move move = BasePokemonUtil.getMove(pokemon, i);
        if (move == null) return none;
        return move.getDisplayName().getString();
    }

    /**
     * 获取第 i 个招式的属性类型名称
     *
     * @param pokemon 宝可梦对象
     * @param i 招式索引
     * @return 招式属性类型名称字符串，如果不存在返回 none
     */
    public static String getMoveTypeName(@NotNull Pokemon pokemon, int i) {
        ElementalType type = BasePokemonUtil.getMoveType(pokemon, i);
        if (type == null) return none;
        return type.getDisplayName().getString();
    }

    /**
     * 获取第 i 个招式的伤害类别名称
     *
     * @param pokemon 宝可梦对象
     * @param i 招式索引
     * @return 招式伤害类别名称字符串，如果不存在返回 none
     */
    public static String getMoveDamageCategoryName(@NotNull Pokemon pokemon, int i) {
        DamageCategory category = BasePokemonUtil.getMoveDamageCategory(pokemon, i);
        if (category == null) return none;
        return category.getDisplayName().getString();
    }

    /**
     * 获取第 i 个招式的类别名称（伤害类别的别名）
     *
     * @param pokemon 宝可梦对象
     * @param i 招式索引
     * @return 招式类别名称字符串，如果不存在返回 none
     */
    public static String getMoveCategoryName(@NotNull Pokemon pokemon, int i) {
        return getMoveDamageCategoryName(pokemon, i);
    }

    /**
     * 获取第 i 个招式的威力字符串表示
     *
     * @param pokemon 宝可梦对象
     * @param i 招式索引
     * @return 招式威力字符串，如果威力为0或负数返回 "-"
     */
    public static String getMovePowerToString(@NotNull Pokemon pokemon, int i) {
        double power = BasePokemonUtil.getMovePower(pokemon, i);
        return power > 0 ? String.valueOf(power) : "-";
    }

    /**
     * 获取第 i 个招式的命中率字符串表示
     *
     * @param pokemon 宝可梦对象
     * @param i 招式索引
     * @return 招式命中率字符串（带百分号），如果命中率为0或负数返回 "-"
     */
    public static String getMoveAccuracyToString(@NotNull Pokemon pokemon, int i) {
        double accuracy = BasePokemonUtil.getMoveAccuracy(pokemon, i);
        return accuracy > 0 ? accuracy + "%" : "-";
    }

    /**
     * 获取第 i 个招式的当前PP值字符串表示
     *
     * @param pokemon 宝可梦对象
     * @param i 招式索引
     * @return 当前PP值字符串
     */
    public static String getMoveCurrentPpToString(@NotNull Pokemon pokemon, int i) {
        return String.valueOf(BasePokemonUtil.getMoveCurrentPp(pokemon, i));
    }

    /**
     * 获取第 i 个招式的最大PP值字符串表示
     *
     * @param pokemon 宝可梦对象
     * @param i 招式索引
     * @return 最大PP值字符串
     */
    public static String getMoveMaxPpToString(@NotNull Pokemon pokemon, int i) {
        return String.valueOf(BasePokemonUtil.getMoveMaxPp(pokemon, i));
    }

    /**
     * 获取第 i 个招式的PP值比例字符串表示（当前PP/最大PP）
     *
     * @param pokemon 宝可梦对象
     * @param i 招式索引
     * @return PP值比例字符串，格式为 "当前PP/最大PP"
     */
    public static String getMovePPToString(@NotNull Pokemon pokemon, int i) {
        int currentPP = BasePokemonUtil.getMoveCurrentPp(pokemon, i);
        int maxPP = BasePokemonUtil.getMoveMaxPp(pokemon, i);
        return currentPP + "/" + maxPP;
    }

    /**
     * 获取第 i 个招式的描述信息
     *
     * @param pokemon 宝可梦对象
     * @param i 招式索引
     * @return 招式描述字符串
     */
    public static String getMoveDescription(@NotNull Pokemon pokemon, int i) {
        return BasePokemonUtil.getMoveDescription(pokemon, i);
    }

    /**
     * 获取宝可梦的主属性类型名称。
     *
     * @param pokemon 宝可梦对象，不能为 {@code null}。
     * @return 返回主属性类型的显示名称（如“火”、“水”等）。
     * @throws NullPointerException 如果传入的 pokemon 为 {@code null}，
     *                              或其主属性类型为 {@code null}（理论上不会发生，但为了安全起见进行检查）。
     */
    public static String getPrimaryTypeName(@NotNull Pokemon pokemon) {
        // 使用 BasePokemonUtils 工具类获取宝可梦的主属性类型
        ElementalType type = BasePokemonUtil.getPrimaryType(pokemon);

        // 获取该属性类型的本地化显示名称并转换为字符串形式返回
        return type.getDisplayName().getString();
    }

    /**
     * 获取宝可梦的副属性类型名称。部分宝可梦没有副属性，此时返回空字符串。
     *
     * @param pokemon 宝可梦对象，不能为 {@code null}。
     * @return 返回副属性类型的显示名称（如“飞行”、“格斗”等），若无副属性则返回空字符串。
     * @throws NullPointerException 如果传入的 pokemon 为 {@code null}。
     */
    public static String getSecondaryTypeName(@NotNull Pokemon pokemon) {
        // 使用 BasePokemonUtils 工具类获取宝可梦的副属性类型
        ElementalType type = BasePokemonUtil.getSecondaryType(pokemon);

        // 如果副属性不存在（type 为 null），返回空字符串；否则返回显示名称
        if (type == null) return "";
        return type.getDisplayName().getString();
    }


    /**
     * 获取全国图鉴编号字符串表示
     *
     * @return 图鉴编号字符串
     */
    public static String getNationalPokedexIntegerToString(@NotNull Pokemon pokemon) {
        return String.valueOf(BasePokemonUtil.getNationalPokedexNumber(pokemon));
    }

    /**
     * 获取亲密度字符串表示
     *
     * @return 亲密度字符串
     */
    public static String getFriendshipToString(@NotNull Pokemon pokemon) {
        return String.valueOf(BasePokemonUtil.getFriendship(pokemon));
    }

    /**
     * 以字符串形式返回Dmax级别
     * 此方法调用了getDmaxLevel()方法来获取Dmax级别的值，
     * 然后将其转换为字符串形式返回
     *
     * @return Dmax级别的字符串表示
     */
    public static String getDmaxLevelToString(@NotNull Pokemon pokemon) {
        return String.valueOf(BasePokemonUtil.getDmaxLevel(pokemon));
    }

    /**
     * 获取当前经验值字符串表示
     *
     * @return 当前经验值字符串
     */
    public static String getExpToString(@NotNull Pokemon pokemon) {
        return String.valueOf(BasePokemonUtil.getExp(pokemon));
    }

    /**
     * 获取到下一级所需经验字符串表示
     *
     * @return 所需经验数量字符串
     */
    public static String getExperienceToLevelUpToString(@NotNull Pokemon pokemon) {
        return String.valueOf(BasePokemonUtil.getExperienceToLevelUp(pokemon));
    }

    /**
     * 获取携带物品名称
     *
     * @return 物品名称字符串，如果没有携带物返回 none
     */
    public static String getHeldItemName(@NotNull Pokemon pokemon) {
        class_1799 heldItem = BasePokemonUtil.getHeldItem(pokemon);
        return PokemonNameUtil.getItemName(heldItem);
    }

    /**
     * 获取宝可梦唯一标识符字符串表示
     *
     * @return UUID 字符串
     */
    public static String getUUIDToString(@NotNull Pokemon pokemon) {
        return BasePokemonUtil.getUUID(pokemon).toString();
    }

    /**
     * 获取捕捉所使用的精灵球名称
     *
     * @return 精灵球名称字符串
     */
    public static String getCaughtBallName(@NotNull Pokemon pokemon) {
        return PokemonNameUtil.getPokeBallName(BasePokemonUtil.getCaughtBall(pokemon));
    }

    /**
     * 获取当前 HP 实战属性值字符串表示
     *
     * @return 实战 HP 字符串
     */
    public static String getStatHPToString(@NotNull Pokemon pokemon) {
        return String.valueOf(BasePokemonUtil.getStatHP(pokemon));
    }

    /**
     * 获取当前攻击实战属性值字符串表示
     *
     * @return 实战攻击字符串
     */
    public static String getStatAttackToString(@NotNull Pokemon pokemon) {
        return String.valueOf(BasePokemonUtil.getStatAttack(pokemon));
    }

    /**
     * 获取当前防御实战属性值字符串表示
     *
     * @return 实战防御字符串
     */
    public static String getStatDefenceToString(@NotNull Pokemon pokemon) {
        return String.valueOf(BasePokemonUtil.getStatDefence(pokemon));
    }

    /**
     * 获取当前特攻实战属性值字符串表示
     *
     * @return 实战特攻字符串
     */
    public static String getStatSpecialAttackToString(@NotNull Pokemon pokemon) {
        return String.valueOf(BasePokemonUtil.getStatSpecialAttack(pokemon));
    }

    /**
     * 获取当前特防实战属性值字符串表示
     *
     * @return 实战特防字符串
     */
    public static String getStatSpecialDefenceToString(@NotNull Pokemon pokemon) {
        return String.valueOf(BasePokemonUtil.getStatSpecialDefence(pokemon));
    }

    /**
     * 获取当前速度实战属性值字符串表示
     *
     * @return 实战速度字符串
     */
    public static String getStatSpeedToString(@NotNull Pokemon pokemon) {
        return String.valueOf(BasePokemonUtil.getStatSpeed(pokemon));
    }

    /**
     * 获取种族基础 HP 值字符串表示
     *
     * @return 基础 HP 字符串
     */
    public static String getBaseStatHPToString(@NotNull Pokemon pokemon) {
        return String.valueOf(BasePokemonUtil.getBaseStatHP(pokemon));
    }

    /**
     * 获取种族基础攻击值字符串表示
     *
     * @return 基础攻击字符串
     */
    public static String getBaseStatAttackToString(@NotNull Pokemon pokemon) {
        return String.valueOf(BasePokemonUtil.getBaseStatAttack(pokemon));
    }

    /**
     * 获取种族基础防御值字符串表示
     *
     * @return 基础防御字符串
     */
    public static String getBaseStatDefenceToString(@NotNull Pokemon pokemon) {
        return String.valueOf(BasePokemonUtil.getBaseStatDefence(pokemon));
    }

    /**
     * 获取种族基础特攻值字符串表示
     *
     * @return 基础特攻字符串
     */
    public static String getBaseStatSpecialAttackToString(@NotNull Pokemon pokemon) {
        return String.valueOf(BasePokemonUtil.getBaseStatSpecialAttack(pokemon));
    }

    /**
     * 获取种族基础特防值字符串表示
     *
     * @return 基础特防字符串
     */
    public static String getBaseStatSpecialDefenceToString(@NotNull Pokemon pokemon) {
        return String.valueOf(BasePokemonUtil.getBaseStatSpecialDefence(pokemon));
    }

    /**
     * 获取种族基础速度值字符串表示
     *
     * @return 基础速度字符串
     */
    public static String getBaseStatSpeedToString(@NotNull Pokemon pokemon) {
        return String.valueOf(BasePokemonUtil.getBaseStatSpeed(pokemon));
    }

    /**
     * 获取种族基础属性总和字符串表示
     *
     * @return 属性总和字符串
     */
    public static String getBaseStatSumToString(@NotNull Pokemon pokemon) {
        return String.valueOf(BasePokemonUtil.getBaseStatSum(pokemon));
    }

    /**
     * 获取捕获率字符串表示
     *
     * @return 捕获率字符串
     */
    public static String getCatchRateToString(@NotNull Pokemon pokemon) {
        return String.valueOf(BasePokemonUtil.getCatchRate(pokemon));
    }

    /**
     * 获取持有者玩家名称
     *
     * @return 玩家名称字符串，没有则返回 none
     */
    public static String getOwnerPlayerName(@NotNull Pokemon pokemon) {
        OfflinePlayer player = BasePokemonUtil.getBukkitOfflineOwnerPlayer(pokemon);
        if (player == null) return none;
        return player.getName();
    }

    /**
     * 获取交易是否可用的字符串表示
     * <p>
     * 此方法用于提供一个用户友好的方式来判断交易是否可用
     * 它根据isTradeAble()方法的返回值来返回相应的字符串
     * 如果交易可用，返回yes，否则返回no
     *
     * @return 如果交易可用返回yes，否则返回no
     */
    public static String getTradeAbleToString(@NotNull Pokemon pokemon) {
        return BasePokemonUtil.isTradeAble(pokemon) ? yes : no;
    }

}
