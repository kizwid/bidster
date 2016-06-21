package sandkev.bidster;

/**
 * Behaviour for an auction that has started but as yet has no bids.
 */
public class VirginAuction extends AbstractAuctionState {

    public VirginAuction(AuctionCoordinator coordinator, Auction auction) {
        super(coordinator, auction);
    }

    public void start(Auction auction) {
        throw new IllegalStateException("Can't start an auction that is already running: " + auction);
    }

    public double nod(Bidder bidder, Lot lot) {
        return getAuction().getStartingBid();
    }

    public synchronized BidResponse bid(Bidder bidder, double amount, Lot lot) {
        if(amount>=getAuction().getStartingBid()){
            coordinator.getStateTracker().setBid(getAuction().getId(), coordinator.createBid(bidder, lot, getAuction(), amount));
            coordinator.getStateTracker().setState(getAuction().getId(), coordinator.getRunningAuction());
            return BidResponse.Accepted;
        }else {
            return BidResponse.RejectedAsTooLow;
        }
    }

    public Bid hammerDown() {
        throw new UnsupportedOperationException("Cant bring the hammer down until we have at least one bid");
    }

    public AuctionStatus getStatus() {
        return AuctionStatus.Virgin;
    }
}
