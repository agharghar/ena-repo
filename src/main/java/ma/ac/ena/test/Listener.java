//package ma.ac.ena.test;
//
//import javax.security.auth.message.callback.PrivateKeyCallback.Request;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jms.annotation.JmsListener;
//import org.springframework.jms.core.JmsTemplate;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class Listener {
//	
//	@Autowired
//	private JmsTemplate jmsTemplate ; 
//	
//	@GetMapping("/jms")
//	public String a() {
//		System.out.println("eae");
//		return jmsTemplate.getClass().getName() ; 
//	}
//
//
//	@PostMapping("/jms")
//	public String send(@RequestParam("a") String a) {
//		this.jmsTemplate.convertAndSend("mailbox" , a);
//		return "a" ;
//	}
//	
//}
