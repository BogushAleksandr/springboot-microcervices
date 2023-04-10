package com.ua.sasha.bogush.springbootmicroservices.controller;

import com.ua.sasha.bogush.springbootmicroservices.model.error.UnexpectedErrorModel;
import com.ua.sasha.bogush.springbootmicroservices.model.node.CreateSecondaryChildModel;
import com.ua.sasha.bogush.springbootmicroservices.model.node.NodeModel;
import com.ua.sasha.bogush.springbootmicroservices.model.node.childresponse.CreateSecondaryChildResponseModel;
import com.ua.sasha.bogush.springbootmicroservices.model.node.copybody.NodeCopyModel;
import com.ua.sasha.bogush.springbootmicroservices.model.node.createbody.NodeBodyCreateModel;
import com.ua.sasha.bogush.springbootmicroservices.model.node.updatebody.NodeBodyUpdateModel;
import com.ua.sasha.bogush.springbootmicroservices.service.node.NodeServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.util.annotation.NonNull;

import java.util.List;

/**
 * @author Oleksandr Bogush
 * @version 1.0
 * @since 18.12.2020
 */
@Tag(name = "node", description = "Retrieve and manage nodes")
@RestController
@RequestMapping("/api")
public class NodeController {
    private static final Logger logNodeController = LoggerFactory.getLogger(NodeController.class);
    private final NodeServiceImpl nodeService;

    public NodeController(NodeServiceImpl nodeService) {
        this.nodeService = nodeService;
    }

    /**
     * @author Oleksandr Bogush
     * @version 1.0
     * @since 21.12.2020
     */
    @Operation(
            summary = "Get a node.",
            description = "",
            tags = {"node"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = NodeModel.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid parameter: nodeId is not a valid format",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "401", description = "Authentication failed",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "403", description = "Current user does not have permission to retrieve nodeId",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "404", description = "nodeId does not exist",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))})
    })
    @GetMapping(path = "/node", produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    public Mono<NodeModel> getNode(@Parameter(description = "The identifier of a node. You can also use one of these well-known aliases:\n" + "-my-\n" + "-shared-\n" + "-root-")
                                   @RequestParam(name = "nodeId") @NotBlank String nodeId,
                                   @Parameter(description = "Returns additional information about the node. The following optional fields can be requested:\n" +
                                           "     *                <p>\n" +
                                           "     *                allowableOperations\n" +
                                           "     *                association\n" +
                                           "     *                isLink\n" +
                                           "     *                isFavorite\n" +
                                           "     *                isLocked\n" +
                                           "     *                path\n" +
                                           "     *                permissions")
                                   @RequestParam(name = "include", defaultValue = "permissions") @NotBlank String include) {
        logNodeController.info("getNode:"
                + "\nnodeId = " + nodeId
                + "\ninclude = " + include);
        return nodeService.getNode(nodeId, include);
    }

    /**
     * @author Oleksandr Bogush
     * @version 1.0
     * @since 22.12.2020
     */
    @Operation(
            summary = "Gets a list of children of the parent node nodeId.",
            description = "Minimal information for each child is returned by default.\n" +
                    "\n" +
                    "You can use the include parameter to return additional information.\n" +
                    "\n" +
                    "The list of child nodes includes primary children and secondary children, if there are any.\n" +
                    "\n" +
                    "You can use the include parameter (include=association) to return child association details for each child, including the assocType and the isPrimary flag.\n" +
                    "\n" +
                    "The default sort order for the returned list is for folders to be sorted before files, and by ascending name.\n" +
                    "\n" +
                    "You can override the default using orderBy to specify one or more fields to sort by. The default order is always ascending, but you can use an optional ASC or DESC modifier to specify an ascending or descending sort order.\n" +
                    "\n" +
                    "For example, specifying orderBy=name DESC returns a mixed folder/file list in descending name order.\n" +
                    "\n" +
                    "You can use any of the following fields to order the results:\n" +
                    "\n" +
                    "isFolder\n" +
                    "name\n" +
                    "mimeType\n" +
                    "nodeType\n" +
                    "sizeInBytes\n" +
                    "modifiedAt\n" +
                    "createdAt\n" +
                    "modifiedByUser\n" +
                    "createdByUser",
            tags = {"node"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = NodeModel.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid parameter: nodeId is not a valid format, nodeId is not a folder or orderBy is invalid",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "401", description = "Authentication failed",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "403", description = "Current user does not have permission to retrieve children of nodeId",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "404", description = "nodeId does not exist",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))})
    })
    @GetMapping(path = "/node/children", produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    public Mono<NodeModel> getNodeListChildren(@Parameter(description = "The identifier of a node. You can also use one of these well-known aliases:\n" + "-my-\n" + "-shared-\n" + "-root-")
                                               @RequestParam(name = "nodeId") @NotBlank String nodeId,
                                               @Parameter(description = "The number of entities that exist in the collection before those included in this list. If not supplied then the default value is 0.")
                                               @RequestParam(name = "skipCount", defaultValue = "0") @NotBlank Integer skipCount,
                                               @Parameter(description = "The maximum number of items to return in the list. If not supplied then the default value is 100.")
                                               @RequestParam(name = "maxItems", defaultValue = "100") @NotBlank Integer maxItems,
                                               @Parameter(description = "A string to control the order of the entities returned in a list. You can use the orderBy parameter to sort the list by one or more fields.\n" +
                                                       "\n" +
                                                       "Each field has a default sort order, which is normally ascending order. Read the API method implementation notes above to check if any fields used in this method have a descending default search order.\n" +
                                                       "\n" +
                                                       "To sort the entities in a specific order, you can use the ASC and DESC keywords for any field.")
                                               @RequestParam(name = "orderBy", defaultValue = "ASC") @NotBlank String orderBy,
                                               @Parameter(description = "Optionally filter the list. Here are some examples:\n" +
                                                       "\n" +
                                                       "where=(isFolder=true)\n" +
                                                       "\n" +
                                                       "where=(isFile=true)\n" +
                                                       "\n" +
                                                       "where=(nodeType='my:specialNodeType')\n" +
                                                       "\n" +
                                                       "where=(nodeType='my:specialNodeType INCLUDESUBTYPES')\n" +
                                                       "\n" +
                                                       "where=(isPrimary=true)\n" +
                                                       "\n" +
                                                       "where=(assocType='my:specialAssocType')\n" +
                                                       "\n" +
                                                       "where=(isPrimary=false and assocType='my:specialAssocType')")
                                               @RequestParam(name = "where", defaultValue = "(isFolder=true)") @NotBlank String where,
                                               @Parameter(description = "Returns additional information about the node. The following optional fields can be requested:\n" +
                                                       "\n" +
                                                       "allowableOperations\n" +
                                                       "aspectNames\n" +
                                                       "association\n" +
                                                       "isLink\n" +
                                                       "isFavorite\n" +
                                                       "isLocked\n" +
                                                       "path\n" +
                                                       "properties\n" +
                                                       "permissions")
                                               @RequestParam(name = "include", defaultValue = "path,permissions") @NotBlank String include,
                                               @Parameter(description = "Also include source in addition to entries with folder information on the parent node – either the specified parent nodeId, or as resolved by relativePath.")
                                               @RequestParam(name = "includeSource", defaultValue = "true") Boolean includeSource) {
        logNodeController.info("getListChildrenNode: "
                + "\nnodeId  = " + nodeId
                + "\nskipCount = " + skipCount
                + "\nmaxItems = " + maxItems
                + "\norderBy = " + orderBy
                + "\nwhere = " + where
                + "\ninclude = " + include
                + "\nincludeSource = " + includeSource);
        return nodeService.getListChildrenNode(nodeId, skipCount, maxItems, orderBy, where, include, includeSource);
    }

    /**
     * @author Oleksandr Bogush
     * @version 1.0
     * @since 22.12.2020
     */
    @Operation(
            summary = "Gets a list of parent nodes that are associated with the current child nodeId.\n" +
                    "\n" +
                    "The list includes both the primary parent and any secondary parents.",
            description = "",
            tags = {"node"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = NodeModel.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid parameter: assocType is unknown or the nodeId is not a valid format",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "401", description = "Authentication failed",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "403", description = "Current user does not have permission for nodeId",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "404", description = "Child nodeId does not exist",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))})
    })
    @GetMapping(path = "/node/parents", produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    public Mono<NodeModel> getNodeListParents(@Parameter(description = "The identifier of a node. You can also use one of these well-known aliases:\n" + "-my-\n" + "-shared-\n" + "-root-")
                                              @RequestParam(name = "nodeId") @NotBlank String nodeId,
                                              @Parameter(description = "Optionally filter the list by assocType and/or isPrimary. Here are some example filters:\n" +
                                                      "\n" +
                                                      "where=(assocType='my:specialAssocType')\n" +
                                                      "\n" +
                                                      "where=(isPrimary=true)\n" +
                                                      "\n" +
                                                      "where=(isPrimary=false and assocType='my:specialAssocType')")
                                              @RequestParam(name = "where", defaultValue = "(isPrimary=true)") @NotBlank String where,
                                              @Parameter(description = "Returns additional information about the node. The following optional fields can be requested:\n" +
                                                      "\n" +
                                                      "allowableOperations\n" +
                                                      "aspectNames\n" +
                                                      "isLink\n" +
                                                      "isFavorite\n" +
                                                      "isLocked\n" +
                                                      "path\n" +
                                                      "properties")
                                              @RequestParam(name = "include", defaultValue = "path")
                                              @NotBlank String include,
                                              @Parameter(description = "The number of entities that exist in the collection before those included in this list. If not supplied then the default value is 0.")
                                              @RequestParam(name = "skipCount", defaultValue = "0") @NotBlank Integer skipCount,
                                              @Parameter(description = "The maximum number of items to return in the list. If not supplied then the default value is 100.")
                                              @RequestParam(name = "maxItems", defaultValue = "100") @NotBlank Integer maxItems,
                                              @Parameter(description = "Also include source (in addition to entries) with folder information on nodeId")
                                              @RequestParam(name = "includeSource", defaultValue = "true") Boolean includeSource) {
        logNodeController.info("getListParentsNode: "
                + "\nnodeId = " + nodeId
                + "\nwhere = " + where
                + "\ninclude = " + include
                + "\nskipCount = " + skipCount
                + "\nmaxItems = " + maxItems
                + "\nincludeSource = " + includeSource);
        return nodeService.getListParentsNode(nodeId, where, include, skipCount, maxItems, includeSource);
    }

    /**
     * @author Oleksandr Bogush
     * @version 1.0
     * @since 22.12.2020
     */
    @Operation(
            summary = "Gets a list of secondary child nodes that are associated with the current parent nodeId, via a secondary child association.",
            description = "",
            tags = {"node"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = NodeModel.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid parameter: assocType is unknown or the nodeId is not a valid format",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "401", description = "Authentication failed",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "403", description = "Current user does not have permission for nodeId",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "404", description = "Child nodeId does not exist",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))})
    })
    @GetMapping(path = "/node/secondary-children", produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    public Mono<NodeModel> getNode(@Parameter(description = "The identifier of a node. You can also use one of these well-known aliases:\n" + "-my-\n" + "-shared-\n" + "-root-")
                                   @RequestParam(name = "nodeId") @NotBlank String nodeId,
                                   @Parameter(description = "Returns additional information about the node. The following optional fields can be requested:\n" +
                                           "\n" +
                                           "allowableOperations\n" +
                                           "aspectNames\n" +
                                           "isLink\n" +
                                           "isFavorite\n" +
                                           "isLocked\n" +
                                           "path\n" +
                                           "properties")
                                   @RequestParam(name = "include", defaultValue = "path")
                                   @NotBlank String include,
                                   @Parameter(description = "The number of entities that exist in the collection before those included in this list. If not supplied then the default value is 0.")
                                   @RequestParam(name = "skipCount", defaultValue = "0") @NotBlank Integer skipCount,
                                   @Parameter(description = "The maximum number of items to return in the list. If not supplied then the default value is 100.")
                                   @RequestParam(name = "maxItems", defaultValue = "100") @NotBlank Integer maxItems,
                                   @Parameter(description = "Also include source (in addition to entries) with folder information on nodeId")
                                   @RequestParam(name = "includeSource", defaultValue = "true") Boolean includeSource) {
        logNodeController.info("getListSecondaryChildrenNode: "
                + "\nnodeId = " + nodeId
                + "\ninclude = " + include
                + "\nskipCount = " + skipCount
                + "\nmaxItems = " + maxItems
                + "\nincludeSource = " + includeSource);
        return nodeService.getListSecondaryChildrenNode(nodeId, include, skipCount, maxItems, includeSource);
    }

    /**
     * @author Oleksandr Bogush
     * @version 1.0
     * @since 23.12.20
     */
    @Operation(
            summary = "Deletes the node nodeId.",
            description = "If nodeId is a folder, then its children are also deleted.\n" +
                    "\n" +
                    "Deleted nodes move to the trashcan unless the permanent query parameter is true and the current user is the owner of the node or an admin.\n" +
                    "\n" +
                    "Deleting a node deletes it from its primary parent and also from any secondary parents. Peer associations are also deleted, where the deleted node is either a source or target of an association. This applies recursively to any hierarchy of primary children of the deleted node.\n" +
                    "\n" +
                    "Note: If the node is not permanently deleted, and is later successfully restored to its former primary parent, then the primary child association is restored. This applies recursively for any primary children. No other secondary child associations or peer associations are restored for any of the nodes in the primary parent-child hierarchy of restored nodes, regardless of whether the original associations were to nodes inside or outside the restored hierarchy.",
            tags = {"node"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Successful operation"),
            @ApiResponse(responseCode = "400", description = "Invalid parameter: nodeId is not a valid format",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "401", description = "Authentication failed",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "403", description = "Current user does not have permission to delete nodeId",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "404", description = "nodeId does not exist",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "409", description = "nodeId is locked and cannot be deleted",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))})
    })
    @DeleteMapping(path = "/node", produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteNode(@Parameter(description = "The identifier of a node.")
                                 @RequestParam(name = "nodeId") @NotBlank String nodeId,
                                 @Parameter(description = "If true then the node is deleted permanently, without moving to the trashcan. Only the owner of the node or an admin can permanently delete the node.")
                                 @RequestParam(name = "permanent", defaultValue = "false") Boolean permanent) {
        logNodeController.info("delete the node: "
                + "\nnodeId = " + nodeId
                + "\npermanent = " + permanent);
        return nodeService.deleteNode(nodeId, permanent);
    }

    /**
     * @author Oleksandr Bogush
     * @version 1.0
     * @since 23.12.20
     */
    @Operation(
            summary = "Updates the node nodeId.",
            description = "Updates the node nodeId. For example, you can rename a file or folder:\n" +
                    "\n" +
                    "{\n" +
                    "  \"name\":\"My new name\"\n" +
                    "}\n" +
                    "You can also set or update one or more properties:\n" +
                    "\n" +
                    "{\n" +
                    "  \"properties\":\n" +
                    "  {\n" +
                    "    \"cm:title\":\"Folder title\"\n" +
                    "  }\n" +
                    "}\n" +
                    "You can update multi-value properties of a node which supports properties of type multiple.\n" +
                    "\n" +
                    "{\n" +
                    "  \"name\":\"My Other Folder\",\n" +
                    "  \"nodeType\":\"custom:destination\",\n" +
                    "  \"properties\":\n" +
                    "  {\n" +
                    "    \"cm:title\":\"Folder title\",\n" +
                    "    \"cm:description\":\"This is an important folder\",\n" +
                    "    \"custom:locations\": [\n" +
                    "                         \"location NewX\",\n" +
                    "                         \"location NewY\"\n" +
                    "                        ]\n" +
                    "  }\n" +
                    "}\n" +
                    "Note: setting properties of type d:content and d:category are not supported.\n" +
                    "\n" +
                    "Note: if you want to add or remove aspects, then you must use GET /nodes/{nodeId} first to get the complete set of aspectNames.\n" +
                    "\n" +
                    "You can add (or remove) locallySet permissions, if any, in addition to any inherited permissions. You can also optionally disable (or re-enable) inherited permissions via isInheritanceEnabled flag:\n" +
                    "\n" +
                    "{\n" +
                    "  \"permissions\":\n" +
                    "    {\n" +
                    "      \"isInheritanceEnabled\": false,\n" +
                    "      \"locallySet\":\n" +
                    "        [\n" +
                    "          {\"authorityId\": \"GROUP_special\", \"name\": \"Read\", \"accessStatus\":\"DENIED\"},\n" +
                    "          {\"authorityId\": \"testuser\", \"name\": \"Contributor\", \"accessStatus\":\"ALLOWED\"}\n" +
                    "        ]\n" +
                    "    }\n" +
                    "}\n" +
                    "Note: if you want to add or remove locally set permissions then you must use GET /nodes/{nodeId} first to get the complete set of locallySet permissions.\n" +
                    "\n" +
                    "Note: Currently there is no optimistic locking for updates, so they are applied in \"last one wins\" order.",
            tags = {"node"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful response",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = NodeModel.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid parameter: the update request is invalid or nodeId is not a valid format or nodeBodyUpdate is invalid",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "401", description = "Authentication failed",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "403", description = "Current user does not have permission to update nodeId",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "404", description = "nodeId does not exist",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "409", description = "Updated name clashes with an existing node in the current parent folder",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "422", description = "Model integrity exception including a file name containing invalid characters",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))})
    })
    @PutMapping(path = "/node", produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    public Mono<NodeModel> updateNode(@Parameter(description = "The identifier of a node.")
                                      @RequestParam(name = "nodeId") @NotBlank String nodeId,
                                      @Parameter(description = "Returns additional information about the node. The following optional fields can be requested:\n" +
                                              "\n" +
                                              "allowableOperations\n" +
                                              "association\n" +
                                              "isLink\n" +
                                              "isFavorite\n" +
                                              "isLocked\n" +
                                              "path\n" +
                                              "permissions")
                                      @RequestParam(name = "include", defaultValue = "permissions") @NotBlank String include,
                                      @RequestBody @NonNull NodeBodyUpdateModel nodeBodyUpdate) {
        logNodeController.info("Update a node: "
                + "\nnodeId = " + nodeId
                + "\ninclude = " + include);
        return nodeService.updateNode(nodeId, include, nodeBodyUpdate);
    }

    /**
     * @author Oleksandr Bogush
     * @version 1.0
     * @since 23.12.20
     */
    @Operation(
            summary = "Create a node and add it as a primary child of node nodeId.",
            description = "Create a node and add it as a primary child of node nodeId.\n" +
                    "\n" +
                    "This endpoint supports both JSON and multipart/form-data (file upload).\n" +
                    "\n" +
                    "Using multipart/form-data\n" +
                    "\n" +
                    "Use the filedata field to represent the content to upload, for example, the following curl command will create a node with the contents of test.txt in the test user's home folder.\n" +
                    "\n" +
                    "curl -utest:test -X POST host:port/alfresco/api/-default-/public/alfresco/versions/1/nodes/-my-/children -F filedata=@test.txt\n" +
                    "\n" +
                    "You can use the name field to give an alternative name for the new file.\n" +
                    "\n" +
                    "You can use the nodeType field to create a specific type. The default is cm:content.\n" +
                    "\n" +
                    "You can use the renditions field to create renditions (e.g. doclib) asynchronously upon upload. Also, as requesting rendition is a background process, any rendition failure (e.g. No transformer is currently available) will not fail the whole upload and has the potential to silently fail.\n" +
                    "\n" +
                    "Use overwrite to overwrite an existing file, matched by name. If the file is versionable, the existing content is replaced.\n" +
                    "\n" +
                    "When you overwrite existing content, you can set the majorVersion boolean field to true to indicate a major version should be created. The default for majorVersion is false. Setting majorVersion enables versioning of the node, if it is not already versioned.\n" +
                    "\n" +
                    "When you overwrite existing content, you can use the comment field to add a version comment that appears in the version history. This also enables versioning of this node, if it is not already versioned.\n" +
                    "\n" +
                    "You can set the autoRename boolean field to automatically resolve name clashes. If there is a name clash, then the API method tries to create a unique name using an integer suffix.\n" +
                    "\n" +
                    "You can use the relativePath field to specify the folder structure to create relative to the node nodeId. Folders in the relativePath that do not exist are created before the node is created.\n" +
                    "\n" +
                    "Any other field provided will be treated as a property to set on the newly created node.\n" +
                    "\n" +
                    "Note: setting properties of type d:content and d:category are not supported.\n" +
                    "\n" +
                    "Using JSON\n" +
                    "\n" +
                    "You must specify at least a name and nodeType. For example, to create a folder:\n" +
                    "\n" +
                    "{\n" +
                    "  \"name\":\"My Folder\",\n" +
                    "  \"nodeType\":\"cm:folder\"\n" +
                    "}\n" +
                    "You can create an empty file like this:\n" +
                    "\n" +
                    "{\n" +
                    "  \"name\":\"My text file.txt\",\n" +
                    "  \"nodeType\":\"cm:content\"\n" +
                    "}\n" +
                    "You can update binary content using the PUT /nodes/{nodeId} API method.\n" +
                    "\n" +
                    "You can create a folder, or other node, inside a folder hierarchy:\n" +
                    "\n" +
                    "{\n" +
                    "  \"name\":\"My Special Folder\",\n" +
                    "  \"nodeType\":\"cm:folder\",\n" +
                    "  \"relativePath\":\"X/Y/Z\"\n" +
                    "}\n" +
                    "The relativePath specifies the folder structure to create relative to the node nodeId. Folders in the relativePath that do not exist are created before the node is created.\n" +
                    "\n" +
                    "You can set properties when you create a new node:\n" +
                    "\n" +
                    "{\n" +
                    "  \"name\":\"My Other Folder\",\n" +
                    "  \"nodeType\":\"cm:folder\",\n" +
                    "  \"properties\":\n" +
                    "  {\n" +
                    "    \"cm:title\":\"Folder title\",\n" +
                    "    \"cm:description\":\"This is an important folder\"\n" +
                    "  }\n" +
                    "}\n" +
                    "You can set multi-value properties when you create a new node which supports properties of type multiple.\n" +
                    "\n" +
                    "{\n" +
                    "  \"name\":\"My Other Folder\",\n" +
                    "  \"nodeType\":\"custom:destination\",\n" +
                    "  \"properties\":\n" +
                    "  {\n" +
                    "    \"cm:title\":\"Folder title\",\n" +
                    "    \"cm:description\":\"This is an important folder\",\n" +
                    "    \"custom:locations\": [\n" +
                    "                         \"location X\",\n" +
                    "                         \"location Y\"\n" +
                    "                        ]\n" +
                    "  }\n" +
                    "}\n" +
                    "Any missing aspects are applied automatically. For example, cm:titled in the JSON shown above. You can set aspects explicitly, if needed, using an aspectNames field.\n" +
                    "\n" +
                    "Note: setting properties of type d:content and d:category are not supported.\n" +
                    "\n" +
                    "You can also optionally disable (or enable) inherited permissions via isInheritanceEnabled flag:\n" +
                    "\n" +
                    "{\n" +
                    "  \"permissions\":\n" +
                    "    {\n" +
                    "      \"isInheritanceEnabled\": false,\n" +
                    "      \"locallySet\":\n" +
                    "        [\n" +
                    "          {\"authorityId\": \"GROUP_special\", \"name\": \"Read\", \"accessStatus\":\"DENIED\"},\n" +
                    "          {\"authorityId\": \"testuser\", \"name\": \"Contributor\", \"accessStatus\":\"ALLOWED\"}\n" +
                    "        ]\n" +
                    "    }\n" +
                    "}\n" +
                    "Typically, for files and folders, the primary children are created within the parent folder using the default \"cm:contains\" assocType. If the content model allows then it is also possible to create primary children with a different assoc type. For example:\n" +
                    "\n" +
                    "{\n" +
                    "  \"name\":\"My Node\",\n" +
                    "  \"nodeType\":\"my:specialNodeType\",\n" +
                    "  \"association\":\n" +
                    "  {\n" +
                    "    \"assocType\":\"my:specialAssocType\"\n" +
                    "  }\n" +
                    "}\n" +
                    "Additional associations can be added after creating a node. You can also add associations at the time the node is created. This is required, for example, if the content model specifies that a node has mandatory associations to one or more existing nodes. You can optionally specify an array of secondaryChildren to create one or more secondary child associations, such that the newly created node acts as a parent node. You can optionally specify an array of targets to create one or more peer associations such that the newly created node acts as a source node. For example, to associate one or more secondary children at time of creation:\n" +
                    "\n" +
                    "{\n" +
                    "  \"name\":\"My Folder\",\n" +
                    "  \"nodeType\":\"cm:folder\",\n" +
                    "  \"secondaryChildren\":\n" +
                    "    [ {\"childId\":\"abcde-01234-...\", \"assocType\":\"my:specialChildAssocType\"} ]\n" +
                    "}\n" +
                    "For example, to associate one or more targets at time of creation:\n" +
                    "\n" +
                    "{\n" +
                    "  \"name\":\"My Folder\",\n" +
                    "  \"nodeType\":\"cm:folder\",\n" +
                    "  \"targets\":\n" +
                    "    [ {\"targetId\":\"abcde-01234-...\", \"assocType\":\"my:specialPeerAssocType\"} ]\n" +
                    "}\n" +
                    "Note: You can create more than one child by specifying a list of nodes in the JSON body. For example, the following JSON body creates two folders inside the specified nodeId, if the nodeId identifies a folder:\n" +
                    "\n" +
                    "[\n" +
                    "  {\n" +
                    "    \"name\":\"My Folder 1\",\n" +
                    "    \"nodeType\":\"cm:folder\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\":\"My Folder 2\",\n" +
                    "    \"nodeType\":\"cm:folder\"\n" +
                    "  }\n" +
                    "]\n" +
                    "If you specify a list as input, then a paginated list rather than an entry is returned in the response body. For example:\n" +
                    "\n" +
                    "{\n" +
                    "  \"list\": {\n" +
                    "    \"pagination\": {\n" +
                    "      \"count\": 2,\n" +
                    "      \"hasMoreItems\": false,\n" +
                    "      \"totalItems\": 2,\n" +
                    "      \"skipCount\": 0,\n" +
                    "      \"maxItems\": 100\n" +
                    "    },\n" +
                    "    \"entries\": [\n" +
                    "      {\n" +
                    "        \"entry\": {\n" +
                    "          ...\n" +
                    "        }\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"entry\": {\n" +
                    "          ...\n" +
                    "        }\n" +
                    "      }\n" +
                    "    ]\n" +
                    "  }\n" +
                    "}",
            tags = {"node"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successful response",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = NodeModel.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid parameter: nodeId is not a valid format or nodeBodyCreate is invalid",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "401", description = "Authentication failed",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "403", description = "Current user does not have permission to create children of nodeId",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "404", description = "nodeId or renditionId does not exist",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "409", description = "New name clashes with an existing node in the current parent folder",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "413", description = "Content exceeds individual file size limit configured for the network or system",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "415", description = "Content Type is not supported",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "422", description = "Model integrity exception including a file name containing invalid characters",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "507", description = "Content exceeds overall storage quota limit configured for the network or system",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))})
    })
    @PostMapping(path = "/node", produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<NodeModel> createNode(@Parameter(description = "The identifier of a node. You can also use one of these well-known aliases:\n" +
            "\n" +
            "-my-\n" +
            "-shared-\n" +
            "-root-")
                                      @RequestParam(name = "nodeId") @NotBlank String nodeId,
                                      @Parameter(description = "The identifier of a node.")
                                      @RequestParam(name = "autoRename", defaultValue = "false") Boolean autoRename,
                                      @Parameter(description = "Returns additional information about the node. The following optional fields can be requested:\n" +
                                              "\n" +
                                              "allowableOperations\n" +
                                              "association\n" +
                                              "isLink\n" +
                                              "isFavorite\n" +
                                              "isLocked\n" +
                                              "path\n" +
                                              "permissions")
                                      @RequestParam(name = "include", defaultValue = "path") @NotBlank String include,
                                      @RequestBody @NonNull NodeBodyCreateModel nodeBodyCreate) {
        logNodeController.info("Create a node: "
                + "\nnodeId = " + nodeId
                + "\nautoRename = " + autoRename
                + "\ninclude = " + include
        );
        return nodeService.createNode(nodeId, autoRename, include, nodeBodyCreate);
    }

    /**
     * @author Oleksandr Bogush
     * @version 1.0
     * @since 29.12.20
     */
    @Operation(
            summary = "Create a list nodes like tree and add as a primary child of node nodeId.",
            description = "Create a node and add it as a primary child of node nodeId.\n" +
                    "\n" +
                    "{\n" +
                    "  \"name\":\"My text file.txt\",\n" +
                    "  \"nodeType\":\"cm:content\"\n" +
                    "}\n" +
                    "You can create a folder, or other node, inside a folder hierarchy:\n" +
                    "\n" +
                    "{\n" +
                    "  \"name\":\"My Special Folder\",\n" +
                    "  \"nodeType\":\"cm:folder\",\n" +
                    "  \"relativePath\":\"X/Y/Z\"\n" +
                    "}\n" +
                    "\n" +
                    "You can also optionally disable (or enable) inherited permissions via isInheritanceEnabled flag:\n" +
                    "\n" +
                    "{\n" +
                    "  \"permissions\":\n" +
                    "    {\n" +
                    "      \"isInheritanceEnabled\": false,\n" +
                    "      \"locallySet\":\n" +
                    "        [\n" +
                    "          {\"authorityId\": \"GROUP_special\", \"name\": \"Read\", \"accessStatus\":\"DENIED\"},\n" +
                    "          {\"authorityId\": \"testuser\", \"name\": \"Contributor\", \"accessStatus\":\"ALLOWED\"}\n" +
                    "        ]\n" +
                    "    }\n" +
                    "}\n" +
                    "Typically, for files and folders, the primary children are created within the parent folder using the default \"cm:contains\" assocType. If the content model allows then it is also possible to create primary children with a different assoc type. For example:\n" +
                    "\n" +
                    "{\n" +
                    "  \"name\":\"My Node\",\n" +
                    "  \"nodeType\":\"my:specialNodeType\",\n" +
                    "  \"association\":\n" +
                    "  {\n" +
                    "    \"assocType\":\"my:specialAssocType\"\n" +
                    "  }\n" +
                    "}\n" +
                    "Additional associations can be added after creating a node. You can also add associations at the time the node is created. This is required, for example, if the content model specifies that a node has mandatory associations to one or more existing nodes. You can optionally specify an array of secondaryChildren to create one or more secondary child associations, such that the newly created node acts as a parent node. You can optionally specify an array of targets to create one or more peer associations such that the newly created node acts as a source node. For example, to associate one or more secondary children at time of creation:\n" +
                    "\n" +
                    "{\n" +
                    "  \"name\":\"My Folder\",\n" +
                    "  \"nodeType\":\"cm:folder\",\n" +
                    "  \"secondaryChildren\":\n" +
                    "    [ {\"childId\":\"abcde-01234-...\", \"assocType\":\"my:specialChildAssocType\"} ]\n" +
                    "}\n" +
                    "For example, to associate one or more targets at time of creation:\n" +
                    "\n" +
                    "{\n" +
                    "  \"name\":\"My Folder\",\n" +
                    "  \"nodeType\":\"cm:folder\",\n" +
                    "  \"targets\":\n" +
                    "    [ {\"targetId\":\"abcde-01234-...\", \"assocType\":\"my:specialPeerAssocType\"} ]\n" +
                    "}\n" +
                    "Note: You can create more than one child by specifying a list of nodes in the JSON body. For example, the following JSON body creates two folders inside the specified nodeId, if the nodeId identifies a folder:\n" +
                    "\n" +
                    "[\n" +
                    "  {\n" +
                    "    \"name\":\"My Folder 1\",\n" +
                    "    \"nodeType\":\"cm:folder\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\":\"My Folder 2\",\n" +
                    "    \"nodeType\":\"cm:folder\"\n" +
                    "  }\n" +
                    "]\n" +
                    "If you specify a list as input, then a paginated list rather than an entry is returned in the response body. For example:\n" +
                    "\n" +
                    "{\n" +
                    "  \"list\": {\n" +
                    "    \"pagination\": {\n" +
                    "      \"count\": 2,\n" +
                    "      \"hasMoreItems\": false,\n" +
                    "      \"totalItems\": 2,\n" +
                    "      \"skipCount\": 0,\n" +
                    "      \"maxItems\": 100\n" +
                    "    },\n" +
                    "    \"entries\": [\n" +
                    "      {\n" +
                    "        \"entry\": {\n" +
                    "          ...\n" +
                    "        }\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"entry\": {\n" +
                    "          ...\n" +
                    "        }\n" +
                    "      }\n" +
                    "    ]\n" +
                    "  }\n" +
                    "}",
            tags = {"node"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successful response",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = NodeModel.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid parameter: nodeId is not a valid format or nodeBodyCreate is invalid",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "401", description = "Authentication failed",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "403", description = "Current user does not have permission to create children of nodeId",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "404", description = "nodeId or renditionId does not exist",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "409", description = "New name clashes with an existing node in the current parent folder",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "413", description = "Content exceeds individual file size limit configured for the network or system",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "415", description = "Content Type is not supported",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "422", description = "Model integrity exception including a file name containing invalid characters",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "507", description = "Content exceeds overall storage quota limit configured for the network or system",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))})
    })
    @PostMapping(path = "/nodelist", produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<NodeModel> createListNode(@Parameter(description = "The identifier of a node. You can also use one of these well-known aliases:\n" +
            "\n" +
            "-my-\n" +
            "-shared-\n" +
            "-root-")
                                          @RequestParam(name = "nodeId") @NotBlank String nodeId,
                                          @Parameter(description = "The identifier of a node.")
                                          @RequestParam(name = "autoRename", defaultValue = "false") Boolean autoRename,
                                          @Parameter(description = "Returns additional information about the node. The following optional fields can be requested:\n" +
                                                  "\n" +
                                                  "allowableOperations\n" +
                                                  "association\n" +
                                                  "isLink\n" +
                                                  "isFavorite\n" +
                                                  "isLocked\n" +
                                                  "path\n" +
                                                  "permissions")
                                          @RequestParam(name = "include", defaultValue = "path") @NotBlank String include,
                                          @RequestBody @NonNull List<NodeBodyCreateModel> nodeBodyCreate) {
        logNodeController.info("Create a node: "
                + "\nnodeId = " + nodeId
                + "\nautoRename = " + autoRename
                + "\ninclude = " + include
        );
        return nodeService.createNodeFromList(nodeId, autoRename, include, nodeBodyCreate);
    }

    /**
     * @author Oleksandr Bogush
     * @version 1.0
     * @since 23.12.20
     */
    @Operation(
            summary = "Copy a node",
            description = "Copies the node nodeId to the parent folder node targetParentId. You specify the targetParentId in the request body.\n" +
                    "\n" +
                    "The new node has the same name as the source node unless you specify a new name in the request body.\n" +
                    "\n" +
                    "If the source nodeId is a folder, then all of its children are also copied.\n" +
                    "\n" +
                    "If the source nodeId is a file, it's properties, aspects and tags are copied, it's ratings, comments and locks are not.",
            tags = {"node"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successful response",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = NodeModel.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid parameter: nodeId is not a valid format or nodeBodyCopy is invalid",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "401", description = "Authentication failed",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "403", description = "Current user does not have permission to copy nodeId",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "404", description = "nodeId does not exist",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "409", description = "New name clashes with an existing node in the destination parent folder",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "422", description = "Model integrity exception including a file name containing invalid characters",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))})
    })
    @PostMapping(path = "/node/copy", produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<NodeModel> copyNode(@Parameter(description = "The identifier of a node.")
                                    @RequestParam(name = "nodeId") @NotBlank String nodeId,
                                    @Parameter(description = "Returns additional information about the node. The following optional fields can be requested:\n" +
                                            "\n" +
                                            "allowableOperations\n" +
                                            "association\n" +
                                            "isLink\n" +
                                            "isFavorite\n" +
                                            "isLocked\n" +
                                            "path\n" +
                                            "permissions")
                                    @RequestParam(name = "include", defaultValue = "path") @NotBlank String include,
                                    @RequestBody @NonNull NodeCopyModel nodeBodyCopy) {
        logNodeController.info("Copy a node: "
                + "\nnodeId = " + nodeId
                + "\ninclude = " + include
        );
        return nodeService.copyNode(nodeId, include, nodeBodyCopy);
    }

    /**
     * @author Oleksandr Bogush
     * @version 1.0
     * @since 23.12.20
     */
    @Operation(
            summary = "Move a node",
            description = "Move the node nodeId to the parent folder node targetParentId.\n" +
                    "\n" +
                    "The targetParentId is specified in the in request body.\n" +
                    "\n" +
                    "The moved node retains its name unless you specify a new name in the request body.\n" +
                    "\n" +
                    "If the source nodeId is a folder, then its children are also moved.\n" +
                    "\n" +
                    "The move will effectively change the primary parent.",
            tags = {"node"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successful response",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = NodeModel.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid parameter: nodeId is not a valid format or nodeBodyCopy is invalid",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "401", description = "Authentication failed",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "403", description = "Current user does not have permission to copy nodeId",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "404", description = "nodeId does not exist",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "409", description = "New name clashes with an existing node in the destination parent folder",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "422", description = "Model integrity exception including a file name containing invalid characters",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))})
    })
    @PostMapping(path = "/node/move", produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<NodeModel> moveNode(@Parameter(description = "The identifier of a node.")
                                    @RequestParam(name = "nodeId") @NotBlank String nodeId,
                                    @Parameter(description = "Returns additional information about the node. The following optional fields can be requested:\n" +
                                            "\n" +
                                            "allowableOperations\n" +
                                            "association\n" +
                                            "isLink\n" +
                                            "isFavorite\n" +
                                            "isLocked\n" +
                                            "path\n" +
                                            "permissions")
                                    @RequestParam(name = "include", defaultValue = "path") @NotBlank String include,
                                    @RequestBody @NonNull NodeCopyModel nodeBodyMove) {
        logNodeController.info("Copy a node: "
                + "\nnodeId = " + nodeId
                + "\ninclude = " + include
        );
        return nodeService.moveNode(nodeId, include, nodeBodyMove);
    }

    /**
     * @author Oleksandr Bogush
     * @version 1.0
     * @since 23.12.20
     */
    @Operation(
            summary = "Create a secondary child association, with the given association type, between the parent nodeId and a child node.",
            description = "Note: You can create more than one secondary child association by specifying a list of associations in the JSON body like this:\n" +
                    "\n" +
                    "[\n" +
                    "  {\n" +
                    "    \"childId\": \"string\",\n" +
                    "    \"assocType\": \"string\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"childId\": \"string\",\n" +
                    "    \"assocType\": \"string\"\n" +
                    "  }\n" +
                    "]\n" +
                    "If you specify a list as input, then a paginated list rather than an entry is returned in the response body. For example:\n" +
                    "\n" +
                    "{\n" +
                    "  \"list\": {\n" +
                    "    \"pagination\": {\n" +
                    "      \"count\": 2,\n" +
                    "      \"hasMoreItems\": false,\n" +
                    "      \"totalItems\": 2,\n" +
                    "      \"skipCount\": 0,\n" +
                    "      \"maxItems\": 100\n" +
                    "    },\n" +
                    "    \"entries\": [\n" +
                    "      {\n" +
                    "        \"entry\": {\n" +
                    "          ...\n" +
                    "        }\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"entry\": {\n" +
                    "          ...\n" +
                    "        }\n" +
                    "      }\n" +
                    "    ]\n" +
                    "  }\n" +
                    "}",
            tags = {"node"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successful response",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = CreateSecondaryChildResponseModel.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid parameter: assocType is unknown, or the nodeId is not a valid format, or secondaryChildAssociationBodyCreate invalid",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "401", description = "Authentication failed",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "403", description = "Current user does not have permission to create secondary children of nodeId",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "404", description = "Parent nodeId or childId does not exist",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "409", description = "An association of this assoc type already exists between these two nodes",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "422", description = "Model integrity exception",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))})
    })
    @PostMapping(path = "/node/secondary-children", produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<CreateSecondaryChildResponseModel> createSecondaryChild(@Parameter(description = "The identifier of a parent node.")
                                                                        @RequestParam(name = "nodeId") @NotBlank String nodeId,
                                                                        @RequestBody @NonNull CreateSecondaryChildModel secondaryChildAssociationBodyCreate) {
        logNodeController.info("createSecondaryChild: " + "\nnodeId = " + nodeId);
        return nodeService.createSecondaryChild(nodeId, secondaryChildAssociationBodyCreate);
    }

    /**
     * @author Oleksandr Bogush
     * @version 1.0
     * @since 23.12.20
     */
    @Operation(
            summary = "Delete secondary child or children",
            description = "Delete secondary child associations between the parent nodeId and child nodes for the given association type.\n" +
                    "\n" +
                    "If the association type is not specified, then all secondary child associations, of any type in the direction from parent to secondary child, will be deleted. The child will still have a primary parent and may still be associated as a secondary child with other secondary parents.",
            tags = {"node"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Successful operation"),
            @ApiResponse(responseCode = "400", description = "Invalid parameter: assocType is unknown or you are trying to delete a primary assocType. Use delete node instead",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "401", description = "Authentication failed",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "403", description = "Current user does not have permission for nodeId",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "404", description = "Parent nodeId or childId does not exist (with given assocType, if specified)",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))})

    })
    @DeleteMapping(path = "/node/secondary-children", produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteSecondaryChildOrChildrenNode(@Parameter(description = "The identifier of a parent node.")
                                                         @RequestParam(name = "nodeId") @NotBlank String nodeId,
                                                         @Parameter(description = "The identifier of a child node.")
                                                         @RequestParam(name = "childId") @NotBlank String childId) {
        logNodeController.info("delete the node: "
                + "\nnodeId = " + nodeId
                + "\nchildId = " + childId);
        return nodeService.deleteSecondaryChildOrChildren(nodeId, childId);
    }

}
