package com.github.huda0209.loginmessagecdevdojo.listener;

import com.github.huda0209.loginmessagecdevdojo.LoginMessageCDevDojo;
import com.github.huda0209.loginmessagecdevdojo.config.configManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.List;

public class PlayerJoinEventListener implements Listener {
    private LoginMessageCDevDojo plugin;
    public PlayerJoinEventListener(LoginMessageCDevDojo pl) {
        this.plugin=pl;
    }

    @EventHandler
    public void PlayerJoinEventHandler(PlayerJoinEvent event){
        Player player = event.getPlayer();
        List<String> messages = configManager.getLoginMessage();
        for(int i=0; i<messages.size(); i++){
            player.sendMessage(ChatColor.translateAlternateColorCodes('&',messages.get(i)));
        }
    }
}
