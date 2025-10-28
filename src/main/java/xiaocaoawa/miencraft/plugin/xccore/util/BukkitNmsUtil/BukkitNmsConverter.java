package xiaocaoawa.miencraft.plugin.xccore.util.BukkitNmsUtil;

import net.minecraft.*;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * Bukkit与NMS（Net Minecraft Server）之间的转换工具类
 * 提供Bukkit API对象与Minecraft内部对象之间的相互转换功能
 * 作为统一入口，委托给各个专门的转换工具类
 * 
 * @author XiaoCaoAwA
 * @version 2.0
 * @deprecated 建议直接使用具体的转换工具类，如 LocationConverter、EntityConverter 等
 */
@Deprecated
public final class BukkitNmsConverter {

    private BukkitNmsConverter() {}

    // ==================== 位置相关转换 ====================
    
    /**
     * 将Bukkit位置转换为NMS方块位置
     * 
     * @param location Bukkit位置对象
     * @return NMS方块位置对象
     * @deprecated 使用 {@link LocationConverter#toBlockPos(Location)} 替代
     */
    @Deprecated
    public static class_2338 toBlockPos(@NotNull Location location) {
        return LocationConverter.toBlockPos(location);
    }

    /**
     * 获取指定位置的服务器端生物群系
     * 
     * @param location 目标位置
     * @return 服务器端生物群系对象
     * @throws IllegalArgumentException 如果位置的世界为null
     * @deprecated 使用 {@link LocationConverter#getServerBiome(Location)} 替代
     */
    @Deprecated
    public static class_1959 getServerBiome(@NotNull Location location) {
        return LocationConverter.getServerBiome(location);
    }

    // ==================== 世界相关转换 ====================

    /**
     * 将Bukkit世界转换为NMS世界
     * 
     * @param world Bukkit世界对象
     * @return NMS世界对象
     * @deprecated 使用 {@link WorldConverter#toWorld(World)} 替代
     */
    @Deprecated
    public static class_1937 toWorld(@NotNull World world) {
        return WorldConverter.toWorld(world);
    }

    /**
     * 将Bukkit世界转换为服务器级别对象
     * 
     * @param world Bukkit世界对象
     * @return 服务器级别对象
     * @deprecated 使用 {@link WorldConverter#getServerLevel(World)} 替代
     */
    @Deprecated
    public static class_3218 getServerLevel(@NotNull World world) {
        return WorldConverter.getServerLevel(world);
    }

    // ==================== 实体相关转换 ====================

    /**
     * 将Bukkit玩家转换为NMS玩家
     * 
     * @param player Bukkit玩家对象
     * @return NMS玩家对象
     * @deprecated 使用 {@link EntityConverter#toPlayer(Player)} 替代
     */
    @Deprecated
    public static class_3222 toPlayer(@NotNull Player player) {
        return EntityConverter.toPlayer(player);
    }

    /**
     * 将NMS玩家转换为Bukkit玩家
     * 
     * @param player NMS玩家对象
     * @return Bukkit玩家对象
     * @deprecated 使用 {@link EntityConverter#toPlayer(class_3222)} 替代
     */
    @Deprecated
    public static Player toPlayer(@NotNull class_3222 player) {
        return EntityConverter.toPlayer(player);
    }

    /**
     * 将NMS实体转换为Bukkit实体
     * 
     * @param entity NMS实体对象
     * @return Bukkit实体对象
     * @deprecated 使用 {@link EntityConverter#toEntity(class_1297)} 替代
     */
    @Deprecated
    public static Entity toEntity(@NotNull class_1297 entity) {
        return EntityConverter.toEntity(entity);
    }

    /**
     * 将Bukkit实体转换为NMS实体
     * 
     * @param entity Bukkit实体对象
     * @return NMS实体对象
     * @deprecated 使用 {@link EntityConverter#toEntity(Entity)} 替代
     */
    @Deprecated
    public static class_1297 toEntity(@NotNull Entity entity) {
        return EntityConverter.toEntity(entity);
    }

    // ==================== 物品相关转换 ====================

    /**
     * 将NMS物品堆叠转换为Bukkit物品堆叠
     * 
     * @param itemStack NMS物品堆叠对象
     * @return Bukkit物品堆叠对象
     * @deprecated 使用 {@link ItemConverter#toItemStack(class_1799)} 替代
     */
    @Deprecated
    public static ItemStack toItemStack(@NotNull class_1799 itemStack) {
        return ItemConverter.toItemStack(itemStack);
    }

    /**
     * 将Bukkit物品堆叠转换为NMS物品堆叠
     * 
     * @param bukkitItem Bukkit物品堆叠对象
     * @return NMS物品堆叠对象
     * @deprecated 使用 {@link ItemConverter#toItemStack(ItemStack)} 替代
     */
    @Deprecated
    public static class_1799 toItemStack(@NotNull ItemStack bukkitItem) {
        return ItemConverter.toItemStack(bukkitItem);
    }

    // ==================== 注册表相关转换 ====================

    /**
     * 获取默认世界的注册表访问器
     * 使用服务器中的第一个世界作为默认世界
     * 
     * @return 注册表访问器对象
     * @deprecated 使用 {@link RegistryConverter#getRegistryAccess()} 替代
     */
    @Deprecated
    public static class_5455 getRegistryAccess() {
        return RegistryConverter.getRegistryAccess();
    }

    /**
     * 获取指定世界的注册表访问器
     * 
     * @param world 目标世界
     * @return 注册表访问器对象
     * @deprecated 使用 {@link RegistryConverter#getRegistryAccess(World)} 替代
     */
    @Deprecated
    public static class_5455 getRegistryAccess(@NotNull World world) {
        return RegistryConverter.getRegistryAccess(world);
    }
}
