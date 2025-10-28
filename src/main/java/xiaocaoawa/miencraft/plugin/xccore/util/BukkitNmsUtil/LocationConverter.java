package xiaocaoawa.miencraft.plugin.xccore.util.BukkitNmsUtil;

import net.minecraft.*;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

/**
 * 位置转换工具类
 * 提供Bukkit位置对象与NMS位置对象之间的转换功能
 * 
 * @author XiaoCaoAwA
 * @version 1.0
 */
public final class LocationConverter {

    private LocationConverter() {}

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
     * 获取指定位置的服务器端生物群系
     * 
     * @param location 目标位置
     * @return 服务器端生物群系对象
     * @throws IllegalArgumentException 如果位置的世界为null
     */
    public static class_1959 getServerBiome(@NotNull Location location) {
        if (location.getWorld() == null) {
            throw new IllegalArgumentException("World is null");
        }
        return WorldConverter.getServerLevel(location.getWorld())
                .method_23753(toBlockPos(location))
                .comp_349();
    }
}