package sandkev.bidster.dao;

import lombok.Getter;
import lombok.ToString;
import lombok.Value;
import lombok.extern.java.Log;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by kevin on 14/06/2016.
 */
@Getter
@ToString
@Log
public abstract class GenericDaoAbstract<T extends Identifiable<ID>, ID extends Serializable> implements GenericDao<T,ID> {

    protected final  Class< T > type;

    public GenericDaoAbstract(){
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];

    }

}
