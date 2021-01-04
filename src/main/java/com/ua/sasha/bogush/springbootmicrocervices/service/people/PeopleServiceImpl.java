package com.ua.sasha.bogush.springbootmicrocervices.service.people;

import com.ua.sasha.bogush.springbootmicrocervices.configpojo.cmis.Alfresco;
import com.ua.sasha.bogush.springbootmicrocervices.model.people.PeopleModel;
import com.ua.sasha.bogush.springbootmicrocervices.model.people.PersonRequestModel;
import com.ua.sasha.bogush.springbootmicrocervices.service.webclient.WebClientAlfresco;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @author Oleksandr Bogush
 * @version 1.0
 * @since 09.12.2020
 */
@Service
public class PeopleServiceImpl implements PeopleService {
    private static final Logger logPeopleServiceImpl = LoggerFactory.getLogger(PeopleServiceImpl.class);

    private final WebClientAlfresco webClientAlfresco;
    private final Alfresco alfresco;

    public PeopleServiceImpl(WebClientAlfresco webClientAlfresco, Alfresco alfresco) {
        this.webClientAlfresco = webClientAlfresco;
        this.alfresco = alfresco;
    }

    /**
     * @param skipCount The number of entities that exist in the collection before those included in this list. If not supplied then the default value is 0.
     * @param maxItems  The maximum number of items to return in the list. If not supplied then the default value is 100.
     * @param orderBy   A string to control the order of the entities returned in a list. You can use the orderBy parameter to sort the list by one or more fields.
     *                  <p>
     *                  Each field has a default sort order, which is normally ascending order. Read the API method implementation notes above to check if any fields used in this method have a descending default search order.
     *                  <p>
     *                  To sort the entities in a specific order, you can use the ASC and DESC keywords for any field.
     * @param include   Returns additional information about the person. The following optional fields can be requested:
     *                  <p>
     *                  properties
     *                  aspectNames
     *                  capabilities
     * @param fields    A list of field names.
     *                  <p>
     *                  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.
     *                  <p>
     *                  The list applies to a returned individual entity or entries within a collection.
     *                  <p>
     *                  If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.
     * @return PeopleModel List people.
     * The default sort order for the returned list is for people to be sorted by ascending id.
     * @author Oleksandr Bogush
     * @version 1.0
     * @see <a href="https://api-explorer.alfresco.com/api-explorer/#!/people/listPeople">GET list people</a>
     * @since 22.12.2020
     */
    public Mono<PeopleModel> getListPeople(Integer skipCount, Integer maxItems, String orderBy, String include, String fields) {
        logPeopleServiceImpl.info("getListPeople");
        return webClientAlfresco
                .getWebClient()
                .get()
                .uri(LIST_PERSON, skipCount, maxItems, orderBy, include, fields)
                .accept(MediaType.APPLICATION_JSON)
                .headers(headers -> headers.setBasicAuth(alfresco.getUsername(), alfresco.getPassword()))
                .retrieve()
                .bodyToMono(PeopleModel.class);
    }

    /**
     * @param maxItems   The maximum number of items to return in the list. If not supplied then the default value is 100.
     * @param orderByOne A string to control the order of the entities returned in a list. You can use the orderBy parameter to sort the list by only one field.
     *                   You can use any of the following fields to order the results: id, firstName, lastName
     * @return List people.
     * The default sort order for the returned list is for people to be sorted by ascending id.
     * @author Oleksandr Bogush
     * @version 1.0
     * @see <a href="https://api-explorer.alfresco.com/api-explorer/#!/people/listPeople">GET list people</a>
     * @since 17.12.2020
     */
    public Mono<PeopleModel> getListPeople(Integer maxItems, String orderByOne) {
        logPeopleServiceImpl.info("getListPersonOne");
        return webClientAlfresco
                .getWebClient()
                .get()
                .uri(LIST_PEOPLE_ONE, maxItems, orderByOne)
                .accept(MediaType.APPLICATION_JSON)
                .headers(headers -> headers.setBasicAuth(alfresco.getUsername(), alfresco.getPassword()))
                .retrieve()
                .bodyToMono(PeopleModel.class);
    }

    /**
     * @param maxItems   The maximum number of items to return in the list. If not supplied then the default value is 100.
     * @param orderByOne A string to control the order of the entities returned in a list. You can use the orderBy parameter to sort the list by only one field.
     *                   You can use any of the following fields to order the results: id, firstName, lastName
     * @param orderByTwo Second parameter for order by...
     * @return List people.
     * The default sort order for the returned list is for people to be sorted by ascending id.
     * @author Oleksandr Bogush
     * @version 1.0
     * @see <a href="https://api-explorer.alfresco.com/api-explorer/#!/people/listPeople">GET list people</a>
     * @since 21.12.2020
     */
    public Mono<PeopleModel> getListPeople(Integer maxItems, String orderByOne, String orderByTwo) {
        logPeopleServiceImpl.info("getListPersonTwo");
        return webClientAlfresco
                .getWebClient()
                .get()
                .uri(LIST_PEOPLE_TWO, maxItems, orderByOne, orderByTwo)
                .accept(MediaType.APPLICATION_JSON)
                .headers(headers -> headers.setBasicAuth(alfresco.getUsername(), alfresco.getPassword()))
                .retrieve()
                .bodyToMono(PeopleModel.class);
    }

    /**
     * @param maxItems     The maximum number of items to return in the list. If not supplied then the default value is 100.
     *                     <p>
     *                     A string to control the order of the entities returned in a list. You can use the orderBy parameter to sort the list by only one field.
     *                     You can use any of the following fields to order the results: id, firstName, lastName
     * @param orderByOne   First parameter for order by...
     * @param orderByTwo   Second parameter for order by...
     * @param orderByThree Third parameter for order by...
     * @return List people.
     * The default sort order for the returned list is for people to be sorted by ascending id.
     * @author Oleksandr Bogush
     * @version 1.0
     * @see <a href="https://api-explorer.alfresco.com/api-explorer/#!/people/listPeople">GET list people</a>
     * @since 21.12.2020
     */
    public Mono<PeopleModel> getListPeople(Integer maxItems, String orderByOne, String orderByTwo, String orderByThree) {
        logPeopleServiceImpl.info("getListPersonThree");
        return webClientAlfresco
                .getWebClient()
                .get()
                .uri(LIST_PEOPLE_THREE, maxItems, orderByOne, orderByTwo, orderByThree)
                .accept(MediaType.APPLICATION_JSON)
                .headers(headers -> headers.setBasicAuth(alfresco.getUsername(), alfresco.getPassword()))
                .retrieve()
                .bodyToMono(PeopleModel.class);
    }

    /**
     * @param personId The identifier of a person. If not supplied then the default value is -me-.
     * @return Gets information for the person personId.
     * * You can use the -me- string in place of <personid> to specify the currently authenticated user.
     * @author Oleksandr Bogush
     * @version 1.0
     * @see <a href="https://api-explorer.alfresco.com/api-explorer/#!/people/getPerson">GET person</a>
     * @since 17.12.2020
     */
    public Mono<PeopleModel> getPerson(String personId) {
        logPeopleServiceImpl.info("getPerson");
        return webClientAlfresco
                .getWebClient()
                .get()
                .uri(GET_PERSON, personId)
                .accept(MediaType.APPLICATION_JSON)
                .headers(headers -> headers.setBasicAuth(alfresco.getUsername(), alfresco.getPassword()))
                .retrieve()
                .bodyToMono(PeopleModel.class);
    }

    /**
     * Create a person
     *
     * @param person The person details.
     * @return Create a person and get information for the person.
     * If applicable, the given person's login access can also be optionally disabled.
     * You must have admin rights to create a person.
     * @version 1.0
     * @see <a href="https://api-explorer.alfresco.com/api-explorer/#!/people/createPerson">POST person</a>
     * @since 18.12.2020
     */
    public Mono<PeopleModel> createPerson(PersonRequestModel person) {
        logPeopleServiceImpl.info("createPerson");
        return webClientAlfresco
                .getWebClient()
                .post()
                .uri(URL_PERSON)
                .accept(MediaType.APPLICATION_JSON)
                .headers(headers -> headers.setBasicAuth(alfresco.getUsername(), alfresco.getPassword()))
                .body(Mono.just(person), PersonRequestModel.class)
                .retrieve()
                .bodyToMono(PeopleModel.class);
    }

    /**
     * Update the given person's details.
     *
     * @param personBodyUpdate The person details.
     * @param personId         The identifier of a person. If not supplied then the default value is -me-.
     * @return Update a person and get information for the person.
     * You can use the -me- string in place of <personid> to specify the currently authenticated user.
     * <p>
     * If applicable, the given person's login access can also be optionally disabled or re-enabled.
     * <p>
     * You must have admin rights to update a person — unless updating your own details.
     * <p>
     * If you are changing your password, as a non-admin user, then the existing password must also be supplied (using the oldPassword field in addition to the new password value).
     * <p>
     * Admin users cannot be disabled by setting enabled to false.
     * <p>
     * Non-admin users may not disable themselves.
     * @version 1.0
     * @see <a href="https://api-explorer.alfresco.com/api-explorer/#!/people/updatePerson">PUT person</a>
     * @since 18.12.2020
     */
    public Mono<PeopleModel> updatePerson(PersonRequestModel personBodyUpdate, String personId) {
        logPeopleServiceImpl.info("updatePerson");
        return webClientAlfresco
                .getWebClient()
                .put()
                .uri(GET_PERSON, personId)
                .accept(MediaType.APPLICATION_JSON)
                .headers(headers -> headers.setBasicAuth(alfresco.getUsername(), alfresco.getPassword()))
                .body(Mono.just(personBodyUpdate), PersonRequestModel.class)
                .retrieve()
                .bodyToMono(PeopleModel.class);
    }

    /**
     * Delete the Person used Api from Alfresco.
     *
     * @param personId name's person for Delete.
     * @return Void.
     * @version 1.0
     * @since 21.12.2020
     */
    public Mono<Void> deletePerson(String personId) {
        logPeopleServiceImpl.info("deletePerson");
        return webClientAlfresco
                .getWebClient()
                .delete()
                .uri(DELETE_PERSON, personId)
                .accept(MediaType.APPLICATION_JSON)
                .headers(headers -> headers.setBasicAuth(alfresco.getUsername(), alfresco.getPassword()))
                .retrieve()
                .bodyToMono(Void.class);
    }
}
