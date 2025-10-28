package xiaocaoawa.miencraft.plugin.xccore.util.BukkitNmsUtil;

import net.minecraft.*;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_21_R1.CraftWorld;
import org.jetbrains.annotations.NotNull;

/**
 * 世界转换工具类
 * 提供Bukkit世界对象与NMS世界对象之间的转换功能
 * 
 * @author XiaoCaoAwA
 * @version 1.0
 */
public final class WorldConverter {

    private WorldConverter() {}

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
     * 将Bukkit世界转换为服务器级别对象
     * 
     * @param world Bukkit世界对象
     * @return 服务器级别对象
     */
    public static class_3218 getServerLevel(@NotNull World world) {
        return class_3218.class.cast(((CraftWorld) world).getHandle());
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
    public static class_5455 getRegistryAccess(@NotNull World world) {
        return toWorld(world).method_30349();
    }
}