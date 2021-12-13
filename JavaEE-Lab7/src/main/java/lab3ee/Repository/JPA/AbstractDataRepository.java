package lab3ee.Repository.JPA;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.dom4j.tree.AbstractEntity;

import java.io.Serializable;

public abstract class AbstractDataRepository <T extends AbstractEntity, ID extends Serializable>
{
    @PersistenceContext(unitName = "myPersistenceUnit")
    protected EntityManager em;

    public abstract T findById(ID id);

    public abstract void persist(T entity);

    public abstract void remove(ID id);

    public abstract void update(ID id, T entity);

}
