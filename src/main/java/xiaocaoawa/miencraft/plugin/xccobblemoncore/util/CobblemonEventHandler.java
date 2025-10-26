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
 * @author XiaoCaoAwA
 * @version 1.0
 */
public class CobblemonEventHandler {

    private static final Map<Plugin, List<ObservableSubscription<?>>> map = new HashMap<>();

    private CobblemonEventHandler() {}

    public static <T> void registerCobblemonEvent(Plugin plugin, Observable<T> observable, Priority priority, Consumer<T> handler) {
        ObservableSubscription<T> subscribe = observable.subscribe(priority, event -> {
            handler.accept(event);
            return Unit.INSTANCE;
        });
        List<ObservableSubscription<?>> subscriptions = getSubscriptions(plugin);
        subscriptions.add(subscribe);
    }

    public static void unregisterCobblemonEvent(Plugin plugin) {
        List<ObservableSubscription<?>> list = map.get(plugin);
        if (list == null) return;
        for (ObservableSubscription<?> subscription : list) {
            subscription.unsubscribe();
        }
    }

    public static void unregisterAllCobblemonEvent() {
        for (List<ObservableSubscription<?>> list : map.values()) {
            for (ObservableSubscription<?> subscription : list) {
                subscription.unsubscribe();
            }
        }
    }

    public static List<ObservableSubscription<?>> getSubscriptions(Plugin plugin) {
        return map.computeIfAbsent(plugin, k -> new ArrayList<>());
    }

}
