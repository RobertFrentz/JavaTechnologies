package com.lab9EEjava.JavaLab9EE.services;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import com.lab9EEjava.JavaLab9EE.models.Document;
import com.lab9EEjava.JavaLab9EE.repositories.DocumentRepository;

@ApplicationScoped
public class DeleteDocumentService {

    @Inject
    private DocumentRepository documentRepository;

    public Response deleteDocument(int id){
        Document document = documentRepository.deleteDocument(id);
        return Response.noContent().entity(document).build();
    }
}
