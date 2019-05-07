package com.rayturner.horsetrading.controllers;

import com.rayturner.horsetrading.forms.ConversationForm;
import com.rayturner.horsetrading.forms.MessageForm;
import com.rayturner.horsetrading.repositories.ConversationRepository;
import com.rayturner.horsetrading.repositories.PostgresMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/conversation")
public class ConversationController {
    public PostgresMessageRepository messageRepository;
    public ConversationRepository convoRepository;

    @Autowired
    public ConversationController(PostgresMessageRepository MessageRepository, ConversationRepository conversationRepository) {
        messageRepository = MessageRepository;
        convoRepository = conversationRepository;
    }


    @GetMapping("/{id}")
    public String showConversation(@PathVariable int id, Model model){
        model.addAttribute("conversation_id", id);
        model.addAttribute("messages", messageRepository.findAll(id));
        return "conversation";
    }

    @PostMapping()
    public String makeConversation(ConversationForm conversation, Principal principal, Model model){
        conversation.buyer_id = principal.getName();

        if (conversation.is_valid()){
            Integer id = convoRepository.save(conversation);
            return "redirect:/conversation/" + id.toString();
        }
        return "horse";
    }

    @PostMapping("/{conversationId}/message")
    public String newMessage(@PathVariable Integer conversationId, MessageForm message, Principal principal){
        message.conversation_id = conversationId;
        message.author_id = principal.getName();
        System.out.println(message.conversation_id);
        System.out.println(message.author_id);
        if (message.is_valid()){
            messageRepository.save(message);
        }
        return "redirect:/conversation/" + conversationId.toString();
    }
}