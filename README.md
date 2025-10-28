# 🌟 XCCore - 葵草宝典核心框架

<div align="center">

![Version](https://img.shields.io/badge/version-1.0-blue.svg)
![Java](https://img.shields.io/badge/Java-21-orange.svg)
![Minecraft](https://img.shields.io/badge/Minecraft-1.21.1-green.svg)
![Cobblemon](https://img.shields.io/badge/Cobblemon-1.6.1+-purple.svg)
![License](https://img.shields.io/badge/license-MIT-brightgreen.svg)

**🎯 专业的 Minecraft Cobblemon 插件开发框架**

*为 Cobblemon 生态系统提供强大的底层支持与开发工具*

</div>

---

## 📖 项目简介

**XCCore** 是一个专为 Minecraft Cobblemon 模组生态系统设计的高性能核心框架。作为本人系列插件的基础架构，它提供了一套完整的开发工具链和API接口，让开发者能够轻松构建功能丰富的 Cobblemon \ Pokemon 以及 其他内容 相关插件。

### ✨ 核心特性

- 🚀 **高性能架构** - 基于现代Java 21技术栈，提供卓越的运行性能
- 🔧 **完整工具链** - 涵盖日志管理、任务调度、界面系统等核心功能
- 🎮 **Cobblemon深度集成** - 提供丰富的Cobblemon API封装和工具类
- 🛡️ **类型安全** - 全面的类型检查和异常处理机制
- 📚 **开发友好** - 详尽的文档和示例，降低学习成本
- 🔌 **插件生态** - 为第三方插件提供统一的开发标准

---

## 🏗️ 项目架构

### 📁 核心模块结构

```
xiaocaoawa.miencraft.plugin.xccore/
├── 🎯 XCCore.java                    # 主插件类，系统入口点
├── 📝 log/                           # 日志管理模块
│   └── XCLogger.java                 # 统一日志管理器
├── 🎨 inventory/                     # 界面系统模块
│   ├── XCInventory.java              # 抽象界面基类
│   ├── InventoryContext.java         # 界面上下文
│   ├── ClickInventoryContext.java    # 点击事件上下文
│   └── CancelInventoryContext.java   # 取消事件上下文
├── 👂 listener/                      # 事件监听模块
│   └── InventoryEvent.java           # 界面事件处理器
├── ⚙️ task/                          # 任务调度模块
│   └── BaseTask.java                 # 任务基类
├── 🔧 util/                          # 工具类模块
│   ├── CobblemonDetector.java        # Cobblemon模组检测器
│   ├── BukkitNmsUtil/                # Bukkit-NMS转换工具
│   │   ├── BukkitNmsConverter.java   # 统一转换入口
│   │   ├── LocationConverter.java    # 位置转换工具
│   │   ├── EntityConverter.java      # 实体转换工具
│   │   ├── ItemConverter.java        # 物品转换工具
│   │   ├── WorldConverter.java       # 世界转换工具
│   │   └── RegistryConverter.java    # 注册表转换工具
│   └── CobblemonUtil/                # Cobblemon工具集
│       ├── CobblemonUtil.java        # 核心工具类
│       ├── CobblemonBasePokemonUtil.java  # 宝可梦基础工具
│       ├── CobblemonEntityUtil.java  # 实体工具
│       ├── CobblemonEventHandler.java # 事件处理器
│       ├── CobblemonItemUtil.java    # 物品工具
│       ├── CobblemonLocalizedName.java # 本地化名称工具
│       ├── CobblemonNameUtil.java    # 名称工具
│       ├── CobblemonPartyUtil.java   # 队伍工具
│       └── CobblemonResourceUtil.java # 资源工具
└── 🔤 common/                        # 通用工具模块
    └── PlaceholderReplacer.java      # 占位符替换工具
```

### 🎯 架构设计原则

- **模块化设计** - 每个功能模块独立封装，便于维护和扩展
- **依赖注入** - 通过统一的服务定位器管理组件依赖
- **事件驱动** - 基于观察者模式的事件系统，实现松耦合
- **类型安全** - 全面使用泛型和注解，提供编译时类型检查

---

## 🚀 核心API文档

### 📝 日志管理系统

#### XCLogger - 统一日志管理器

```java
// 创建日志管理器实例
XCLogger logger = new XCLogger(plugin.getLogger(), "MyPlugin");

// 基础日志记录
logger.info("插件初始化完成");
logger.warning("检测到配置问题");
logger.severe("严重错误发生");

// 格式化日志记录
logger.info("玩家 {} 加入游戏", playerName);
logger.warning("配置项 {} 值无效: {}", configKey, configValue);

// 异常日志记录
logger.error("数据库连接失败", exception);
logger.debug("调试信息: 当前状态 = {}", currentState);
```

**特性说明:**
- ✅ 自动添加插件名称前缀
- ✅ 支持格式化字符串和参数
- ✅ 提供多种日志级别 (INFO, WARNING, SEVERE, DEBUG, ERROR)
- ✅ 异常堆栈跟踪支持

### 🎨 界面系统框架

#### XCInventory - 抽象界面基类

```java
public class MyCustomInventory extends XCInventory {
    
    public MyCustomInventory() {
        super(3, "§6我的自定义界面"); // 3行界面，标题带颜色
    }
    
    @Override
    public void onInventoryOpen(CancelInventoryContext context) {
        // 界面打开时的逻辑
        Player player = context.getPlayer();
        setupInventoryItems(player);
    }
    
    @Override
    public void onInventoryClick(ClickInventoryContext context) {
        // 处理点击事件
        context.setCancelled(true); // 取消默认行为
        
        int slot = context.getSlot();
        Player player = context.getPlayer();
        
        switch (slot) {
            case 10 -> handleConfirmClick(player);
            case 16 -> handleCancelClick(player);
        }
    }
    
    @Override
    public void onInventoryClose(InventoryContext context) {
        // 界面关闭时的清理工作
        Player player = context.getPlayer();
        cleanupPlayerData(player);
    }
}

// 使用界面
MyCustomInventory inventory = new MyCustomInventory();
inventory.openInventory(player);
```

**特性说明:**
- ✅ 事件驱动的界面管理
- ✅ 自动的玩家界面状态跟踪
- ✅ 灵活的界面大小配置
- ✅ 完整的生命周期管理

### ⚙️ 任务调度系统

#### BaseTask - 任务基类

```java
public class MyPeriodicTask extends BaseTask {
    
    private final Plugin plugin;
    private int counter = 0;
    
    public MyPeriodicTask(Plugin plugin) {
        this.plugin = plugin;
    }
    
    @Override
    public void run() {
        // 任务执行逻辑
        counter++;
        plugin.getLogger().info("定时任务执行第 " + counter + " 次");
        
        // 条件停止
        if (counter >= 100) {
            stop();
        }
    }
}

// 使用任务调度
MyPeriodicTask task = new MyPeriodicTask(plugin);

// 延迟20tick后开始，每20tick执行一次
task.runTaskTimer(plugin, 20L, 20L);

// 异步执行
task.runTaskTimerAsynchronously(plugin, 0L, 100L);

// 检查任务状态
if (task.isActive()) {
    task.stop(); // 停止任务
}
```

**特性说明:**
- ✅ 同步/异步任务支持
- ✅ 灵活的调度策略
- ✅ 任务状态管理
- ✅ 自动资源清理

### 🔧 Bukkit-NMS转换工具

#### 统一转换接口

```java
// 位置转换
Location bukkitLocation = player.getLocation();
BlockPos nmsBlockPos = LocationConverter.toBlockPos(bukkitLocation);
Biome serverBiome = LocationConverter.getServerBiome(bukkitLocation);

// 实体转换
Player bukkitPlayer = Bukkit.getPlayer("PlayerName");
ServerPlayer nmsPlayer = EntityConverter.toPlayer(bukkitPlayer);
Entity bukkitEntity = EntityConverter.toEntity(nmsEntity);

// 物品转换
ItemStack bukkitItem = new ItemStack(Material.DIAMOND);
net.minecraft.world.item.ItemStack nmsItem = ItemConverter.toItemStack(bukkitItem);

// 世界转换
World bukkitWorld = Bukkit.getWorld("world");
ServerLevel serverLevel = WorldConverter.getServerLevel(bukkitWorld);
RegistryAccess registryAccess = WorldConverter.getRegistryAccess(bukkitWorld);
```

**特性说明:**
- ✅ 类型安全的转换操作
- ✅ 模块化的转换工具
- ✅ 向后兼容的统一入口
- ✅ 完整的错误处理

### 🎮 Cobblemon集成工具

#### 宝可梦操作工具集

```java
// 获取玩家的宝可梦队伍
List<Pokemon> party = CobblemonPartyUtil.getParty(player);

// 检查玩家是否拥有特定宝可梦
boolean hasSpecies = CobblemonPartyUtil.hasSpecies(player, "pikachu");

// 获取宝可梦的本地化名称
String localizedName = CobblemonLocalizedName.getSpeciesName("pikachu", "zh_cn");

// 创建宝可梦物品
ItemStack pokemonItem = CobblemonItemUtil.createPokemonItem(pokemon);

// 事件处理
CobblemonEventHandler.subscribe(PokemonCaptureEvent.class, event -> {
    Player player = event.getPlayer();
    Pokemon pokemon = event.getPokemon();
    // 处理捕获事件
});
```

**特性说明:**
- ✅ 完整的Cobblemon API封装
- ✅ 本地化支持
- ✅ 事件系统集成
- ✅ 类型安全的操作接口

### 🔤 通用工具

#### PlaceholderReplacer - 占位符替换

```java
// 单个字符串替换
Map<String, String> placeholders = Map.of(
    "player", "XiaoCaoAwA",
    "level", "50",
    "pokemon", "皮卡丘"
);

String template = "玩家 {player} 的 {pokemon} 达到了 {level} 级！";
String result = PlaceholderReplacer.replaceInString(template, placeholders);
// 结果: "玩家 XiaoCaoAwA 的 皮卡丘 达到了 50 级！"

// 字符串列表替换
List<String> templates = Arrays.asList(
    "欢迎 {player}！",
    "你的等级是 {level}",
    "当前宝可梦: {pokemon}"
);
List<String> results = PlaceholderReplacer.replaceInList(templates, placeholders);
```

**特性说明:**
- ✅ 高性能的字符串替换
- ✅ 批量处理支持
- ✅ 空值安全处理
- ✅ 灵活的占位符格式

---

## 🛠️ 快速开始

### 📋 环境要求

- **Java**: 21+
- **Minecraft**: 1.21.1
- **Bukkit/Spigot/Paper**: 1.21.1+
- **Cobblemon**: 1.6.1+
- **Fabric**: 0.115.4+

#### 插件依赖

在你的 `plugin.yml` 中添加：

```yaml
depend: [XCCore]
# 或者软依赖
softdepend: [XCCore]
```

### 🚀 基础使用示例

```java
public class MyPlugin extends JavaPlugin {
    
    private XCLogger logger;
    
    @Override
    public void onEnable() {
        // 初始化日志管理器
        logger = new XCLogger(getLogger(), getName());
        
        // 检查Cobblemon模组
        if (!CobblemonDetector.checkCobblemonOrDisable(this)) {
            return;
        }
        
        logger.info("插件启动成功！");
        
        // 注册事件监听器
        getServer().getPluginManager().registerEvents(new MyEventListener(), this);
        
        // 启动定时任务
        new MyPeriodicTask(this).runTaskTimer(this, 0L, 20L);
    }
    
    @Override
    public void onDisable() {
        logger.info("插件已关闭");
    }
}
```

---

## 🤝 开发指南

### 📝 编码规范

- 使用 **Java 21** 特性和语法
- 遵循 **Google Java Style Guide**
- 所有公共API必须提供 **JavaDoc** 文档
- 使用 **@NotNull** 和 **@Nullable** 注解
- 异常处理必须具体和有意义


#### 集成现有API

```java
public class MyFeature {
    
    private final XCLogger logger;
    
    public MyFeature(Plugin plugin) {
        this.logger = new XCLogger(plugin.getLogger(), plugin.getName());
    }
    
    public void executeFeature() {
        try {
            // 使用XCCore提供的工具
            logger.info("开始执行功能");
            
            // 你的业务逻辑
            
            logger.info("功能执行完成");
        } catch (Exception e) {
            logger.error("功能执行失败", e);
        }
    }
}
```

---

## 📞 技术支持

### 🐛 问题反馈

如果您在使用过程中遇到问题，请通过以下方式联系我们：

- **QQ群**: 966720491 (官方插件交流群)
- **作者**: XiaoCaoAwA
- **邮箱**: [2401322882@qq.com]

### 📚 文档资源

- [API文档](docs/api.md)
- [开发教程](docs/tutorial.md)
- [常见问题](docs/faq.md)
- [更新日志](CHANGELOG.md)


<div align="center">

**🌟 感谢使用 XCCore！**

*让我们一起构建更好的 Cobblemon 插件生态系统*

[![Star](https://img.shields.io/github/stars/xiaocaoawa/xccore?style=social)](https://github.com/xiaocaoawa/xccore)
[![Fork](https://img.shields.io/github/forks/xiaocaoawa/xccore?style=social)](https://github.com/xiaocaoawa/xccore)

</div>
