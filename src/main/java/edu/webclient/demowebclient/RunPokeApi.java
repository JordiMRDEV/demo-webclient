package edu.webclient.demowebclient;

import edu.webclient.demowebclient.models.pokeapi.Berry;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Configuration
public class RunPokeApi implements ApplicationRunner {

    public void listBerries() {

        WebClient client = WebClient.create("https://pokeapi.co/api/v2/");
        Optional<Berry> optionalBerry = client.get()
                .uri(uriBuilder -> uriBuilder
                        .path("berry/{id}")
                        .build("9999"))
                .retrieve()
                .bodyToMono(Berry.class)
                .onErrorResume(
                        WebClientResponseException.class,
                        this::handleException)
                .blockOptional();

        optionalBerry.ifPresent(System.out::println);
    }

    @Override
    public void run(ApplicationArguments args) {
        listBerries();
    }

    private Mono<Berry> handleException(WebClientResponseException ex) {
        return switch (ex.getStatusCode()) {
            // Controlamos este error para que no lance excepción y devolvemos una respuesta vacía
            case NOT_FOUND -> handleNotFound(ex);
            // Controlamos otros case o nos vamos al default
            // Cualquier otro error imprevisto lanza Excepción WebClientResponseException
            default -> Mono.error(ex);
        };
    }

    private Mono<Berry> handleNotFound(WebClientResponseException ex) {
        System.out.println(ex.getMessage());
        return Mono.empty();
    }
}
