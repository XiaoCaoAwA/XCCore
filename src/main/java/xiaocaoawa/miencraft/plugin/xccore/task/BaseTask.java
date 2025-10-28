package xiaocaoawa.miencraft.plugin.xccore.task;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.NotNull;

/**
 * @author XiaoCaoAwA
 * @version 1.0
 */
public abstract class BaseTask implements Runnable {

    private BukkitTask task;

    public synchronized boolean isActive() throws IllegalStateException {
        return task != null && !task.isCancelled();
    }

    public synchronized void stop() throws IllegalStateException {
        if (!isActive()) return;
        Bukkit.getScheduler().cancelTask(getTaskId());
        task = null;
    }

    @NotNull
    public synchronized BukkitTask runTask(@NotNull Plugin plugin) throws IllegalArgumentException, IllegalStateException {
        checkNotYetScheduled();
        return setupTask(Bukkit.getScheduler().runTask(plugin, this));
    }

    @NotNull
    public synchronized BukkitTask runTaskAsynchronously(@NotNull Plugin plugin) throws IllegalArgumentException, IllegalStateException  {
        checkNotYetScheduled();
        return setupTask(Bukkit.getScheduler().runTaskAsynchronously(plugin, this));
    }

    @NotNull
    public synchronized BukkitTask runTaskLater(@NotNull Plugin plugin, long delay) throws IllegalArgumentException, IllegalStateException  {
        checkNotYetScheduled();
        return setupTask(Bukkit.getScheduler().runTaskLater(plugin, this, delay));
    }

    @NotNull
    public synchronized BukkitTask runTaskLaterAsynchronously(@NotNull Plugin plugin, long delay) throws IllegalArgumentException, IllegalStateException  {
        checkNotYetScheduled();
        return setupTask(Bukkit.getScheduler().runTaskLaterAsynchronously(plugin, this, delay));
    }

    @NotNull
    public synchronized BukkitTask runTaskTimer(@NotNull Plugin plugin, long delay, long period) throws IllegalArgumentException, IllegalStateException  {
        checkNotYetScheduled();
        return setupTask(Bukkit.getScheduler().runTaskTimer(plugin, this, delay, period));
    }

    @NotNull
    public synchronized BukkitTask runTaskTimerAsynchronously(@NotNull Plugin plugin, long delay, long period) throws IllegalArgumentException, IllegalStateException  {
        checkNotYetScheduled();
        return setupTask(Bukkit.getScheduler().runTaskTimerAsynchronously(plugin, this, delay, period));
    }

    public synchronized int getTaskId() throws IllegalStateException {
        checkScheduled();
        return task.getTaskId();
    }

    private void checkScheduled() {
        if (task == null) {
            throw new IllegalStateException("Not scheduled yet");
        }
    }

    private void checkNotYetScheduled() {
        if (task != null) {
            if (!task.isCancelled()) {
                throw new IllegalStateException("Already scheduled as " + task.getTaskId());
            } else {
                task = null;
            }
        }
    }

    @NotNull
    private BukkitTask setupTask(@NotNull final BukkitTask task) {
        this.task = task;
        return task;
    }

}
