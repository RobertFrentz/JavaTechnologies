package lab3ee.Repository.JPA;

import jakarta.ejb.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lab3ee.Entities.Resource;

import java.util.List;

@Stateful(name = "myStatefulEJB")
//@ApplicationException(rollback = true)
public class ResourceRepositoryStateful {

    @PersistenceContext(unitName = "myPersistenceUnit")
    private EntityManager em;

    /*@jakarta.annotation.Resource
    EJBContext ejbContext;*/

    public Resource findById(Integer id) {
        return em.find(Resource.class, id);
    }

    public void assignResources(List<Resource> resources, String examName, List<Integer> selectedQuantities) {
        for (int i = 0; i < resources.size(); i++) {
            Resource resource = em.find(Resource.class, resources.get(i));
            resource.setExam(resource.getExam() + examName + ", ");
            resource.setQuantity(resource.getQuantity() - selectedQuantities.get(i));
            em.merge(resource);
        }
    }
}
