package lab3ee.Repository.JPA;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lab3ee.Entities.Resource;

import java.util.List;

@Stateless
public class ResourcesRepositoryStateless {

    @PersistenceContext(unitName = "myPersistenceUnit")
    private EntityManager em;

    public Resource findById(Integer id) {
        return em.find(Resource.class, id);
    }

    public boolean isResourceAvailable(Resource resource){
        Resource _resource = em.find(Resource.class, resource);
        return resource.getQuantity() > 0;
    }

    public List<Resource> getResources() {
        return (List<Resource>) em.createNamedQuery("Resource.getAll").getResultList();
    }

}
