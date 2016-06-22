package sandkev.bidster;

/**
 * Created by kevin on 10/06/2016.
 */
public class RunningAuction extends AbstractAuctionState {

    public RunningAuction(AuctionCoordinator coordinator, Auction auction) {
        super(coordinator, auction);
    }

    public void start() {
        throw new IllegalStateException("Can't start an auction that is already running: " + auction);
    }

    public double nod(Bidder bidder, Lot lot) {
        coordinator.getStateTracker().setState(auction.getId(), coordinator.getRunningAuction());
        return 0;
    }

    public synchronized BidResponse bid(Bidder bidder, double amount, Lot lot) {
        Bid currentBid = coordinator.getStateTracker().getBid(coordinator);
        if(amount>currentBid.getAmount()){
            coordinator.getStateTracker().setBid(getAuction().getId(), coordinator.createBid(bidder, lot, auction, amount));
            return BidResponse.Accepted;
        }else {
            return BidResponse.RejectedAsTooLow;
        }
    }

    public Bid hammerDown() {
        coordinator.getStateTracker().setState(auction.getId(), coordinator.getCompletedAuction());
        Bid winningBid = coordinator.getStateTracker().getBid(coordinator);
        coordinator.recordWinner(winningBid);
        return winningBid;
    }

    public AuctionStatus getStatus() {
        return AuctionStatus.Running;
    }
}
