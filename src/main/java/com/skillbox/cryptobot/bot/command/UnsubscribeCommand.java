package com.skillbox.cryptobot.bot.command;

import com.skillbox.cryptobot.bot.Subscriptions;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;

/**
 * Обработка команды отмены подписки на курс валюты
 */
@Service
@Slf4j
@AllArgsConstructor
public class UnsubscribeCommand implements IBotCommand {


    @Override
    public String getCommandIdentifier() {
        return "unsubscribe";
    }

    @Override
    public String getDescription() {
        return "Отменяет подписку пользователя";
    }

    @Override
    public void processMessage(AbsSender absSender, Message message, String[] arguments) {
        SendMessage answer = new SendMessage();
        answer.setChatId(message.getChatId());

        Subscriptions s = SubscribeCommand.getsObj();

        if (s.getSubs().contains(arguments[0])){
            s.removeSub(arguments[0]);
            answer.setText("Подписка на цену " + arguments[0] + " USD удалена.");
        } else{
            answer.setText("Не удалось найти подписку на указанную цену.");
        }

        try {
            absSender.execute(answer);
        } catch (Exception e) {
            //log.error("Ошибка возникла /unsubscribe методе", e);
        }
    }
}