package xiaocaoawa.miencraft.plugin.xccobblemoncore;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import xiaocaoawa.miencraft.plugin.xccobblemoncore.inventory.XCInventory;
import xiaocaoawa.miencraft.plugin.xccobblemoncore.util.CobblemonDetector;

import java.util.HashMap;
import java.util.Map;

public final class XCCobblemonCore extends JavaPlugin {

    @Getter
    private static final Map<Player, XCInventory> XCInventoryMap = new HashMap<>();

    @Override
    public void onEnable() {

        if (!CobblemonDetector.checkCobblemonOrDisable(this)) {
            return;
        }
        printStartupMessage();
    }

    @Override
    public void onDisable() {
        getLogger().info("XCCobblemonCore插件已禁用！");
    }



    private static void printStartupMessage() {
        ConsoleCommandSender consoleSender = Bukkit.getConsoleSender();
        consoleSender.sendMessage("§7[§aXCCobbleCore§7] §b┏┳━━━━━━━━━━━━┓");
        consoleSender.sendMessage("§7[§aXCCobbleCore§7] §b┃┃████████████┃");
        consoleSender.sendMessage("§7[§aXCCobbleCore§7] §b┣┫████┏━━━━┓██┃");
        consoleSender.sendMessage("§7[§aXCCobbleCore§7] §b┃┃████┃ 葵 ┃██┃");
        consoleSender.sendMessage("§7[§aXCCobbleCore§7] §b┣┫████┃ 草 ┃██┃");
        consoleSender.sendMessage("§7[§aXCCobbleCore§7] §b┃┃████┃ 宝 ┃██┃");
        consoleSender.sendMessage("§7[§aXCCobbleCore§7] §b┃┃████┃ 典 ┃██┃");
        consoleSender.sendMessage("§7[§aXCCobbleCore§7] §b┃┃████┗━━━━┛██┃");
        consoleSender.sendMessage("§7[§aXCCobbleCore§7] §b┣┫████████████┃");
        consoleSender.sendMessage("§7[§aXCCobbleCore§7] §b┃┃████████████┃");
        consoleSender.sendMessage("§7[§aXCCobbleCore§7] §b┗┻━━━━━━━━━━━━┛");
        consoleSender.sendMessage("§7[§aXCCobbleCore§7] §b欢迎使用XCCobbleCore插件");
        consoleSender.sendMessage("§7[§aXCCobbleCore§7] §b作者:XiaoCaoAwA 感谢您的支持！");
        consoleSender.sendMessage("§7[§aXCCobbleCore§7] §b加入官方插件交流群：966720491 快速反馈问题和需求");
        consoleSender.sendMessage("§7[§aXCCobbleCore§7] §b官方插件交流群有许多有趣的小插件等您来获取哟！~");
    }

}
