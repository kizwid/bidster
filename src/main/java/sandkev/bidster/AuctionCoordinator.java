package sandkev.bidster;

import lombok.Getter;
import lombok.ToString;
import lombok.Value;
import lombok.extern.java.Log;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by kevin on 10/06/2016.
 */
@Value
@Getter
@ToString
@Log
public class AuctionCoordinator {
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
        state.start(auction);
    }

    Bid createBid(Bidder bidder, Lot lot, Auction auction, double amount) {
        long nextId = 0l;
        LocalDateTime timestamp=LocalDateTime.now();
        return new Bid(nextId, timestamp, auction, bidder, lot, amount);
    }

    public AuctionState getState(){
        return stateTracker.getState(this);
    }


}
