package com.ua.sasha.bogush.springbootmicrocervices.controller;

import com.ua.sasha.bogush.springbootmicrocervices.model.modelgroup.Groupe;
import com.ua.sasha.bogush.springbootmicrocervices.service.servicegroup.ServiceGroupImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.util.annotation.NonNull;

import javax.validation.constraints.NotEmpty;

/**
 * @author Bogush Aleksandr
 * @version 1.0
 * @since 15-11-2020
 */

@Tag(name = "group", description = "Group CRUD operation ")
@RestController
@RequestMapping(path = "/api/group")
public class ControllerGroup {
    private final ServiceGroupImpl groupClient;

    public ControllerGroup(ServiceGroupImpl groupClient) {
        this.groupClient = groupClient;
    }

    @Operation(
            summary = "Get all groups",
            description = "Search all groups and return",
            tags = {"group"})
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "successful operation",
                    content = @Content(schema = @Schema(implementation = Groupe.class))
            )
    })
    @GetMapping(produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    private Mono<Groupe> getGroups() {
        return groupClient.getAllGroups();
    }

    @Operation(
            summary = "Get group on name",
            description = "Search group and return",
            tags = {"group"})
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "successful operation",
                    content = @Content(schema = @Schema(implementation = Groupe.class))
            )
    })
    @GetMapping(path = "/{name}", produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    private Mono<Groupe> getGroup(
            @Parameter(description = "Name group must be short or full name.") @NotEmpty @PathVariable("name") String name) {
        return groupClient.getSingleGroup(name);
    }

    @Operation(
            summary = "Add a new Group",
            description = "Create Group. \"JSON must be only \"{}\"",
            tags = {"group"})
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Group created",
                    content = @Content(schema = @Schema(implementation = Groupe.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "Group already exists")})
    @PostMapping(path = "/{name}", produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    private Mono<Groupe> createGroupe(
            @RequestBody @NonNull Groupe groupe,
            @Parameter(description = "Name group must be short without => \"GROUP_\".") @PathVariable("name") @NotEmpty String name) {
        return groupClient.createGroupe(name, groupe);
    }

    @Operation(
            summary = "Update an existing Group",
            description = "Update details (displayName) for group groupId. You must have admin rights to update a group",
            tags = {"group"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "400", description = "Invalid parameter: groupId or groupBodyCreate is invalid"),
            @ApiResponse(responseCode = "401", description = "Authentication failed"),
            @ApiResponse(responseCode = "403", description = "User does not have permission to update a group"),
            @ApiResponse(responseCode = "404", description = "groupId does not exist"),
            @ApiResponse(responseCode = "409", description = "Trying to modify a pre-defined system group, such as GROUP_EVERYONE")})
    @PutMapping(path = "/{name}", produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    private Mono<Groupe> updateGroupe(
            @RequestBody @NonNull Groupe groupe,
            @Parameter(description = "The identifier of a group.") @PathVariable("name") @NotEmpty String name) {
        return groupClient.updateGroupe(name, groupe);
    }

    @Operation(summary = "Delete a group", description = "Delete a group on a name group", tags = {"group"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "Group not found")})
    @DeleteMapping(path = "/{name}", produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    private Mono<Groupe> deleteGroupe(
            @Parameter(description = "The name group cannot be empty.") @PathVariable("name") @NotEmpty String name) {
        return groupClient.deleteGroupe(name);
    }
}
