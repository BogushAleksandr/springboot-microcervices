package com.ua.sasha.bogush.springbootmicrocervices.service.servicegroup;

import com.ua.sasha.bogush.springbootmicrocervices.model.modelgroup.Groupe;
import com.ua.sasha.bogush.springbootmicrocervices.pojoconfig.Alfresco;
import com.ua.sasha.bogush.springbootmicrocervices.service.WebClientAlfresco;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @author Bogush Aleksandr
 * @version 1.0
 * @since 15-11-2020
 */

@Service
public class ServiceGroupImpl implements ServiceGroup {
    private final WebClientAlfresco webClientAlfresco;
    private final Alfresco alfresco;

    public ServiceGroupImpl(WebClientAlfresco webClientAlfresco, Alfresco alfresco) {
        this.webClientAlfresco = webClientAlfresco;
        this.alfresco = alfresco;
    }

    public Mono<Groupe> getAllGroups() {
        return webClientAlfresco
                .getWebClient()
                .get()
                .uri("/alfresco/service/api/groups")
                .accept(MediaType.APPLICATION_JSON)
                .headers(headers -> headers
                        .setBasicAuth(alfresco.getUsername(), alfresco.getPassword())
                )
                .retrieve()
                .bodyToMono(Groupe.class);
    }

    public Mono<Groupe> getSingleGroup(String nameGroup) {
        return webClientAlfresco
                .getWebClient()
                .get()
                .uri("/alfresco/service/api/groups/{nameGroup}", nameGroup)
                .accept(MediaType.APPLICATION_JSON)
                .headers(headers -> headers
                        .setBasicAuth(alfresco.getUsername(), alfresco.getPassword())
                )
                .retrieve()
                .bodyToMono(Groupe.class);
    }

    public Mono<Groupe> createGroupe(String shortName, Groupe groupe) {
        return webClientAlfresco
                .getWebClient()
                .post()
                .uri("/alfresco/service/api/rootgroups/{shortName}", shortName)
                .accept(MediaType.APPLICATION_JSON)
                .headers(headers -> headers.setBasicAuth(alfresco.getUsername(), alfresco.getPassword()))
                .body(Mono.just(groupe), Groupe.class)
                .retrieve()
                .bodyToMono(Groupe.class);
    }

    public Mono<Groupe> updateGroupe(String shortName, Groupe groupe) {
        return webClientAlfresco
                .getWebClient()
                .put()
                .uri("/alfresco/service/api/groups/{shortName}", shortName)
                .accept(MediaType.APPLICATION_JSON)
                .headers(headers -> headers.setBasicAuth(alfresco.getUsername(), alfresco.getPassword()))
                .body(Mono.just(groupe), Groupe.class)
                .retrieve()
                .bodyToMono(Groupe.class);
    }

    public Mono<Groupe> deleteGroupe(String shortName) {
        return webClientAlfresco
                .getWebClient()
                .delete()
                .uri("/alfresco/service/api/groups/{shortName}", shortName)
                .accept(MediaType.APPLICATION_JSON)
                .headers(headers -> headers.setBasicAuth(alfresco.getUsername(), alfresco.getPassword()))
                .retrieve()
                .bodyToMono(Groupe.class);
    }
}
