package com.lab9EEjava.JavaLab9EE.controllers;

import com.lab9EEjava.JavaLab9EE.models.Document;
import com.lab9EEjava.JavaLab9EE.services.AddDocumentService;
import com.lab9EEjava.JavaLab9EE.services.DeleteDocumentService;
import com.lab9EEjava.JavaLab9EE.services.UpdateDocumentService;
import com.lab9EEjava.JavaLab9EE.services.ViewDocumentService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 *
 */
@Path("/documents")
@ApplicationScoped
public class DocumentsController {

    @Inject
    private AddDocumentService addDocumentService;

    @Inject
    private DeleteDocumentService deleteDocumentService;

    @Inject
    private UpdateDocumentService updateDocumentService;

    @Inject
    private ViewDocumentService viewDocumentService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Created document", content = @Content(mediaType = "application/json")),
            @APIResponse(responseCode = "500", description = "Internal service error") })
    @Operation(summary = "Create document", description = "Create document")
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
    public Document updateDocument(Document document){
        updateDocumentService.updateDocument(document);
        return document;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Get user specific documents", content = @Content(mediaType = "application/json")),
            @APIResponse(responseCode = "500", description = "Internal service error") })
    @Operation(summary = "Get user specific documents", description = "Get user specific documents")
    public List<Document> getAllDocuments(){
        return viewDocumentService.getAllDocuments();
    }

    @GET
    @Path("/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Get all documents", content = @Content(mediaType = "application/json")),
            @APIResponse(responseCode = "500", description = "Internal service error") })
    @Operation(summary = "Get all documents", description = "Get all documents")
    public List<Document> getUserDocuments(@jakarta.ws.rs.PathParam("userId") int userId){
        return viewDocumentService.getUserDocuments(userId);
    }

    @Path("/test")
    @GET
    public String sayHello() {
        return "Hello World";
    }
}
