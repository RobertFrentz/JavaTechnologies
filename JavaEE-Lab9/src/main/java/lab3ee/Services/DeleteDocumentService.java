package lab3ee.Services;

import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import lab3ee.Model.Document;
import lab3ee.Repository.JPA.DocumentRepository;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@Path("/documents")
@ApplicationScoped
@RolesAllowed({"author", "admin"})
public class DeleteDocumentService {

    @Inject
    private DocumentRepository documentRepository;

    @DELETE
    @Path("/{id}")
    @APIResponses(value = {
            @APIResponse(responseCode = "204", description = "Deleted document", content = @Content(mediaType = "text/html")),
            @APIResponse(responseCode = "500", description = "Internal service error") })
    @Operation(summary = "Delete document", description = "Delete document")
    public Response deleteDocument(@PathParam("id") int id){
        Document document = documentRepository.deleteDocument(id);
        return Response.noContent().entity(document).build();
    }
}
