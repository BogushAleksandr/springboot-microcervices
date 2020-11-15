package com.ua.sasha.bogush.springbootmicrocervices.controller;

import com.ua.sasha.bogush.springbootmicrocervices.model.modelnode.Entry;
import com.ua.sasha.bogush.springbootmicrocervices.model.modelnode.Permissions;
import com.ua.sasha.bogush.springbootmicrocervices.service.servicenode.ServiceNodeImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.util.annotation.NonNull;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author Bogush Aleksandr
 * @version 1.0
 * @since 15-11-2020
 */

@Tag(name = "node", description = "Node CRUD operation ")
@RestController
@RequestMapping("/api")
public class ControllerNode {
    private final ServiceNodeImpl nodeClient;

    public ControllerNode(ServiceNodeImpl nodeClient) {
        this.nodeClient = nodeClient;
    }

    @Operation(
            summary = "Get information for node nodeId.",
            description = "The identifier of a node. You can also use one of these well-known aliases:\n" +
                    "\n" +
                    "-my-\n" +
                    "-shared-\n" +
                    "-root-",
            tags = {"node"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "400", description = "Invalid parameter: nodeId is not a valid format"),
            @ApiResponse(responseCode = "401", description = "Authentication failed"),
            @ApiResponse(responseCode = "403", description = "Current user does not have permission to retrieve nodeId"),
            @ApiResponse(responseCode = "404", description = "nodeId does not exist")
    })
    @GetMapping(path = "/node/{nodeid}", produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    private Mono<Entry> getNode(
            @Parameter(description = "The identifier of a node.") @PathVariable("nodeid") @NotEmpty String nodeid) {
        return nodeClient.getNodeOnNodesId(nodeid);
    }

    @Operation(
            summary = "Updates the node on nodeId.",
            description = "For example, you can rename a file or folder."
                    + "\n" +
                    "You can also set or update one or more properties."
                    + "\n" +
                    "Note: setting properties of type d:content and d:category are not supported."
                    + "\n" +
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
                    "}"
                    + "\n" +
                    "Note: if you want to add or remove locally set permissions then you must use GET /nodes/{nodeId} first to get the complete set of locallySet permissions."
                    + "\n" +
                    "Note: Currently there is no optimistic locking for updates, so they are applied in \"last one wins\" order.",
            tags = {"node"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "400", description = "Invalid parameter: the update request is invalid or nodeId is not a valid format or nodeBodyUpdate is invalid"),
            @ApiResponse(responseCode = "401", description = "Authentication failed"),
            @ApiResponse(responseCode = "403", description = "Current user does not have permission to update nodeId"),
            @ApiResponse(responseCode = "404", description = "nodeId does not exist"),
            @ApiResponse(responseCode = "409", description = "Updated name clashes with an existing node in the current parent folder"),
            @ApiResponse(responseCode = "422", description = "Model integrity exception including a file name containing invalid characters")
    })
    @PutMapping(path = "/node/{nodeid}", produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    private Mono<Entry> setPermissions(
            @Parameter(description = "The identifier of a node.") @PathVariable("nodeid") @NotEmpty String nodeid,
            @RequestBody @NonNull Permissions permission) {
        return nodeClient.setPermissionsOnNodesId(nodeid, permission);
    }

    @Operation(
            summary = "Create a node and add it as a primary child of node nodeId.",
            description = "You must specify at least a name and nodeType. For example, to create a folder:\n" +
                    "\n" +
                    "{\n" +
                    "  \"name\":\"My Folder\",\n" +
                    "  \"nodeType\":\"cm:folder\"\n" +
                    "}\n"
                    + "\n" +
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
                    "}\n"
                    + "You can create a folder, or other node, inside a folder hierarchy:\n" +
                    "\n" +
                    "{\n" +
                    "  \"name\":\"My Special Folder\",\n" +
                    "  \"nodeType\":\"cm:folder\",\n" +
                    "  \"relativePath\":\"X/Y/Z\"\n" +
                    "}\n"
                    + "The relativePath specifies the folder structure to create relative to the node nodeId. Folders in the relativePath that do not exist are created before the node is created.",
            tags = {"node"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "successful operation"),
            @ApiResponse(responseCode = "400", description = "Invalid parameter: nodeId is not a valid format or nodeBodyCreate is invalid"),
            @ApiResponse(responseCode = "401", description = "Authentication failed"),
            @ApiResponse(responseCode = "403", description = "Current user does not have permission to create children of nodeId"),
            @ApiResponse(responseCode = "404", description = "nodeId does not exist"),
            @ApiResponse(responseCode = "409", description = "New name clashes with an existing node in the current parent folder"),
            @ApiResponse(responseCode = "413", description = "Content exceeds individual file size limit configured for the network or system"),
            @ApiResponse(responseCode = "415", description = "Content Type is not supported"),
            @ApiResponse(responseCode = "422", description = "Model integrity exception including a file name containing invalid characters"),
            @ApiResponse(responseCode = "507", description = "Content exceeds overall storage quota limit configured for the network or system")
    })
    @PostMapping(path = "/node/{nodeid}", produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    private Mono<Entry> createNode(
            @Parameter(description = "The identifier of a node.") @PathVariable("nodeid") String nodeid,
            @RequestBody @NonNull Entry entry) {
        return nodeClient.createNodeOnNodesIds(nodeid, entry);
    }

    @Operation(
            summary = "Create a list nodes like tree and add as a primary child of node nodeId.",
            description = "Note: You can create more than one child by specifying a list of nodes in the JSON body. For example, the following JSON body creates two folders inside the specified nodeId, if the nodeId identifies a folder:\n" +
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
                    "]\n",
            tags = {"node"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "successful operation"),
            @ApiResponse(responseCode = "400", description = "Invalid parameter: nodeId is not a valid format or nodeBodyCreate is invalid"),
            @ApiResponse(responseCode = "401", description = "Authentication failed"),
            @ApiResponse(responseCode = "403", description = "Current user does not have permission to create children of nodeId"),
            @ApiResponse(responseCode = "404", description = "nodeId does not exist"),
            @ApiResponse(responseCode = "409", description = "New name clashes with an existing node in the current parent folder"),
            @ApiResponse(responseCode = "413", description = "Content exceeds individual file size limit configured for the network or system"),
            @ApiResponse(responseCode = "415", description = "Content Type is not supported"),
            @ApiResponse(responseCode = "422", description = "Model integrity exception including a file name containing invalid characters"),
            @ApiResponse(responseCode = "507", description = "Content exceeds overall storage quota limit configured for the network or system")
    })
    @PostMapping(path = "/nodelist/{nodeid}", produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    private Mono<Entry> createListNode(
            @Parameter(description = "The identifier of a node.") @PathVariable("nodeid") @NotEmpty String nodeid,
            @RequestBody List<Entry> entryList) {
        return nodeClient.createNodeFromListOnNodesId(nodeid, entryList);
    }

    @Operation(
            summary = "Delete a node.",
            description = "If nodeId is a folder, then its children are also deleted.\n" +
                    "\n" +
                    "Deleted nodes move to the trashcan unless the permanent query parameter is true and the current user is the owner of the node or an admin.\n" +
                    "\n" +
                    "Deleting a node deletes it from its primary parent and also from any secondary parents. Peer associations are also deleted, where the deleted node is either a source or target of an association. This applies recursively to any hierarchy of primary children of the deleted node.\n" +
                    "\n" +
                    "Note: If the node is not permanently deleted, and is later successfully restored to its former primary parent, then the primary child association is restored. This applies recursively for any primary children. No other secondary child associations or peer associations are restored for any of the nodes in the primary parent-child hierarchy of restored nodes, regardless of whether the original associations were to nodes inside or outside the restored hierarchy.",
            tags = {"node"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "successful operation"),
            @ApiResponse(responseCode = "400", description = "Invalid parameter: nodeId is not a valid format"),
            @ApiResponse(responseCode = "401", description = "Authentication failed"),
            @ApiResponse(responseCode = "403", description = "Current user does not have permission to delete nodeId"),
            @ApiResponse(responseCode = "404", description = "nodeId does not exist"),
            @ApiResponse(responseCode = "409", description = "nodeId is locked and cannot be deleted")
    })
    @DeleteMapping("/node/{nodeid}")
    @ResponseStatus(HttpStatus.OK)
    private Mono<Void> deleteNode(@Parameter(description = "The identifier of a node.") @PathVariable @NotEmpty String nodeid) {
        return nodeClient.fullDelateNode(nodeid);
    }

}
