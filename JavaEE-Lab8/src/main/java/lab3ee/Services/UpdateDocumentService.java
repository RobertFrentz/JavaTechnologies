package lab3ee.Services;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lab3ee.Model.Document;
import lab3ee.Repository.JPA.DocumentRepository;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@Path("/documents")
@ApplicationScoped
public class UpdateDocumentService {

    @Inject
    private DocumentRepository documentRepository;

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Updated document", content = @Content(mediaType = "application/json")),
            @APIResponse(responseCode = "500", description = "Internal service error") })
    @Operation(summary = "Update document", description = "Update document")
    public Document updateDocument(Document document){
        documentRepository.updateDocument(document);
        return document;
    }

}
