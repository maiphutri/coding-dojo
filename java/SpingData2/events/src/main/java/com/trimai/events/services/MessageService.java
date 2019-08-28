package com.trimai.events.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trimai.events.models.Message;
import com.trimai.events.repositories.MessageRepo;

@Service
public class MessageService {
	@Autowired
	private MessageRepo mR;
	
	public Message createOrUpdate(Message message) {
		Message newMsg = new Message();
		newMsg.setContent(message.getContent());
		newMsg.setEvent(message.getEvent());
		newMsg.setSender(message.getSender());
		return mR.save(newMsg);
	}
	
	public List<Message> getMessages(Long id) {
		return mR.findAllByEventId(id);
	}
}
