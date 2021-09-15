package com.github.huda0209.loginmessagecdevdojo;

import com.github.huda0209.loginmessagecdevdojo.config.configManager;
import com.github.huda0209.loginmessagecdevdojo.command.commandHandler;
import com.github.huda0209.loginmessagecdevdojo.listener.PlayerJoinEventListener;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public final class LoginMessageCDevDojo extends JavaPlugin implements CommandExecutor {


    @Override
    public void onEnable() {
        saveDefaultConfig();
        configManager.loadConfig(this);
        getCommand("loginmessage").setExecutor(new commandHandler(this));
        getServer().getPluginManager().registerEvents(new PlayerJoinEventListener(this),this);

        String[] EnableMessage = {"=============================","Plugin Name : "+this.getDescription().getName() ,"Author : "+ this.getDescription().getAuthors(),"============================="};
        for (String s : EnableMessage) {
            getLogger().info(s);
        }
    }

    @Override
    public void onDisable() {
        getLogger().info(this.getDescription().getName()+" was disable.");
    }

}