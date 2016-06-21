package sandkev.bidster;

import java.util.List;

/**
 * Created by kevin on 08/06/2016.
 */
public interface AuctionBidTracker {

    /**
     * record a users bid on an item
     * @param bid
     */
    void recordUserBid(Bid bid);

    /**
     * get the current winning bid for an item
     * @param lot
     * @return
     */
    Bid getWinningBid(Lot lot);


    /**
     * get a list of all bids made for an item
     * @param lot
     * @return
     */
    List<Bid> getAllBids(Lot lot);

    /**
     *
     * @param bidder
     * @return
     */
    List<Lot> getLotsBidFor(Bidder bidder);



}
