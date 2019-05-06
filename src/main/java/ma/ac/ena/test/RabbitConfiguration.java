package ma.ac.ena.test;



import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker
public class RabbitConfiguration implements WebSocketMessageBrokerConfigurer {

	@Value("${broker.host}")
	private String host ; 
	@Value("${broker.login}")
	private String login ; 
	@Value("${broker.password}")
	private String password ;
	@Value("${broker.port}")
	private int port ; 
	
	
	
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/websocketApp").withSockJS();
		registry.addEndpoint("/websocketApp");
	}

	
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.setApplicationDestinationPrefixes("/app");
		registry.enableStompBrokerRelay("/topic" , "/queue").setRelayHost(host).setRelayPort(port).setClientLogin(login)
				.setClientPasscode(password);
		

	}
	

}
	  


	  
