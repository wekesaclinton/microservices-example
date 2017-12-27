package ke.co.safaricom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import javax.jms.ConnectionFactory;

@EnableEurekaClient
@EnableJms
@SpringBootApplication
public class AppManagementServiceApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(AppManagementServiceApplication.class, args);
    }
    
    @Bean
    public JmsListenerContainerFactory<?> jmsFactory(ConnectionFactory connectionFactory,
            DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        factory.setErrorHandler(t -> {
            System.out.println("JMS Error occured : "+t.getMessage());
       });
        return factory;
    }
}
