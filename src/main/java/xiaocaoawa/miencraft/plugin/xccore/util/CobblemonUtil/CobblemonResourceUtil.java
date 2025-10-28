package xiaocaoawa.miencraft.plugin.xccore.util.CobblemonUtil;

import com.cobblemon.mod.common.util.IdentifierExtensionsKt;
import net.minecraft.class_2960;
import org.jetbrains.annotations.NotNull;

/**
 * 资源标识符工具类
 * 提供资源标识符的创建和简化方法
 * 
 * @author XiaoCaoAwA
 * @version 1.0
 */
public final class CobblemonResourceUtil {

    // 静态初始化标志
    private static boolean initialized = false;

    /**
     * 设置初始化状态
     */
    public static void setInitialized() {
        initialized = true;
    }

    // 私有构造函数防止实例化
    private CobblemonResourceUtil() {}

    /**
     * 简化资源标识符，如果命名空间是 "cobblemon" 则省略命名空间
     * 
     * @param name 资源标识符对象
     * @return 简化后的资源标识符字符串
     * @throws NullPointerException 如果 name 为 null
     */
    public static String simplify(@NotNull class_2960 name) {
        if (!initialized) return "";
        return IdentifierExtensionsKt.simplify(name, "cobblemon"); 
    } 

    /**
     * 创建 Cobblemon 命名空间的资源标识符
     * 
     * @param name 资源名称
     * @return Cobblemon 命名空间的资源标识符对象
     * @throws NullPointerException 如果 name 为 null
     */
    public static class_2960 createCobblemonResource(@NotNull String name) {
        if (!initialized) return null;
        return class_2960.method_60655("cobblemon", name); 
    }
}