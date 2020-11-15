package com.ua.sasha.bogush.springbootmicrocervices.service.serviceperson;

import com.ua.sasha.bogush.springbootmicrocervices.model.modelperson.PersonRequest;
import com.ua.sasha.bogush.springbootmicrocervices.model.modelperson.PersonResponse;
import com.ua.sasha.bogush.springbootmicrocervices.pojoconfig.Alfresco;
import com.ua.sasha.bogush.springbootmicrocervices.service.WebClientAlfresco;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @author Bogush Aleksandr
 * @version 1.0
 * @since 15-11-2020
 */

@Service
public class ServicePersonImpl implements ServicePerson {
    private static final Logger logServicePersonImpl = LoggerFactory.getLogger(ServicePersonImpl.class);
    private final WebClientAlfresco webClientAlfresco;
    private final Alfresco alfresco;

    public ServicePersonImpl(WebClientAlfresco webClientAlfresco, Alfresco alfresco) {
        this.webClientAlfresco = webClientAlfresco;
        this.alfresco = alfresco;
    }

    public Mono<PersonResponse> getPersons(int maximumItems) {
        return webClientAlfresco
                .getWebClient()
                .get()
                .uri("/alfresco/api/-default-/public/alfresco/versions/1/people?maxItems={maximumItems}&orderBy=id", maximumItems)
                .accept(MediaType.APPLICATION_JSON)
                .headers(headers -> headers.setBasicAuth(alfresco.getUsername(), alfresco.getPassword()))
                .retrieve()
                .bodyToMono(PersonResponse.class);
    }

    public Mono<PersonResponse> getPerson(String namePerson) {
        return webClientAlfresco
                .getWebClient()
                .get()
                .uri("/alfresco/api/-default-/public/alfresco/versions/1/people/{namePerson}", namePerson)
                .accept(MediaType.APPLICATION_JSON)
                .headers(headers -> headers.setBasicAuth(alfresco.getUsername(), alfresco.getPassword()))
                .retrieve()
                .bodyToMono(PersonResponse.class);
    }

    public Mono<PersonResponse> createPerson(PersonRequest person) {
        return webClientAlfresco
                .getWebClient()
                .post()
                .uri("/alfresco/api/-default-/public/alfresco/versions/1/people")
                .accept(MediaType.APPLICATION_JSON)
                .headers(headers -> headers.setBasicAuth(alfresco.getUsername(), alfresco.getPassword()))
                .body(Mono.just(person), PersonRequest.class)
                .retrieve()
                .bodyToMono(PersonResponse.class);
    }

    public Mono<PersonResponse> updatePerson(PersonRequest person, String namePerson) {
        return webClientAlfresco
                .getWebClient()
                .put()
                .uri("/alfresco/api/-default-/public/alfresco/versions/1/people/{namePerson}", namePerson)
                .accept(MediaType.APPLICATION_JSON)
                .headers(headers -> headers.setBasicAuth(alfresco.getUsername(), alfresco.getPassword()))
                .body(Mono.just(person), PersonRequest.class)
                .retrieve()
                .bodyToMono(PersonResponse.class);
    }

    public Mono<Void> deletePerson(String namePerson) {
        return webClientAlfresco
                .getWebClient()
                .delete()
                .uri("/alfresco/service/api/people/{namePerson}", namePerson)
                .accept(MediaType.APPLICATION_JSON)
                .headers(headers -> headers.setBasicAuth(alfresco.getUsername(), alfresco.getPassword()))
                .retrieve()
                .bodyToMono(Void.class);
    }

}
