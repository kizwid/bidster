package sandkev.bidster;

import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import lombok.extern.java.Log;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by kevin on 10/06/2016.
 */
@Log
@Value
@Getter
public class AuctionStateTracker {
    ConcurrentHashMap<Long,TrackedObject> registry;

    @Getter
    private static class TrackedObject {
        Auction auction;
        AuctionState state;
        @Setter Bid bid;
        public TrackedObject(Auction auction, AuctionState state) {
            this.auction = auction;
            this.state = state;
            this.bid = null;
        }
    }

    public AuctionStateTracker(){
        this.registry = new ConcurrentHashMap<>();
    }
    public AuctionState getState(AuctionCoordinator coordinator){
        AuctionState state;
        TrackedObject trackedObject = registry.get(coordinator.getAuction().getId());
        if(trackedObject == null){
            state = coordinator.getPendingAuction();
            registry.putIfAbsent(coordinator.getAuction().getId(), trackedObject = new TrackedObject(coordinator.getAuction(), state));
        }
        return trackedObject.state;
    }
    public void setState(Long auctionId, AuctionState state){
        TrackedObject trackedObject = registry.get(auctionId);
        if(trackedObject==null){
            throw new IllegalStateException("No auction with ID[" + auctionId +"] is registered");
        }
        trackedObject.state = state;
    }
    public Bid getBid(AuctionCoordinator coordinator){
        TrackedObject trackedObject = registry.get(coordinator.getAuction().getId());
        if(trackedObject==null){
            throw new IllegalStateException("No auction with ID[" + coordinator.getAuction().getId() +"] is registered");
        }
        return trackedObject.bid;
    }
    public void setBid(Long auctionId, Bid bid){
        TrackedObject trackedObject = registry.get(auctionId);
        if(trackedObject==null){
            throw new IllegalStateException("No auction with ID[" + auctionId +"] is registered");
        }
        trackedObject.bid = bid;
    }

}
