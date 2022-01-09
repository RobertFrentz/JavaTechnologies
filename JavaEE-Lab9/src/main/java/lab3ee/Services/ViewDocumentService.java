package lab3ee.Services;


import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.*;
import lab3ee.Model.Document;
import lab3ee.Repository.JPA.DocumentRepository;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import java.util.List;

@Path("/documents")
@ApplicationScoped
@RolesAllowed({"author", "admin", "reviewer"})
public class ViewDocumentService {

    @Inject
    private DocumentRepository documentRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("admin")
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Get user specific documents", content = @Content(mediaType = "application/json")),
            @APIResponse(responseCode = "500", description = "Internal service error") })
    @Operation(summary = "Get user specific documents", description = "Get user specific documents")
    public List<Document> getAllDocuments(){
        return documentRepository.getAllDocuments();
    }

    @GET
    @Path("/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Get all documents", content = @Content(mediaType = "application/json")),
            @APIResponse(responseCode = "500", description = "Internal service error") })
    @Operation(summary = "Get all documents", description = "Get all documents")
    public List<Document> getUserDocuments(@PathParam("userId") int userId){
        return documentRepository.getDocumentsForUser(userId);
    }
}
