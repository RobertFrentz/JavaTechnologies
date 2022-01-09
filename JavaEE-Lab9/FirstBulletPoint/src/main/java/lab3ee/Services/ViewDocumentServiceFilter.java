package lab3ee.Services;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import lab3ee.Model.Document;
import lab3ee.Types.CacheStore;

import java.util.ArrayList;
import java.util.List;

public class ViewDocumentServiceFilter implements ContainerResponseFilter {
    private List<CacheStore> cache = new ArrayList<>();

    public void filter(ContainerRequestContext req, ContainerResponseContext res) {
        if (req.getMethod().equals("GET")) {
            CacheStore cacheStore = new CacheStore(req.getUriInfo().getPathParameters().getFirst("id"), (List<Document>)res.getEntity());
            cache.add(cacheStore);
        }
    }
}
