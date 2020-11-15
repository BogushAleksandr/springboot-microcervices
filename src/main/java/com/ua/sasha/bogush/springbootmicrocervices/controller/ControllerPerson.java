package com.ua.sasha.bogush.springbootmicrocervices.controller;

import com.ua.sasha.bogush.springbootmicrocervices.model.modelperson.PersonRequest;
import com.ua.sasha.bogush.springbootmicrocervices.model.modelperson.PersonResponse;
import com.ua.sasha.bogush.springbootmicrocervices.service.serviceperson.ServicePersonImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@Tag(name = "people", description = "Person CRUD operation ")
@RestController
@RequestMapping("/api")
public class ControllerPerson {
    private static final Logger logControllerPerson = LoggerFactory.getLogger(ControllerPerson.class);
    private final ServicePersonImpl personClient;

    public ControllerPerson(ServicePersonImpl personClient) {
        this.personClient = personClient;
    }

    @Operation(
            summary = "Get list people",
            description = "Search all people and return. The default sort order for the returned list is for people to be sorted by ascending id",
            tags = {"people"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "400", description = "Invalid parameter: value of maxItems is invalid"),
            @ApiResponse(responseCode = "401", description = "Authentication failed")
    })
    @GetMapping(path = "/peoples/{maximumItems}", produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    private Mono<PersonResponse> getAll(
            @Parameter(description = "The maximum number of items to return in the list.") @PathVariable("maximumItems") @NotEmpty int maximumItems) {
        logControllerPerson.info("Get All people where \"Items\" = " + maximumItems);
        return personClient.getPersons(maximumItems);
    }

    @Operation(
            summary = "Gets information for the person on personId",
            description = "You can use the \"-me-\" string in place of <name> to specify the currently authenticated user.",
            tags = {"person"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "401", description = "personId does not exist"),
            @ApiResponse(responseCode = "404", description = "Group already exists")
    })
    @GetMapping(path = "/people/{name}", produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    private Mono<PersonResponse> getPeople(
            @Parameter(description = "The identifier of a person.") @PathVariable("name") @NotEmpty String name) {
        logControllerPerson.info("Get people! where \"people\" = " + name);
        return personClient.getPerson(name);
    }

    @Operation(
            summary = "Create a person.",
            description = "You must have admin rights to create a person. Note: setting properties of type d:content and d:category are not supported.",
            tags = {"person"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Person created"),
            @ApiResponse(responseCode = "400", description = "Invalid parameter: personBodyCreate is invalid"),
            @ApiResponse(responseCode = "401", description = "Authentication failed"),
            @ApiResponse(responseCode = "403", description = "Current user does not have permission to create a person"),
            @ApiResponse(responseCode = "409", description = "Person within given id already exists"),
            @ApiResponse(responseCode = "422", description = "Model integrity exception")
    })
    @PostMapping(path = "/people", produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    private Mono<PersonResponse> createPerson(@RequestBody @NonNull PersonRequest person) {
        return personClient.createPerson(person);
    }

    @Operation(
            summary = "Update the given person's details.",
            description = "You can use the -me- string in place of <personid> to specify the currently authenticated user.\n" +
                    "\n" +
                    "If applicable, the given person's login access can also be optionally disabled or re-enabled.\n" +
                    "\n" +
                    "You must have admin rights to update a person — unless updating your own details.\n" +
                    "\n" +
                    "If you are changing your password, as a non-admin user, then the existing password must also be supplied (using the oldPassword field in addition to the new password value).\n" +
                    "\n" +
                    "Admin users cannot be disabled by setting enabled to false.\n" +
                    "\n" +
                    "Non-admin users may not disable themselves.",
            tags = {"person"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Person created"),
            @ApiResponse(responseCode = "400", description = "Invalid parameter: the update request is invalid or personId is not a valid format or personBodyUpdate is invalid"),
            @ApiResponse(responseCode = "401", description = "Authentication failed"),
            @ApiResponse(responseCode = "403", description = "Current user does not have permission to update a person"),
            @ApiResponse(responseCode = "404", description = "personId does not exist"),
            @ApiResponse(responseCode = "422", description = "Model integrity exception")
    })
    @PutMapping(path = "/people/{name}", produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    private Mono<PersonResponse> updatePerson(
            @RequestBody @NonNull PersonRequest person,
            @Parameter(description = "The identifier of a person.") @PathVariable("name") @NotEmpty String name) {
        logControllerPerson.info("Update people where \"people\" = " + name + " People = \n " + person.toString());
        return personClient.updatePerson(person, name);
    }

    @Operation(
            summary = "Delete a person.",
            description = "You must be the person or have admin rights for delete a person",
            tags = {"person"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "successful operation"),
            @ApiResponse(responseCode = "401", description = "Authentication failed"),
            @ApiResponse(responseCode = "403", description = "Current user does not have permission to update a person"),
            @ApiResponse(responseCode = "404", description = "personId does not exist")
    })
    @DeleteMapping(path = "/people/{name}", produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    private Mono<Void> deletePerson(
            @Parameter(description = "The identifier of a person.") @PathVariable("name") @NotEmpty String name) {
        logControllerPerson.info("Delete people where \"people\" = " + name);
        return personClient.deletePerson(name);
    }
}
