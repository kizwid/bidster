package sandkev.bidster;

/**
 * Created by kevin on 10/06/2016.
 */
public class CompletedAuction extends AbstractAuctionState {

    public CompletedAuction(AuctionCoordinator coordinator, Auction auction) {
        super(coordinator, auction);
    }

    public void start(Auction auction) {
        throw new IllegalStateException("Can't start an auction that has completed: " + auction);
    }

    public double nod(Bidder bidder, Lot lot) {
        return 0;
    }

    public BidResponse bid(Bidder bidder, double amount, Lot lot) {
        return BidResponse.Accepted;
    }

    public Bid hammerDown() {
        return null;
    }

    public AuctionStatus getStatus() {
        return AuctionStatus.Complete;
    }
}
