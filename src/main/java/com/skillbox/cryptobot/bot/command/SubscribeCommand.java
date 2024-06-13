package com.skillbox.cryptobot.bot.command;

import com.skillbox.cryptobot.bot.Subscriptions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;

/**
 * Обработка команды подписки на курс валюты
 */
@Service
@Slf4j
public class SubscribeCommand implements IBotCommand {

    @Override
    public String getCommandIdentifier() {
        return "subscribe";
    }

    @Override
    public String getDescription() {
        return "Подписывает пользователя на стоимость биткоина";
    }

    Subscriptions s = new Subscriptions();

    @Override
    public void processMessage(AbsSender absSender, Message message, String[] arguments) {
        SendMessage answer = new SendMessage();
        answer.setChatId(message.getChatId());

        answer.setText("Вы подписались на цену в " + arguments[0] + " USD");

        s.addSub(arguments[0]);

        try {
            absSender.execute(answer);
        } catch (Exception e) {
            //log.error("Ошибка возникла /subscribe методе", e);
        }
    }

}