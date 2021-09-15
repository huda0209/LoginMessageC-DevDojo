package com.github.huda0209.loginmessagecdevdojo.config;

import com.github.huda0209.loginmessagecdevdojo.LoginMessageCDevDojo;
import org.bukkit.configuration.Configuration;

import java.util.List;

public class configManager {
    private static LoginMessageCDevDojo plugin;
    private static Configuration config;
    private static List<String> LoginMessages;


    public static void loadConfig(LoginMessageCDevDojo pl){
        plugin=pl;
        config = plugin.getConfig();
        LoginMessages = config.getStringList("LoginMessages");
    }

    public static List<String> getLoginMessage(){
        return LoginMessages;
    }

    public static void setLoginMessage(List<String> Lists){
        LoginMessages = Lists;
        config.set("LoginMessages", LoginMessages);
        plugin.saveConfig();
    }

    public static void reloadConfig(){
        plugin.reloadConfig();
        config = plugin.getConfig();
        LoginMessages = config.getStringList("LoginMessages");
    }
}