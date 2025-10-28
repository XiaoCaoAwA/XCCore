package xiaocaoawa.miencraft.plugin.xccore.util.BukkitNmsUtil;

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
import org.bukkit.inventory.ItemStack;
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
     * 获取指定位置的服务器端生物群系
     * 
     * @param location 目标位置
     * @return 服务器端生物群系对象
     * @throws IllegalArgumentException 如果位置的世界为null
     */
    public static class_1959 getServerBiome(@NotNull Location location) {
        World world = location.getWorld();
        if (world == null) throw new IllegalArgumentException("World is null");
        return getServerLevel(world).method_23753(toBlockPos(location)).comp_349();
    }

    /**
     * 将Bukkit世界转换为服务器级别对象
     * 
     * @param world Bukkit世界对象
     * @return 服务器级别对象
     */
    public static class_3218 getServerLevel(@NotNull World world) {
        return class_3218.class.cast(((CraftWorld) world).getHandle());
    }

}
