package xiaocaoawa.miencraft.plugin.xccore.util.BukkitNmsUtil;

import net.minecraft.*;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.jetbrains.annotations.NotNull;

/**
 * 注册表转换工具类
 * 提供注册表访问相关的功能
 * 
 * @author XiaoCaoAwA
 * @version 1.0
 */
public final class RegistryConverter {

    private RegistryConverter() {}

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
        return WorldConverter.toWorld(world).method_30349();
    }
}