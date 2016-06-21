package sandkev.bidster;

import java.util.Date;

/**
 * Created by kevin on 10/06/2016.
 */
public class TraditionalAuction implements AuctionService {
    public Auction registerAuction(String description, Date startTime) {
        return new Auction(0L, description, 10.0);
    }

    public Lot registerLot(String description, byte[] image, double startingPrice, int timeoutBeforeWinningBid) {
        return null;
    }

    public Bidder registerBidder(String name) {
        return null;
    }

    public void start() {

    }

    public Lot openBidding() {
        return null;
    }

    public double nod(Bidder bidder, Lot lot) {
        return 0;
    }

    public boolean bid(Bidder bidder, double amount, Lot lot) {
        return false;
    }

    public Bid hammerDown() {
        return null;
    }

    public void close() {

    }

    public AuctionStatus currentState() {
        return null;
    }
}
