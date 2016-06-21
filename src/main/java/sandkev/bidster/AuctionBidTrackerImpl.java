package sandkev.bidster;

import lombok.Value;
import lombok.extern.java.Log;

import java.util.List;

/**
 * Created by kevin on 10/06/2016.
 */
@Log
@Value
public class AuctionBidTrackerImpl implements AuctionBidTracker {

    public void recordUserBid(Bid bid) {

    }

    public Bid getWinningBid(Lot lot) {
        return null;
    }

    public List<Bid> getAllBids(Lot lot) {
        return null;
    }

    public List<Lot> getLotsBidFor(Bidder bidder) {
        return null;
    }

}
