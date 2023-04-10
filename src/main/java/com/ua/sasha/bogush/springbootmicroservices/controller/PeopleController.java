package com.ua.sasha.bogush.springbootmicroservices.controller;

import com.ua.sasha.bogush.springbootmicroservices.model.error.UnexpectedErrorModel;
import com.ua.sasha.bogush.springbootmicroservices.model.people.PeopleModel;
import com.ua.sasha.bogush.springbootmicroservices.model.people.PersonRequestModel;
import com.ua.sasha.bogush.springbootmicroservices.service.people.PeopleServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.util.annotation.NonNull;

/**
 * @author Oleksandr Bogush
 * @version 1.0
 * @since 09.12.2020
 */
@Tag(name = "people", description = "Retrieve and manage people")
@RestController
@RequestMapping("/api")
public class PeopleController {
    private static final Logger logPeopleController = LoggerFactory.getLogger(PeopleController.class);

    private final PeopleServiceImpl people;

    public PeopleController(PeopleServiceImpl people) {
        this.people = people;
    }

    /**
     * @author Oleksandr Bogush
     * @version 1.0
     * @since 22.12.2020
     */
    @Operation(
            summary = "Get list people",
            description = "Search all people and return. The default sort order for the returned list is for people to be sorted by ascending id",
            tags = {"people"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = PeopleModel.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid parameter: value of maxItems, skipCount or orderBy is invalid",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "401", description = "Authentication failed",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))})
    })
    @GetMapping(path = "/people/list", produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    public Mono<PeopleModel> getPeople(@Parameter(description = "The number of entities that exist in the collection before those included in this list. If not supplied then the default value is 0.")
                                       @RequestParam(name = "skipCount", defaultValue = "0")
                                       @Min(value = 0, message = "Age should not be less than 0") @NotNull Integer skipCount,
                                       @Parameter(description = "The maximum number of items to return in the list. If not supplied then the default value is 100.")
                                       @RequestParam(name = "maxItems", defaultValue = "100")
                                       @Min(value = 1, message = "Age should not be less than 1") @NotNull Integer maxItems,
                                       @Parameter(description = "A string to control the order of the entities returned in a list. You can use the orderBy parameter to sort the list by one or more fields.\n" +
                                               "\n" +
                                               "Each field has a default sort order, which is normally ascending order. Read the API method implementation notes above to check if any fields used in this method have a descending default search order.\n" +
                                               "\n" +
                                               "To sort the entities in a specific order, you can use the ASC and DESC keywords for any field." + "\nfields to order the results:\n" +
                                               "\n" +
                                               "id\n" +
                                               "firstName\n" +
                                               "lastName")
                                       @RequestParam(name = "orderBy", defaultValue = "id") @NotNull String orderBy,
                                       @Parameter(description = "Returns additional information about the person. The following optional fields can be requested:\n" +
                                               "\n" +
                                               "properties\n" +
                                               "aspectNames\n" +
                                               "capabilities")
                                       @RequestParam(name = "include") @NotNull String include,
                                       @Parameter(description = "A list of field names.\n" +
                                               "\n" +
                                               "You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.\n" +
                                               "\n" +
                                               "The list applies to a returned individual entity or entries within a collection.\n" +
                                               "\n" +
                                               "If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.")
                                       @RequestParam(name = "fields") @NotNull String fields) {
        logPeopleController.info("GetListPeople people where parameters:\n"
                + "skipCount " + skipCount + "\n"
                + "maxItems " + maxItems + "\n"
                + "orderBy " + orderBy + "\n"
                + "include " + include + "\n"
                + "fields " + fields + "\n"
        );
        return people.getListPeople(skipCount, maxItems, orderBy, include, fields);
    }

    /**
     * @author Oleksandr Bogush
     * @version 1.0
     * @since 18.12.2020
     */
    @Operation(
            summary = "Get list people",
            description = "Search all people and return. The default sort order for the returned list is for people to be sorted by ascending id",
            tags = {"people"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = PeopleModel.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid parameter: value of maxItems, skipCount or orderBy is invalid",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "401", description = "Authentication failed",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))})
    })
    @GetMapping(path = "/people/one", produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    public Mono<PeopleModel> getPeopleOne(@Parameter(description = "The maxItems.")
                                          @RequestParam(name = "maxItems", defaultValue = "100")
                                          @NotBlank(message = "defaultValue = \"100\"")
                                          @Min(value = 1, message = "Age should not be less than 1") Integer maxItems,
                                          @Parameter(description = "fields to order the results:\n" +
                                                  "\n" +
                                                  "id\n" +
                                                  "firstName\n" +
                                                  "lastName")
                                          @RequestParam(name = "orderByOne", defaultValue = "id")
                                          @NotBlank @Size(min = 2, message = "orderBy must be min 2 chars") String orderByOne) {
        logPeopleController.info("GetListPeople people where parameters:" +
                " \"maxItems\" = " + maxItems +
                " and \"orderByOne\" = " + orderByOne);
        return people.getListPeople(maxItems, orderByOne);
    }

    /**
     * @author Oleksandr Bogush
     * @version 1.0
     * @since 21.12.2020
     */
    @Operation(
            summary = "Get list people",
            description = "Search all people and return. The default sort order for the returned list is for people to be sorted by ascending id",
            tags = {"people"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = PeopleModel.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid parameter: value of maxItems, skipCount or orderBy is invalid",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "401", description = "Authentication failed",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))})
    })
    @GetMapping(path = "/people/two", produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    public Mono<PeopleModel> getPeopleTwo(@Parameter(description = "The maxItems.")
                                          @RequestParam(name = "maxItems", defaultValue = "100")
                                          @NotBlank(message = "defaultValue = \"100\"")
                                          @Min(value = 1, message = "Age should not be less than 1") Integer maxItems,
                                          @Parameter(description = "fields to order the results:\n" +
                                                  "\n" +
                                                  "id\n" +
                                                  "firstName\n" +
                                                  "lastName")
                                          @RequestParam(name = "orderByOne", defaultValue = "firstName")
                                          @NotBlank @Size(min = 2, message = "orderBy must be min 2 chars") String orderByOne,
                                          @Parameter(description = "fields to order the results:\n" +
                                                  "\n" +
                                                  "id\n" +
                                                  "firstName\n" +
                                                  "lastName")
                                          @RequestParam(name = "orderByTwo", defaultValue = "lastName")
                                          @NotBlank @Size(min = 2, message = "orderBy must be min 2 chars") String orderByTwo) {
        logPeopleController.info(
                "GetListPeople people where parameters:" +
                        " \"maxItems\" = " + maxItems +
                        " and \"orderByOne\" = " + orderByOne +
                        " and \"orderByTwo\" = " + orderByTwo
        );
        return people.getListPeople(maxItems, orderByOne, orderByTwo);
    }

    /**
     * @author Oleksandr Bogush
     * @version 1.0
     * @since 21.12.2020
     */
    @Operation(
            summary = "Get list people",
            description = "Search all people and return. The default sort order for the returned list is for people to be sorted by ascending id",
            tags = {"people"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = PeopleModel.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid parameter: value of maxItems, skipCount or orderBy is invalid",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "401", description = "Authentication failed",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))})
    })
    @GetMapping(path = "/people/three", produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    public Mono<PeopleModel> getPeopleThree(@Parameter(description = "The maxItems.")
                                            @RequestParam(name = "maxItems", defaultValue = "100")
                                            @NotBlank(message = "defaultValue = \"100\"")
                                            @Min(value = 1, message = "Age should not be less than 1") Integer maxItems,
                                            @Parameter(description = "fields to order the results:\n" +
                                                    "\n" +
                                                    "id\n" +
                                                    "firstName\n" +
                                                    "lastName")
                                            @RequestParam(name = "orderByOne", defaultValue = "id")
                                            @NotBlank @Size(min = 2, message = "orderBy must be min 2 chars") String orderByOne,
                                            @Parameter(description = "fields to order the results:\n" +
                                                    "\n" +
                                                    "id\n" +
                                                    "firstName\n" +
                                                    "lastName")
                                            @RequestParam(name = "orderByTwo", defaultValue = "firstName")
                                            @NotBlank @Size(min = 2, message = "orderBy must be min 2 chars") String orderByTwo,
                                            @Parameter(description = "fields to order the results:\n" +
                                                    "\n" +
                                                    "id\n" +
                                                    "firstName\n" +
                                                    "lastName")
                                            @RequestParam(name = "orderByThree", defaultValue = "lastName")
                                            @NotBlank @Size(min = 2, message = "orderBy must be min 2 chars") String orderByThree) {
        logPeopleController.info(
                "GetListPeople people where parameters:" +
                        " \"maxItems\" = " + maxItems +
                        " and \"orderByOne\" = " + orderByOne +
                        " and \"orderByTwo\" = " + orderByTwo +
                        " and \"orderByThree\" = " + orderByThree
        );
        return people.getListPeople(maxItems, orderByOne, orderByTwo, orderByThree);
    }

    /**
     * @author Oleksandr Bogush
     * @version 1.0
     * @since 18.12.2020
     */
    @Operation(
            summary = "Gets information for the person on personId",
            description = "You can use the \"-me-\" string in place of <name> to specify the currently authenticated user.",
            tags = {"person"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = PeopleModel.class))}),
            @ApiResponse(responseCode = "401", description = "Authentication failed",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "404", description = "PersonId does not exist",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))})
    })
    @GetMapping(path = "/person", produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    public Mono<PeopleModel> getPerson(@Parameter(description = "The identifier of a person.")
                                       @RequestParam(name = "personId", defaultValue = "-me-")
                                       @NotBlank @Size(min = 4, message = "personId must be min 4 chars") String personId) {
        logPeopleController.info("Get Person where parameters \"personId\" = " + personId);
        return people.getPerson(personId);
    }

    /**
     * @author Oleksandr Bogush
     * @version 1.0
     * @since 18.12.2020
     */
    @Operation(
            summary = "Create a person.",
            description = "You must have admin rights to create a person. Note: setting properties of type d:content and d:category are not supported.",
            tags = {"person"})

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Person created",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = PeopleModel.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid parameter: personBodyCreate is invalid",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "401", description = "Authentication failed",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "403", description = "Current user does not have permission to create a person",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "409", description = "Person within given id already exists",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "422", description = "Model integrity exception",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
    })
    @PostMapping(path = "/person", produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<PeopleModel> createPerson(@RequestBody @NonNull PersonRequestModel person) {
        logPeopleController.info("createPerson");
        return people.createPerson(person);
    }

    /**
     * @author Oleksandr Bogush
     * @version 1.0
     * @since 21.12.20
     */
    @Operation(
            summary = "Update the given personBodyUpdate's details.",
            description = "You can use the -me- string in place of <personid> to specify the currently authenticated user.\n" +
                    "\n" +
                    "If applicable, the given personBodyUpdate's login access can also be optionally disabled or re-enabled.\n" +
                    "\n" +
                    "You must have admin rights to update a personBodyUpdate — unless updating your own details.\n" +
                    "\n" +
                    "If you are changing your password, as a non-admin user, then the existing password must also be supplied (using the oldPassword field in addition to the new password value).\n" +
                    "\n" +
                    "Admin users cannot be disabled by setting enabled to false.\n" +
                    "\n" +
                    "Non-admin users may not disable themselves.",
            tags = {"person"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Person created",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = PeopleModel.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid parameter: the update request is invalid or personId is not a valid format or personBodyUpdate is invalid",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "401", description = "Authentication failed",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "403", description = "Current user does not have permission to update a personBodyUpdate",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "404", description = "personId does not exist",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))}),
            @ApiResponse(responseCode = "422", description = "Model integrity exception",
                    content = {@Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UnexpectedErrorModel.class))})
    })
    @PutMapping(path = "/person", produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    public Mono<PeopleModel> updatePerson(@RequestBody @NonNull PersonRequestModel personBodyUpdate,
                                          @Parameter(description = "The identifier of a personBodyUpdate.")
                                          @RequestParam(name = "personId")
                                          @NotBlank @Size(min = 4, message = "personId must be min 4 chars") String personId) {
        logPeopleController.info("Update people where \"people\" = " + personId);
        return people.updatePerson(personBodyUpdate, personId);
    }

    /**
     * @author Oleksandr Bogush
     * @version 1.0
     * @since 21.12.20
     */
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
    @DeleteMapping(path = "/person", produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deletePerson(@Parameter(description = "The identifier of a person.")
                                   @RequestParam(name = "personId")
                                   @NotBlank @Size(min = 4, message = "personId must be more than 4 chars") String personId) {
        logPeopleController.info("Delete people where \"people\" = " + personId);
        return people.deletePerson(personId);
    }
}
