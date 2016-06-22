package sandkev.bidster;

/**
 * Created by kevin on 10/06/2016.
 */
public class CompletedAuction extends AbstractAuctionState {

    public CompletedAuction(AuctionCoordinator coordinator, Auction auction) {
        super(coordinator, auction);
    }

    public void start() {
        throw new IllegalStateException("Can't start an auction that has completed: " + auction);
    }

    public double nod(Bidder bidder, Lot lot) {
        throw new IllegalStateException("Can't nod in an auction that has completed: " + auction);
    }

    public BidResponse bid(Bidder bidder, double amount, Lot lot) {
        return BidResponse.RejectedAsAuctionIsClosed;
    }

    public Bid hammerDown() {
        throw new IllegalStateException("Can't close an auction that has completed: " + auction);
    }

    public AuctionStatus getStatus() {
        return AuctionStatus.Complete;
    }
}
