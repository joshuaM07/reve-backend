package mu.elohim.reve.config;

import ai.fal.client.FalClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FalConfig {

    @Bean
    public FalClient falClient(@Value("${fal.ai.api.key}") String apiKey) {
        System.setProperty("FAL_KEY", apiKey);
        return FalClient.withEnvCredentials();
    }
}
