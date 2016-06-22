package sandkev.bidster;

import lombok.Getter;
import lombok.ToString;
import lombok.Value;
import lombok.extern.java.Log;

/**
 * Created by kevin on 10/06/2016.
 */
@Value
@Getter
@ToString
@Log
public class AuctionCoordinator implements AuctionState {
    AuctionService auctionService;
    AuctionStateTracker stateTracker;
    AuctionState pendingAuction;
    AuctionState virginAuction;
    AuctionState runningAuction;
    AuctionState completedAuction;
    Auction auction;

    public AuctionCoordinator(AuctionService auctionService, Auction auction){
        this.auctionService = auctionService;
        this.auction = auction;
        this.stateTracker = new AuctionStateTracker();
        this.pendingAuction = new PendingAuction(this, auction);
        this.virginAuction = new VirginAuction(this, auction);
        this.runningAuction = new RunningAuction(this, auction);
        this.completedAuction = new CompletedAuction(this, auction);
    }

    public void start(){
        AuctionState state = stateTracker.getState(this);
        state.start();
    }

    @Override
    public double nod(Bidder bidder, Lot lot) {
        AuctionState state = stateTracker.getState(this);
        return state.nod(bidder, lot);
    }

    @Override
    public BidResponse bid(Bidder bidder, double amount, Lot lot) {
        AuctionState state = stateTracker.getState(this);
        return state.bid(bidder, amount, lot);
    }

    @Override
    public AuctionStatus getStatus() {
        AuctionState state = stateTracker.getState(this);
        return state.getStatus();
    }

    @Override
    public Bid hammerDown() {
        AuctionState state = stateTracker.getState(this);
        return state.hammerDown();
    }

    Bid createBid(Bidder bidder, Lot lot, Auction auction, double amount) {
        return auctionService.recordBid(bidder, lot, auction, amount);
    }

    public AuctionState getState(){
        return stateTracker.getState(this);
    }


    public void recordWinner(Bid winningBid) {
        auctionService.recordWinningBid(winningBid);
    }
}
