package sandkev.bidster.dao;

import java.io.Serializable;

/**
 * Created by kevin on 14/06/2016.
 */
public interface Identifiable <ID extends Serializable> extends Serializable {
    ID getId();
}
