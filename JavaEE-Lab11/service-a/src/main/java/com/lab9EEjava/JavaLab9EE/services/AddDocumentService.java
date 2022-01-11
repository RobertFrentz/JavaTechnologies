package com.lab9EEjava.JavaLab9EE.services;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import com.lab9EEjava.JavaLab9EE.models.Document;
import com.lab9EEjava.JavaLab9EE.repositories.DocumentRepository;

@ApplicationScoped
public class AddDocumentService {

    @Inject
    private DocumentRepository documentRepository;

    public Document addDocument(Document document){
        documentRepository.addDocument(document);
        return document;
    }
}
