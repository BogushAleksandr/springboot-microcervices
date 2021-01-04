package com.ua.sasha.bogush.springbootmicrocervices.service.people;

import com.ua.sasha.bogush.springbootmicrocervices.model.people.PeopleModel;
import com.ua.sasha.bogush.springbootmicrocervices.model.people.PersonRequestModel;
import reactor.core.publisher.Mono;

/**
 * @author Oleksandr Bogush
 * @version 1.0
 * @since 09.12.2020
 */
public interface PeopleService {
    String URL_PERSON = "/alfresco/api/-default-/public/alfresco/versions/1/people";
    String LIST_PERSON = URL_PERSON + "?skipCount={skipCount}&maxItems={maxItems}&orderBy={orderBy}&include={include}&fields={fields}";
    String LIST_PEOPLE_ONE = URL_PERSON + "?skipCount=0&maxItems={maxItems}&orderBy={orderByOne}";
    String LIST_PEOPLE_TWO = LIST_PEOPLE_ONE + "%2C{orderByTwo}";
    String LIST_PEOPLE_THREE = LIST_PEOPLE_TWO + "%2C{orderByThree}";
    String GET_PERSON = URL_PERSON + "/{personId}";
    String DELETE_PERSON = "/alfresco/service/api/people/{personId}";

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
    Mono<PeopleModel> getListPeople(Integer skipCount, Integer maxItems, String orderBy, String include, String fields);

    /**
     * @param maxItems The maximum number of items to return in the list. If not supplied then the default value is 100.
     * @param orderBy  A string to control the order of the entities returned in a list. You can use the orderBy parameter to sort the list by only one field.
     *                 You can use any of the following fields to order the results: id, firstName, lastName
     * @return List people.
     * The default sort order for the returned list is for people to be sorted by ascending id.
     * @author Oleksandr Bogush
     * @version 1.0
     * @see <a href="https://api-explorer.alfresco.com/api-explorer/#!/people/listPeople">GET list people</a>
     * @since 17.12.2020
     */
    Mono<PeopleModel> getListPeople(Integer maxItems, String orderBy);

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
    Mono<PeopleModel> getListPeople(Integer maxItems, String orderByOne, String orderByTwo);

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
    Mono<PeopleModel> getListPeople(Integer maxItems, String orderByOne, String orderByTwo, String orderByThree);

    /**
     * @param personId The identifier of a person. If not supplied then the default value is -me-.
     * @return Gets information for the person personId.
     * * You can use the -me- string in place of <personid> to specify the currently authenticated user.
     * @author Oleksandr Bogush
     * @version 1.0
     * @see <a href="https://api-explorer.alfresco.com/api-explorer/#!/people/getPerson">GET person</a>
     * @since 17.12.2020
     */
    Mono<PeopleModel> getPerson(String personId);

    /**
     * @param person The person details.
     * @return Create a person and get information for the person.
     * If applicable, the given person's login access can also be optionally disabled.
     * You must have admin rights to create a person.
     * @version 1.0
     * @see <a href="https://api-explorer.alfresco.com/api-explorer/#!/people/createPerson">POST person</a>
     * @since 21.12.2020
     */
    Mono<PeopleModel> createPerson(PersonRequestModel person);

    /**
     * Update the given personBodyUpdate's details.
     *
     * @param personBodyUpdate The personBodyUpdate details.
     * @param personId         The identifier of a personBodyUpdate. If not supplied then the default value is -me-.
     * @return Update a personBodyUpdate and get information for the personBodyUpdate.
     * You can use the -me- string in place of <personid> to specify the currently authenticated user.
     * <p>
     * If applicable, the given personBodyUpdate's login access can also be optionally disabled or re-enabled.
     * <p>
     * You must have admin rights to update a personBodyUpdate — unless updating your own details.
     * <p>
     * If you are changing your password, as a non-admin user, then the existing password must also be supplied (using the oldPassword field in addition to the new password value).
     * <p>
     * Admin users cannot be disabled by setting enabled to false.
     * <p>
     * Non-admin users may not disable themselves.
     * @version 1.0
     * @see <a href="https://api-explorer.alfresco.com/api-explorer/#!/people/updatePerson">PUT personBodyUpdate</a>
     * @since 18.12.2020
     */
    Mono<PeopleModel> updatePerson(PersonRequestModel personBodyUpdate, String personId);

    /**
     * Delete the Person used Api from Alfresco.
     *
     * @param personId name's person for Delete.
     * @return Void.
     * @version 1.0
     * @since 21.12.2020
     */
    Mono<Void> deletePerson(String personId);
}
