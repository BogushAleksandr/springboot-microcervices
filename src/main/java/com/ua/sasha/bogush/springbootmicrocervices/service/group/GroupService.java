package com.ua.sasha.bogush.springbootmicrocervices.service.group;

import com.ua.sasha.bogush.springbootmicrocervices.model.group.Datum;
import com.ua.sasha.bogush.springbootmicrocervices.model.group.GroupBodyCreateModel;
import com.ua.sasha.bogush.springbootmicrocervices.model.group.GroupBodyUpdateModel;
import com.ua.sasha.bogush.springbootmicrocervices.model.group.GroupModel;
import reactor.core.publisher.Mono;

/**
 * @author Oleksandr Bogush
 * @version 1.0
 * @since 28.12.2020
 */
public interface GroupService {
    String URL_GROUP = "/alfresco/service/api/groups";
    String GET_ALL_GROUPS = URL_GROUP + "?skipCount={skipCount}&maxItems={maxItems}";
    String GROUPS_CHILDREN = URL_GROUP + "/{shortGroupName}/children?maxItems={maxItems}&skipCount={skipCount}";
    String GROUPS_CHILDREN_FILTER = URL_GROUP + "/{shortGroupName}/children?authorityType={authorityType}&maxItems={maxItems}&skipCount={skipCount}";
    String GROUPS_PARENTS_FILTER = URL_GROUP + "/{shortGroupName}/parents?maxItems={maxItems}&skipCount={skipCount}";
    String GET_GROUP = URL_GROUP + "/{groupId}";
    String DELETE_AND_CREATE = "/alfresco/service/api/rootgroups/{shortGroupName}";
    String UPDATE_GROUP = URL_GROUP + "/{shortGroupName}";

    /**
     * @param skipCount The number of entities that exist in the collection before those included in this list. If not supplied then the default value is 0.
     * @param maxItems  The maximum number of items to return in the list. If not supplied then the default value is 100.
     * @return List groups
     * @author Oleksandr Bogush
     * @version 1.0
     * @since 28.12.2020
     */
    Mono<GroupModel> getGroups(Integer skipCount, Integer maxItems);

    /**
     * @author Oleksandr Bogush
     * @version 1.0
     * @since 28.12.2020
     */
    Mono<GroupModel> getGroupsChildren(String shortGroupName, Integer maxItems, Integer skipCount);

    /**
     * @author Oleksandr Bogush
     * @version 1.0
     * @since 28.12.2020
     */
    Mono<GroupModel> getGroupsParents(String shortGroupName, Integer maxItems, Integer skipCount);

    /**
     * @author Oleksandr Bogush
     * @version 1.0
     * @since 28.12.2020
     */
    Mono<GroupModel> getGroupsChildren(String shortGroupName, String authorityType, Integer maxItems, Integer skipCount);

    /**
     * @param groupId The identifier of a group.
     * @return Get group details
     * @author Oleksandr Bogush
     * @version 1.0
     * @since 28.12.2020
     */
    Mono<Datum> getGroup(String groupId);

    /**
     * @author Oleksandr Bogush
     * @version 1.0
     * @since 28.12.2020
     */
    Mono<Datum> createGroup(String shortGroupName, GroupBodyCreateModel groupBodyCreate);

    /**
     * @author Oleksandr Bogush
     * @version 1.0
     * @since 28.12.2020
     */
    Mono<Void> deleteGroup(String shortGroupName);

    /**
     * @author Oleksandr Bogush
     * @version 1.0
     * @since 28.12.2020
     */
    Mono<Datum> updateGroup(String shortGroupName, GroupBodyUpdateModel groupBodyUpdate);

}
