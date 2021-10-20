/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.costume.repository;

import com.costume.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.costume.repository.dao.MessageDaoRepository;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author hugog
 */
@Repository
public class MessageRepository {

    @Autowired
    private MessageDaoRepository messageDaoRepository;

    public List<Message> getAllMessage() {
        List<Message> listMessage = (List<Message>) messageDaoRepository.findAll();

        return listMessage;
    }

    public Optional<Message> getMessage(Integer id) {
        Optional<Message> messageGeById = messageDaoRepository.findById(id);

        return messageGeById;
    }

    public Message saveMessage(Message message) {
        Message newMessage = messageDaoRepository.save(message);
        return newMessage;
    }

    public Message UpdateMessage(Message message) {
        Optional<Message> messaOptional = messageDaoRepository.findById(message.getIdMessage());
        if (messaOptional.isPresent()) {
            return message;
        }
        return null;
    }

    public void deleteMessage(Integer id) {

        messageDaoRepository.deleteById(id);
    }

}
