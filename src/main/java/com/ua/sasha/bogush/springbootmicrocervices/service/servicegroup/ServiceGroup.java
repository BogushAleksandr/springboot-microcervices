package com.ua.sasha.bogush.springbootmicrocervices.service.servicegroup;

import com.ua.sasha.bogush.springbootmicrocervices.model.modelgroup.Groupe;
import reactor.core.publisher.Mono;

/**
 * @author Bogush Aleksandr
 * @version 1.0
 * @since 15-11-2020
 */

public interface ServiceGroup {
    Mono<Groupe> getAllGroups();

    Mono<Groupe> getSingleGroup(String nameGroup);

    Mono<Groupe> createGroupe(String nameGroup, Groupe groupe);

    Mono<Groupe> updateGroupe(String name, Groupe groupe);

    Mono<Groupe> deleteGroupe(String name);
}
