package xiaocaoawa.miencraft.plugin.xccore.util.CobblemonUtil;

import com.cobblemon.mod.common.Cobblemon;
import com.cobblemon.mod.common.api.storage.party.PlayerPartyStore;
import com.cobblemon.mod.common.pokemon.Pokemon;
import com.cobblemon.mod.common.pokemon.Species;
import com.cobblemon.mod.common.util.LocalizationUtilsKt;
import net.minecraft.class_3222;
import org.bukkit.entity.Player;
import xiaocaoawa.miencraft.plugin.xccore.util.BukkitNmsUtil.BukkitNmsConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * 宝可梦队伍工具类
 * 提供对玩家宝可梦队伍的各种检查和操作方法
 */
public class CobblemonPartyUtil {

    // 静态初始化标志，控制功能是否可用
    private static boolean initialized = false;

    /**
     * 设置初始化状态
     * 只有在 Cobblemon 模组检测成功后才应该调用此方法
     */
    public static void setInitialized() {
        initialized = true;
    }

    /**
     * 获取玩家的宝可梦队伍存储
     * @param player 玩家
     * @return 宝可梦队伍存储，如果获取失败则返回null
     */
    public static PlayerPartyStore getPlayerPartyStore(Player player) {
        if (!initialized) return null;
        class_3222 serverPlayer = BukkitNmsConverter.toPlayer(player);
        if (serverPlayer == null) {
            return null;
        }
        return Cobblemon.INSTANCE.getStorage().getParty(serverPlayer);
    }

    /**
     * 获取玩家队伍中的所有宝可梦（不包含空位）
     * @param player 玩家
     * @return 玩家队伍中的所有宝可梦列表，如果获取失败则返回空列表
     */
    public static List<Pokemon> getAllPokemon(Player player) {
        if (!initialized) return new ArrayList<>();
        List<Pokemon> allPokemon = new ArrayList<>();
        PlayerPartyStore partyStore = getPlayerPartyStore(player);
        if (partyStore == null) {
            return allPokemon;
        }

        for (Pokemon pokemon : partyStore) {
            if (pokemon != null) {
                allPokemon.add(pokemon);
            }
        }
        return allPokemon;
    }

    /**
     * 检查玩家队伍中是否存在传奇宝可梦
     * @param player 玩家
     * @return 是否存在传奇宝可梦
     */
    public static boolean hasLegendaryPokemon(Player player) {
        if (!initialized) return false;
        PlayerPartyStore partyStore = getPlayerPartyStore(player);
        if (partyStore == null) {
            return false;
        }

        for (Pokemon pokemon : partyStore) {
            if (pokemon != null && pokemon.isLegendary()) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取玩家队伍中第一个传奇宝可梦
     * @param player 玩家
     * @return 传奇宝可梦，如果没有则返回null
     */
    public static Pokemon getFirstLegendaryPokemon(Player player) {
        if (!initialized) return null;
        PlayerPartyStore partyStore = getPlayerPartyStore(player);
        if (partyStore == null) {
            return null;
        }

        for (Pokemon pokemon : partyStore) {
            if (pokemon != null && pokemon.isLegendary()) {
                return pokemon;
            }
        }
        return null;
    }

    /**
     * 获取玩家队伍中第一个传奇宝可梦的名称
     * @param player 玩家
     * @return 传奇宝可梦的名称，如果没有则返回null
     */
    public static String getFirstLegendaryPokemonName(Player player) {
        if (!initialized) return null;
        Pokemon legendaryPokemon = getFirstLegendaryPokemon(player);
        return legendaryPokemon != null ? legendaryPokemon.getDisplayName().getString() : null;
    }

    /**
     * 获取玩家队伍中所有传奇宝可梦
     * @param player 玩家
     * @return 传奇宝可梦列表
     */
    public static List<Pokemon> getAllLegendaryPokemon(Player player) {
        if (!initialized) return new ArrayList<>();
        List<Pokemon> legendaryPokemon = new ArrayList<>();
        PlayerPartyStore partyStore = getPlayerPartyStore(player);
        if (partyStore == null) {
            return legendaryPokemon;
        }

        for (Pokemon pokemon : partyStore) {
            if (pokemon != null && pokemon.isLegendary()) {
                legendaryPokemon.add(pokemon);
            }
        }
        return legendaryPokemon;
    }

    /**
     * 检查玩家队伍中是否存在究极异兽宝可梦
     * @param player 玩家
     * @return 是否存在究极异兽宝可梦
     */
    public static boolean hasUltraBeastPokemon(Player player) {
        if (!initialized) return false;
        PlayerPartyStore partyStore = getPlayerPartyStore(player);
        if (partyStore == null) {
            return false;
        }

        for (Pokemon pokemon : partyStore) {
            if (pokemon != null && pokemon.isUltraBeast()) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取玩家队伍中第一个究极异兽宝可梦
     * @param player 玩家
     * @return 究极异兽宝可梦，如果没有则返回null
     */
    public static Pokemon getFirstUltraBeastPokemon(Player player) {
        if (!initialized) return null;
        PlayerPartyStore partyStore = getPlayerPartyStore(player);
        if (partyStore == null) {
            return null;
        }

        for (Pokemon pokemon : partyStore) {
            if (pokemon != null && pokemon.isUltraBeast()) {
                return pokemon;
            }
        }
        return null;
    }

    /**
     * 获取玩家队伍中第一个究极异兽宝可梦的名称
     * @param player 玩家
     * @return 究极异兽宝可梦的名称，如果没有则返回null
     */
    public static String getFirstUltraBeastPokemonName(Player player) {
        if (!initialized) return null;
        Pokemon pokemon = getFirstUltraBeastPokemon(player);
        return pokemon != null ? pokemon.getDisplayName().getString() : null;
    }

    /**
     * 获取玩家队伍中所有究极异兽宝可梦
     * @param player 玩家
     * @return 究极异兽宝可梦列表
     */
    public static List<Pokemon> getAllUltraBeastPokemon(Player player) {
        if (!initialized) return new ArrayList<>();
        List<Pokemon> ultraBeastPokemon = new ArrayList<>();
        PlayerPartyStore partyStore = getPlayerPartyStore(player);
        if (partyStore == null) {
            return ultraBeastPokemon;
        }

        for (Pokemon pokemon : partyStore) {
            if (pokemon != null && pokemon.isUltraBeast()) {
                ultraBeastPokemon.add(pokemon);
            }
        }
        return ultraBeastPokemon;
    }

    /**
     * 检查玩家队伍中是否存在幻兽宝可梦
     * @param player 玩家
     * @return 是否存在幻兽宝可梦
     */
    public static boolean hasMythicalPokemon(Player player) {
        if (!initialized) return false;
        PlayerPartyStore partyStore = getPlayerPartyStore(player);
        if (partyStore == null) {
            return false;
        }

        for (Pokemon pokemon : partyStore) {
            if (pokemon != null && pokemon.isMythical()) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取玩家队伍中第一个幻兽宝可梦
     * @param player 玩家
     * @return 幻兽宝可梦，如果没有则返回null
     */
    public static Pokemon getFirstMythicalPokemon(Player player) {
        if (!initialized) return null;
        PlayerPartyStore partyStore = getPlayerPartyStore(player);
        if (partyStore == null) {
            return null;
        }

        for (Pokemon pokemon : partyStore) {
            if (pokemon != null && pokemon.isMythical()) {
                return pokemon;
            }
        }
        return null;
    }

    /**
     * 获取玩家队伍中第一个幻兽宝可梦的名称
     * @param player 玩家
     * @return 幻兽宝可梦的名称，如果没有则返回null
     */
    public static String getFirstMythicalPokemonName(Player player) {
        if (!initialized) return null;
        Pokemon pokemon = getFirstMythicalPokemon(player);
        return pokemon != null ? pokemon.getDisplayName().getString() : null;
    }

    /**
     * 获取玩家队伍中所有幻兽宝可梦
     * @param player 玩家
     * @return 幻兽宝可梦列表
     */
    public static List<Pokemon> getAllMythicalPokemon(Player player) {
        if (!initialized) return new ArrayList<>();
        List<Pokemon> mythicalPokemon = new ArrayList<>();
        PlayerPartyStore partyStore = getPlayerPartyStore(player);
        if (partyStore == null) {
            return mythicalPokemon;
        }

        for (Pokemon pokemon : partyStore) {
            if (pokemon != null && pokemon.isMythical()) {
                mythicalPokemon.add(pokemon);
            }
        }
        return mythicalPokemon;
    }

    /**
     * 检查玩家队伍中是否存在闪光宝可梦
     * @param player 玩家
     * @return 是否存在闪光宝可梦
     */
    public static boolean hasShinyPokemon(Player player) {
        if (!initialized) return false;
        PlayerPartyStore partyStore = getPlayerPartyStore(player);
        if (partyStore == null) {
            return false;
        }

        for (Pokemon pokemon : partyStore) {
            if (pokemon != null && pokemon.getShiny()) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取玩家队伍的大小（包含空位）
     * @param player 玩家
     * @return 队伍大小，如果获取失败则返回0
     */
    public static int getPartySize(Player player) {
        if (!initialized) return 0;
        PlayerPartyStore partyStore = getPlayerPartyStore(player);
        return partyStore != null ? partyStore.size() : 0;
    }

    /**
     * 获取玩家队伍中实际宝可梦的数量（不包含空位）
     * @param player 玩家
     * @return 实际宝可梦数量
     */
    public static int getActualPokemonCount(Player player) {
        if (!initialized) return 0;
        PlayerPartyStore partyStore = getPlayerPartyStore(player);
        if (partyStore == null) {
            return 0;
        }

        int count = 0;
        for (Pokemon pokemon : partyStore) {
            if (pokemon != null) {
                count++;
            }
        }
        return count;
    }

    /**
     * 获取玩家队伍指定位置的宝可梦名称
     * @param player 玩家
     * @param position 位置（1-6）
     * @return 宝可梦名称，如果该位置没有宝可梦或位置无效则返回空字符串
     */
    public static String getPokemonNameAtPosition(Player player, int position) {
        if (!initialized) return "";
        PlayerPartyStore partyStore = getPlayerPartyStore(player);
        if (partyStore == null) {
            return "";
        }

        int index = position - 1;
        if (index < 0 || index >= partyStore.size()) {
            return "";
        }

        Pokemon pokemon = partyStore.get(index);
        if (pokemon == null) {
            return "";
        }

        return pokemon.getDisplayName().getString();
    }

    /**
     * 获取玩家队伍指定位置的宝可梦本地化名称
     * @param player 玩家
     * @param position 位置（1-6）
     * @return 宝可梦本地化名称，如果该位置没有宝可梦或位置无效则返回空字符串
     */
    public static String getPokemonLocalizedNameAtPosition(Player player, int position) {
        if (!initialized) return "";
        PlayerPartyStore partyStore = getPlayerPartyStore(player);
        if (partyStore == null) {
            return "";
        }

        int index = position - 1;
        if (index < 0 || index >= partyStore.size()) {
            return "";
        }

        Pokemon pokemon = partyStore.get(index);
        if (pokemon == null) {
            return "";
        }

        return getPokemonLocalizedName(pokemon.getSpecies());
    }

    /**
     * 获取宝可梦的本地化名称
     * @param species 宝可梦种类
     * @return 本地化名称
     */
    private static String getPokemonLocalizedName(Species species) {
        if (!initialized) return species != null ? species.getName() : "";
        try {
            return LocalizationUtilsKt.lang("species." + species.getName().toLowerCase() + ".name").getString();
        } catch (Exception e) {
            return species.getName();
        }
    }
}