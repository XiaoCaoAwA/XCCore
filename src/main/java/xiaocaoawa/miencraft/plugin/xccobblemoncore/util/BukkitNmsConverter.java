package xiaocaoawa.miencraft.plugin.xccobblemoncore.util;

import com.cobblemon.mod.common.CobblemonEntities;
import com.cobblemon.mod.common.entity.pokemon.PokemonEntity;
import com.cobblemon.mod.common.item.PokemonItem;
import com.cobblemon.mod.common.pokeball.PokeBall;
import com.cobblemon.mod.common.pokemon.Pokemon;
import com.cobblemon.mod.common.pokemon.Species;
import net.minecraft.*;
import net.minecraft.server.level.EntityPlayer;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_21_R1.CraftServer;
import org.bukkit.craftbukkit.v1_21_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_21_R1.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_21_R1.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_21_R1.inventory.CraftItemStack;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

/**
 * Bukkit与NMS（Net Minecraft Server）之间的转换工具类
 * 提供Bukkit API对象与Minecraft内部对象之间的相互转换功能
 * 
 * @author XiaoCaoAwA
 * @version 1.0
 */
public final class BukkitNmsConverter {

    private BukkitNmsConverter() {}

    /**
     * 将Bukkit位置转换为NMS方块位置
     * 
     * @param location Bukkit位置对象
     * @return NMS方块位置对象
     */
    public static class_2338 toBlockPos(@NotNull Location location) {
        return new class_2338(location.getBlockX(), location.getBlockY(), location.getBlockZ());
    }

    /**
     * 将Bukkit世界转换为NMS世界
     * 
     * @param world Bukkit世界对象
     * @return NMS世界对象
     */
    public static class_1937 toWorld(@NotNull World world) {
        return class_1937.class.cast(((CraftWorld) world).getHandle());
    }

    /**
     * 将Bukkit玩家转换为NMS玩家
     * 
     * @param player Bukkit玩家对象
     * @return NMS玩家对象
     */
    public static class_3222 toPlayer(@NotNull Player player) {
        return class_3222.class.cast(((CraftPlayer) player).getHandle());
    }

    /**
     * 将NMS玩家转换为Bukkit玩家
     * 
     * @param player NMS玩家对象
     * @return Bukkit玩家对象
     */
    public static Player toPlayer(@NotNull class_3222 player) {
        return EntityPlayer.class.cast(player).getBukkitEntity().getPlayer();
    }

    /**
     * 将NMS实体转换为Bukkit实体
     * 
     * @param entity NMS实体对象
     * @return Bukkit实体对象
     */
    public static Entity toEntity(@NotNull class_1297 entity) {
        net.minecraft.world.entity.Entity nmsEntity = net.minecraft.world.entity.Entity.class.cast(entity);
        return CraftEntity.getEntity((CraftServer) Bukkit.getServer(), nmsEntity);
    }

    /**
     * 将Bukkit实体转换为NMS实体
     * 
     * @param entity Bukkit实体对象
     * @return NMS实体对象
     */
    public static class_1297 toEntity(@NotNull Entity entity) {
        return class_1297.class.cast(((CraftEntity) entity).getHandle());
    }

    /**
     * 将Bukkit实体转换为宝可梦实体
     * 
     * @param entity Bukkit实体对象
     * @return 宝可梦实体对象
     */
    public static PokemonEntity toPokemonEntity(@NotNull Entity entity) {
        return PokemonEntity.class.cast(((CraftEntity) entity).getHandle());
    }

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

    /**
     * 根据宝可梦对象创建对应的Bukkit物品堆叠
     * 
     * @param pokemon 宝可梦对象
     * @return 包含宝可梦信息的Bukkit物品堆叠
     */
    public static ItemStack getPokemonItem(@NotNull Pokemon pokemon) {
        class_1799 item = PokemonItem.from(pokemon);
        return toItemStack(item);
    }

    /**
     * 根据宝可梦种族创建对应的Bukkit物品堆叠
     * 
     * @param species 宝可梦种族对象
     * @return 包含宝可梦种族信息的Bukkit物品堆叠
     */
    public static ItemStack getPokemonItem(@NotNull Species species) {
        class_1799 item = PokemonItem.from(species);
        return toItemStack(item);
    }

    /**
     * 根据精灵球类型创建对应的Bukkit物品堆叠
     * 会自动添加所有物品标志以隐藏额外信息
     * 
     * @param pokeBall 精灵球类型
     * @return 精灵球物品堆叠
     */
    public static ItemStack getPokeBallItem(PokeBall pokeBall) {
        ItemStack item = toItemStack(pokeBall.stack(1));
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.addItemFlags(ItemFlag.values());
            item.setItemMeta(meta);
        }
        return item;
    }

    /**
     * 获取默认世界的注册表访问器
     * 使用服务器中的第一个世界作为默认世界
     * 
     * @return 注册表访问器对象
     */
    public static class_5455 getRegistryAccess() {
        World world = Bukkit.getWorlds().getFirst();
        return getRegistryAccess(world);
    }

    /**
     * 获取指定世界的注册表访问器
     * 
     * @param world 目标世界
     * @return 注册表访问器对象
     */
    public static class_5455 getRegistryAccess(World world) {
        return toWorld(world).method_30349();
    }

    /**
     * 在指定位置生成宝可梦实体
     * 
     * @param pokemon 要生成的宝可梦对象
     * @param location 生成位置
     * @return 生成的宝可梦实体
     * @throws IllegalArgumentException 如果位置的世界为null
     */
    public static PokemonEntity spawnPokemon(@NotNull Pokemon pokemon, @NotNull Location location) {
        World world = location.getWorld();
        if (world == null) throw new IllegalArgumentException("World is null");

        class_1937 level = BukkitNmsConverter.toWorld(world);

        PokemonEntity pokemonEntity = new PokemonEntity(level, pokemon, CobblemonEntities.POKEMON);
        pokemonEntity.method_5814(location.getX(), location.getY(), location.getZ());
        level.method_8649(pokemonEntity);

        return pokemonEntity;
    }

}
