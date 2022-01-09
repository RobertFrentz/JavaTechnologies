package com.lab9EEjava.JavaLab9EE.repositories;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import com.lab9EEjava.JavaLab9EE.models.Document;

import java.util.List;

@ApplicationScoped
public class DocumentRepository {

    @PersistenceContext(unitName = "myPersistenceUnit")
    protected EntityManager em;

    public List<Document> getDocumentsForUser(int userId){
        return (List<Document>) em.createNamedQuery("Document.getAllForUser")
                .setParameter("userId", userId)
                .getResultList();
    }

    public List<Document> getAllDocuments(){
        return (List<Document>) em.createNamedQuery("Document.getAll")
                .getResultList();
    }


    @Transactional
    public void addDocument(Document document){
        Document createdDocument = new Document(document.getId(),document.getName(),document.getAuthors(),document.getContent(),document.getUserId());
        em.persist(createdDocument);
        //return em.find(Document.class, document.getId());
    }

    @Transactional
    public void updateDocument(Document document){
        if(em.find(Document.class, document.getId()) == null){
            em.persist(document);
            return;
        }
        em.merge(document);
    }

    @Transactional
    public Document deleteDocument(int id){
        Document document = em.find(Document.class, id);
        if(document != null){
            em.remove(document);
        }
        return document;
    }


}
