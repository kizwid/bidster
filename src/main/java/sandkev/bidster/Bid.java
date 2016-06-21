package sandkev.bidster;

import lombok.Value;
import sandkev.bidster.dao.Identifiable;

import java.time.LocalDateTime;

/**
 * Created by kevin on 10/06/2016.
 */
@Value
public class Bid implements Identifiable<Long> {
    Long id;
    LocalDateTime timestamp;
    Auction auction;
    Bidder bidder;
    Lot lot;
    double amount;
}
