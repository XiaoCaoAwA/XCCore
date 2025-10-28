package xiaocaoawa.miencraft.plugin.xccobblemoncore.util.CobblemonUtil;

import com.cobblemon.mod.common.CobblemonEntities;
import com.cobblemon.mod.common.entity.pokemon.PokemonEntity;
import com.cobblemon.mod.common.pokemon.Pokemon;
import net.minecraft.class_1937;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_21_R1.entity.CraftEntity;
import org.bukkit.entity.Entity;
import org.jetbrains.annotations.NotNull;
import xiaocaoawa.miencraft.plugin.xccobblemoncore.util.BukkitNmsUtil.BukkitNmsConverter;

/**
 * Cobblemon宝可梦实体工具类
 * 提供宝可梦实体的转换和生成功能
 * 
 * @author XiaoCaoAwA
 * @version 1.0
 */
public final class CobblemonEntityUtil {

    /**
     * 静态初始化标志
     */
    private static boolean initialized = false;

    private CobblemonEntityUtil() {}

    /**
     * 设置初始化状态
     */
    public static void setInitialized() {
        initialized = true;
    }

    /**
     * 将Bukkit实体转换为宝可梦实体
     * 
     * @param entity Bukkit实体对象
     * @return 宝可梦实体对象，如果未初始化则返回null
     */
    public static PokemonEntity toPokemonEntity(@NotNull Entity entity) {
        if (!initialized) {
            return null;
        }
        return PokemonEntity.class.cast(((CraftEntity) entity).getHandle());
    }

    /**
     * 在指定位置生成宝可梦实体
     * 
     * @param pokemon 要生成的宝可梦对象
     * @param location 生成位置
     * @return 生成的宝可梦实体，如果未初始化或位置世界为null则返回null
     * @throws IllegalArgumentException 如果位置的世界为null
     */
    public static PokemonEntity spawnPokemon(@NotNull Pokemon pokemon, @NotNull Location location) {
        if (!initialized) {
            return null;
        }
        
        World world = location.getWorld();
        if (world == null) throw new IllegalArgumentException("World is null");

        class_1937 level = BukkitNmsConverter.toWorld(world);

        PokemonEntity pokemonEntity = new PokemonEntity(level, pokemon, CobblemonEntities.POKEMON);
        pokemonEntity.method_5814(location.getX(), location.getY(), location.getZ());
        level.method_8649(pokemonEntity);

        return pokemonEntity;
    }
}