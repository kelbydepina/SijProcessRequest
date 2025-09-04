/*package cv.pn.processmanagement.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class JacksonConfig {

    @Bean
    @Primary
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();

        // Remove qualquer módulo existente que possa estar causando conflito
        objectMapper.findAndRegisterModules();

        JavaTimeModule javaTimeModule = new JavaTimeModule();

        // Configura o formato para HH:mm:ss
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        // SERIALIZER: Sempre output como string "HH:mm:ss"
        javaTimeModule.addSerializer(LocalTime.class, new LocalTimeSerializer(timeFormatter));

        // DESERIALIZER: Customizado para aceitar objeto E string
        javaTimeModule.addDeserializer(LocalTime.class, new CustomLocalTimeDeserializer());

        // REGISTRA o módulo (substitui qualquer configuração anterior)
        objectMapper.registerModule(javaTimeModule);

        // CONFIGURAÇÕES CRUCIAIS para evitar formato de objeto
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.disable(SerializationFeature.WRITE_DURATIONS_AS_TIMESTAMPS);

        return objectMapper;
    }
}*/
