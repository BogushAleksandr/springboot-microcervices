package com.ua.sasha.bogush.springbootmicrocervices.service.node;

import com.ua.sasha.bogush.springbootmicrocervices.model.node.CreateSecondaryChildModel;
import com.ua.sasha.bogush.springbootmicrocervices.model.node.NodeModel;
import com.ua.sasha.bogush.springbootmicrocervices.model.node.childresponse.CreateSecondaryChildResponseModel;
import com.ua.sasha.bogush.springbootmicrocervices.model.node.copybody.NodeCopyModel;
import com.ua.sasha.bogush.springbootmicrocervices.model.node.createbody.NodeBodyCreateModel;
import com.ua.sasha.bogush.springbootmicrocervices.model.node.updatebody.NodeBodyUpdateModel;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author Oleksandr Bogush
 * @version 1.0
 * @since 21.12.2020
 */
public interface NodeService {
    String URL_NODE = "/alfresco/api/-default-/public/alfresco/versions/1/nodes";
    String GET_NODE = URL_NODE + "/{nodeId}?include={include}";
    String GET_LIST_CHILDREN_NODE = URL_NODE + "/{nodeId}/children?skipCount={skipCount}&maxItems={maxItems}&orderBy={orderBy}&where={where}&include={include}&includeSource={includeSource}";
    String GET_LIST_PARENT_NODE = URL_NODE + "/{nodeId}/parents?where={where}&include={include}&skipCount={skipCount}&maxItems={maxItems}&includeSource={includeSource}";
    String GET_LIST_SECONDARY_CHILDREN_NODE = URL_NODE + "/{nodeId}/secondary-children?&include={include}&skipCount={skipCount}&maxItems={maxItems}&includeSource={includeSource}";
    String DELETE_NODE = URL_NODE + "/{nodeId}?permanent={permanent}";
    String CREATE_NODE = URL_NODE + "/{nodeId}/children?autoRename={autoRename}&include={include}";
    String COPY_NODE = URL_NODE + "/{nodeId}/copy?include={include}";
    String MOVE_NODE = URL_NODE + "/{nodeId}/move?include={include}";
    String SECONDARY_CHILD = URL_NODE + "/{nodeId}/secondary-children";
    String DELETE_SECONDARY_CHILD = SECONDARY_CHILD + "/{childId}";

    /**
     * @param nodeId  The identifier of a node. You can also use one of these well-known aliases:
     *                <p>
     *                -my-
     *                -shared-
     *                -root-
     * @param include Returns additional information about the node. The following optional fields can be requested:
     *                <p>
     *                allowableOperations
     *                association
     *                isLink
     *                isFavorite
     *                isLocked
     *                path
     *                permissions
     * @return Get information for node nodeId.
     * @author Oleksandr Bogush
     * @version 1.0
     * @see <a href="https://api-explorer.alfresco.com/api-explorer/#!/nodes/getNode">GET node</a>
     * @since 21.12.2020
     */
    Mono<NodeModel> getNode(String nodeId, String include);

    /**
     * @param nodeId        The identifier of a node. You can also use one of these well-known aliases:
     *                      <p>
     *                      -my-
     *                      -shared-
     *                      -root-
     * @param skipCount     The number of entities that exist in the collection before those included in this list. If not supplied then the default value is 0.
     * @param maxItems      The maximum number of items to return in the list. If not supplied then the default value is 100.
     * @param orderBy       A string to control the order of the entities returned in a list. You can use the orderBy parameter to sort the list by one or more fields.
     *                      <p>
     *                      Each field has a default sort order, which is normally ascending order. Read the API method implementation notes above to check if any fields used in this method have a descending default search order.
     *                      <p>
     *                      To sort the entities in a specific order, you can use the ASC and DESC keywords for any field.
     * @param where         Optionally filter the list. Here are some examples:
     *                      <p>
     *                      where=(isFolder=true)
     *                      <p>
     *                      where=(isFile=true)
     *                      <p>
     *                      where=(nodeType='my:specialNodeType')
     *                      <p>
     *                      where=(nodeType='my:specialNodeType INCLUDESUBTYPES')
     *                      <p>
     *                      where=(isPrimary=true)
     *                      <p>
     *                      where=(assocType='my:specialAssocType')
     *                      <p>
     *                      where=(isPrimary=false and assocType='my:specialAssocType')
     * @param include       Returns additional information about the node. The following optional fields can be requested:
     *                      <p>
     *                      allowableOperations
     *                      aspectNames
     *                      association
     *                      isLink
     *                      isFavorite
     *                      isLocked
     *                      path
     *                      properties
     *                      permissions
     * @param includeSource Also include source in addition to entries with folder information on the parent node – either the specified parent nodeId, or as resolved by relativePath.
     * @return List node children
     * @author Oleksandr Bogush
     * @version 1.0
     * @see <a href="https://api-explorer.alfresco.com/api-explorer/#!/nodes/listNodeChildren">GET List node children</a>
     * @since 22.12.2020
     */
    Mono<NodeModel> getListChildrenNode(String nodeId, Integer skipCount, Integer maxItems, String orderBy, String where, String include, Boolean includeSource);

    /**
     * @param nodeId        The identifier of a child node. You can also use one of these well-known aliases:
     *                      <p>
     *                      -my-
     *                      -shared-
     *                      -root-
     * @param where         Optionally filter the list by assocType and/or isPrimary. Here are some example filters:
     *                      <p>
     *                      where=(assocType='my:specialAssocType')
     *                      <p>
     *                      where=(isPrimary=true)
     *                      <p>
     *                      where=(isPrimary=false and assocType='my:specialAssocType')
     * @param include       Returns additional information about the node. The following optional fields can be requested:
     *                      <p>
     *                      allowableOperations
     *                      aspectNames
     *                      isLink
     *                      isFavorite
     *                      isLocked
     *                      path
     *                      properties
     * @param skipCount     The number of entities that exist in the collection before those included in this list. If not supplied then the default value is 0.
     * @param maxItems      The maximum number of items to return in the list. If not supplied then the default value is 100.
     * @param includeSource Also include source (in addition to entries) with folder information on nodeId
     * @return List parents node
     * @author Oleksandr Bogush
     * @version 1.0
     * @see <a href="https://api-explorer.alfresco.com/api-explorer/#!/nodes/listParents">GET List parents node</a>
     * @since 22.12.2020
     */
    Mono<NodeModel> getListParentsNode(String nodeId, String where, String include, Integer skipCount, Integer maxItems, Boolean includeSource);

    /**
     * @param nodeId        The identifier of a parent node. You can also use one of these well-known aliases:
     *                      <p>
     *                      -my-
     *                      -shared-
     *                      -root-
     * @param include       Returns additional information about the node. The following optional fields can be requested:
     *                      <p>
     *                      allowableOperations
     *                      aspectNames
     *                      isLink
     *                      isFavorite
     *                      isLocked
     *                      path
     *                      properties
     * @param skipCount     The number of entities that exist in the collection before those included in this list. If not supplied then the default value is 0.
     * @param maxItems      The maximum number of items to return in the list. If not supplied then the default value is 100.
     * @param includeSource Also include source (in addition to entries) with folder information on nodeId.
     * @return List secondary children
     * @author Oleksandr Bogush
     * @version 1.0
     * @see <a href="https://api-explorer.alfresco.com/api-explorer/#!/nodes/listSecondaryChildren">GET List secondary children</a>
     * @since 23.12.2020
     */
    Mono<NodeModel> getListSecondaryChildrenNode(String nodeId, String include, Integer skipCount, Integer maxItems, Boolean includeSource);

    /**
     * @param nodeId    The identifier of a node.
     * @param permanent If true then the node is deleted permanently, without moving to the trashcan. Only the owner of the node or an admin can permanently delete the node.
     * @return Void
     * @author Oleksandr Bogush
     * @version 1.0
     * @see <a href="https://api-explorer.alfresco.com/api-explorer/#!/nodes/deleteNode">DELETE Delete a node</a>
     * @since 23.12.2020
     */
    Mono<Void> deleteNode(String nodeId, Boolean permanent);

    /**
     * @param nodeId         The identifier of a node.
     * @param include        Returns additional information about the node. The following optional fields can be requested:
     *                       <p>
     *                       allowableOperations
     *                       association
     *                       isLink
     *                       isFavorite
     *                       isLocked
     *                       path
     *                       permissions
     * @param nodeBodyUpdate The node information to update.
     * @return Update a node
     * @author Oleksandr Bogush
     * @version 1.0
     * @see <a href="https://api-explorer.alfresco.com/api-explorer/#!/nodes/updateNode">PUT Update a node</a>
     * @since 23.12.2020
     */
    Mono<NodeModel> updateNode(String nodeId, String include, NodeBodyUpdateModel nodeBodyUpdate);

    /**
     * @param nodeId         The identifier of a node. You can also use one of these well-known aliases:
     *                       <p>
     *                       -my-
     *                       -shared-
     *                       -root-
     * @param autoRename     If true, then a name clash will cause an attempt to auto rename by finding a unique name using an integer suffix.
     * @param include        Returns additional information about the node. The following optional fields can be requested:
     *                       <p>
     *                       allowableOperations
     *                       association
     *                       isLink
     *                       isFavorite
     *                       isLocked
     *                       path
     *                       permissions
     * @param nodeBodyCreate The node information to create.
     * @return Create a node and add it as a primary child of node nodeId.
     * @author Oleksandr Bogush
     * @version 1.0
     * @see <a href="https://api-explorer.alfresco.com/api-explorer/#!/nodes/updateNode">POST Create a node</a>
     * @since 23.12.2020
     */
    Mono<NodeModel> createNode(String nodeId, Boolean autoRename, String include, NodeBodyCreateModel nodeBodyCreate);

    /**
     * @param nodeId         The identifier of a node. You can also use one of these well-known aliases:
     *                       <p>
     *                       -my-
     *                       -shared-
     *                       -root-
     * @param autoRename     If true, then a name clash will cause an attempt to auto rename by finding a unique name using an integer suffix.
     * @param include        Returns additional information about the node. The following optional fields can be requested:
     *                       <p>
     *                       allowableOperations
     *                       association
     *                       isLink
     *                       isFavorite
     *                       isLocked
     *                       path
     *                       permissions
     * @param nodeBodyCreate The node information to create.
     * @return Create a node and add it as a primary child of node nodeId.
     * @author Oleksandr Bogush
     * @version 1.0
     * @see <a href="https://api-explorer.alfresco.com/api-explorer/#!/nodes/updateNode">POST Create a node</a>
     * @since 29.12.2020
     */
    Mono<NodeModel> createNodeFromList(String nodeId, Boolean autoRename, String include, List<NodeBodyCreateModel> nodeBodyCreate);

    /**
     * @param nodeId       The identifier of a node.
     * @param include      Returns additional information about the node. The following optional fields can be requested:
     *                     <p>
     *                     allowableOperations
     *                     association
     *                     isLink
     *                     isFavorite
     *                     isLocked
     *                     path
     *                     permissions
     * @param nodeBodyCopy The targetParentId and, optionally, a new name which should include the file extension.
     * @return Copies the node nodeId to the parent folder node targetParentId.
     * @author Oleksandr Bogush
     * @version 1.0
     * @see <a href="https://api-explorer.alfresco.com/api-explorer/#!/nodes/copyNode">POST Copy a node</a>
     * @since 23.12.2020
     */
    Mono<NodeModel> copyNode(String nodeId, String include, NodeCopyModel nodeBodyCopy);

    /**
     * @param nodeId       The identifier of a node.
     * @param include      Returns additional information about the node. The following optional fields can be requested:
     *                     <p>
     *                     allowableOperations
     *                     association
     *                     isLink
     *                     isFavorite
     *                     isLocked
     *                     path
     *                     permissions
     * @param nodeBodyMove The targetParentId and, optionally, a new name which should include the file extension.
     * @return Move the node nodeId to the parent folder node targetParentId.
     * @author Oleksandr Bogush
     * @version 1.0
     * @see <a href="https://api-explorer.alfresco.com/api-explorer/#!/nodes/moveNode">POST Move a node</a>
     * @since 23.12.2020
     */
    Mono<NodeModel> moveNode(String nodeId, String include, NodeCopyModel nodeBodyMove);

    /**
     * @param nodeId                              The identifier of a parent node.
     * @param secondaryChildAssociationBodyCreate The child node id and assoc type.
     * @return Create a secondary child association, with the given association type, between the parent nodeId and a child node.
     * @author Oleksandr Bogush
     * @version 1.0
     * @see <a href="https://api-explorer.alfresco.com/api-explorer/#!/nodes/createSecondaryChildAssociation">POST Create secondary child</a>
     * @since 23.12.2020
     */
    Mono<CreateSecondaryChildResponseModel> createSecondaryChild(String nodeId, CreateSecondaryChildModel secondaryChildAssociationBodyCreate);

    /**
     * @param nodeId  The identifier of a parent node.
     * @param childId The identifier of a child node.
     * @return Delete secondary child associations between the parent nodeId and child nodes for the given association type.
     * @author Oleksandr Bogush
     * @version 1.0
     * @see <a href="https://api-explorer.alfresco.com/api-explorer/#!/nodes/deleteSecondaryChildAssociation">Delete Delete secondary child or children</a>
     * @since 23.12.2020
     */
    Mono<Void> deleteSecondaryChildOrChildren(String nodeId, String childId);
}
