package com.github.huda0209.loginmessagecdevdojo.command;

import com.github.huda0209.loginmessagecdevdojo.LoginMessageCDevDojo;
import com.github.huda0209.loginmessagecdevdojo.config.configManager;
import com.github.huda0209.loginmessagecdevdojo.util.messageListManager;
import com.github.huda0209.loginmessagecdevdojo.util.StatusMessage;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.List;
import java.util.Locale;

public class commandHandler implements CommandExecutor {
    private LoginMessageCDevDojo plugin;
    public commandHandler(LoginMessageCDevDojo pl) {
        this.plugin=pl;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length==0) return false;
        if(!sender.hasPermission("LoginMessageCDevDojo.command")){
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',command.getPermissionMessage()));
            return true;
        }

        StatusMessage status = null;
        switch (args[0].toLowerCase(Locale.ROOT)){
            case "addline" :
                status = messageListManager.addLine(args[1]);
                if(!status.getStatus()) sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&c"+status.getMessage()));
                else sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&a"+status.getMessage()));
                break;

            case "removeline":
                try{
                    int index = Integer.parseInt(args[1])-1;
                    status = messageListManager.removeLine(index);
                }catch (Exception e){
                    status = new StatusMessage(false,"Failed to convert to numeric value.");
                }
                if(!status.getStatus()) sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&9[" + plugin.getDescription().getName() + "] &c"+status.getMessage()));
                else sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&9[" + plugin.getDescription().getName() + "] &a"+status.getMessage()));
                break;

            case "setline":
                try{
                    int index = Integer.parseInt(args[1])-1;
                    status = messageListManager.setLine(index,args[2]);
                }catch (Exception e){
                    status = new StatusMessage(false,"Failed to convert to numeric value.");
                }

                if(!status.getStatus()) sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&9[" + plugin.getDescription().getName() + "] &c"+status.getMessage()));
                else sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&9[" + plugin.getDescription().getName() + "] &a"+status.getMessage()));
                break;

            case "show":
                List<String> messages = configManager.getLoginMessage();
                for(int i=0; i<messages.size(); i++){
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&aLine"+(i+1)+"&r "+messages.get(i)));
                }
                break;

            case "reload":
                try {
                    configManager.reloadConfig();
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&9[" + plugin.getDescription().getName() + "]&a Reload the config file."));
                }catch(Exception e){
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&9[" + plugin.getDescription().getName() + "]&c While reload the config file, occurred error. Please check console."));
                    System.out.println(e.toString());
                }
                break;

            default:
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&9[" + plugin.getDescription().getName() + "]&c Unknown command."));
        }

        return true;
    }
}
