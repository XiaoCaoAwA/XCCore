package xiaocaoawa.miencraft.plugin.xccore.util.BukkitNmsUtil;


import net.minecraft.class_1297;
import net.minecraft.class_3222;
import net.minecraft.server.level.EntityPlayer;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_21_R1.CraftServer;
import org.bukkit.craftbukkit.v1_21_R1.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_21_R1.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * 实体转换工具类
 * 提供Bukkit实体对象与NMS实体对象之间的转换功能
 * 包括玩家和普通实体的转换
 * 
 * @author XiaoCaoAwA
 * @version 1.0
 */
public final class EntityConverter {

    private EntityConverter() {}

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
}