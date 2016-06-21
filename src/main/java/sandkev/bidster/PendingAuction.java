package sandkev.bidster;

/**
 * Created by kevin on 10/06/2016.
 */
public class PendingAuction extends AbstractAuctionState {

    public PendingAuction(AuctionCoordinator coordinator, Auction auction) {
        super(coordinator, auction);
    }

    public void start(Auction auction) {
        coordinator.getStateTracker().setState(auction.getId(), coordinator.getVirginAuction());
    }

    public double nod(Bidder bidder, Lot lot) {
        throw new UnsupportedOperationException("Nods cannot be made until the auction has started");
    }

    public BidResponse bid(Bidder bidder, double amount, Lot lot) {
        throw new UnsupportedOperationException("Bids cannot be accepted until the auction has started");
    }

    public Bid hammerDown() {
        throw new UnsupportedOperationException("The hammer cant come down before the auction has started or any bids have been made");
    }

    public AuctionStatus getStatus() {
        return AuctionStatus.Pending;
    }
}
