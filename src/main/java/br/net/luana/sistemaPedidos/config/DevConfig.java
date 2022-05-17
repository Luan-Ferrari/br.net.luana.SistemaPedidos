package br.net.luana.sistemaPedidos.config;

import br.net.luana.sistemaPedidos.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.ParseException;

@Configuration
@Profile("dev")
public class DevConfig {

    @Autowired
    private DBService dbService;

    @Value("${spring.jpa.hibernate.dll-auto}")
    private String strategyDatabase;

    @Bean
    public boolean instantiateDatabase() throws ParseException {
        if (!"create".equals(strategyDatabase)) {
            return false;
        }
        dbService.instanciateTestDatabase();
        return true;
    }
}
