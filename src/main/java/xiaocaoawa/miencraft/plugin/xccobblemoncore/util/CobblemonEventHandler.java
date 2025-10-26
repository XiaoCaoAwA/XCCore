package xiaocaoawa.miencraft.plugin.xccobblemoncore.util;

import com.cobblemon.mod.common.api.Priority;
import com.cobblemon.mod.common.api.reactive.Observable;
import com.cobblemon.mod.common.api.reactive.ObservableSubscription;
import kotlin.Unit;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Cobblemon事件处理器工具类
 * 提供Cobblemon模组事件的注册、注销和管理功能
 * 
 * @author XiaoCaoAwA
 * @version 1.0
 */
public class CobblemonEventHandler {

    /**
     * 存储每个插件的事件订阅列表
     */
    private static final Map<Plugin, List<ObservableSubscription<?>>> map = new HashMap<>();

    private CobblemonEventHandler() {}

    /**
     * 为指定插件注册Cobblemon事件监听器
     * 
     * @param <T> 事件类型
     * @param plugin 插件实例
     * @param observable 可观察的事件对象
     * @param priority 事件处理优先级
     * @param handler 事件处理器函数
     */
    public static <T> void registerCobblemonEvent(Plugin plugin, Observable<T> observable, Priority priority, Consumer<T> handler) {
        ObservableSubscription<T> subscribe = observable.subscribe(priority, event -> {
            handler.accept(event);
            return Unit.INSTANCE;
        });
        List<ObservableSubscription<?>> subscriptions = getSubscriptions(plugin);
        subscriptions.add(subscribe);
    }

    /**
     * 注销指定插件的所有Cobblemon事件监听器
     * 
     * @param plugin 插件实例
     */
    public static void unregisterCobblemonEvent(Plugin plugin) {
        List<ObservableSubscription<?>> list = map.get(plugin);
        if (list == null) return;
        for (ObservableSubscription<?> subscription : list) {
            subscription.unsubscribe();
        }
    }

    /**
     * 注销所有插件的Cobblemon事件监听器
     * 通常在服务器关闭时调用
     */
    public static void unregisterAllCobblemonEvent() {
        for (List<ObservableSubscription<?>> list : map.values()) {
            for (ObservableSubscription<?> subscription : list) {
                subscription.unsubscribe();
            }
        }
    }

    /**
     * 获取指定插件的事件订阅列表
     * 如果插件没有订阅列表，则创建一个新的空列表
     * 
     * @param plugin 插件实例
     * @return 插件的事件订阅列表
     */
    public static List<ObservableSubscription<?>> getSubscriptions(Plugin plugin) {
        return map.computeIfAbsent(plugin, k -> new ArrayList<>());
    }

}
