package sandkev.bidster;

import java.util.Date;

/**
 * services provided by an auction
 */
public interface AuctionService {

    /**
     * register the auction
     *
     * @param description
     * @param startTime
     * @return
     */
    Auction registerAuction(String description, Date startTime);

    /**
     * add item to the auction
     *
     * @param description
     * @param image
     * @param startingPrice
     * @param timeoutBeforeWinningBid
     * @return
     */
    Lot registerLot(String description, byte[] image, double startingPrice, int timeoutBeforeWinningBid);

    /**
     * allow bidders to join the auction
     *
     * @param name
     * @return
     */
    Bidder registerBidder(String name);


    Bid recordBid(Bidder bidder, Lot lot, Auction auction, double amount);


    void recordWinningBid(Bid winningBid);
}
