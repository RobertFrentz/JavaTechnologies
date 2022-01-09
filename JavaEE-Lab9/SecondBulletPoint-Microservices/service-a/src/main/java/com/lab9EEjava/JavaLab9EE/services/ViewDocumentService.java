package com.lab9EEjava.JavaLab9EE.services;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import com.lab9EEjava.JavaLab9EE.models.Document;
import com.lab9EEjava.JavaLab9EE.repositories.DocumentRepository;

import java.util.List;

@ApplicationScoped
public class ViewDocumentService {

    @Inject
    private DocumentRepository documentRepository;

    public List<Document> getAllDocuments(){
        return documentRepository.getAllDocuments();
    }

    public List<Document> getUserDocuments(int userId){
        return documentRepository.getDocumentsForUser(userId);
    }
}
