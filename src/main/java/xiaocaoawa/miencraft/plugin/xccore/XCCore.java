package xiaocaoawa.miencraft.plugin.xccore;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import xiaocaoawa.miencraft.plugin.xccore.inventory.XCInventory;
import xiaocaoawa.miencraft.plugin.xccore.util.CobblemonDetector;

import java.util.HashMap;
import java.util.Map;

public final class XCCore extends JavaPlugin {

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
        getLogger().info("XCCore插件已禁用！");
    }



    private static void printStartupMessage() {
        ConsoleCommandSender consoleSender = Bukkit.getConsoleSender();
        consoleSender.sendMessage("§7[§aXCCore§7] §b┏┳━━━━━━━━━━━━┓");
        consoleSender.sendMessage("§7[§aXCCore§7] §b┃┃████████████┃");
        consoleSender.sendMessage("§7[§aXCCore§7] §b┣┫████┏━━━━┓██┃");
        consoleSender.sendMessage("§7[§aXCCore§7] §b┃┃████┃ 葵 ┃██┃");
        consoleSender.sendMessage("§7[§aXCCore§7] §b┣┫████┃ 草 ┃██┃");
        consoleSender.sendMessage("§7[§aXCCore§7] §b┃┃████┃ 宝 ┃██┃");
        consoleSender.sendMessage("§7[§aXCCore§7] §b┃┃████┃ 典 ┃██┃");
        consoleSender.sendMessage("§7[§aXCCore§7] §b┃┃████┗━━━━┛██┃");
        consoleSender.sendMessage("§7[§aXCCore§7] §b┣┫████████████┃");
        consoleSender.sendMessage("§7[§aXCCore§7] §b┃┃████████████┃");
        consoleSender.sendMessage("§7[§aXCCore§7] §b┗┻━━━━━━━━━━━━┛");
        consoleSender.sendMessage("§7[§aXCCore§7] §b欢迎使用XCCore插件");
        consoleSender.sendMessage("§7[§aXCCore§7] §b作者:XiaoCaoAwA");
        consoleSender.sendMessage("§7[§aXCCore§7] §b加入官方插件交流群：966720491");
        consoleSender.sendMessage("§7[§aXCCore§7] §b本插件为前置插件,没有实际功能！");
    }

}
