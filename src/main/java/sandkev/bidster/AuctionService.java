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


    /**
     * start the auction
     */
    void start();

    /**
     * open the bidding for the next lot
     *
     * @return lot
     */
    Lot openBidding();

    /**
     * allows the bidder to request a snapshot of the next minimum bid that will supercede the current top slot
     * @param bidder
     * @return
     */
    double nod(Bidder bidder, Lot lot);

    /**
     * allow bidders to bid on the current lot
     *
     * @param bidder
     * @param amount
     * @param lot
     * @return boolean indicating if the bid was successful
     */
    boolean bid(Bidder bidder, double amount, Lot lot);


    /**
     * close the bidding on the winning bid
     *
     * @return the winning bid
     */
    Bid hammerDown();

    /**
     * close the auction when all the lots are sold
     */
    void close();

    AuctionStatus currentState();
}
