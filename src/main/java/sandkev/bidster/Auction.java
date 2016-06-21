package sandkev.bidster;

import lombok.Getter;
import lombok.ToString;
import lombok.Value;
import lombok.extern.java.Log;
import sandkev.bidster.dao.Identifiable;

import java.util.LongSummaryStatistics;

/**
 * Created by kevin on 10/06/2016.
 */
@Value
@Getter
@ToString
@Log
public class Auction implements Identifiable<Long> {
    Long id;
    String description;
    double startingBid;
}
