package com.github.huda0209.loginmessagecdevdojo.util;

import com.github.huda0209.loginmessagecdevdojo.config.configManager;

import java.util.List;

public class messageListManager {
    public static StatusMessage addLine(String msg){
        if(msg==null) return new StatusMessage(false, "The message is not specified.");
        List<String> messagesList = configManager.getLoginMessage();
        messagesList.add(msg);
        configManager.setLoginMessage(messagesList);
        return new StatusMessage(true, "Succeeded to add the message.");
    }

    public static StatusMessage removeLine(int index){
        List<String> messagesList = configManager.getLoginMessage();
        if(messagesList.size()<index) return new StatusMessage(false,"index is larger than the number of lines in the message.");
        messagesList.remove(index);
        configManager.setLoginMessage(messagesList);
        return new StatusMessage(true, "Succeeded to delete the message with the index "+(index+1)+".");
    }

    public static StatusMessage setLine(int index, String msg){
        if(msg==null) return new StatusMessage(false, "The message is not specified.");

        List<String> messagesList = configManager.getLoginMessage();
        if(messagesList.size()<=index){
            messagesList.set(index-1,msg);
            configManager.setLoginMessage(messagesList);
            return new StatusMessage(true, "Succeeded to set the message in the specified index "+(index+1)+".");
        }

        for(int i=messagesList.size(); i<index; i++){
            if(i==index) messagesList.add(msg);
            messagesList.add(msg);
        }
        configManager.setLoginMessage(messagesList);
        return new StatusMessage(true, "Succeeded to set the message in the specified index "+(index+1)+".");
    }
}
