package com.skillbox.cryptobot.bot.command;
import com.skillbox.cryptobot.bot.Subscriptions;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class GetSubscriptionCommand implements IBotCommand {

    @Override
    public String getCommandIdentifier() {
        return "get_subscription";
    }

    @Override
    public String getDescription() {
        return "Возвращает текущую подписку";
    }

    @Override
    public void processMessage(AbsSender absSender, Message message, String[] arguments) {
        SendMessage answer = new SendMessage();
        answer.setChatId(message.getChatId());

        Subscriptions s = SubscribeCommand.getsObj();

        String text = "";
        for (String sub : s.getSubs()){
            text += sub + "\n";
        }
        answer.setText("Список подписок:\n" + text);

        try {
            absSender.execute(answer);
        } catch (Exception e) {
            //log.error("Ошибка возникла /get_subscribe методе", e);
        }
    }

}