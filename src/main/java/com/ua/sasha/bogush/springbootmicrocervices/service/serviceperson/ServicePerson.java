package com.ua.sasha.bogush.springbootmicrocervices.service.serviceperson;

import com.ua.sasha.bogush.springbootmicrocervices.model.modelperson.PersonRequest;
import com.ua.sasha.bogush.springbootmicrocervices.model.modelperson.PersonResponse;
import reactor.core.publisher.Mono;

/**
 * @author Bogush Aleksandr
 * @version 1.0
 * @since 15-11-2020
 */
public interface ServicePerson {
    Mono<PersonResponse> getPersons(int maximumItems);

    Mono<PersonResponse> getPerson(String namePerson);

    Mono<PersonResponse> createPerson(PersonRequest person);

    Mono<PersonResponse> updatePerson(PersonRequest person, String namePerson);

    Mono<Void> deletePerson(String namePerson);

}
