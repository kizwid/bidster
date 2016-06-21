package sandkev.bidster.dao;

import lombok.Getter;
import lombok.ToString;
import lombok.Value;
import lombok.extern.java.Log;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

/**
 * Created by kevin on 14/06/2016.
 */
@Getter
@ToString
@Log
public abstract class GenericDaoAbstractMap<T extends Identifiable<ID>, ID extends Serializable> implements GenericDao<T,ID> {
    Map<ID,T> store;
    public GenericDaoAbstractMap(){
        store = new HashMap<ID, T>();
    }

    public boolean exists(ID primaryKey) {
        return store.containsKey(primaryKey);
    }

    public void save(T entity) {
        store.put(entity.getId(), entity);
    }

    public void saveAll(Collection<T> entities) {
        for (T entity : entities) {
            save(entity);
        }
    }

    public T find(ID primaryKey) {
        return store.get(primaryKey);
    }

    public List<T> find(Predicate<T> filter) {
        throw new UnsupportedOperationException("TODO");
    }

    public void delete(Collection<ID> primaryKeys) {
        store.remove(primaryKeys);
    }

    public void delete(ID primaryKey) {
        store.remove(primaryKey);
    }
}
