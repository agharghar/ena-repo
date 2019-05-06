package ma.ac.ena.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

import ma.ac.ena.wrapper.Documentwrapper;

@Controller
public class MessagingController {
	
	 @Autowired   
	 private SimpMessageSendingOperations messagingTemplate;

		@MessageMapping("/a")
	    public String greeting(@Payload String message  ) {
			messagingTemplate.convertAndSend("/queue/privé", "99");
	        return message ;
	    }
}
