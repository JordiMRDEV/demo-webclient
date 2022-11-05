package edu.webclient.demowebclient;

import edu.webclient.demowebclient.models.pokeapi.Berry;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Configuration
public class RunPokeApi implements ApplicationRunner {

    public void listBerries() {
        try {
            WebClient client = WebClient.create("https://pokeapi.co/api/v2/");
            var response = client.get()
                    .uri(uriBuilder -> uriBuilder
                            .path("berry/{id}")
                            .build("1"))
                    .retrieve()
                    .toEntity(Berry.class)
                    .block();

            assert response != null;
            var berry = response.getBody();
            System.out.println(berry);
        }
        catch (WebClientResponseException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        listBerries();
    }

}
