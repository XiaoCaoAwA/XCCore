package xiaocaoawa.miencraft.plugin.xccore.util;

import com.cobblemon.mod.common.Cobblemon;
import org.bukkit.plugin.Plugin;
import xiaocaoawa.miencraft.plugin.xccore.util.CobblemonUtil.*;

/**
 * Cobblemon模组检测工具类
 * 提供检测Cobblemon模组是否存在和可用的方法
 * 
 * @author XiaoCaoAwA
 * @version 1.0
 */
public final class CobblemonDetector {

    // 私有构造函数防止实例化
    private CobblemonDetector() {}

    /**
     * 初始化所有Cobblemon工具类
     * 此方法应在 Cobblemon 模组检测成功后调用
     */
    private static void initialize() {
        CobblemonBasePokemonUtil.setInitialized();
        CobblemonEntityUtil.setInitialized();
        CobblemonEventHandler.setInitialized();
        CobblemonItemUtil.setInitialized();
        CobblemonLocalizedName.setInitialized();
        CobblemonNameUtil.setInitialized();
        CobblemonPartyUtil.setInitialized();
        CobblemonUtil.setInitialized();
        CobblemonResourceUtil.setInitialized();
    }

    /**
     * 检测Cobblemon模组是否可用（带日志输出）
     * 
     * @param plugin 插件实例，用于输出日志
     * @return 如果Cobblemon模组存在且可用返回true，否则返回false
     */
    private static boolean isCobblemonAvailable(Plugin plugin) {
        try {
            Cobblemon.INSTANCE.getImplementation();
            return true;
        } catch (Exception e) {
            plugin.getLogger().warning("Cobblemon模组检测失败: " + e.getMessage());
            return false;
        }
    }

    /**
     * 检测Cobblemon模组并在失败时提醒
     * 
     * @param plugin 插件实例
     * @return 如果检测成功返回true，如果检测失败返回false
     */
    public static boolean checkCobblemonOrDisable(Plugin plugin) {
        if (!isCobblemonAvailable(plugin)) {
            plugin.getLogger().warning("未检测到Cobblemon模组，不启用方可梦相关方法");
            return false;
        }
        plugin.getLogger().info("已检测到Cobblemon模组,启动方可梦相关方法");
        initialize();
        return true;
    }
}