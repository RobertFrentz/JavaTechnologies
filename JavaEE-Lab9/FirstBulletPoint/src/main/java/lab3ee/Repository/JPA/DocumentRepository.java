package lab3ee.Repository.JPA;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lab3ee.Model.Document;

import java.util.List;

@Named
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
        Document createdDocument = new Document(document.getName(),document.getAuthors(),document.getContent(),document.getUserId());
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
