package sandkev.bidster;

import lombok.Value;
import sandkev.bidster.dao.Identifiable;

/**
 * Created by kevin on 10/06/2016.
 */
@Value
public class Bidder implements Identifiable<Long>{
    Long id;
    String name;
}
