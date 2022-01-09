package lab3ee.Types;

import lab3ee.Model.Document;

import java.util.List;

public class CacheStore {
    String parameter;
    List<Document> response;

    public CacheStore(String parameter, List<Document> response) {
        this.parameter = parameter;
        this.response = response;
    }
}
