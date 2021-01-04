package com.ua.sasha.bogush.springbootmicrocervices.controller;

import com.ua.sasha.bogush.springbootmicrocervices.model.error.UnexpectedErrorModel;
import com.ua.sasha.bogush.springbootmicrocervices.model.group.Datum;
import com.ua.sasha.bogush.springbootmicrocervices.model.group.GroupBodyCreateModel;
import com.ua.sasha.bogush.springbootmicrocervices.model.group.GroupBodyUpdateModel;
import com.ua.sasha.bogush.springbootmicrocervices.model.group.GroupModel;
import com.ua.sasha.bogush.springbootmicrocervices.service.group.GroupServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.util.annotation.NonNull;

import javax.validation.constraints.NotBlank;

/**
 * @author Oleksandr Bogush
 * @version 1.0
 * @since 28.12.2020
 */
@Tag(name = "group", description = "Retrieve and manage groups")
@RestController
@RequestMapping("/api")
public class GroupController {
    private static final Logger logGroupController = LoggerFactory.getLogger(GroupController.class);
    private final GroupServiceImpl groupService;

    public GroupController(GroupServiceImpl groupService) {
        this.groupService = groupService;
    }

    /**
     * @author Oleksandr Bogush
     * @version 1.0
     * @since 28.12.2020
     */
    @Operation(
            summary = "Get all groups",
            description = "Search all groups and return",
            tags = {"group"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = GroupModel.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid parameter: value of maxItems or skipCount",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "401", description = "Authentication failed",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))})
    })
    @GetMapping(path = "/groups", produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    public Mono<GroupModel> getGroups(@Parameter(description = "The number of entities that exist in the collection before those included in this list. If not supplied then the default value is 0.")
                                      @RequestParam(name = "skipCount", defaultValue = "0") @NotBlank Integer skipCount,
                                      @Parameter(description = "The maximum number of items to return in the list. If not supplied then the default value is 100.")
                                      @RequestParam(name = "maxItems", defaultValue = "100") @NotBlank Integer maxItems) {
        logGroupController.info("List groups: "
                + "\nskipCount = " + skipCount
                + "\nmaxItems = " + maxItems);
        return groupService.getGroups(skipCount, maxItems);
    }

    /**
     * @author Oleksandr Bogush
     * @version 1.0
     * @since 28.12.2020
     */
    @Operation(
            summary = "Get all groups",
            description = "Search all groups and return",
            tags = {"group"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = GroupModel.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid parameter: value of maxItems or skipCount",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "401", description = "Authentication failed",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))})
    })
    @GetMapping(path = "/groups/children", produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    public Mono<GroupModel> getGroupsChildren(@Parameter(description = "")
                                              @RequestParam(name = "shortGroupName") @NotBlank String shortGroupName,
                                              @Parameter(description = "The number of entities that exist in the collection before those included in this list. If not supplied then the default value is 0.")
                                              @RequestParam(name = "skipCount", defaultValue = "0") @NotBlank Integer skipCount,
                                              @Parameter(description = "The maximum number of items to return in the list. If not supplied then the default value is 100.")
                                              @RequestParam(name = "maxItems", defaultValue = "100") @NotBlank Integer maxItems) {
        logGroupController.info("List groups: "
                + "\nshortGroupName = " + shortGroupName
                + "\nskipCount = " + skipCount
                + "\nmaxItems = " + maxItems
        );
        return groupService.getGroupsChildren(shortGroupName, maxItems, skipCount);
    }

    /**
     * @author Oleksandr Bogush
     * @version 1.0
     * @since 28.12.2020
     */
    @Operation(
            summary = "Get all parents groups",
            description = "Search all groups and return",
            tags = {"group"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = GroupModel.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid parameter: value of maxItems or skipCount",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "401", description = "Authentication failed",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))})
    })
    @GetMapping(path = "/groups/parents", produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    public Mono<GroupModel> getGroupsParents(@Parameter(description = "")
                                             @RequestParam(name = "shortGroupName") @NotBlank String shortGroupName,
                                             @Parameter(description = "The number of entities that exist in the collection before those included in this list. If not supplied then the default value is 0.")
                                             @RequestParam(name = "skipCount", defaultValue = "0") @NotBlank Integer skipCount,
                                             @Parameter(description = "The maximum number of items to return in the list. If not supplied then the default value is 100.")
                                             @RequestParam(name = "maxItems", defaultValue = "100") @NotBlank Integer maxItems) {
        logGroupController.info("List groups: "
                + "\nshortGroupName = " + shortGroupName
                + "\nskipCount = " + skipCount
                + "\nmaxItems = " + maxItems
        );
        return groupService.getGroupsParents(shortGroupName, maxItems, skipCount);
    }

    /**
     * @author Oleksandr Bogush
     * @version 1.0
     * @since 28.12.2020
     */
    @Operation(
            summary = "Get all groups",
            description = "Search all groups and return",
            tags = {"group"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = GroupModel.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid parameter: value of maxItems or skipCount",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "401", description = "Authentication failed",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))})
    })
    @GetMapping(path = "/groups/children/filter", produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    public Mono<GroupModel> getGroupsChildrenFilter(@Parameter(description = "")
                                                    @RequestParam(name = "shortGroupName") @NotBlank String shortGroupName,
                                                    @Parameter(description = "")
                                                    @RequestParam(name = "authorityType", defaultValue = "USER") @NotBlank String authorityType,
                                                    @Parameter(description = "The number of entities that exist in the collection before those included in this list. If not supplied then the default value is 0.")
                                                    @RequestParam(name = "skipCount", defaultValue = "0") @NotBlank Integer skipCount,
                                                    @Parameter(description = "The maximum number of items to return in the list. If not supplied then the default value is 100.")
                                                    @RequestParam(name = "maxItems", defaultValue = "100") @NotBlank Integer maxItems) {
        logGroupController.info("List groups: "
                + "\nshortGroupName = " + shortGroupName
                + "\nauthorityType = " + authorityType
                + "\nskipCount = " + skipCount
                + "\nmaxItems = " + maxItems
        );
        return groupService.getGroupsChildren(shortGroupName, authorityType, maxItems, skipCount);
    }

    /**
     * @author Oleksandr Bogush
     * @version 1.0
     * @since 28.12.2020
     */
    @Operation(
            summary = "Get group on name",
            description = "Search group and return",
            tags = {"group"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = Datum.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid parameter: invalid groupId",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "401", description = "Authentication failed",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "404", description = "groupId does not exist",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))})
    })
    @GetMapping(path = "/group", produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Datum> getGroup(@Parameter(description = "The identifier of a group.")
                                @RequestParam(name = "groupId") @NotBlank String groupId) {
        logGroupController.info("Group details: "
                + "\ngroupId = " + groupId
        );
        return groupService.getGroup(groupId);
    }

    @Operation(
            summary = "Add a new Group",
            description = "Create Group. \"JSON must be only \"{}\"",
            tags = {"group"})
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Group created",
                    content = @Content(schema = @Schema(implementation = Datum.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "409", description = "Group already exists",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))})})
    @PostMapping(path = "/group", produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Datum> createGroup(@Parameter(description = "The identifier of a group.")
                                   @RequestParam(name = "shortGroupName") @NotBlank String shortGroupName,
                                   @RequestBody @NonNull GroupBodyCreateModel groupBodyCreate) {
        return groupService.createGroup(shortGroupName, groupBodyCreate);
    }

    @Operation(
            summary = "Update an existing Group",
            description = "Update details (displayName) for group groupId. You must have admin rights to update a group",
            tags = {"group"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = Datum.class))),
            @ApiResponse(responseCode = "400", description = "Invalid parameter: groupId or groupBodyCreate is invalid",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "401", description = "Authentication failed",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "403", description = "User does not have permission to update a group",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "404", description = "groupId does not exist",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "409", description = "Trying to modify a pre-defined system group, such as GROUP_EVERYONE",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))})})
    @PutMapping(path = "/group", produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Datum> updateGroup(@Parameter(description = "The identifier of a group.")
                                   @RequestParam(name = "shortGroupName") @NotBlank String shortGroupName,
                                   @RequestBody @NonNull GroupBodyUpdateModel groupBodyUpdate) {
        return groupService.updateGroup(shortGroupName, groupBodyUpdate);
    }

    @Operation(summary = "Delete a group", description = "Delete a group on a name group", tags = {"group"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Successful operation"),
            @ApiResponse(responseCode = "404", description = "Group not found")})
    @DeleteMapping(path = "/group", produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteGroup(@Parameter(description = "The identifier of a group.")
                                  @RequestParam(name = "shortGroupName") @NotBlank String shortGroupName) {
        return groupService.deleteGroup(shortGroupName);
    }
}
