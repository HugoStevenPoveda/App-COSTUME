/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.costume.service;

import com.costume.model.Message;
import com.costume.repository.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hugog
 */
@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAllMessage() {
        List<Message> listClient = messageRepository.getAllMessage();
        return listClient;
    }

    public Message saveMessage(Message message) {
        Message newMessage;
        if (message.getIdMessage() == null) {
            newMessage = messageRepository.saveMessage(message);
            return newMessage;
        } else {
            Optional<Message> messageOptional = messageRepository.getMessage(message.getIdMessage());
            if (messageOptional.isPresent()) {
                return message;

            } else {
                newMessage = messageRepository.saveMessage(message);
                return newMessage;

            }

        }

    }
    
    
    public Message updateMessage(Message message) {
        Message messageForUpdate = messageRepository.UpdateMessage(message);
        if (messageForUpdate!= null) {
            
            Message newMessage = messageForUpdate;
            newMessage.setMessageText(message.getMessageText());
            newMessage.setCostume(message.getCostume());
            newMessage.setClient(message.getClient());
            messageRepository.saveMessage(newMessage);
            return newMessage;
        }

        return null;
    }

    public void deleteMessage(Integer id) {
        Optional<Message> messageExits = messageRepository.getMessage(id);
        if (messageExits.isPresent()) {
            messageRepository.deleteMessage(id);

        }

    }
    

}
