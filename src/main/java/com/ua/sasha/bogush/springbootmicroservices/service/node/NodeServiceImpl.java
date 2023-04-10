package com.ua.sasha.bogush.springbootmicroservices.service.node;

import com.ua.sasha.bogush.springbootmicroservices.configpojo.cmis.Alfresco;
import com.ua.sasha.bogush.springbootmicroservices.model.node.CreateSecondaryChildModel;
import com.ua.sasha.bogush.springbootmicroservices.model.node.NodeModel;
import com.ua.sasha.bogush.springbootmicroservices.model.node.childresponse.CreateSecondaryChildResponseModel;
import com.ua.sasha.bogush.springbootmicroservices.model.node.copybody.NodeCopyModel;
import com.ua.sasha.bogush.springbootmicroservices.model.node.createbody.NodeBodyCreateModel;
import com.ua.sasha.bogush.springbootmicroservices.model.node.updatebody.NodeBodyUpdateModel;
import com.ua.sasha.bogush.springbootmicroservices.service.webclient.WebClientAlfresco;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author Oleksandr Bogush
 * @version 1.0
 * @since 18.12.2020
 */

@Service
public class NodeServiceImpl implements NodeService {
    private static final Logger logNodeServiceImpl = LoggerFactory.getLogger(NodeServiceImpl.class);

    private final WebClientAlfresco webClientAlfresco;
    private final Alfresco alfresco;

    public NodeServiceImpl(WebClientAlfresco webClientAlfresco, Alfresco alfresco) {
        this.webClientAlfresco = webClientAlfresco;
        this.alfresco = alfresco;
    }

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
    public Mono<NodeModel> getNode(String nodeId, String include) {
        logNodeServiceImpl.info("nodeId = " + nodeId + "\ninclude = " + include);
        return webClientAlfresco
                .getWebClient()
                .get()
                .uri(GET_NODE, nodeId, include)
                .accept(MediaType.APPLICATION_JSON)
                .headers(headers -> headers.setBasicAuth(alfresco.getUsername(), alfresco.getPassword()))
                .retrieve()
                .bodyToMono(NodeModel.class);
    }

    /**
     * List node children
     *
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
    public Mono<NodeModel> getListChildrenNode(String nodeId, Integer skipCount, Integer maxItems, String orderBy, String where, String include, Boolean includeSource) {
        logNodeServiceImpl.info("getListChildrenNode: "
                + "\nnodeId  = " + nodeId
                + "\nskipCount = " + skipCount
                + "\nmaxItems = " + maxItems
                + "\norderBy = " + orderBy
                + "\nwhere = " + where
                + "\ninclude = " + include
                + "\nincludeSource = " + includeSource);
        return webClientAlfresco
                .getWebClient()
                .get()
                .uri(GET_LIST_CHILDREN_NODE, nodeId, skipCount, maxItems, orderBy, where, include, includeSource)
                .accept(MediaType.APPLICATION_JSON)
                .headers(headers -> headers.setBasicAuth(alfresco.getUsername(), alfresco.getPassword()))
                .retrieve()
                .bodyToMono(NodeModel.class);
    }

    /**
     * List parents
     *
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
    public Mono<NodeModel> getListParentsNode(String nodeId, String where, String include, Integer skipCount, Integer maxItems, Boolean includeSource) {
        logNodeServiceImpl.info("getListChildrenNode: "
                + "\nnodeId = " + nodeId
                + "\nwhere = " + where
                + "\ninclude = " + include
                + "\nskipCount = " + skipCount
                + "\nmaxItems = " + maxItems
                + "\nincludeSource = " + includeSource);
        return webClientAlfresco
                .getWebClient()
                .get()
                .uri(GET_LIST_PARENT_NODE, nodeId, where, include, skipCount, maxItems, includeSource)
                .accept(MediaType.APPLICATION_JSON)
                .headers(headers -> headers.setBasicAuth(alfresco.getUsername(), alfresco.getPassword()))
                .retrieve()
                .bodyToMono(NodeModel.class);
    }

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
    public Mono<NodeModel> getListSecondaryChildrenNode(String nodeId, String include, Integer skipCount, Integer maxItems, Boolean includeSource) {
        logNodeServiceImpl.info("GET List secondary children: "
                + "\nnodeId = " + nodeId
                + "\ninclude = " + include
                + "\nskipCount = " + skipCount
                + "\nmaxItems = " + maxItems
                + "\nincludeSource = " + includeSource);
        return webClientAlfresco
                .getWebClient()
                .get()
                .uri(GET_LIST_SECONDARY_CHILDREN_NODE, nodeId, include, skipCount, maxItems, includeSource)
                .accept(MediaType.APPLICATION_JSON)
                .headers(headers -> headers.setBasicAuth(alfresco.getUsername(), alfresco.getPassword()))
                .retrieve()
                .bodyToMono(NodeModel.class);
    }

    /**
     * @param nodeId    The identifier of a node.
     * @param permanent If true then the node is deleted permanently, without moving to the trashcan. Only the owner of the node or an admin can permanently delete the node.
     * @return Void
     * @author Oleksandr Bogush
     * @version 1.0
     * @see <a href="https://api-explorer.alfresco.com/api-explorer/#!/nodes/deleteNode">DELETE Delete a node</a>
     * @since 23.12.2020
     */
    public Mono<Void> deleteNode(String nodeId, Boolean permanent) {
        logNodeServiceImpl.info("Delete a node: "
                + "\nnodeId = " + nodeId
                + "\npermanent = " + permanent
        );
        return webClientAlfresco
                .getWebClient()
                .delete()
                .uri(DELETE_NODE, nodeId, permanent)
                .accept(MediaType.APPLICATION_JSON)
                .headers(headers -> headers.setBasicAuth(alfresco.getUsername(), alfresco.getPassword()))
                .retrieve()
                .bodyToMono(Void.class);
    }

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
    public Mono<NodeModel> updateNode(String nodeId, String include, NodeBodyUpdateModel nodeBodyUpdate) {
        logNodeServiceImpl.info("Update a node: "
                + "\nnodeId = " + nodeId
                + "\ninclude = " + include
        );
        return webClientAlfresco
                .getWebClient()
                .put()
                .uri(GET_NODE, nodeId, include)
                .accept(MediaType.APPLICATION_JSON)
                .headers(headers -> headers.setBasicAuth(alfresco.getUsername(), alfresco.getPassword()))
                .body(Mono.just(nodeBodyUpdate), NodeBodyUpdateModel.class)
                .retrieve()
                .bodyToMono(NodeModel.class);
    }

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
    public Mono<NodeModel> createNode(String nodeId, Boolean autoRename, String include, NodeBodyCreateModel nodeBodyCreate) {
        logNodeServiceImpl.info("Create a node: "
                + "\nnodeId = " + nodeId
                + "\nautoRename = " + autoRename
                + "\ninclude = " + include
        );
        return webClientAlfresco
                .getWebClient()
                .post()
                .uri(CREATE_NODE, nodeId, autoRename, include)
                .accept(MediaType.APPLICATION_JSON)
                .headers(headers -> headers.setBasicAuth(alfresco.getUsername(), alfresco.getPassword()))
                .body(Mono.just(nodeBodyCreate), NodeBodyCreateModel.class)
                .retrieve()
                .bodyToMono(NodeModel.class);
    }

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
    public Mono<NodeModel> createNodeFromList(String nodeId, Boolean autoRename, String include, List<NodeBodyCreateModel> nodeBodyCreate) {
        logNodeServiceImpl.info("Create a list node: "
                + "\nnodeId = " + nodeId
                + "\nautoRename = " + autoRename
                + "\ninclude = " + include
        );
        return webClientAlfresco
                .getWebClient()
                .post()
                .uri(CREATE_NODE, nodeId, autoRename, include)
                .accept(MediaType.APPLICATION_JSON)
                .headers(headers -> headers.setBasicAuth(alfresco.getUsername(), alfresco.getPassword()))
                .body(Mono.just(nodeBodyCreate.listIterator()), NodeBodyCreateModel.class)
                .retrieve()
                .bodyToMono(NodeModel.class);
    }

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
    public Mono<NodeModel> copyNode(String nodeId, String include, NodeCopyModel nodeBodyCopy) {
        logNodeServiceImpl.info("Copy a node: "
                + "\nnodeId = " + nodeId
                + "\ninclude = " + include
        );
        return webClientAlfresco
                .getWebClient()
                .post()
                .uri(COPY_NODE, nodeId, include)
                .accept(MediaType.APPLICATION_JSON)
                .headers(headers -> headers.setBasicAuth(alfresco.getUsername(), alfresco.getPassword()))
                .body(Mono.just(nodeBodyCopy), NodeCopyModel.class)
                .retrieve()
                .bodyToMono(NodeModel.class);
    }

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
    public Mono<NodeModel> moveNode(String nodeId, String include, NodeCopyModel nodeBodyMove) {
        logNodeServiceImpl.info("Move a node: "
                + "\nnodeId = " + nodeId
                + "\ninclude = " + include
        );
        return webClientAlfresco
                .getWebClient()
                .post()
                .uri(MOVE_NODE, nodeId, include)
                .accept(MediaType.APPLICATION_JSON)
                .headers(headers -> headers.setBasicAuth(alfresco.getUsername(), alfresco.getPassword()))
                .body(Mono.just(nodeBodyMove), NodeCopyModel.class)
                .retrieve()
                .bodyToMono(NodeModel.class);
    }

    /**
     * @param nodeId                              The identifier of a parent node.
     * @param secondaryChildAssociationBodyCreate The child node id and assoc type.
     * @return Create a secondary child association, with the given association type, between the parent nodeId and a child node.
     * @author Oleksandr Bogush
     * @version 1.0
     * @see <a href="https://api-explorer.alfresco.com/api-explorer/#!/nodes/createSecondaryChildAssociation">POST Create secondary child</a>
     * @since 23.12.2020
     */
    public Mono<CreateSecondaryChildResponseModel> createSecondaryChild(String nodeId, CreateSecondaryChildModel secondaryChildAssociationBodyCreate) {
        logNodeServiceImpl.info("createSecondaryChild: "
                + "\nnodeId = " + nodeId
        );
        return webClientAlfresco
                .getWebClient()
                .post()
                .uri(SECONDARY_CHILD, nodeId)
                .accept(MediaType.APPLICATION_JSON)
                .headers(headers -> headers.setBasicAuth(alfresco.getUsername(), alfresco.getPassword()))
                .body(Mono.just(secondaryChildAssociationBodyCreate), CreateSecondaryChildModel.class)
                .retrieve()
                .bodyToMono(CreateSecondaryChildResponseModel.class);
    }

    /**
     * @param nodeId  The identifier of a parent node.
     * @param childId The identifier of a child node.
     * @return Delete secondary child associations between the parent nodeId and child nodes for the given association type.
     * @author Oleksandr Bogush
     * @version 1.0
     * @see <a href="https://api-explorer.alfresco.com/api-explorer/#!/nodes/deleteSecondaryChildAssociation">Delete Delete secondary child or children</a>
     * @since 23.12.2020
     */
    public Mono<Void> deleteSecondaryChildOrChildren(String nodeId, String childId) {
        logNodeServiceImpl.info("Delete secondary child or children: "
                + "\nnodeId = " + nodeId
                + "\nchildId = " + childId
        );
        return webClientAlfresco
                .getWebClient()
                .delete()
                .uri(DELETE_SECONDARY_CHILD, nodeId, childId)
                .accept(MediaType.APPLICATION_JSON)
                .headers(headers -> headers.setBasicAuth(alfresco.getUsername(), alfresco.getPassword()))
                .retrieve()
                .bodyToMono(Void.class);
    }

}
