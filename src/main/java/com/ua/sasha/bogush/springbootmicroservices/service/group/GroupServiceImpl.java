package com.ua.sasha.bogush.springbootmicroservices.service.group;

import com.ua.sasha.bogush.springbootmicroservices.configpojo.cmis.Alfresco;
import com.ua.sasha.bogush.springbootmicroservices.model.group.Datum;
import com.ua.sasha.bogush.springbootmicroservices.model.group.GroupBodyCreateModel;
import com.ua.sasha.bogush.springbootmicroservices.model.group.GroupBodyUpdateModel;
import com.ua.sasha.bogush.springbootmicroservices.model.group.GroupModel;
import com.ua.sasha.bogush.springbootmicroservices.service.webclient.WebClientAlfresco;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @author Oleksandr Bogush
 * @version 1.0
 * @since 28.12.2020
 */

@Service
public class GroupServiceImpl implements GroupService {
    private static final Logger logGroupServiceImpl = LoggerFactory.getLogger(GroupServiceImpl.class);

    private final WebClientAlfresco webClientAlfresco;
    private final Alfresco alfresco;

    public GroupServiceImpl(WebClientAlfresco webClientAlfresco, Alfresco alfresco) {
        this.webClientAlfresco = webClientAlfresco;
        this.alfresco = alfresco;
    }

    /**
     * @param skipCount The number of entities that exist in the collection before those included in this list. If not supplied then the default value is 0.
     * @param maxItems  The maximum number of items to return in the list. If not supplied then the default value is 100.
     * @return List groups
     * @author Oleksandr Bogush
     * @version 1.0
     * @since 28.12.2020
     */
    public Mono<GroupModel> getGroups(Integer skipCount, Integer maxItems) {
        logGroupServiceImpl.info("List groups: "
                + "\nskipCount = " + skipCount
                + "\nmaxItems = " + maxItems
        );
        return webClientAlfresco
                .getWebClient()
                .get()
                .uri(GET_ALL_GROUPS, skipCount, maxItems)
                .accept(MediaType.APPLICATION_JSON)
                .headers(headers -> headers.setBasicAuth(alfresco.getUsername(), alfresco.getPassword()))
                .retrieve()
                .bodyToMono(GroupModel.class);
    }

    /**
     * @author Oleksandr Bogush
     * @version 1.0
     * @since 28.12.2020
     */
    public Mono<GroupModel> getGroupsChildren(String shortGroupName, Integer maxItems, Integer skipCount) {
        logGroupServiceImpl.info("List groups: "
                + "\nshortGroupName = " + shortGroupName
                + "\nskipCount = " + skipCount
                + "\nmaxItems = " + maxItems
        );
        return webClientAlfresco
                .getWebClient()
                .get()
                .uri(GROUPS_CHILDREN, shortGroupName, maxItems, skipCount)
                .accept(MediaType.APPLICATION_JSON)
                .headers(headers -> headers.setBasicAuth(alfresco.getUsername(), alfresco.getPassword()))
                .retrieve()
                .bodyToMono(GroupModel.class);
    }

    /**
     * @author Oleksandr Bogush
     * @version 1.0
     * @since 28.12.2020
     */
    public Mono<GroupModel> getGroupsParents(String shortGroupName, Integer maxItems, Integer skipCount) {
        logGroupServiceImpl.info("List groups: "
                + "\nshortGroupName = " + shortGroupName
                + "\nskipCount = " + skipCount
                + "\nmaxItems = " + maxItems
        );
        return webClientAlfresco
                .getWebClient()
                .get()
                .uri(GROUPS_PARENTS_FILTER, shortGroupName, maxItems, skipCount)
                .accept(MediaType.APPLICATION_JSON)
                .headers(headers -> headers.setBasicAuth(alfresco.getUsername(), alfresco.getPassword()))
                .retrieve()
                .bodyToMono(GroupModel.class);
    }

    /**
     * @author Oleksandr Bogush
     * @version 1.0
     * @since 28.12.2020
     */
    public Mono<GroupModel> getGroupsChildren(String shortGroupName, String authorityType, Integer maxItems, Integer skipCount) {
        logGroupServiceImpl.info("List groups: "
                + "\nshortGroupName = " + shortGroupName
                + "\nauthorityType = " + authorityType
                + "\nskipCount = " + skipCount
                + "\nmaxItems = " + maxItems
        );
        return webClientAlfresco
                .getWebClient()
                .get()
                .uri(GROUPS_CHILDREN_FILTER, shortGroupName, authorityType, maxItems, skipCount)
                .accept(MediaType.APPLICATION_JSON)
                .headers(headers -> headers.setBasicAuth(alfresco.getUsername(), alfresco.getPassword()))
                .retrieve()
                .bodyToMono(GroupModel.class);
    }

    /**
     * @param groupId The identifier of a group.
     * @return Get group details
     * @author Oleksandr Bogush
     * @version 1.0
     * @since 28.12.2020
     */
    public Mono<Datum> getGroup(String groupId) {
        logGroupServiceImpl.info("Get group details: "
                + "\ngroupId = " + groupId
        );
        return webClientAlfresco
                .getWebClient()
                .get()
                .uri(GET_GROUP, groupId)
                .accept(MediaType.APPLICATION_JSON)
                .headers(headers -> headers.setBasicAuth(alfresco.getUsername(), alfresco.getPassword()))
                .retrieve()
                .bodyToMono(Datum.class);
    }

    /**
     * @author Oleksandr Bogush
     * @version 1.0
     * @since 28.12.2020
     */
    public Mono<Datum> createGroup(String shortGroupName, GroupBodyCreateModel groupBodyCreate) {
        logGroupServiceImpl.info("Create a Group: "
                + "\nshortGroupName = " + shortGroupName
        );
        return webClientAlfresco
                .getWebClient()
                .post()
                .uri(DELETE_AND_CREATE, shortGroupName)
                .accept(MediaType.APPLICATION_JSON)
                .headers(headers -> headers.setBasicAuth(alfresco.getUsername(), alfresco.getPassword()))
                .body(Mono.just(groupBodyCreate), GroupBodyCreateModel.class)
                .retrieve()
                .bodyToMono(Datum.class);
    }

    /**
     * @author Oleksandr Bogush
     * @version 1.0
     * @since 28.12.2020
     */
    public Mono<Void> deleteGroup(String shortGroupName) {
        return webClientAlfresco
                .getWebClient()
                .delete()
                .uri(DELETE_AND_CREATE, shortGroupName)
                .accept(MediaType.APPLICATION_JSON)
                .headers(headers -> headers.setBasicAuth(alfresco.getUsername(), alfresco.getPassword()))
                .retrieve()
                .bodyToMono(Void.class);
    }

    /**
     * @author Oleksandr Bogush
     * @version 1.0
     * @since 28.12.2020
     */
    public Mono<Datum> updateGroup(String shortGroupName, GroupBodyUpdateModel groupBodyUpdate) {
        return webClientAlfresco
                .getWebClient()
                .put()
                .uri(UPDATE_GROUP, shortGroupName)
                .accept(MediaType.APPLICATION_JSON)
                .headers(headers -> headers.setBasicAuth(alfresco.getUsername(), alfresco.getPassword()))
                .body(Mono.just(groupBodyUpdate), GroupBodyUpdateModel.class)
                .retrieve()
                .bodyToMono(Datum.class);
    }
}
