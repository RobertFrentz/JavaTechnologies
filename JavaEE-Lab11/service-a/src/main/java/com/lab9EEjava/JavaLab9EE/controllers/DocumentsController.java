package com.lab9EEjava.JavaLab9EE.controllers;

import com.lab9EEjava.JavaLab9EE.models.Document;
import com.lab9EEjava.JavaLab9EE.services.AddDocumentService;
import com.lab9EEjava.JavaLab9EE.services.DeleteDocumentService;
import com.lab9EEjava.JavaLab9EE.services.UpdateDocumentService;
import com.lab9EEjava.JavaLab9EE.services.ViewDocumentService;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.metrics.MetricRegistry;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.security.Principal;
import java.util.List;

/**
 *
 */
@Path("/documents")
@ApplicationScoped
@RolesAllowed({"admin", "author", "reviewer"})
public class DocumentsController {

    @Inject
    private AddDocumentService addDocumentService;

    @Inject
    private DeleteDocumentService deleteDocumentService;

    @Inject
    private UpdateDocumentService updateDocumentService;

    @Inject
    private ViewDocumentService viewDocumentService;

    @Inject
    private MetricRegistry metricRegistry;

    @Inject
    private JsonWebToken token;

    @Inject
    private Principal principal;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Created document", content = @Content(mediaType = "application/json")),
            @APIResponse(responseCode = "500", description = "Internal service error") })
    @Operation(summary = "Create document", description = "Create document")
    @RolesAllowed("author")
    public Document addDocument(Document document){
        addDocumentService.addDocument(document);
        return document;
    }

    @DELETE
    @Path("/{id}")
    @APIResponses(value = {
            @APIResponse(responseCode = "204", description = "Deleted document", content = @Content(mediaType = "text/html")),
            @APIResponse(responseCode = "500", description = "Internal service error") })
    @Operation(summary = "Delete document", description = "Delete document")
    @RolesAllowed({"author"})
    public Response deleteDocument(@jakarta.ws.rs.PathParam("id") int id){
        return deleteDocumentService.deleteDocument(id);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Updated document", content = @Content(mediaType = "application/json")),
            @APIResponse(responseCode = "500", description = "Internal service error") })
    @Operation(summary = "Update document", description = "Update document")
    @RolesAllowed("author")
    public Document updateDocument(Document document){
        updateDocumentService.updateDocument(document);
        return document;
    }

    @Timed(name = "durationToGetAllDocuments")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Get user specific documents", content = @Content(mediaType = "application/json")),
            @APIResponse(responseCode = "500", description = "Internal service error") })
    @Operation(summary = "Get user specific documents", description = "Get user specific documents")
    @RolesAllowed("admin")
    public List<Document> getAllDocuments(){
        metricRegistry.counter("getAllDocumentsCounter").inc();
        return viewDocumentService.getAllDocuments();
    }

    @GET
    @Path("/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Get all documents", content = @Content(mediaType = "application/json")),
            @APIResponse(responseCode = "500", description = "Internal service error") })
    @Operation(summary = "Get all documents", description = "Get all documents")
    @RolesAllowed({"author", "admin", "reviewer"})
    public List<Document> getUserDocuments(@jakarta.ws.rs.PathParam("userId") int userId){
        return viewDocumentService.getUserDocuments(userId);
    }

    @Path("/test")
    @GET
    @RolesAllowed("admin")
    public String sayHello() {
        return principal.getName() + " " + token.getGroups();
    }
}
