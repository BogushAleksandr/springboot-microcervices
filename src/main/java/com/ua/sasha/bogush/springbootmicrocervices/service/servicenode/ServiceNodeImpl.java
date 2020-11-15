package com.ua.sasha.bogush.springbootmicrocervices.service.servicenode;

import com.ua.sasha.bogush.springbootmicrocervices.model.modelnode.Entry;
import com.ua.sasha.bogush.springbootmicrocervices.model.modelnode.Permissions;
import com.ua.sasha.bogush.springbootmicrocervices.pojoconfig.Alfresco;
import com.ua.sasha.bogush.springbootmicrocervices.service.WebClientAlfresco;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author Bogush Aleksandr
 * @version 1.0
 * @since 15-11-2020
 */

@Service
public class ServiceNodeImpl implements ServiceNode {
    private final WebClientAlfresco webClientAlfresco;
    private final Alfresco alfresco;

    public ServiceNodeImpl(WebClientAlfresco webClientAlfresco, Alfresco alfresco) {
        this.webClientAlfresco = webClientAlfresco;
        this.alfresco = alfresco;
    }

    public Mono<Entry> getNodeOnNodesId(String nodeid) {
        return webClientAlfresco
                .getWebClient()
                .get()
                .uri("/alfresco/api/-default-/public/alfresco/versions/1/nodes/{nodeid}?include=permissions", nodeid)
                .accept(MediaType.APPLICATION_JSON)
                .headers(headers -> headers
                        .setBasicAuth(alfresco.getUsername(), alfresco.getPassword())
                )
                .retrieve()
                .bodyToMono(Entry.class);
    }

    public Mono<Entry> setPermissionsOnNodesId(String nodeid, Permissions permission) {
        return webClientAlfresco
                .getWebClient()
                .put()
                .uri("/alfresco/api/-default-/public/alfresco/versions/1/nodes/{nodeid}?include=permissions", nodeid)
                .accept(MediaType.APPLICATION_JSON)
                .headers(headers -> headers
                        .setBasicAuth(alfresco.getUsername(), alfresco.getPassword())
                ).body(Mono.just(permission), Permissions.class)
                .retrieve()
                .bodyToMono(Entry.class);
    }

    public Mono<Entry> createNodeOnNodesIds(String nodeid, Entry entry) {
        return webClientAlfresco
                .getWebClient()
                .post()
                .uri("/alfresco/api/-default-/public/alfresco/versions/1/nodes/{nodeid}/children", nodeid)
                .accept(MediaType.APPLICATION_JSON)
                .headers(headers -> headers
                        .setBasicAuth(alfresco.getUsername(), alfresco.getPassword())
                ).body(Mono.just(entry), Entry.class)
                .retrieve()
                .bodyToMono(Entry.class);
    }

    public Mono<Entry> createNodeFromListOnNodesId(String nodeid, List<Entry> entry) {
        return webClientAlfresco
                .getWebClient()
                .post()
                .uri("/alfresco/api/-default-/public/alfresco/versions/1/nodes/{nodeid}/children", nodeid)
                .accept(MediaType.APPLICATION_JSON)
                .headers(headers -> headers
                        .setBasicAuth(alfresco.getUsername(), alfresco.getPassword())
                ).body(Mono.just(entry.listIterator()), Entry.class)
                .retrieve()
                .bodyToMono(Entry.class);
    }

    public Mono<Void> fullDelateNode(String nodeid) {
        return webClientAlfresco
                .getWebClient()
                .delete()
                .uri("/alfresco/api/-default-/public/alfresco/versions/1/nodes/{nodeid}?permanent=true", nodeid)
                .headers(headers -> headers
                        .setBasicAuth(alfresco.getUsername(), alfresco.getPassword()))
                .retrieve()
                .bodyToMono(Void.class);
    }
}
