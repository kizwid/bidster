package sandkev.bidster.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by kevin on 14/06/2016.
 */
public interface GenericDao <T extends Identifiable,ID extends Serializable>{
    boolean exists(ID primaryKey);
    void save(T entity);
    void saveAll(Collection<T> entities);
    T find(ID primaryKey);
    List<T> find(Predicate<T> filter);
    void delete(Collection<ID> primaryKeys);
    void delete(ID primaryKey);
}
