package sandkev.bidster;

/**
 * Created by kevin on 08/06/2016.
 */
public interface AuctionState {

    /**
     * start the auction
     */
    void start();

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
    BidResponse bid(Bidder bidder, double amount, Lot lot);


    /**
     * close the bidding on the winning bid
     *
     * @return the winning bid
     */
    Bid hammerDown();


    /**
     * report current status
     *
     * @return
     */
    AuctionStatus getStatus();

}
