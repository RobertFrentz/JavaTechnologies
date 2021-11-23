package lab3ee.Services;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import lab3ee.Model.Resource;
import lab3ee.Model.Student;
import lab3ee.Repository.JPA.ResourceRepositoryStateful;
import lab3ee.Repository.JPA.ResourcesRepositoryStateless;
import lab3ee.Utils.DataMapper;

import java.util.ArrayList;
import java.util.List;

@Named
@ApplicationScoped
public class ResourceService {

    private List<Resource> resources;

    @EJB(name = "myStatefulEJB")
    private ResourceRepositoryStateful resourceRepositoryStateful;

    @EJB
    private ResourcesRepositoryStateless resourcesRepositoryStateless;

    @PostConstruct
    public void init() {
        resources = DataMapper.ResourcesToModel(resourcesRepositoryStateless.getResources());
    }

    public List<Resource> getResources() {
        return new ArrayList<>(resources);
    }

    public void assignResources(List<Resource> resources, String examName, List<Integer> selectedQuantities) {
        resourceRepositoryStateful.assignResources(DataMapper.ResourcesToEntity(resources), examName, selectedQuantities);
        //System.out.println("Here I am!");
    }

    public boolean isResourceAvailable(Resource resource){
        return resourcesRepositoryStateless.isResourceAvailable(DataMapper.ResourceToEntity(resource));
    }
}
