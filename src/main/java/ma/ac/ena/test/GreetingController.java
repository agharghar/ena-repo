package ma.ac.ena.test;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import ma.ac.ena.entities.Etudiant;
import ma.ac.ena.entities.User;

@Controller
public class GreetingController {

	 @Autowired   
	 private SimpMessageSendingOperations messagingTemplate;
	

    @MessageMapping("/hello/{id}")
    public String greeting(String message , @DestinationVariable int id ) {
    	messagingTemplate.convertAndSend("/topic/public", id);
        return "aaze" ;
    }
    
    @MessageMapping("/queue.chat")
    @SendTo("/queue/messages")
    public Etudiant greeting1(@Payload Etudiant etd) {
    	System.out.println(etd.getNom());

    	
    	return etd ;
    }

    @MessageMapping("/queue.test")
    @SendTo("/queue/messages1")
    public Object greeting1(@Payload String message) {
    	
    	return "ee" ;
    }
    
    
}