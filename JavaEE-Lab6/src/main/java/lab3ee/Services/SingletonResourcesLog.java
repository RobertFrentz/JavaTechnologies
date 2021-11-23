package lab3ee.Services;

import jakarta.ejb.Lock;
import jakarta.ejb.LockType;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;
import lab3ee.Model.Exam;
import lab3ee.Model.Resource;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Singleton
@Startup
public class SingletonResourcesLog {

    private Map<String, String> resourceMap;

    @Inject
    private ResourceService resourceService;

    @PostConstruct
    void init(){
        resourceMap = new HashMap<>();
        List<Resource> resources = resourceService.getResources();
        for(Resource resource: resources){
            resourceMap.put(resource.getName(), resource.getExam());
        }
        System.out.println(resourceMap.toString());
    }

    @Lock(LockType.WRITE)
    public void updateMap(List<Resource> resources){
        for(Resource resource: resources){
            if(resourceMap.containsKey(resource.getName())){
                resourceMap.put(resource.getName(), resourceMap.get(resource.getName()) + resource.getExam());
            } else{
                resourceMap.put(resource.getName(), resource.getExam());
            }
        }
        System.out.println(resourceMap.toString());
    }
}
