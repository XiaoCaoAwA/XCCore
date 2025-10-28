package xiaocaoawa.miencraft.plugin.xccobblemoncore.util.CobblemonUtil;

import com.cobblemon.mod.common.api.abilities.Ability;
import com.cobblemon.mod.common.api.moves.Move;
import com.cobblemon.mod.common.api.moves.categories.DamageCategory;
import com.cobblemon.mod.common.api.pokemon.stats.Stats;
import com.cobblemon.mod.common.api.types.ElementalType;
import com.cobblemon.mod.common.entity.npc.NPCEntity;
import com.cobblemon.mod.common.pokeball.PokeBall;
import com.cobblemon.mod.common.pokemon.*;
import net.minecraft.class_1309;
import net.minecraft.class_1799;
import net.minecraft.class_3222;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

/**
 * @author langle__
 * @version 1.0
 */
public class CobblemonBasePokemonUtil {

    private static final int IV_SUM = IVs.MAX_VALUE * 6;
    
    // 静态初始化标志，控制工具类是否可用
    private static boolean initialized = false;

    // 私有构造器防止实例化
    private CobblemonBasePokemonUtil() {}
    
    /**
     * 设置工具类为已初始化状态
     * 此方法应由 CobblemonDetector 在检测到 Cobblemon 模组成功后调用
     */
    public static void setInitialized() {
        initialized = true;
    }
    
    


    /**
     * 判断当前是否为空对象（即 pokemon 是否为null）
     *
     * @return 如果 pokemon 为null 返回 true，否则返回false
     */
    public static boolean isAir(@Nullable Pokemon pokemon) {
        if (!initialized) return false;
        return pokemon == null;
    }

    // 基础信息

    /**
     * 获取宝可梦的物种信息
     *
     * @return 宝可梦的物种对象
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static Species getSpecies(@NotNull Pokemon pokemon) {
        if (!initialized) return null;
        return pokemon.getSpecies();
    }

    /**
     * 获取宝可梦的昵称
     *
     * @return 昵称字符串
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static String getNickName(@NotNull Pokemon pokemon) {
        if (!initialized) return "";
        return pokemon.getDisplayName().getString();
    }

    // 等级 & 经验

    /**
     * 获取宝可梦的等级
     *
     * @return 当前等级
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static int getLevel(@NotNull Pokemon pokemon) {
        if (!initialized) return 0;
        return pokemon.getLevel();
    }

    /**
     * 获取宝可梦当前的经验值
     *
     * @return 当前经验值
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static int getExp(@NotNull Pokemon pokemon) {
        if (!initialized) return 0;
        return pokemon.getExperience();
    }

    /**
     * 获取到下一级所需的经验值
     *
     * @return 所需经验数量
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static int getExperienceToLevelUp(@NotNull Pokemon pokemon) {
        if (!initialized) return 0;
        return pokemon.getExperienceToNextLevel();
    }

    // 努力值(EVs)

    /**
     * 获取 HP 的努力值
     *
     * @return HP 努力值
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static int getEvHP(@NotNull Pokemon pokemon) {
        if (!initialized) return 0;
        Integer value = pokemon.getEvs().get(Stats.HP);
        return value == null ? 0 : value;
    }

    /**
     * 获取攻击的努力值
     *
     * @return 攻击努力值
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static int getEvAttack(@NotNull Pokemon pokemon) {
        if (!initialized) return 0;
        Integer value = pokemon.getEvs().get(Stats.ATTACK);
        return value == null ? 0 : value;
    }

    /**
     * 获取防御的努力值
     *
     * @return 防御努力值
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static int getEvDefence(@NotNull Pokemon pokemon) {
        if (!initialized) return 0;
        Integer value = pokemon.getEvs().get(Stats.DEFENCE);
        return value == null ? 0 : value;
    }

    /**
     * 获取特攻的努力值
     *
     * @return 特攻努力值
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static int getEvSpecialAttack(@NotNull Pokemon pokemon) {
        if (!initialized) return 0;
        Integer value = pokemon.getEvs().get(Stats.SPECIAL_ATTACK);
        return value == null ? 0 : value;
    }

    /**
     * 获取特防的努力值
     *
     * @return 特防努力值
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static int getEvSpecialDefence(@NotNull Pokemon pokemon) {
        if (!initialized) return 0;
        Integer value = pokemon.getEvs().get(Stats.SPECIAL_DEFENCE);
        return value == null ? 0 : value;
    }

    /**
     * 获取速度的努力值
     *
     * @return 速度努力值
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static int getEvSpeed(@NotNull Pokemon pokemon) {
        if (!initialized) return 0;
        Integer value = pokemon.getEvs().get(Stats.SPEED);
        return value == null ? 0 : value;
    }

    /**
     * 获取总努力值百分比（以最大值510 为基准）
     *
     * @return 总努力值百分比
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static int getEvSum(@NotNull Pokemon pokemon) {
        if (!initialized) return 0;
        int sum = getEvHP(pokemon) + getEvAttack(pokemon) + getEvDefence(pokemon) + getEvSpecialAttack(pokemon) + getEvSpecialDefence(pokemon) + getEvSpeed(pokemon);
        return sum * 100 / EVs.MAX_STAT_VALUE;
    }

    // 个体值(IVs)

    /**
     * 获取 HP 的个体值
     *
     * @return HP 个体值
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static int getIvHP(@NotNull Pokemon pokemon) {
        if (!initialized) return 0;
        Integer value = pokemon.getIvs().get(Stats.HP);
        return value == null ? 0 : value;
    }

    /**
     * 获取攻击的个体值
     *
     * @return 攻击个体值
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static int getIvAttack(@NotNull Pokemon pokemon) {
        if (!initialized) return 0;
        Integer value = pokemon.getIvs().get(Stats.ATTACK);
        return value == null ? 0 : value;
    }

    /**
     * 获取防御的个体值
     *
     * @return 防御个体值
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static int getIvDefence(@NotNull Pokemon pokemon) {
        if (!initialized) return 0;
        Integer value = pokemon.getIvs().get(Stats.DEFENCE);
        return value == null ? 0 : value;
    }

    /**
     * 获取特攻的个体值
     *
     * @return 特攻个体值
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static int getIvSpecialAttack(@NotNull Pokemon pokemon) {
        if (!initialized) return 0;
        Integer value = pokemon.getIvs().get(Stats.SPECIAL_ATTACK);
        return value == null ? 0 : value;
    }

    /**
     * 获取特防的个体值
     *
     * @return 特防个体值
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static int getIvSpecialDefence(@NotNull Pokemon pokemon) {
        if (!initialized) return 0;
        Integer value = pokemon.getIvs().get(Stats.SPECIAL_DEFENCE);
        return value == null ? 0 : value;
    }

    /**
     * 获取速度的个体值
     *
     * @return 速度个体值
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static int getIvSpeed(@NotNull Pokemon pokemon) {
        if (!initialized) return 0;
        Integer value = pokemon.getIvs().get(Stats.SPEED);
        return value == null ? 0 : value;
    }

    /**
     * 获取个体值总和百分比（以最大值186 为基准）
     *
     * @return 个体值总和百分比
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static int getIvSum(@NotNull Pokemon pokemon) {
        if (!initialized) return 0;
        int sum = getIvHP(pokemon) + getIvAttack(pokemon) + getIvDefence(pokemon) + getIvSpecialAttack(pokemon) + getIvSpecialDefence(pokemon) + getIvSpeed(pokemon);
        return sum * 100 / IV_SUM;
    }

    // 最大个体值判断

    /**
     * 判断 HP 是否达到最大个体值（MAX_IV）
     *
     * @return 是否达到最大个体值
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static boolean isMaxIvHP(@NotNull Pokemon pokemon) {
        if (!initialized) return false;
        return getIvHP(pokemon) == IVs.MAX_VALUE;
    }

    /**
     * 判断攻击是否达到最大个体值（MAX_IV）
     *
     * @return 是否达到最大个体值
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static boolean isMaxIvAttack(@NotNull Pokemon pokemon) {
        if (!initialized) return false;
        return getIvAttack(pokemon) == IVs.MAX_VALUE;
    }

    /**
     * 判断防御是否达到最大个体值（MAX_IV）
     *
     * @return 是否达到最大个体值
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static boolean isMaxIvDefence(@NotNull Pokemon pokemon) {
        if (!initialized) return false;
        return getIvDefence(pokemon) == IVs.MAX_VALUE;
    }

    /**
     * 判断特攻是否达到最大个体值（MAX_IV）
     *
     * @return 是否达到最大个体值
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static boolean isMaxIvSpecialAttack(@NotNull Pokemon pokemon) {
        if (!initialized) return false;
        return getIvSpecialAttack(pokemon) == IVs.MAX_VALUE;
    }

    /**
     * 判断特防是否达到最大个体值（MAX_IV）
     *
     * @return 是否达到最大个体值
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static boolean isMaxIvSpecialDefence(@NotNull Pokemon pokemon) {
        if (!initialized) return false;
        return getIvSpecialDefence(pokemon) == IVs.MAX_VALUE;
    }

    /**
     * 判断速度是否达到最大个体值（MAX_IV）
     *
     * @return 是否达到最大个体值
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static boolean isMaxIvSpeed(@NotNull Pokemon pokemon) {
        if (!initialized) return false;
        return getIvSpeed(pokemon) == IVs.MAX_VALUE;
    }

    /**
     * 获取达到最大个体值(MAX_IV) 的属性数量
     *
     * @return 达到最大个体值的属性数量
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static int countMaxIvs(@NotNull Pokemon pokemon) {
        if (!initialized) return 0;
        int count = 0;
        if (isMaxIvHP(pokemon)) count++;
        if (isMaxIvAttack(pokemon)) count++;
        if (isMaxIvDefence(pokemon)) count++;
        if (isMaxIvSpecialAttack(pokemon)) count++;
        if (isMaxIvSpecialDefence(pokemon)) count++;
        if (isMaxIvSpeed(pokemon)) count++;
        return count;
    }

    /**
     * 判断所有个体值是否都达到了最大值（MAX_IV）
     *
     * @return 如果全部个体值都达到最大值则返回 true
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static boolean isMaxIv(@NotNull Pokemon pokemon) {
        if (!initialized) return false;
        return isMaxIvHP(pokemon) && isMaxIvAttack(pokemon) && isMaxIvDefence(pokemon) && isMaxIvSpecialAttack(pokemon) && isMaxIvSpecialDefence(pokemon) && isMaxIvSpeed(pokemon);
    }

    // 最大努力值判断

    /**
     * 判断 HP 是否达到最大努力值（MAX_EV）
     *
     * @return 是否达到最大努力值
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static boolean isMaxEvHP(@NotNull Pokemon pokemon) {
        if (!initialized) return false;
        return getEvHP(pokemon) >= EVs.MAX_STAT_VALUE;
    }

    /**
     * 判断攻击是否达到最大努力值（MAX_EV）
     *
     * @return 是否达到最大努力值
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static boolean isMaxEvAttack(@NotNull Pokemon pokemon) {
        if (!initialized) return false;
        return getEvAttack(pokemon) >= EVs.MAX_STAT_VALUE;
    }

    /**
     * 判断防御是否达到最大努力值（MAX_EV）
     *
     * @return 是否达到最大努力值
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static boolean isMaxEvDefence(@NotNull Pokemon pokemon) {
        if (!initialized) return false;
        return getEvDefence(pokemon) >= EVs.MAX_STAT_VALUE;
    }

    /**
     * 判断特攻是否达到最大努力值（MAX_EV）
     *
     * @return 是否达到最大努力值
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static boolean isMaxEvSpecialAttack(@NotNull Pokemon pokemon) {
        if (!initialized) return false;
        return getEvSpecialAttack(pokemon) >= EVs.MAX_STAT_VALUE;
    }

    /**
     * 判断特防是否达到最大努力值（MAX_EV）
     *
     * @return 是否达到最大努力值
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static boolean isMaxEvSpecialDefence(@NotNull Pokemon pokemon) {
        if (!initialized) return false;
        return getEvSpecialDefence(pokemon) >= EVs.MAX_STAT_VALUE;
    }

    /**
     * 判断速度是否达到最大努力值（MAX_EV）
     *
     * @return 是否达到最大努力值
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static boolean isMaxEvSpeed(@NotNull Pokemon pokemon) {
        if (!initialized) return false;
        return getEvSpeed(pokemon) >= EVs.MAX_STAT_VALUE;
    }

    /**
     * 判断总努力值是否达到上限（510）
     *
     * @return 是否达到上限
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static boolean isMaxEv(@NotNull Pokemon pokemon) {
        if (!initialized) return false;
        int sum = getEvHP(pokemon) + getEvAttack(pokemon) + getEvDefence(pokemon) + getEvSpecialAttack(pokemon) + getEvSpecialDefence(pokemon) + getEvSpeed(pokemon);
        return sum >= EVs.MAX_TOTAL_VALUE;
    }

    /**
     * 获取宝可梦剩余的努力值点数（总上限为 510，已使用部分将被扣除）
     *
     * @return 剩余的努力值总数
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static int getRemainingEVs(@NotNull Pokemon pokemon) {
        if (!initialized) return 0;
        int used = getEvHP(pokemon) + getEvAttack(pokemon) + getEvDefence(pokemon) + getEvSpecialAttack(pokemon) + getEvSpecialDefence(pokemon) + getEvSpeed(pokemon);
        return Math.max(0, EVs.MAX_TOTAL_VALUE - used);
    }

    // 形态 & 属性

    /**
     * 获取宝可梦的性别
     *
     * @return 性别枚举
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static Gender getGender(@NotNull Pokemon pokemon) {
        if (!initialized) return null;
        return pokemon.getGender();
    }

    /**
     * 获取宝可梦的原始性格
     * <p>
     * 此方法用于返回当前宝可梦的原始性格（Nature）对象如果宝可梦对象为空，
     * 则抛出NullPointerException异常这确保调用者可以意识到宝可梦对象未被正确初始化的问题
     *
     * @return Nature 返回宝可梦的原始性格对象
     * @throws NullPointerException 如果宝可梦对象为null，则抛出此异常
     */
    public static Nature getMintedNature(@NotNull Pokemon pokemon) {
        if (!initialized) return null;
        return pokemon.getMintedNature();
    }

    /**
     * 获取宝可梦的性格
     *
     * @return 性格对象
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static Nature getNature(@NotNull Pokemon pokemon) {
        if (!initialized) return null;
        return pokemon.getNature();
    }

    /**
     * 获取宝可梦的体型缩放系数
     *
     * @return 缩放系数
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static float getScale(@NotNull Pokemon pokemon) {
        if (!initialized) return 0.0f;
        return pokemon.getScaleModifier();
    }

    /**
     * 获取宝可梦的形态数据
     *
     * @return 形态数据对象
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static FormData getForm(@NotNull Pokemon pokemon) {
        if (!initialized) return null;
        return pokemon.getForm();
    }

    /**
     * 获取宝可梦的主属性类型。
     * <p>
     * 主属性是宝可梦固有的属性之一，每个宝可梦必定有一个主属性。
     * 例如：火系、水系等。
     *
     * @param pokemon 宝可梦对象，不能为{@code null}。
     * @return 返回主属性类型（ElementalType），火、水、草等。
     * @throws NullPointerException 如果传入的pokemon 为{@code null}，
     *                              或其形态数据（FormData）为 null（由 getForm 抛出）。
     */
    public static ElementalType getPrimaryType(@NotNull Pokemon pokemon) {
        if (!initialized) return null;
        // 调用 getForm 获取宝可梦的形态数据，并获取其主属性类型
        return getForm(pokemon).getPrimaryType();
    }

    /**
     * 获取宝可梦的副属性类型。
     *
     * 副属性是部分宝可梦拥有的第二个属性，若该宝可梦没有副属性，则返回null。
     * 例如：飞行系、格斗系等。
     *
     * @param pokemon 宝可梦对象，不能为{@code null}。
     * @return 返回副属性类型（ElementalType），如果没有副属性则返回 {@code null}。
     * @throws NullPointerException 如果传入的pokemon 为{@code null}，
     *                              或其形态数据（FormData）为 null（由 getForm 抛出）。
     */
    public static ElementalType getSecondaryType(@NotNull Pokemon pokemon) {
        if (!initialized) return null;
        // 调用 getForm 获取宝可梦的形态数据，并获取其副属性类型
        return getForm(pokemon).getSecondaryType();
    }

    /**
     * 判断该宝可梦是否是闪光精灵
     *
     * @return 是否为闪光
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static boolean isShiny(@NotNull Pokemon pokemon) {
        if (!initialized) return false;
        return pokemon.getShiny();
    }

    // 能力 & 招式

    /**
     * 获取宝可梦的能力
     *
     * @return 能力对象
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static Ability getAbility(@NotNull Pokemon pokemon) {
        if (!initialized) return null;
        return pokemon.getAbility();
    }

    /**
     * 获取�?i 个招�?
     *
     * @param i 招式槽位索引
     * @return 招式对象，如果不存在则返回null
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static Move getMove(@NotNull Pokemon pokemon, int i) {
        if (!initialized) return null;
        if (pokemon.getMoveSet().get(i) == null) return null;
        return pokemon.getMoveSet().get(i);
    }

    public static ElementalType getMoveType(@NotNull Pokemon pokemon, int i) {
        if (!initialized) return null;
        Move move = getMove(pokemon, i);
        if (move == null) return null;
        return move.getType();
    }

    public static DamageCategory getMoveDamageCategory(@NotNull Pokemon pokemon, int i) {
        if (!initialized) return null;
        Move move = getMove(pokemon, i);
        if (move == null) return null;
        return move.getDamageCategory();
    }

    public static double getMovePower(@NotNull Pokemon pokemon, int i) {
        if (!initialized) return 0;
        Move move = getMove(pokemon, i);
        if (move == null) return 0;
        return move.getPower();
    }

    public static double getMoveAccuracy(@NotNull Pokemon pokemon, int i) {
        if (!initialized) return 0;
        Move move = getMove(pokemon, i);
        if (move == null) return 0;
        return move.getAccuracy();
    }

    public static int getMoveCurrentPp(@NotNull Pokemon pokemon, int i) {
        if (!initialized) return 0;
        Move move = getMove(pokemon, i);
        if (move == null) return 0;
        return move.getCurrentPp();
    }

    public static int getMoveMaxPp(@NotNull Pokemon pokemon, int i) {
        if (!initialized) return 0;
        Move move = getMove(pokemon, i);
        if (move == null) return 0;
        return move.getMaxPp();
    }

    public static String getMoveDescription(@NotNull Pokemon pokemon, int i) {
        if (!initialized) return "";
        Move move = getMove(pokemon, i);
        if (move == null) return CobblemonUtil.none;
        return move.getDescription().toString();
    }

    // 图鉴 & 捕获

    /**
     * 获取全国图鉴编号
     *
     * @return 图鉴编号
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static int getNationalPokedexNumber(@NotNull Pokemon pokemon) {
        if (!initialized) return 0;
        return pokemon.getSpecies().getNationalPokedexNumber();
    }

    /**
     * 获取捕获率
     *
     * @return 捕获率
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static int getCatchRate(@NotNull Pokemon pokemon) {
        if (!initialized) return 0;
        return getSpecies(pokemon).getCatchRate();
    }

    /**
     * 获取捕捉所使用的精灵球
     *
     * @return 精灵球对象
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static PokeBall getCaughtBall(@NotNull Pokemon pokemon) {
        if (!initialized) return null;
        return pokemon.getCaughtBall();
    }

    // 战斗属性

    /**
     * 获取当前 HP 实战属性值
     *
     * @return 实战 HP
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static int getStatHP(@NotNull Pokemon pokemon) {
        if (!initialized) return 0;
        return pokemon.getStat(Stats.HP);
    }

    /**
     * 获取当前攻击实战属性值
     *
     * @return 实战攻击
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static int getStatAttack(@NotNull Pokemon pokemon) {
        if (!initialized) return 0;
        return pokemon.getStat(Stats.ATTACK);
    }

    /**
     * 获取当前防御实战属性值
     *
     * @return 实战防御
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static int getStatDefence(@NotNull Pokemon pokemon) {
        if (!initialized) return 0;
        return pokemon.getStat(Stats.DEFENCE);
    }

    /**
     * 获取当前特攻实战属性值
     *
     * @return 实战特攻
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static int getStatSpecialAttack(@NotNull Pokemon pokemon) {
        if (!initialized) return 0;
        return pokemon.getStat(Stats.SPECIAL_ATTACK);
    }

    /**
     * 获取当前特防实战属性值
     *
     * @return 实战特防
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static int getStatSpecialDefence(@NotNull Pokemon pokemon) {
        if (!initialized) return 0;
        return pokemon.getStat(Stats.SPECIAL_DEFENCE);
    }

    /**
     * 获取当前速度实战属性值
     *
     * @return 实战速度
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static int getStatSpeed(@NotNull Pokemon pokemon) {
        if (!initialized) return 0;
        return pokemon.getStat(Stats.SPEED);
    }

    /**
     * 获取实战属性值总和
     *
     * @return 实战属性值总和
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static int getStatSum(@NotNull Pokemon pokemon) {
        if (!initialized) return 0;
        return getStatHP(pokemon) + getStatAttack(pokemon) + getStatDefence(pokemon) + getStatSpecialAttack(pokemon) + getStatSpecialDefence(pokemon) + getStatSpeed(pokemon);
    }

    // 种族基础属性

    /**
     * 获取种族基础 HP 属性值
     *
     * @return 种族基础 HP
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static int getBaseStatHP(@NotNull Pokemon pokemon) {
        if (!initialized) return 0;
        return getSpecies(pokemon).getBaseStats().get(Stats.HP);
    }

    /**
     * 获取种族基础攻击属性值
     *
     * @return 种族基础攻击
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static int getBaseStatAttack(@NotNull Pokemon pokemon) {
        if (!initialized) return 0;
        return getSpecies(pokemon).getBaseStats().get(Stats.ATTACK);
    }

    /**
     * 获取种族基础防御属性值
     *
     * @return 种族基础防御
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static int getBaseStatDefence(@NotNull Pokemon pokemon) {
        if (!initialized) return 0;
        return getSpecies(pokemon).getBaseStats().get(Stats.DEFENCE);
    }

    /**
     * 获取种族基础特攻属性值
     *
     * @return 种族基础特攻
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static int getBaseStatSpecialAttack(@NotNull Pokemon pokemon) {
        if (!initialized) return 0;
        return getSpecies(pokemon).getBaseStats().get(Stats.SPECIAL_ATTACK);
    }

    /**
     * 获取种族基础特防属性值
     *
     * @return 种族基础特防
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static int getBaseStatSpecialDefence(@NotNull Pokemon pokemon) {
        if (!initialized) return 0;
        return getSpecies(pokemon).getBaseStats().get(Stats.SPECIAL_DEFENCE);
    }

    /**
     * 获取种族基础速度属性值
     *
     * @return 种族基础速度
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static int getBaseStatSpeed(@NotNull Pokemon pokemon) {
        if (!initialized) return 0;
        return getSpecies(pokemon).getBaseStats().get(Stats.SPEED);
    }

    /**
     * 获取种族基础属性值总和
     *
     * @return 种族基础属性值总和
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static int getBaseStatSum(@NotNull Pokemon pokemon) {
        if (!initialized) return 0;
        return getBaseStatHP(pokemon) + getBaseStatAttack(pokemon) + getBaseStatDefence(pokemon) + getBaseStatSpecialAttack(pokemon) + getBaseStatSpecialDefence(pokemon) + getBaseStatSpeed(pokemon);
    }

    // 其他信息

    /**
     * 获取宝可梦的亲密度
     *
     * @return 亲密度值
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static int getFriendship(@NotNull Pokemon pokemon) {
        if (!initialized) return 0;
        return pokemon.getFriendship();
    }

    /**
     * 获取宝可梦的最大等级
     * <p>
     * 此方法通过调用宝可梦对象的getDmaxLevel方法来获取最大等级
     * 它没有参数，返回一个整数值，表示宝可梦的最大等级
     *
     * @return 最大等级的整数值
     */
    public static int getDmaxLevel(@NotNull Pokemon pokemon) {
        if (!initialized) return 0;
        return pokemon.getDmaxLevel();
    }

    /**
     * 获取携带物品
     *
     * @return 物品对象
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static class_1799 getHeldItem(@NotNull Pokemon pokemon) {
        if (!initialized) return null;
        return pokemon.getHeldItem$common();
    }

    /**
     * 获取宝可梦唯一标识符
     *
     * @return UUID
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static UUID getUUID(@NotNull Pokemon pokemon) {
        if (!initialized) return null;
        return pokemon.getUuid();
    }

    /**
     * 获取宝可梦持有者的 UUID
     *
     * @return 持有者UUID
     * @throws NullPointerException 如果 pokemon 为null
     */
    public static UUID getOwnerUUID(@NotNull Pokemon pokemon) {
        if (!initialized) return null;
        return pokemon.getOwnerUUID();
    }

    /**
     * 获取宝可梦的原始训练师
     * <p>
     * 此方法用于获取当前宝可梦实例的原始训练家信息如果宝可梦实例为空，
     * 则抛出NullPointerException异常，提示"Pokemon is null"这样做是为了避免
     * 访问空对象，确保程序的健壮性
     *
     * @return String 返回宝可梦的原始训练家名称
     * @throws NullPointerException 如果pokemon为null，则抛出此异常，提示"Pokemon is null"
     */
    public static String getOriginalTrainer(@NotNull Pokemon pokemon) {
        if (!initialized) return "";
        return pokemon.getOriginalTrainer();
    }

    /**
     * 获取宝可梦的原训练家名称
     * <p>
     * 此方法用于获取当前宝可梦所属的原训练家名称如果宝可梦对象为空，则抛出NullPointerException异常
     *
     * @return String 当前宝可梦的原训练家名称
     * @throws NullPointerException 如果宝可梦对象为空，则抛出此异常
     */
    public static String getOriginalTrainerName(@NotNull Pokemon pokemon) {
        if (!initialized) return "";
        String originalTrainerName = pokemon.getOriginalTrainerName();
        return originalTrainerName == null ? CobblemonUtil.yes : originalTrainerName;
    }

    /**
     * 获取宝可梦的原训练家类型
     * <p>
     * 此方法用于获取当前宝可梦所属的原训练家类型如果宝可梦对象为空，则抛出NullPointerException异常
     *
     * @return OriginalTrainerType 当前宝可梦的原训练家类型
     * @throws NullPointerException 如果宝可梦对象为空，则抛出此异常
     */
    public static OriginalTrainerType getOriginalTrainerType(@NotNull Pokemon pokemon) {
        if (!initialized) return null;
        return pokemon.getOriginalTrainerType();
    }

    /**
     * 获取宝可梦持有者的 Minecraft 原版玩家实体对象
     *
     * @return 返回 Minecraft 原生玩家对象（class_3222），如果宝可梦未被玩家持有则返回 null
     * @throws NullPointerException 如果当前宝可梦对象为 null
     */
    public static class_3222 getOwnerPlayer(@NotNull Pokemon pokemon) {
        if (!initialized) return null;
        return pokemon.getOwnerPlayer();
    }

    /**
     * 获取对应的 Bukkit 玩家对象
     *
     * @return Bukkit 的 Player 对象，如果没有持有者则返回 null
     * @throws NullPointerException 如果宝可梦为 null
     */
    public static Player getBukkitOwnerPlayer(@NotNull Pokemon pokemon) {
        if (!initialized) return null;
        if (getOwnerPlayer(pokemon) == null) return null;
        return Bukkit.getPlayer(getOwnerUUID(pokemon));
    }

    /**
     * 获取对应的 Bukkit 离线玩家对象
     *
     * @return Bukkit 的 OfflinePlayer 对象
     * @throws NullPointerException 如果宝可梦为 null
     */
    public static OfflinePlayer getBukkitOfflineOwnerPlayer(@NotNull Pokemon pokemon) {
        if (!initialized) return null;
        if (getOwnerPlayer(pokemon) == null) return null;
        return Bukkit.getOfflinePlayer(getOwnerUUID(pokemon));
    }

    /**
     * 获取宝可梦的持有者 NPC 实体（如通过 Cobblemon 的 NPC 功能获得）。
     *
     * @return 返回 NPCEntity 对象，如果宝可梦不是被 NPC 拥有则返回 null
     * @throws NullPointerException 如果当前宝可梦对象为 null
     */
    public static NPCEntity getOwnerNPC(@NotNull Pokemon pokemon) {
        if (!initialized) return null;
        return pokemon.getOwnerNPC();
    }

    /**
     * 获取宝可梦持有者的实体对象（适用于非玩家、NPC 的其他实体类型）。
     *
     * @return 返回 Minecraft 实体对象（class_1309），如果无持有者则返回 null
     * @throws NullPointerException 如果当前宝可梦对象为 null
     */
    public static class_1309 getOwnerEntity(@NotNull Pokemon pokemon) {
        if (!initialized) return null;
        return pokemon.getOwnerEntity();
    }

    /**
     * 判断当前宝可梦是否可交易
     * <p>
     * 此方法用于检查当前宝可梦对象是否处于可交易的状态在执行检查之前，
     * 方法会验证宝可梦对象是否已被初始化（非null），以避免空指针异常
     *
     * @return boolean 返回宝可梦的可交易状态true表示可交易，false表示不可交易
     * @throws NullPointerException 如果宝可梦对象为null，则抛出空指针异常，并提供异消息Pokemon is null"
     */
    public static boolean isTradeAble(@NotNull Pokemon pokemon) {
        if (!initialized) return false;
        // 返回宝可梦的可交易状态
        return pokemon.getTradeable();
    }

}
