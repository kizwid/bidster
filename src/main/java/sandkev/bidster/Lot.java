package sandkev.bidster;

import lombok.Value;

/**
 * represents a lot (single or multiple items) for auction
 */
@Value
public class Lot {
    long id;
    String description;
    byte[] image;
    double startingPrice;
    int timeoutBeforeWinningBid;
}
