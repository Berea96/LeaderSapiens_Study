package com.leaderSapiens;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.toIntExact;

//텔레그렘 봇
public class TestTelegram extends TelegramLongPollingBot {
    @Override
    public String getBotToken() {
        return "716083493:AAF9chXmDAo_x_RL6k_9EOZHwi1v2HVDyZs";
    }

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {
            try {
                execute(sendMessage(update));
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else if (update.hasCallbackQuery()) {
            try {
                execute(sendCallBackMessage(update));
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    private SendMessage sendMessage(Update update) {
        String text = update.getMessage().getText();
        System.out.println(text);

        SendMessage message = new SendMessage()
                .setChatId(update.getMessage().getChatId())
                .setText(text);
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();

        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> rowInline = new ArrayList<>();

        rowInline.add(new InlineKeyboardButton().setText("적중").setCallbackData(text + " : 적중"));
        rowInline.add(new InlineKeyboardButton().setText("관리자").setCallbackData(text + " : 관리자"));

        rowsInline.add(rowInline);

        markupInline.setKeyboard(rowsInline);
        message.setReplyMarkup(markupInline);

        return message;
    }

    private EditMessageText sendCallBackMessage(Update update) {
        String call_data = update.getCallbackQuery().getData();
        long message_id = update.getCallbackQuery().getMessage().getMessageId();
        long chat_id = update.getCallbackQuery().getMessage().getChatId();

        EditMessageText new_message = new EditMessageText()
                .setChatId(chat_id)
                .setMessageId(toIntExact(message_id))
                .setText(call_data);

        return new_message;
    }

    @Override
    public String getBotUsername() {
        return "kimkj96Bot";
    }
}