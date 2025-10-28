package xiaocaoawa.miencraft.plugin.xccore.log;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * XCCore 统一日志管理器
 * 提供统一的日志记录接口，支持不同级别的日志输出
 * 专为附属插件设计的API，支持插件名称标识
 */
public class XCLogger {
    
    private final Logger logger;
    private final String pluginName;
    
    /**
     * 构造函数
     * @param logger 日志记录器实例
     * @param pluginName 插件名称，用于日志标识
     */
    public XCLogger(Logger logger, String pluginName) {
        this.logger = logger;
        this.pluginName = pluginName != null ? pluginName : "Unknown";
    }
    
    /**
     * 获取日志记录器
     * @return Logger实例
     */
    public Logger getLogger() {
        return logger;
    }
    
    /**
     * 获取插件名称
     * @return 插件名称
     */
    public String getPluginName() {
        return pluginName;
    }
    
    /**
     * 格式化日志消息，添加插件名称前缀
     * @param message 原始消息
     * @return 格式化后的消息
     */
    private String formatMessage(String message) {
        return "[" + pluginName + "] " + message;
    }
    
    /**
     * 记录INFO级别日志
     * @param message 日志消息
     * @param objects 格式化参数
     */
    public void info(String message, Object... objects) {
        getLogger().log(Level.INFO, formatMessage(message), objects);
    }
    
    /**
     * 记录INFO级别日志（带异常）
     * @param message 日志消息
     * @param thrown 异常对象
     */
    public void info(String message, Throwable thrown) {
        getLogger().log(Level.INFO, formatMessage(message), thrown);
    }
    
    /**
     * 记录WARNING级别日志
     * @param message 日志消息
     * @param objects 格式化参数
     */
    public void warning(String message, Object... objects) {
        getLogger().log(Level.WARNING, formatMessage(message), objects);
    }
    
    /**
     * 记录WARNING级别日志（带异常）
     * @param message 日志消息
     * @param thrown 异常对象
     */
    public void warning(String message, Throwable thrown) {
        getLogger().log(Level.WARNING, formatMessage(message), thrown);
    }
    
    /**
     * 记录SEVERE级别日志
     * @param message 日志消息
     * @param objects 格式化参数
     */
    public void severe(String message, Object... objects) {
        getLogger().log(Level.SEVERE, formatMessage(message), objects);
    }
    
    /**
     * 记录SEVERE级别日志（带异常）
     * @param message 日志消息
     * @param thrown 异常对象
     */
    public void severe(String message, Throwable thrown) {
        getLogger().log(Level.SEVERE, formatMessage(message), thrown);
    }
    
    /**
     * 记录DEBUG级别日志（使用INFO级别输出）
     * @param message 日志消息
     * @param objects 格式化参数
     */
    public void debug(String message, Object... objects) {
        getLogger().log(Level.INFO, formatMessage("[DEBUG] " + message), objects);
    }
    
    /**
     * 记录ERROR级别日志（使用SEVERE级别输出）
     * @param message 日志消息
     * @param thrown 异常对象
     */
    public void error(String message, Throwable thrown) {
        getLogger().log(Level.SEVERE, formatMessage("[ERROR] " + message), thrown);
    }
    
    /**
     * 记录ERROR级别日志
     * @param message 日志消息
     * @param objects 格式化参数
     */
    public void error(String message, Object... objects) {
        getLogger().log(Level.SEVERE, formatMessage("[ERROR] " + message), objects);
    }
}